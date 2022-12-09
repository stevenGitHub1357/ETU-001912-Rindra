package principe;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import fenetre.*;
import run.*;
public class Client 
{
    public static void main(String[] args)  throws Exception 
    {    
    	
        Socket socket = new Socket("localhost",5555);
        Fenetre fen = new Fenetre(socket);
        System.out.println("Connected -- " );
        Thread th = new Thread(new Ecoute(socket));
        th.start();
        Thread th1 = new Thread(new Expediteur(socket));
        th1.start();
    }
}