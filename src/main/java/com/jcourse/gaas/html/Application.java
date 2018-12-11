package com.jcourse.gaas.html;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Application {
    public static void main(String[] args){

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection ... from " + socket.getRemoteSocketAddress());
                new Thread(new FileGen(socket)).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
