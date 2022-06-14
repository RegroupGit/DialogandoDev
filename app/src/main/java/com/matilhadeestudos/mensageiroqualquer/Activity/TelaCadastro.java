package com.matilhadeestudos.mensageiroqualquer.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.matilhadeestudos.mensageiroqualquer.Model.Usuario;
import com.matilhadeestudos.mensageiroqualquer.R;
//import com.google.firebase.auth.FirebaseAuth;



public class TelaCadastro extends AppCompatActivity {
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();





    private Button enviar;
    private EditText nomes, email, senha, id;
    private FirebaseAuth mAuth;
    private Usuario nokia;

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
            public void onClick(View v) {

            }
        });


        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuperarDados();
                criarLogin();

            }
        });


    }

    private void criarLogin()  {
    //mAuth.createUserWithEmailAndPassword(nokia.getEmail(),nokia.getSenha());
        mAuth.createUserWithEmailAndPassword(nokia.getEmail(),nokia.getSenha()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();
                    salvarDados();
                    startActivity(new Intent(TelaCadastro.this, ListaContatos.class));
                }else{
                    Toast.makeText(TelaCadastro.this, "Erro de login, tente novamente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void salvarDados() {

        reference.child(idConta()).child("dados_da_conta").child("nome").setValue(nomes.getText().toString());
        reference.child(idConta()).child("dados_da_conta").child("email").setValue(email.getText().toString());
        reference.child(idConta()).child("dados_da_conta").child("senha").setValue(senha.getText().toString());
        reference.child(idConta()).child("dados_da_conta").child("recuperar_senha").child("senha").setValue(senha.getText().toString());
        reference.child(idConta()).child("dados_da_conta").child("recuperar_senha").child("email").setValue(senha.getText().toString());

    }
    public String idConta(){
        String idUser = user.getUid();
        return idUser;

    }

    private void recuperarDados() {
        int quantC = senha.getText().toString().length();
        nokia = new Usuario();

        // nokia.salvarDadosdeRecuperacao(nokia.email.getText().toString(), senha.getText().toString());
        if (nomes.getText().toString() == "" ||
                email.getText().toString() == "" ||
                senha.getText().toString() == "") {



/*Padrão de senha estudado por profissionais em segurança da informação e aplicado em computação.*/


            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
        }else if (quantC < 8) {
            System.out.println("Senha muito pequena, minimo 8 caracteres");
        }else{

            nokia.setNome(nomes.getText().toString());
            nokia.setEmail(email.getText().toString());
            nokia.setSenha(senha.getText().toString());


        }



        }
        public void Dados_de_Recuperacao(){

        }


    }

