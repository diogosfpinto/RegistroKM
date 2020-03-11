package com.diogopinto.registrodequilometroeviagens.data.principal.control;

import android.content.ContentValues;
import android.content.Context;

import com.diogopinto.registrodequilometroeviagens.data.DbGateway;
import com.diogopinto.registrodequilometroeviagens.data.principal.model.Quilometragem;

public class QuilometragemInicialDAO {

    private final String TABLE_QUILOMETRAGEM = "Quilometragem";
    private DbGateway gateway;

    public QuilometragemInicialDAO(Context ctx){
        gateway = DbGateway.getInstance(ctx);
    }//construtor

    public boolean adicionarKmInicial(Quilometragem km){
        ContentValues cv = new ContentValues();
        cv.put("KmInicio", km.getKm());
        cv.put("horario", km.getHorario().getTimeInMillis());
        cv.put("periodo", km.getPeriodo());

        return gateway.getDatabase().insert(TABLE_QUILOMETRAGEM, null, cv) > 0;
    }

    public boolean atualizarKmFinal(Quilometragem km, Quilometragem ultimaQuilometragem){
        ContentValues cv = new ContentValues();
        cv.put("kmFinal", km.getKm());
        cv.put("kmPercorrido", (km.getKm() - ultimaQuilometragem.getKm()));

        return gateway.getDatabase().update(TABLE_QUILOMETRAGEM, cv, "ID=?",
                new String[]{ultimaQuilometragem.getId() + ""}) > 0;

    }
}
