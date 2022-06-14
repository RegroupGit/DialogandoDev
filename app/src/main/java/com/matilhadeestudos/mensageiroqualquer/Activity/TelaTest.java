package com.matilhadeestudos.mensageiroqualquer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.matilhadeestudos.mensageiroqualquer.Model.Usuario;
import com.matilhadeestudos.mensageiroqualquer.R;

public class TelaTest extends AppCompatActivity {

    private final DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


    private Button enviar;
    private EditText nomes,email,senha, id;
    private FirebaseAuth mAuth;
    private Usuario u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Usuario nokia;

        salvarDados();

        System.out.println(referencia);
    }
        private void salvarDados(){

            referencia.child(idConta()).child("usuarios").child("dados_da_conta").child("nome").setValue(nomes.getText().toString());
            referencia.child(idConta()).child("usuarios").child("dados_da_conta").child("email").setValue(email.getText().toString());
            referencia.child(idConta()).child("usuarios").child("dados_da_conta").child("senha").setValue(senha.getText().toString());
            referencia.child(idConta()).child("usuarios").child("dados_da_conta").child("recuperar_senha").child("senha").setValue("senhaDohehehe");
            referencia.child(idConta()).child("usuarios").child("dados_da_conta").child("recuperar_senha").child("email").setValue("hehehe@gmail.com");

        }
        public String idConta() {
            String idUser = user.getUid();
            return idUser;
//
        }
    }
