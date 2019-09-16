package com.example.proyectoquack.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.proyectoquack.Entidades.Usuario;


public class DBQueries {
    public static boolean LoginConductor(String username, String password, Context context, boolean comingback){ //comingback es para iniciar automaticamente sesión
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, "db", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String query = "SELECT password FROM conductor WHERE username = '" + username +"'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            if (cursor.getString(0).compareTo(password)==0) {
                db.close();
                return true;
            } else if (!comingback)Toast.makeText(context, "Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
        } else if (!comingback)Toast.makeText(context, "No se encuentra registrado como Conductor", Toast.LENGTH_SHORT).show();
        db.close();
        return false;
    }



    public static boolean isConductorRegistrado(String username, Context context){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, "db", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String query = "SELECT * FROM conductor WHERE username = '" + username +"'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) return true;
        else return false;
    }



    public static Usuario getUsuario(String username, Context context){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, "db", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String query = "SELECT username, nombre, password, correo, telefono, rut, sexo FROM conductor WHERE username = '" + username +"'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            Usuario usuario = new Usuario(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
            return usuario;
        }
        return null;
    }


}
