package com.matilhadeestudos.mensageiroqualquer.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.matilhadeestudos.mensageiroqualquer.Adapter.ContatoAdap;
import com.matilhadeestudos.mensageiroqualquer.Adapter.RecenteAdap;
import com.matilhadeestudos.mensageiroqualquer.Func.RecyclerItemClickListener;
import com.matilhadeestudos.mensageiroqualquer.Model.Contato;
import com.matilhadeestudos.mensageiroqualquer.Model.Recente;
import com.matilhadeestudos.mensageiroqualquer.R;

import java.util.ArrayList;
import java.util.List;

public class ListaContatos extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton switch_b, add_button;

    private List<Contato> listaContatos = new ArrayList<>();
    private List<Recente> listaRecentes = new ArrayList<>();
    private boolean Contatos = true;
    private ContatoAdap adapterContatos;
    private RecenteAdap adapterRecente;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recyclerView);
        switch_b = findViewById(R.id.switch_b);
        add_button = findViewById(R.id.add_contato);

        Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        toolbar.setTitle(R.string.app_name);


        //Definir Layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, 1));

        // definir adapter
        prepararRecentes();
        prepararContatos();
        adapterRecente = new RecenteAdap(listaRecentes);
        recyclerView.setAdapter(adapterRecente);

        // Evento de Click
        RecyclerItemClickListener lContatos = new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Contato contato = listaContatos.get(position);
                Toast.makeText(getApplicationContext(), "Você selecionou o contato: " + contato.getNome(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Contato contato = listaContatos.get(position);
                String auxn = contato.getNome(), auxe = contato.getEmail();
                int auxf = contato.getImagem();
                Intent intent = new Intent(getApplicationContext(), UserInfo.class);
                intent.putExtra("contato", true);
                intent.putExtra("usuario", contato);
                startActivity(intent);

                // Contato contato = listaContatos.get(position);
                // Toast.makeText(getApplicationContext(), "Você tentou atualizar o contato: " + contato.getNome(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        recyclerView.addOnItemTouchListener(lContatos);

    }

    public void switchMensagens(View view) {
        if (!Contatos) {
            adapterContatos = new ContatoAdap(listaContatos);
            recyclerView.setAdapter(adapterContatos);
            switch_b.setImageResource(R.drawable.ic_baseline_message_24);
            add_button.setVisibility(View.VISIBLE);
            Contatos = true;
        } else {
            adapterRecente = new RecenteAdap(listaRecentes);
            recyclerView.setAdapter(adapterRecente);
            switch_b.setImageResource(R.drawable.ic_baseline_contacts_24);
            add_button.setVisibility(View.GONE);
            Contatos = false;
        }
    }


    public void prepararContatos() {
        // Configurar o Firebase aqui!
        // No momento, placeholders para não ficar vazio...
        Contato c = new Contato("Gabriel Gomes", "gabriel.zsloko@gmail.com", R.drawable.ic_baseline_account_circle_24);
        listaContatos.add(c);
        c = new Contato("Lucas Duarte", "lucasd.araujo@hotmail.com", R.drawable.ic_baseline_add_circle_70);
        listaContatos.add(c);
        c = new Contato("Vinicius Clemente", "vinicius16044013@gmail.com", R.drawable.ic_baseline_message_24);
        listaContatos.add(c);
        c = new Contato("Luana Aparecida", "maximoffxstan@gmail.com", R.drawable.ic_baseline_contacts_24);
        listaContatos.add(c);
        c = new Contato("Everson Hernandes", "eversonh95@gmail.com", R.drawable.ic_baseline_message_24);
        listaContatos.add(c);
        c = new Contato("Junior Bamba", "????", R.drawable.ic_baseline_account_circle_24);
        listaContatos.add(c);
    }

    public void prepararRecentes() {
        // Configurar o Firebase aqui!
        // No momento, placeholders para não ficar vazio...
        Recente r = new Recente("Gabriel Gomes", "Estou a muito tempo sem fazer live .-.", R.drawable.ic_baseline_account_circle_24, "12:30");
        listaRecentes.add(r);
        r = new Recente("Lucas Duarte", "Esse Android está muito ruim!", R.drawable.ic_baseline_add_circle_70, "11:25");
        listaRecentes.add(r);
        r = new Recente("Vinicius Clemente", "Bora jogar FNAF Doom? Não consigo baixar outro jogo, pc tá sem memória", R.drawable.ic_baseline_message_24, "11:25");
        listaRecentes.add(r);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
