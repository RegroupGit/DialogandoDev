package com.matilhadeestudos.mensageiroqualquer.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.matilhadeestudos.mensageiroqualquer.Model.Recente;
import com.matilhadeestudos.mensageiroqualquer.R;

import java.util.List;

public class RecenteAdap extends RecyclerView.Adapter<RecenteAdap.MyViewHolder> {
    private List<Recente> listaRecentes;
    public RecenteAdap(List<Recente> lista) {
        this.listaRecentes = lista;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nome, mensagem, hora;
        ImageView foto;

        public MyViewHolder(View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.nome);
            mensagem = itemView.findViewById(R.id.email);
            foto = itemView.findViewById(R.id.imageView);
            hora = itemView.findViewById(R.id.hora);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptador_recentes, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull RecenteAdap.MyViewHolder holder, int position) {
        Recente recente = listaRecentes.get(position);
        holder.nome.setText(recente.getNome());
        holder.mensagem.setText(recente.getMensagem());
        holder.foto.setImageResource(recente.getImagem());
        holder.hora.setText(recente.getHora());
    }

    @Override
    public int getItemCount() {
        return listaRecentes.size();
    }

}
