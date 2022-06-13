package com.matilhadeestudos.mensageiroqualquer.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.matilhadeestudos.mensageiroqualquer.Model.Contato;
import com.matilhadeestudos.mensageiroqualquer.R;

import java.util.List;

public class ContatoAdap extends RecyclerView.Adapter<ContatoAdap.MyViewHolder> {
    private List<Contato> listaContatos;

    public ContatoAdap(List<Contato> lista) {this.listaContatos = lista;}


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptador_contatos, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contato contato = listaContatos.get(position);
        holder.Nome.setText(contato.getNome());
        holder.email.setText(contato.getEmail());
        holder.foto.setImageResource(contato.getImagem());
    }

    @Override
    public int getItemCount() {
        return listaContatos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Nome, email;
        ImageView foto;

        public MyViewHolder(View itemView) {
            super(itemView);

            Nome = itemView.findViewById(R.id.nome);
            email = itemView.findViewById(R.id.email);
            foto = itemView.findViewById(R.id.imageView);
        }
    }
}
