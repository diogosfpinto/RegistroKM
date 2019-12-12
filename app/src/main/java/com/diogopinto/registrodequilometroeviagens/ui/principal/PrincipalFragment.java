package com.diogopinto.registrodequilometroeviagens.ui.principal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diogopinto.registrodequilometroeviagens.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class PrincipalFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.activity_home_principal, container, false);

        return root;
    }//onCreateView
}
