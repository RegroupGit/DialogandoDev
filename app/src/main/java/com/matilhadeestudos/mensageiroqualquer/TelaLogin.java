package com.matilhadeestudos.mensageiroqualquer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TelaLogin extends AppCompatActivity {

    Button cadastroButton, entrar, testePontos;
    TextView esqueceuSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);


        testePontos = findViewById(R.id.teste);
        cadastroButton = findViewById(R.id.buttonCadastro);
        esqueceuSenha = findViewById(R.id.textforgetSenha);

        getSupportActionBar().hide();

        cadastroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               cadastro();

            }
        });

        esqueceuSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               esqueciSenha();

            }
        });
        // gente somente descomentar caso a classe ja tenha sido feita
        testePontos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), TelaDeContatos.class);
               // startActivity(intent);
            }
        });


    }
    public void cadastro(){
        //Intent intent = new Intent(getApplicationContext(), TelaCadastro.class);
        //startActivity(intent);
    }
    public void Entrar(){
       // Intent intent = new Intent(getApplicationContext(), TelaDeContatos.class);
      //  startActivity(intent);

    }
    public void esqueciSenha(){
        //Intent intent = new Intent(getApplicationContext(), EsqueciSenha.class);
       // startActivity(intent);
    }
}