package com.diogopinto.registrodequilometroeviagens.data.principal.model;

import android.content.Context;

import com.diogopinto.registrodequilometroeviagens.data.principal.control.QuilometragemFinalDAO;

public class QuilometragemFinal extends Quilometragem {

    QuilometragemFinalDAO dao;

    public QuilometragemFinal(){

    }//construtor

    public QuilometragemFinal (Context ctx){
        dao = new QuilometragemFinalDAO(ctx);
    }//construtor

    @Override
    protected boolean adicionarKmInicial(Quilometragem km) {
        return dao.atualizarKmInicial(km, ultimaQuilometragem);
    }

    @Override
    protected boolean adicionarKmFinal(Quilometragem km) {
//Se data é maior que data de ultimo registro então adiciona nova tupla
        if (isMesmoDia(km) == false){
            result = dao.adicionarKmFinal(km);
//            adicionarKmInicial(km);
            //adicionar metodo para adicionar novo registro para nova data como ultimo km

            return result;
        } else {
            System.out.println("Atulizar tupla já criada.");
            return dao.atualizarKmFinal(km, ultimaQuilometragem);
        }
    }//adicionarKmFinal
}
