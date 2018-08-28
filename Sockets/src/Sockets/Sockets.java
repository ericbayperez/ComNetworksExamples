package Sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Sockets {

    //Server : Known Address and port, answers questions
    //Client : Finds the server, asks questions

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            while (true) {

                //Block method call ... it won't return until a client socket connects
                Socket clientSocket = serverSocket.accept();

                ThreadedSocket threadedSocket = new ThreadedSocket(clientSocket);
                Thread thread = new Thread(threadedSocket);
                thread.start();

                //How do I talk to the console in Java?
                //Out --> System.out instance of PrintStream
                //In --> Scanner(System.in) instance of InputStream

                PrintStream out = new PrintStream(clientSocket.getOutputStream());
                Scanner scanner = new Scanner(clientSocket.getInputStream());

                String line = scanner.nextLine();

                out.println(line);
                clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
