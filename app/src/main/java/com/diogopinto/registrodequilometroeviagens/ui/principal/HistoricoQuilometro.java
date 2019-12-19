package com.diogopinto.registrodequilometroeviagens.ui.principal;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.diogopinto.registrodequilometroeviagens.R;
import com.diogopinto.registrodequilometroeviagens.adapter.AdapterListaQuilometro;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoricoQuilometro extends Fragment {

    public HistoricoQuilometro() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_historico_quilometro, container, false);

        // Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.recycler_lista_quilometros);

        AdapterListaQuilometro adapterListaQuilometro = new AdapterListaQuilometro();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterListaQuilometro);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);

        return view;
    }
}
