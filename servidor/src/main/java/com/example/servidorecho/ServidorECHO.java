package com.example.servidorecho;


import android.os.SystemClock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorECHO {
    public static void main(String args[])
    {
        try
        {
            System.out.println("Servidor en marcha ...");
            ServerSocket sk = new ServerSocket(7);
            while (true)
            {
                Socket cliente = sk.accept();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                PrintWriter salida = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()),true);
                String datos= entrada.readLine();
                salida.println("Mensaje recibido: "+ datos);
                cliente.close();
                System.out.println(datos);
            }

        }catch (Exception error)
        {
            System.out.println(error);
        }
    }
}
