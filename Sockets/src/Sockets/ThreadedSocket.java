package Sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ThreadedSocket implements Runnable {

    private Socket clientSocket;

    public ThreadedSocket(Socket clientSocket) {

        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            PrintStream out = new PrintStream(clientSocket.getOutputStream());
            Scanner scanner = new Scanner(clientSocket.getInputStream());

            String line = scanner.nextLine();

            out.println(line);
            clientSocket.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
