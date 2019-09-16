package com.example.proyectoquack.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String CREATE_TABLE_CONDUCTOR = "CREATE TABLE conductor(username text PRIMARY KEY, " +
            "nombre text, password text, correo text, telefono int, rut text, sexo text)";
    private static final String CREATE_TABLE_USUARIO= "CREATE TABLE pasajero(username text PRIMARY KEY, " +
            "nombre text, password text, correo text, telefono int, rut text, sexo text)";
    private static final String CREATE_TABLE_VIAJE = "CREATE TABLE viaje(id text PRIMARY KEY, " +
            "origen text, destino text, fechainicio text, horainicio text, valortotal int, " +
            "fechallegada text, horallegada text, parada1 text, parada2 text, parada3 text, parada4 text, " +
            "fecha1 text, fecha2 text, fecha3 text, fecha4 text, hora1 text, hora2 text, hora3 text, hora4 text, " +
            "valor1 int, valor2 int, valor3 int, valor4 int, plazas1 int, plazas2 int, plazas3 int, plazas4 int, plazas5 int, " +
            "conductor text)";
    private static final String CREATE_TABLE_RESERVA = "CREATE TABLE reserva(id text PRIMARY KEY, " +
            "idviaje text, username text, plazas1 int, plazas2 int, plazas3 int, plazas4 int, plazas5 int, valor int, procesada int)"; //procesada: 0=no procesada, 1=aceptada, 2=rechazada

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CONDUCTOR);
        db.execSQL(CREATE_TABLE_USUARIO);
        db.execSQL(CREATE_TABLE_VIAJE);
        db.execSQL(CREATE_TABLE_RESERVA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
