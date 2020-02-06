package com.diogopinto.registrodequilometroeviagens.data.principal.control;

import android.content.Context;

import com.diogopinto.registrodequilometroeviagens.data.principal.model.Quilometragem;
import com.diogopinto.registrodequilometroeviagens.data.principal.model.QuilometragemFinal;
import com.diogopinto.registrodequilometroeviagens.data.principal.model.QuilometragemInicial;

import java.util.Date;

public class QuilometragemFactory {

    public static Quilometragem quilometragem;

    public static Quilometragem criarQuilometro(int periodo, Context ctx) {
        try {
            switch (periodo) {
                case 0:
                    quilometragem = new QuilometragemInicial(ctx);
                    break;
                case 1:
                    quilometragem = new QuilometragemFinal(ctx);
                    break;
                default:
                    System.out.println("Falha");
            }
            quilometragem.setPeriodo(periodo);
            quilometragem.setHorario(new Date());
        } catch (Exception e) {
//            System.out.println("Falha exceção."+e.getMessage());
        }

        return quilometragem;
    }//criarQuilometro

    public static Quilometragem inicializarUltimoQuilometro(Context ctx) {
        Quilometragem.ultimaQuilometragem = Quilometragem.buscarUltimoKm(ctx);
        return Quilometragem.ultimaQuilometragem;
    }
}
