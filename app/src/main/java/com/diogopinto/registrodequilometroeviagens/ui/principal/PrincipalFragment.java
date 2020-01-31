package com.diogopinto.registrodequilometroeviagens.ui.principal;

import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.diogopinto.registrodequilometroeviagens.R;
import com.diogopinto.registrodequilometroeviagens.data.Constantes;
import com.diogopinto.registrodequilometroeviagens.data.principal.control.QuilometragemFactory;
import com.diogopinto.registrodequilometroeviagens.data.principal.model.Quilometragem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class PrincipalFragment extends Fragment {

    RadioButton rbInicioExpediente, rbFinalExpediente;
    Button btSalvar;
    EditText novoKmEditText;

    private Quilometragem quilometragem;

    public PrincipalFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.activity_home_principal, container, false);

        QuilometragemFactory.inicializarUltimoQuilometro(getContext());
        referenciarComponentes(root);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rbInicioExpediente.isChecked()){
                    //cria objeto para quilometro Inicial
                    quilometragem = QuilometragemFactory.criarQuilometro(
                            Constantes.PERIODO_REGISTRO_KM_INICIAL, getContext());

                    quilometragem.setKm(Integer.parseInt(novoKmEditText.getText().toString()));

                    Log.i("novoKm", "Novo Km Digitado: "+quilometragem.getKm());

                    boolean result = quilometragem.adicionarKm(quilometragem);
                    if (result){
                        Toast.makeText(getContext(), "Salvo com sucesso", Toast.LENGTH_LONG).show();
                        resetarCampos();
                    }else {
                        Toast.makeText(getContext(), "Registro não salvo.", Toast.LENGTH_LONG).show();
                    }

                } else if (rbFinalExpediente.isChecked()){
                    //cria objeto para quilometro Final
                    quilometragem = QuilometragemFactory.criarQuilometro(
                            Constantes.PERIODO_REGISTRO_KM_FINAL, getContext());
                }
            }
        });

        return root;
    }//onCreateView


    //Recebe uma view que busca os componentes do layout para referênciá-los.
    private void referenciarComponentes(View view){
        rbInicioExpediente = view.findViewById(R.id.rbInicioExp);
        rbFinalExpediente = view.findViewById(R.id.rbFinalExp);
        btSalvar = view.findViewById(R.id.btSalvar);
        novoKmEditText = view.findViewById(R.id.novoKmTextInputText);
    }//referenciarComponentes

    private void resetarCampos(){
        QuilometragemFactory.inicializarUltimoQuilometro(getContext());
        novoKmEditText.setText("");
        quilometragem = null;
    }
}
