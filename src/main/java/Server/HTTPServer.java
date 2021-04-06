package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//This class will initialize the server
public class HTTPServer {

    public static int port = 8080;
    protected HTTPServerThread[] threads = null;
    //Server Variables
    protected ServerSocket serverSocket = null;
    protected Socket clientSocket = null;
    protected int numClients = 0;

    //Constructor
    public HTTPServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is now running!");
            System.out.println("Listening to port: " + port);
            threads = new HTTPServerThread[10];
            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Client #" + (numClients + 1) + " connected");
                System.out.println("Connection established!");
                threads[numClients] = new HTTPServerThread(clientSocket);
                threads[numClients].start();
                numClients++;

            }
        } catch (IOException e) {
            System.err.println("Error while establishing server connection!");
        }
    }

    public static void main(String[] args) {
        HTTPServer server = new HTTPServer();
    }
}



