package com.matilhadeestudos.mensageiroqualquer.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.matilhadeestudos.mensageiroqualquer.R;
//import com.google.firebase.auth.FirebaseAuth;

public class TelaCadastro extends AppCompatActivity {

    private Button enviar;
    private EditText nomes, email, senha, id;
    //private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        nomes = findViewById(R.id.nomeCadastro);
        email = findViewById(R.id.emailCadastro);
        senha = findViewById(R.id.senhaCadastro);
        enviar = findViewById(R.id.buttonEnviar);
        getSupportActionBar().hide();


        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    private void criarLogin() {


    }

    private void salvarDados() {


    }

    private void recuperarDados() {


    }


}