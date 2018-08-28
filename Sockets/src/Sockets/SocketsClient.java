package Sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketsClient {

    public static void main(String[] args){

        try {
            Socket socket = new Socket("localhost",5000);

            PrintStream out = new PrintStream(socket.getOutputStream());
            Scanner scanner = new Scanner(socket.getInputStream());

            out.println("Echo this back to me");
            String line = scanner.nextLine();

            System.out.println("the serer said: " + line);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
