package com.matilhadeestudos.mensageiroqualquer.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.matilhadeestudos.mensageiroqualquer.Model.Usuario;
import com.matilhadeestudos.mensageiroqualquer.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
//import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TelaCadastro extends AppCompatActivity {

    private final DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


   private Button enviar;
   private EditText nomes,email,senha, id;
   private FirebaseAuth mAuth;
   private Usuario u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        nomes = findViewById(R.id.nomeCadastro);
        email = findViewById(R.id.emailCadastro);
        senha = findViewById(R.id.senhaCadastro);
        enviar = findViewById(R.id.buttonEnviar);
        mAuth = FirebaseAuth.getInstance();


    enviar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            recuperarDados();

            criarLogin();
        }
    });


    }

    private void criarLogin(){
        mAuth.createUserWithEmailAndPassword(u.getEmail(),u.getSenha())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser user = mAuth.getCurrentUser();
                            logar();
                            //startActivity(new Intent(TelaCadastro.this, ListaContatos.class));
                        }else{
                            Toast.makeText(TelaCadastro.this,"Erro ao criar login",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    //TelaLogin login = new TelaLogin();
    //k



    private void logar() {
        mAuth.signInWithEmailAndPassword(u.getEmail(), u.getSenha())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser user = mAuth.getCurrentUser();
                            u.setId(user.getUid());
                            salvarDados();
                            startActivity(new Intent(TelaCadastro.this, ListaContatos.class));
                        }else{
                            Toast.makeText(TelaCadastro.this,"Erro ao autenticar/Conta não existe",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    private void salvarDados(){
        referencia.child("usuarios").child(idConta()).child("dados_da_conta").child("nome").setValue(nomes.getText().toString());
        referencia.child("usuarios").child(idConta()).child("dados_da_conta").child("email").setValue(email.getText().toString());
        referencia.child("usuarios").child(idConta()).child("dados_da_conta").child("senha").setValue(senha.getText().toString());
        referencia.child("usuarios").child(idConta()).child("dados_da_conta").child("recuperar_senha").child("senha").setValue("senhaDohehehe");
        referencia.child("usuarios").child(idConta()).child("dados_da_conta").child("recuperar_senha").child("email").setValue("hehehe@gmail.com");
    }

    private void recuperarDados(){
        if (    nomes.getText().toString() == "" ||
                email.getText().toString() == "" ||
                senha.getText().toString() == ""){

            Toast.makeText(this,"Voce deve prencher todos os dados",Toast.LENGTH_LONG).show();

        }else{
            u = new Usuario();
            u.setNome(nomes.getText().toString());
            u.setEmail(email.getText().toString());
            u.setSenha(senha.getText().toString());

        }

    }
    public String idConta() {


        String IdUser = user.getUid();

        return IdUser;


    }

}