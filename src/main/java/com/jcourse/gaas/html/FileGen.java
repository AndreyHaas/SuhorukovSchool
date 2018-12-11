package com.jcourse.gaas.html;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URLDecoder;


public class FileGen implements Runnable {
    private Socket socket;
    private final String getRequest = "GET";
    private final String headRequest = "HEAD";

    public FileGen(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        while (true) {
            if (socket.isClosed()) return;
            try (DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                 DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())) {

                StringBuilder sb = new StringBuilder();
                int c;
                while ((c = inputStream.read()) != -1 && c != 10 && c != 13) {
                    sb.append((char) c);
                }
                String data = sb.toString();
                String args[] = data.split(" ");
                String command = args[0].trim().toUpperCase();

                if (command.equals(getRequest) || command.equals(headRequest)) {
                    System.out.println(command);
                    if (args.length < 2) return;

                    String name = URLDecoder.decode(args[1], "ASCII");
                    if (!FileManager.exist(name)) {
                        answerNotFoundError(outputStream);
                    } else {
                        FileManager fileManager = new FileManager(name);
                        byte[] answer = fileManager.getAnswer();

                        if (answer == null) answerNotFoundError(outputStream);

                        requestFirst(outputStream, answer.length, "text/html");
                        if (command.equals(getRequest)) sendHtmlBody(outputStream, answer);
                    }
                } else {
                    answerOtherError(outputStream);
                }
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void requestFirst(DataOutputStream outputStream, int length, String contentType) throws IOException {
        outputStream.write("HTTP/1.0 200 OK\r\n".getBytes());
        outputStream.flush();
        outputStream.write(("Content-Type: " + contentType + "\r\n").getBytes());
        outputStream.write(("Content-Length: " + length + "\r\n").getBytes());
        outputStream.write("\r\n".getBytes());
        outputStream.flush();
    }

    private void sendHtmlBody(DataOutputStream outputStream, byte[] s) throws IOException {
        outputStream.write(s);
        outputStream.flush();
    }

    private void answerOtherError(DataOutputStream outputStream) throws IOException {
        outputStream.write("HTTP/1.0 501 Not Implemented\r\n".getBytes());
        outputStream.flush();
        outputStream.write(HtmlGen.generateExceptionHtml("501 Not Implemented").getBytes());
        outputStream.flush();
    }

    private void answerNotFoundError(DataOutputStream outputStream) throws IOException {
        outputStream.write("HTTP/1.0 404 Not Found\r\n".getBytes());
        outputStream.flush();
    }
}
