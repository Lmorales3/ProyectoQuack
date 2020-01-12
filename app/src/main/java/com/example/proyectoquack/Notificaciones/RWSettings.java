package com.example.proyectoquack.Notificaciones;

import android.content.Context;
import android.widget.Toast;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import static android.content.Context.MODE_PRIVATE;

public class RWSettings {
    //leer valor actual en el archivo
    public static boolean read(String archivo, Context context, boolean def){
        boolean r = def;
        try {//leer si notificaciones activadas
            FileInputStream fis = context.openFileInput(archivo);
            DataInputStream dis = new DataInputStream(fis);
            r = dis.readBoolean();
            dis.close();
        }catch (FileNotFoundException e){
            try{
                FileOutputStream fos = context.openFileOutput(archivo, MODE_PRIVATE);
                DataOutputStream dos = new DataOutputStream(fos);
                dos.writeBoolean(def);
                dos.flush();
                dos.close();
            } catch (FileNotFoundException f){
                f.printStackTrace();
            } catch (IOException f){
                f.printStackTrace();
            }
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return r;
    }

    //cambiar valor en el archivo
    public static void flip(String archivo, Context context){
        boolean actual = read(archivo, context, true);
        try {
            PrintWriter pw = new PrintWriter(archivo);//borrar valor actual
            pw.close();
        }catch (FileNotFoundException e){
            try{
                FileOutputStream fos = context.openFileOutput(archivo, MODE_PRIVATE);
                DataOutputStream dos = new DataOutputStream(fos);
                dos.writeBoolean(!actual);
                dos.flush();
                dos.close();
                return;
            } catch (FileNotFoundException f){
                f.printStackTrace();
            } catch (IOException f){
                f.printStackTrace();
            }
            e.printStackTrace();
        }

        try{
            FileOutputStream fos = context.openFileOutput(archivo, MODE_PRIVATE);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeBoolean(!actual);
            dos.flush();
            dos.close();
        } catch (FileNotFoundException f){
            f.printStackTrace();
        } catch (IOException f){
            f.printStackTrace();
        }
    }
}
