package com.diogopinto.registrodequilometroeviagens.ui.principal;


import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.diogopinto.registrodequilometroeviagens.R;
import com.diogopinto.registrodequilometroeviagens.data.principal.control.AdapterListaQuilometro;
import com.diogopinto.registrodequilometroeviagens.data.principal.control.RecyclerItemClickListener;
import com.diogopinto.registrodequilometroeviagens.data.principal.control.UltimoQuilometroDAO;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoricoQuilometro extends Fragment {

    public HistoricoQuilometro() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;

    AdapterListaQuilometro adapterListaQuilometro;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_historico_quilometro, container, false);

        // Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.recycler_lista_quilometros);

        UltimoQuilometroDAO dao = new UltimoQuilometroDAO(getContext());
        adapterListaQuilometro = new AdapterListaQuilometro(dao.retornarAllQuilometros());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterListaQuilometro);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                        //Cria a caixa de diálogo com mais informações do item selecionado
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setTitle("Mais informações");
                        builder.setMessage("Data do registro: "+adapterListaQuilometro.
                                listaQuilometros.get(position).get("horario")
                                + "\nQuilômetro Inicial: "+adapterListaQuilometro.
                                listaQuilometros.get(position).get("kmInicio")
                                + "\nQuilômetro Final: "+adapterListaQuilometro.
                                listaQuilometros.get(position).get("kmFinal"));
                        builder.create();
                        builder.show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));

        return view;
    }
}
