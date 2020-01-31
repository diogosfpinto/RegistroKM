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
            dao.adicionarKmInicial(km);
//            adicionarKmFinal(km);
            return true;
        } else {
            System.out.println("Já existe um km inicial para hoje.");
            return false;
        }
    }

    @Override
    protected boolean adicionarKmFinal(Quilometragem km) {
        return dao.atualizarKmFinal(km, ultimaQuilometragem);

    }
}