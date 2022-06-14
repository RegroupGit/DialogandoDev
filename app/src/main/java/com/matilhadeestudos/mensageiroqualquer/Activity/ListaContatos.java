package com.matilhadeestudos.mensageiroqualquer.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.matilhadeestudos.mensageiroqualquer.Adapter.ContatoAdap;
import com.matilhadeestudos.mensageiroqualquer.Model.Contato;
import com.matilhadeestudos.mensageiroqualquer.R;

import java.util.ArrayList;
import java.util.List;

public class ListaContatos extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Contato> listaContatos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);

        recyclerView = findViewById(R.id.recyclerView);

        //Definir Layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, 1));

        // definir adapter
        prepararContatos();
        ContatoAdap adapter = new ContatoAdap(listaContatos);
        recyclerView.setAdapter(adapter);
    }


    public void prepararContatos() {
        Contato c = new Contato("Gabriel Gomes", "gabriel.zsloko@gmail.com", R.drawable.ic_baseline_account_circle_24);
        this.listaContatos.add(c);
        c = new Contato("Lucas Duarte", "lucas.araujo@hotmail.com", R.drawable.ic_baseline_add_circle_70);
        this.listaContatos.add(c);
        c = new Contato("Vinicius Clemente", "gabriel.zsloko@gmail.com", R.drawable.ic_baseline_account_circle_24);
        this.listaContatos.add(c);
        c = new Contato("Luana Aparecida", "gabriel.zsloko@gmail.com", R.drawable.ic_baseline_account_circle_24);
        this.listaContatos.add(c);
        c = new Contato("Everson Hernandes", "gabriel.zsloko@gmail.com", R.drawable.ic_baseline_account_circle_24);
        this.listaContatos.add(c);
        c = new Contato("Junior Bamba", "gabriel.zsloko@gmail.com", R.drawable.ic_baseline_account_circle_24);
        this.listaContatos.add(c);
    }
}
