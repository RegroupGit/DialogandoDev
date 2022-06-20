package com.matilhadeestudos.mensageiroqualquer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.matilhadeestudos.mensageiroqualquer.Model.Mensagem;
import com.matilhadeestudos.mensageiroqualquer.R;

import java.util.ArrayList;
import java.util.List;

public class MensagensAdap extends RecyclerView.Adapter<MensagensAdap.MyViewHolder> {

    private List<Mensagem> mensagens;
    private Context context;
    private static final int tipo_remetente = 0;
    private static final int tipo_destinatario = 1;

    public MensagensAdap(List<Mensagem> lista, Context c) {
        this.mensagens = lista;
        this.context = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item = null;
        if (viewType == tipo_remetente) {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.mensagem_remetente, parent, false);
        } else if (viewType == tipo_destinatario) {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.mensagem_destinatario, parent, false);
        }

        return new MyViewHolder(item);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Mensagem m = mensagens.get(position);
        holder.mensagem.setText(m.getMensagem());
    }

    @Override
    public int getItemCount() {
        return mensagens.size();
    }

    @Override
    public int getItemViewType(int position) {
        Mensagem m = mensagens.get(position);
        System.out.println(m.getDestinatario());
        if (m.getDestinatario()) {
            return tipo_destinatario;
        }
        return tipo_remetente;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mensagem;

        public MyViewHolder(View itemView) {
            super(itemView);
            mensagem = itemView.findViewById(R.id.msg);
        }
    }
}
