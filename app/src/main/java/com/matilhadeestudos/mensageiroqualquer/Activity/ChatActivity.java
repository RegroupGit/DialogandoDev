package com.matilhadeestudos.mensageiroqualquer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.matilhadeestudos.mensageiroqualquer.R;

public class ChatActivity extends AppCompatActivity {
    private TextView nome;
    private ImageView foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        getSupportActionBar().hide();
        Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle("");
        nome = findViewById(R.id.ContatoNome);
        foto = findViewById(R.id.fotoContato);

        nome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserInfo.class);
                intent.putExtra("contato", true);
                startActivity(intent);
            }
        });

        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserInfo.class);
                intent.putExtra("contato", true);
                startActivity(intent);
            }
        });
    }
}