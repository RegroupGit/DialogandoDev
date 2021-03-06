package com.matilhadeestudos.mensageiroqualquer.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.matilhadeestudos.mensageiroqualquer.Model.Usuario;
import com.matilhadeestudos.mensageiroqualquer.R;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TelaLogin extends AppCompatActivity {


    private EditText email, senha;
    private FirebaseAuth mAuth;
    Button cadastroButton, entrada, testePontos, deslogar;
    TextView esqueceuSenha;
    Usuario u = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        testePontos = findViewById(R.id.teste);
        entrada = findViewById(R.id.entrar);
        cadastroButton = findViewById(R.id.buttonCadastro);
        esqueceuSenha = findViewById(R.id.textforgetSenha);
        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);
        mAuth = FirebaseAuth.getInstance();

        getSupportActionBar().hide();

        testePontos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListaContatos.class);
                intent.putExtra("contato", false);
                startActivity(intent);
            }
        });

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

        entrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Entrar();
            }
        });
    }

    public void cadastro() {
        Intent intent = new Intent(getApplicationContext(), TelaCadastro.class);
        startActivity(intent);
    }

    public void Entrar() {
        receberDados();
        logar();

    }

    public void esqueciSenha() {
        Intent intent = new Intent(getApplicationContext(), EsqueciSenha.class);
        startActivity(intent);
    }

//

    public void logar() {
        mAuth.signInWithEmailAndPassword(u.getEmail(), u.getSenha())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser user = mAuth.getCurrentUser();
                            u.setId(user.getUid());
                            u.salvarDados();
                            startActivity(new Intent(TelaLogin.this, ListaContatos.class));
                            finish();
                        }else{
                            Toast.makeText(TelaLogin.this,"Erro ao autenticar/Conta n??o existe",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
       public void recuperarSenha(){

       }

       public void deslogar(){
        mAuth.signOut();
       }
    private void receberDados() {

        u.setEmail(email.getText().toString());
        u.setSenha(senha.getText().toString());

    }
}