package com.diogopinto.registrodequilometroeviagens.data.principal.model;

import com.diogopinto.registrodequilometroeviagens.data.principal.control.QuilometragemFinalDAO;

public class QuilometragemFinal extends Quilometragem {

    QuilometragemFinalDAO dao = new QuilometragemFinalDAO();

    @Override
    protected boolean adicionarKmInicial(Quilometragem km) {
        return dao.atualizarKmInicial(km, ultimaQuilometragem);
    }

    @Override
    protected boolean adicionarKmFinal(Quilometragem km) {
//Se data é maior que data de ultimo registro então adiciona nova tupla
        if (isMesmoDia(km) == false){
            dao.adicionarKmFinal(km);
            adicionarKmInicial(km);
            //adicionar metodo para adicionar novo registro para nova data como ultimo km

            return true;
        } else {
            return dao.atualizarKmFinal(km, ultimaQuilometragem);
        }
    }//adicionarKmFinal
}
