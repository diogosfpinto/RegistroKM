package com.diogopinto.registrodequilometroeviagens.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "banco.db";
    private static final int DATABASE_VERSION = 1;
    private final String CREATE_TABLE = "CREATE TABLE Quilometragem(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "kmInicio INTEGER, " +
            "kmFinal INTEGER, " +
            "kmPercorrido INTEGER, " +
            "horario DATE NOT NULL, " +
            "periodo INT NOT NULL);";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }//constructor

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
