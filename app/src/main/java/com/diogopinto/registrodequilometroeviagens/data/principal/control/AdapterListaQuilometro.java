package com.diogopinto.registrodequilometroeviagens.data.principal.control;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.diogopinto.registrodequilometroeviagens.R;
import com.diogopinto.registrodequilometroeviagens.data.principal.model.Quilometragem;

import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterListaQuilometro extends RecyclerView.Adapter<AdapterListaQuilometro.MyViewHolder> {

    public List<Map<String, String>> listaQuilometros;

    public AdapterListaQuilometro(List listaQuilometros){
        this.listaQuilometros = listaQuilometros;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_lista_quilometro,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Log.i("ListaQuilometros", "KmInicio: "+ listaQuilometros.get(position).get("kmInicio"));
        Log.i("ListaQuilometros", "KmFinal: "+listaQuilometros.get(position).get("kmFinal"));
        Log.i("ListaQuilometros", "Data: "+listaQuilometros.get(position).get("horario"));
        Log.i("ListaQuilometros", "KmPercorrido"+listaQuilometros.get(position).get("kmPercorrido"));

        holder.kmPercorrido.setText(String.valueOf(listaQuilometros.get(position).get("kmPercorrido")));
        holder.data.setText(listaQuilometros.get(position).get("horario"));
    }//onBindViewHolder

    @Override
    public int getItemCount() {
        return listaQuilometros != null ? listaQuilometros.size() : 0;
    }

    //Inner Class
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView data, kmPercorrido, observacao;
        
        public MyViewHolder(View itemView){
            super(itemView);
            data = (TextView) itemView.findViewById(R.id.tvDataLista);
            kmPercorrido = (TextView) itemView.findViewById(R.id.tvKmPercorridoValor);
            observacao = (TextView) itemView.findViewById(R.id.tvObservacaoLista);

        }
    }
}
