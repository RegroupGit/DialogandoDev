package com.matilhadeestudos.mensageiroqualquer.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatToggleButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
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
    private Usuario u = new Usuario();
    private TextView Nome, Email;
    private ImageView Foto;
    private String nome, email;
    private FloatingActionButton fbutton,botaoSair;
    private int foto;
    private FirebaseAuth mAuth;

    //private FirebaseUser usuario;
    private FirebaseDatabase bd;
    String nomeDoBd;
    private final DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    TelaLogin telaLogin = new TelaLogin();


    public UserInfo() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        mAuth = FirebaseAuth.getInstance();
        Nome = findViewById(R.id.nomeInfo);
        Email = findViewById(R.id.emailInfo);
        Foto = findViewById(R.id.fotoInfo);
        fbutton = findViewById(R.id.botaoSair);
        Email.setText(email);
        Foto.setImageResource(foto);

        getSupportActionBar().hide();

        DatabaseReference nomeBD1 = referencia.child("usuarios").child(idConta()).child("dados_da_conta");
        DatabaseReference emailBD1 = referencia.child("usuarios").child(idConta()).child("dados_da_conta");

        nomeBD1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               String nomis = dataSnapshot.child("nome").getValue(String.class);
               Nome.setText(nomis );
                System.out.println(nomis);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        emailBD1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               String nomis = dataSnapshot.child("email").getValue(String.class);
               Email.setText(nomis);
                System.out.println(nomis);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        final Intent[] intent = {getIntent()};
        contato = intent[0].getBooleanExtra("contato", true);

           if (contato) {
            Contato c = (Contato) intent[0].getSerializableExtra("usuario");
          //  nome = c.getNome();
            email = c.getEmail();
            foto = c.getImagem();
        } else {


        }


        if (contato) {
            fbutton.setImageResource(R.drawable.ic_baseline_edit_48);
        } else {
            fbutton.setImageResource(R.drawable.ic_baseline_exit_to_app_48);
        }

            fbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (contato) {
                        Toast.makeText( UserInfo.this , "Função pendente!", Toast.LENGTH_SHORT).show();
                    } else {
                        try {

                            Nome.setText("Deslogado");
                            Email.setText("Deslogado");

                            deslogar();
                            startActivity(new Intent(getApplicationContext(), TelaLogin.class));

                            finish();



                        } catch (Exception e) {
                            System.out.println("falhou cara ve ai novamente");
                        }

                    }

                }
            });
    }


    public String idConta() {


        String IdUser = user.getUid();

        return IdUser;


    }
    public void deslogar(){
        mAuth.signOut();
    }

}