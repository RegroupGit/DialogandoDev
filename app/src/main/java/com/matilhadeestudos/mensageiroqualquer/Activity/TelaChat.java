package com.matilhadeestudos.mensageiroqualquer.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.matilhadeestudos.mensageiroqualquer.Adapter.MensagensAdap;
import com.matilhadeestudos.mensageiroqualquer.Model.Mensagem;
import com.matilhadeestudos.mensageiroqualquer.R;

import java.util.ArrayList;
import java.util.List;

public class TelaChat extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText mensagem;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch aSwitch;
    private FloatingActionButton enviar;
    private List<Mensagem> listaMensagens = new ArrayList<>();
    private DatabaseReference mensagensref;
    private ChildEventListener mensagensListener;
    MensagensAdap adapter;

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_chat);

        recyclerView = findViewById(R.id.MensagensCorpo);
        mensagem = findViewById(R.id.Mensagem);
        aSwitch = findViewById(R.id.switch1);
        enviar = findViewById(R.id.floatingActionButton2);


        // Configuração Adapter
        adapter = new MensagensAdap(listaMensagens, getApplicationContext());

        // Configuração RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        mensagensref = referencia.child("Mensagens");

    }


    public void enviar(View v) {
        Mensagem m = new Mensagem();
        String textoM = mensagem.getText().toString();
        if (!textoM.isEmpty()) {
            m.setNome("teste");
            m.setMensagem(mensagem.getText().toString());
            m.setDestinatario(aSwitch.isChecked());
            referencia.child("Mensagens").push().setValue(m);
            mensagem.setText("");
        }
    }

    public void switchResp(View v) {
        if (aSwitch.isChecked()) {
            aSwitch.setText("Vinicius");
        } else {
            aSwitch.setText("Gabriel");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        recuperarMsg();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mensagensref.removeEventListener(mensagensListener);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mensagensref.removeEventListener(mensagensListener);

    }

    public void recuperarMsg () {
        mensagensListener = mensagensref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Mensagem m = dataSnapshot.getValue(Mensagem.class);
                listaMensagens.add(m);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}