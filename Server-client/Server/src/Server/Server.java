package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(8189)){
            while(true){
                Socket socket = serverSocket.accept();
                new Thread(new Myserver(socket)).start();
            }
        }

    }
}
