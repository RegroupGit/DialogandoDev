package com.matilhadeestudos.mensageiroqualquer.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.matilhadeestudos.mensageiroqualquer.R;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.matilhadeestudos.mensageiroqualquer.Activity.TelaCadastro;

public class TelaLogin extends AppCompatActivity {
    Usuario nokia = new Usuario();
    private FirebaseAuth mAuth;
    Button cadastroButton, entrar, testePontos;
    TextView esqueceuSenha;
    private EditText email, senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        mAuth = FirebaseAuth.getInstance();

        testePontos = findViewById(R.id.teste);
        cadastroButton = findViewById(R.id.buttonCadastro);
        esqueceuSenha = findViewById(R.id.textforgetSenha);
        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);

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
                //Intent intent = new Intent(getApplicationContext(), TelaDeConversas.class);
               // startActivity(intent);
            }
        });


    }
    public void cadastro(){
        Intent intent = new Intent(getApplicationContext(), TelaCadastro.class);
        startActivity(intent);
    }
    public void Entrar(){
        receberDados();
        logar();

    }
    public void esqueciSenha(){
        Intent intent = new Intent(getApplicationContext(), EsqueciSenha.class);
        startActivity(intent);
    }

    public void receberDados(){
        nokia.setEmail(email.getText().toString());
        nokia.setSenha(senha.getText().toString());


    }
    public void logar(){
        mAuth.signInWithEmailAndPassword(nokia.getEmail(), nokia.getSenha())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    nokia.setId(user.getUid());

                                    startActivity(new Intent(TelaLogin.this,ListaContatos.class
                                    ));

                                }else{
                                    Toast.makeText(TelaLogin.this
                                    ,"Erro, tente novamente",Toast.LENGTH_LONG).show();

                                }
                            }
                        }

                );
    }

}