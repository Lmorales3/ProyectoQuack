package com.example.proyectoquack;

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
        //Toast toast = Toast.makeText(context, "read " + archivo, Toast.LENGTH_SHORT);
        //toast.show();
        boolean r = def;
        try {//leer si notificaciones activadas
            FileInputStream fis = context.openFileInput(archivo);
            DataInputStream dis = new DataInputStream(fis);

            //toast = Toast.makeText(context, "abierto " + archivo, Toast.LENGTH_SHORT);
            //toast.show();

            r = dis.readBoolean();

            //toast = Toast.makeText(context, archivo + " es "+ r, Toast.LENGTH_SHORT);
            //toast.show();

            dis.close();
        }catch (FileNotFoundException e){
            //toast = Toast.makeText(context, "no se encontró "+archivo, Toast.LENGTH_SHORT);
            //toast.show();
            try{
                //toast = Toast.makeText(context, "crear "+archivo, Toast.LENGTH_SHORT);
                //toast.show();
                FileOutputStream fos = context.openFileOutput(archivo, MODE_PRIVATE);
                DataOutputStream dos = new DataOutputStream(fos);
                dos.writeBoolean(def);
                dos.flush();
                dos.close();
            } catch (FileNotFoundException f){
                //toast = Toast.makeText(context, "no se creó "+archivo, Toast.LENGTH_SHORT);
                //toast.show();
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
        //Toast toast = Toast.makeText(context, "flip "+archivo, Toast.LENGTH_SHORT);
        //toast.show();
        try {
            //toast = Toast.makeText(context, "limpiar "+archivo, Toast.LENGTH_SHORT);
            //toast.show();
            PrintWriter pw = new PrintWriter(archivo);//borrar valor actual
            pw.close();
        }catch (FileNotFoundException e){
            //toast = Toast.makeText(context, "no se encontró/limpió "+archivo, Toast.LENGTH_SHORT);
            //toast.show();
            try{
                //toast = Toast.makeText(context, "crear l "+archivo, Toast.LENGTH_SHORT);
                //toast.show();
                FileOutputStream fos = context.openFileOutput(archivo, MODE_PRIVATE);
                DataOutputStream dos = new DataOutputStream(fos);
                dos.writeBoolean(!actual);
                dos.flush();
                dos.close();
                return;
            } catch (FileNotFoundException f){
                //toast = Toast.makeText(context, "no se creó l "+archivo, Toast.LENGTH_SHORT);
                //toast.show();
                f.printStackTrace();
            } catch (IOException f){
                f.printStackTrace();
            }
            e.printStackTrace();
        }

        try{
            //toast = Toast.makeText(context, "excribir en "+archivo, Toast.LENGTH_SHORT);
            //toast.show();
            FileOutputStream fos = context.openFileOutput(archivo, MODE_PRIVATE);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeBoolean(!actual);
            dos.flush();
            dos.close();
        } catch (FileNotFoundException f){
            //toast = Toast.makeText(context, "no se escribió "+archivo, Toast.LENGTH_SHORT);
            //toast.show();
            f.printStackTrace();
        } catch (IOException f){
            f.printStackTrace();
        }
    }
}
