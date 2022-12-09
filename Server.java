package principe;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import run.*;
import fenetre.*;
public class Server 
{
    public static void main(String[] args) throws Exception { 
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Waiting for a client ");
        Socket socket = serverSocket.accept();
        Fenetre1 fen = new Fenetre1(socket);
        System.out.println("A client is connected ");
        Thread th = new Thread(new Ecoute(socket));
        th.start();
        Thread th1 = new Thread(new Expediteur(socket));
        th1.start();

        }
}