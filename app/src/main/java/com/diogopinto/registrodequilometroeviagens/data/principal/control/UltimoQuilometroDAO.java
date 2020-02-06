package com.diogopinto.registrodequilometroeviagens.data.principal.control;

import android.content.Context;
import android.database.Cursor;

import com.diogopinto.registrodequilometroeviagens.data.DbGateway;
import com.diogopinto.registrodequilometroeviagens.data.principal.model.Quilometragem;
import com.diogopinto.registrodequilometroeviagens.data.principal.model.QuilometragemFinal;
import com.diogopinto.registrodequilometroeviagens.data.principal.model.QuilometragemInicial;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UltimoQuilometroDAO {

    private final String TABLE_QUILOMETRAGEM = "Quilometragem";
    private DbGateway gateway;

    public UltimoQuilometroDAO(Context ctx){
        gateway = DbGateway.getInstance(ctx);
    }

    public Quilometragem selecionaUltimoKm(){
        Quilometragem ultimoKm = new QuilometragemInicial();
        Cursor cursor = gateway.getDatabase().rawQuery("SELECT * FROM "+TABLE_QUILOMETRAGEM, null);
        if (cursor!=null){
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
        }

        cursor.close();

        return ultimoKm;
    }//selecionaUltimoKm

    Calendar data = Calendar.getInstance();
    public List<Map<String,String>> retornarAllQuilometros(){
        List<Map<String, String>> quilometragens = new ArrayList<>();

        Cursor cursor = gateway.getDatabase().rawQuery("SELECT * FROM "+TABLE_QUILOMETRAGEM, null);

        cursor.moveToFirst();
        while (cursor.moveToNext()){
            Map<String, String> item = new HashMap<String, String>();

            item.put("kmInicio", cursor.getString(cursor.getColumnIndex("kmInicio")));
            item.put("kmFinal", cursor.getString(cursor.getColumnIndex("kmFinal")));
            item.put("kmPercorrido", cursor.getString(cursor.getColumnIndex("kmPercorrido")));

            Date data = new Date(cursor.getLong(cursor.getColumnIndex("horario")));
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            item.put("horario", dateFormat.format(data));

            quilometragens.add(item);
        }
        cursor.close();

        return quilometragens;
    }
}
