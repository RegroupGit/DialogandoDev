package com.matilhadeestudos.mensageiroqualquer.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatToggleButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.matilhadeestudos.mensageiroqualquer.Model.Contato;
import com.matilhadeestudos.mensageiroqualquer.Model.Usuario;
import com.matilhadeestudos.mensageiroqualquer.R;

public class UserInfo extends AppCompatActivity {
    private boolean contato = true;
    private Contato c;
    private Usuario u;
    private TextView Nome, Email;
    private ImageView Foto;
    private String nome, email;
    private FloatingActionButton fbutton;
    private int foto;
    private FirebaseAuth auth;
    private FirebaseUser usuario;
    private FirebaseDatabase bd;

    private final DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    DatabaseReference nome_db = referencia.child("usuarios").child(user.getUid()).child("dados_da_conta").child("nome");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        contato = intent.getBooleanExtra("contato", true);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();


        if (contato) {
            Contato c = (Contato) intent.getSerializableExtra("usuario");
            nome = c.getNome();
            email = c.getEmail();
            foto = c.getImagem();
        } else {
            nome_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String n = dataSnapshot.getValue().toString();
                nome = n;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
            email = user.getEmail();
        }

        Nome = findViewById(R.id.nomeInfo);
        Email = findViewById(R.id.emailInfo);
        Foto = findViewById(R.id.fotoInfo);
        fbutton = findViewById(R.id.floatingActionButton);
        Nome.setText(nome);
        Email.setText(email);
        Foto.setImageResource(foto);

        if (contato) {
            fbutton.setImageResource(R.drawable.ic_baseline_edit_48);
        } else {
            fbutton.setImageResource(R.drawable.ic_baseline_exit_to_app_48);
        }

    }

    public void ClickFloating(View view) {
        if (contato) {
            Toast.makeText(this, "Função pendente!", Toast.LENGTH_SHORT).show();
        } else {
            try {
                auth.signOut();
                Thread.sleep(1000);
                System.exit(0);

            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

}