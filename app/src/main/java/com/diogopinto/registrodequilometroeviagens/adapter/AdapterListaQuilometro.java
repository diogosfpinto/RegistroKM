package com.diogopinto.registrodequilometroeviagens.adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.diogopinto.registrodequilometroeviagens.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterListaQuilometro extends RecyclerView.Adapter<AdapterListaQuilometro.MyViewHolder> {

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_quilometro,
                parent,
                false);

        MyViewHolder myViewHolder = new MyViewHolder(itemLista);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.observacao.setText("Abasteciemento");
        holder.kmPercorrido.setText("45000");
        holder.data.setText("23/04/2019");
    }//onBindViewHolder

    @Override
    public int getItemCount() {
        return 8;
    }

    //Inner Class
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView data, kmPercorrido, observacao;
        
        public MyViewHolder(View itemView){
            super(itemView);
            data = itemView.findViewById(R.id.tvDataLista);
            kmPercorrido = itemView.findViewById(R.id.tvKmPercorridoLista);
            observacao = itemView.findViewById(R.id.tvObservacaoLista);

        }
    }
}
