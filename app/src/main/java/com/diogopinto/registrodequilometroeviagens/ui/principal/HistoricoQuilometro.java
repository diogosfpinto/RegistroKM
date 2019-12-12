package com.diogopinto.registrodequilometroeviagens.ui.principal;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diogopinto.registrodequilometroeviagens.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoricoQuilometro extends Fragment {


    public HistoricoQuilometro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_historico_quilometro, container, false);
    }

}
