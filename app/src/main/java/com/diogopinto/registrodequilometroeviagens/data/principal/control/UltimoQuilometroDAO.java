package com.diogopinto.registrodequilometroeviagens.data.principal.control;

import android.content.Context;
import android.database.Cursor;

import com.diogopinto.registrodequilometroeviagens.data.DbGateway;
import com.diogopinto.registrodequilometroeviagens.data.principal.model.Quilometragem;
import com.diogopinto.registrodequilometroeviagens.data.principal.model.QuilometragemFinal;
import com.diogopinto.registrodequilometroeviagens.data.principal.model.QuilometragemInicial;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class UltimoQuilometroDAO {

    private final String TABLE_CLIENTES = "Clientes";
    private DbGateway gateway;

    public UltimoQuilometroDAO(Context ctx){
        gateway = DbGateway.getInstance(ctx);
    }

    public Quilometragem selecionaUltimoKm(){
        Quilometragem ultimoKm = new QuilometragemInicial();
        Cursor cursor = gateway.getDatabase().rawQuery("SELECT * FROM Quilometragem", null);
        while (cursor.moveToNext()){
            ultimoKm.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            ultimoKm.setHorario(new Date(cursor.getLong(cursor.getColumnIndex("horario"))));
            ultimoKm.setPeriodo(cursor.getInt(cursor.getColumnIndex("periodo")));
            if (ultimoKm.getPeriodo()==1){
                ultimoKm.setKm(cursor.getInt(cursor.getColumnIndex("kmFinal")));
            } else {
                ultimoKm.setKm(cursor.getInt(cursor.getColumnIndex("kmInicio")));
            }
        }
        cursor.close();

        return ultimoKm;
    }//selecionaUltimoKm

    Calendar data = Calendar.getInstance();
    public List<Quilometragem> retornarAllQuilometros(){
        List<Quilometragem> quilometragens = new ArrayList<>();
        Cursor cursor = gateway.getDatabase().rawQuery("SELECT * FROM Quilometragem", null);
        while (cursor.moveToNext()){
            Quilometragem km = new QuilometragemInicial();
            km.setKm(cursor.getInt(cursor.getColumnIndex("kmInicio")));
            km.setPeriodo(cursor.getInt(cursor.getColumnIndex("periodo")));
            km.setHorario(new Date(cursor.getLong(cursor.getColumnIndex("horario"))));
        quilometragens.add(km);

        }

        return quilometragens;
    }
}
