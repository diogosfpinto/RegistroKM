package com.diogopinto.registrodequilometroeviagens.data.principal.model;

import android.content.Context;
import android.util.Log;

import com.diogopinto.registrodequilometroeviagens.data.principal.control.QuilometragemFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.diogopinto.registrodequilometroeviagens.data.principal.control.UltimoQuilometroDAO;

public abstract class Quilometragem {

    private int id;
    private int km;
    private Calendar horario;
    private int periodo;

    public static Quilometragem ultimaQuilometragem;

    public Quilometragem(){

    }//constructor

    public Quilometragem(int id, int km, Calendar horario, int periodo) {
        this.id = id;
        this.km = km;
        this.horario = horario;
        this.periodo = periodo;
    }//constructor

    public boolean adicionarKm(Quilometragem km) {
        boolean result = false;

        if (km.getKm() >= ultimaQuilometragem.getKm()) {

            switch (QuilometragemFactory.quilometragem.getPeriodo()) {
                case 0:
                    result = adicionarKmInicial(QuilometragemFactory.quilometragem);
                    break;
                case 1:
                    result = adicionarKmFinal(QuilometragemFactory.quilometragem);
                    break;
            }
        } else {
            System.out.println("Km é menor que ultimo quilometro.");
        }

        return result;
    }//adicionarKm

    protected abstract boolean adicionarKmInicial(Quilometragem km);

    protected abstract boolean adicionarKmFinal(Quilometragem km);

    public static final Quilometragem buscarUltimoKm(Context ctx) {
        UltimoQuilometroDAO dao = new UltimoQuilometroDAO(ctx);
        return dao.selecionaUltimoKm();
    }

    protected final boolean isMesmoDia(Quilometragem km){
        boolean isMesmoDia = false;


        Log.i("Data_ultimo_km", "Data do ultimo Km: " + ultimaQuilometragem.getHorario());

        if (ultimaQuilometragem.getHorario() != null){
            int diaUltimoKm = ultimaQuilometragem.getHorario().get(Calendar.DAY_OF_MONTH);
            int diaKm = km.getHorario().get(Calendar.DAY_OF_MONTH);
            int mesUltimoKm = ultimaQuilometragem.getHorario().get(Calendar.MONTH);
            int mesKm = km.getHorario().get(Calendar.MONTH);

            if (diaUltimoKm == diaKm && mesUltimoKm == mesKm){
                isMesmoDia = true;
            }
        }
        return isMesmoDia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public Calendar getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = new GregorianCalendar();
        this.horario.setTime(horario);
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
}
