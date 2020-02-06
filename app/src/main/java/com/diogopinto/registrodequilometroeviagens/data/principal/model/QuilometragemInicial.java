package com.diogopinto.registrodequilometroeviagens.data.principal.model;

import android.content.Context;

import com.diogopinto.registrodequilometroeviagens.data.principal.control.QuilometragemInicialDAO;

public class QuilometragemInicial extends Quilometragem {

    QuilometragemInicialDAO dao;

    public QuilometragemInicial(){

    }//construtor

    public QuilometragemInicial(Context ctx){
        dao = new QuilometragemInicialDAO(ctx);
    }//constructor

    @Override
    public boolean adicionarKmInicial(Quilometragem km){
//Se data é maior que data de ultimo registro então adiciona nova tupla
        if (isMesmoDia(km)==false){
            result = dao.adicionarKmInicial(km);
            //atualiza quilometro final do registro anterior;
            adicionarKmFinal(km);
            return result;
        } else {
            System.out.println("Já existe um km inicial para hoje.");
            return result;
        }
    }

    @Override
    protected boolean adicionarKmFinal(Quilometragem km) {
        return dao.atualizarKmFinal(km, ultimaQuilometragem);

    }
}
