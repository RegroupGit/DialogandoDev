package com.matilhadeestudos.mensageiroqualquer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.matilhadeestudos.mensageiroqualquer.Model.Contato;
import com.matilhadeestudos.mensageiroqualquer.R;

public class AdicionarContato extends AppCompatActivity {
    private EditText nome, email;
    private Button adicionar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_contato);

        nome = findViewById(R.id.NomeContato);
        email = findViewById(R.id.EmailContato);
        adicionar = findViewById(R.id.adicionarContato);

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nome.getText().toString().isEmpty()) {
                    Toast.makeText(AdicionarContato.this, "Insira o nome!", Toast.LENGTH_SHORT).show();
                } else if (email.getText().toString().isEmpty()){
                    Toast.makeText(AdicionarContato.this, "Insira um email!", Toast.LENGTH_SHORT).show();
                } else {
                    Contato c = new Contato();
                    c.setNome(nome.getText().toString());
                    c.setEmail(email.getText().toString());
                    // Firebase.salvarContato(c);
                    finish();
                }
            }
        });

    }
}