package com.matilhadeestudos.mensageiroqualquer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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

    private final DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        contato = intent.getBooleanExtra("contato", true);
        if (contato) {
            Contato c = (Contato) intent.getSerializableExtra("usuario");
            nome = c.getNome();
            email = c.getEmail();
            foto = c.getImagem();
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

}