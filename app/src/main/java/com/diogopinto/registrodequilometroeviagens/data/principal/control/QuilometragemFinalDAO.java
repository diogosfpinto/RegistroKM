package com.diogopinto.registrodequilometroeviagens.data.principal.control;

import android.content.ContentValues;
import android.content.Context;

import com.diogopinto.registrodequilometroeviagens.data.DbGateway;
import com.diogopinto.registrodequilometroeviagens.data.principal.model.Quilometragem;

import org.xml.sax.ContentHandler;

public class QuilometragemFinalDAO {

    private final String TABLE_QUILOMETRAGEM = "Quilometragem";
    private DbGateway gateway;

    public QuilometragemFinalDAO(Context ctx){
        gateway = DbGateway.getInstance(ctx);
    }//construtor

    public boolean atualizarKmInicial(Quilometragem km, Quilometragem ultimaKm){
        return false;
    }

    public boolean atualizarKmFinal(Quilometragem km, Quilometragem ultimaKm){
        return false;
    }

    public boolean adicionarKmFinal(Quilometragem km){
        ContentValues cv = new ContentValues();
        cv.put("kmFinal", km.getKm());
        cv.put("horario", km.getHorario().getTimeInMillis());
        cv.put("periodo", km.getPeriodo());

        return gateway.getDatabase().insert(TABLE_QUILOMETRAGEM, null, cv) > 0;
    }
}
