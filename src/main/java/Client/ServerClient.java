package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerClient {

    //Client Server Variables
    public static String serverAddress = "localhost";
    public static int serverPort = 8080;

    //Client Variables
    private Socket socket;
    private final BufferedReader in;
    private BufferedReader networkIn;
    private PrintWriter networkOut;

    public ServerClient() {
        try {
            InetSocketAddress address = new InetSocketAddress(serverAddress, serverPort);
            socket = new Socket();
            socket.connect(address);

        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + serverAddress);
        } catch (IOException e) {
            System.err.println("IOException while connecting to server: " + serverAddress);
            // Print the wrapper exception:
            System.out.println("Wrapper exception: " + e);

            // Print the 'actual' exception:
            System.out.println("Underlying exception: " + e.getCause());
        }
        if (socket == null) {
            System.err.println("socket is null");
        }
        try {
            networkOut = new PrintWriter(socket.getOutputStream(), true);
            networkIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.err.println("IOException while opening a read/write connection");
        }

        in = new BufferedReader(new InputStreamReader(System.in));
    }
}
