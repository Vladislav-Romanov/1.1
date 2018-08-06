package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Myserver implements Runnable {
    Socket socket;

    public Myserver(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){
        try(Scanner scanner = new Scanner(socket.getInputStream());
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true)){
            if(scanner.hasNextLine()){
                printWriter.println(""+scanner.nextLine());
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}