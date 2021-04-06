package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HTTPServerThread extends Thread {
    String line = null;
    BufferedReader in = null;
    PrintWriter out = null;
    Socket socket = null;

    public HTTPServerThread(Socket socket) {
        super();
        this.socket = socket;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.err.println("IOException while opening a read/write connection");
        }
    }

    public void run() {

        try {
            line = in.readLine();
            while (line.compareToIgnoreCase("QUIT") != 0) {
                out.println(line);
                out.flush();
                System.out.println("Response to clint" + line);
                line = in.readLine();
            }
        } catch (IOException e) {
            line = this.getName();
            System.err.println("IOException while opening a read/write connection");
        } catch (NullPointerException e) {
            line = this.getName();
            System.out.println("Client " + line + " Closed");
        } finally {
            try {
                System.out.println("Connection Closing..");
                if (in != null) {
                    in.close();
                    System.out.println("Socket Input Stream Closed");
                }

                if (out != null) {
                    out.close();
                    System.out.println("Socket Out Closed");
                }
                if (socket != null) {
                    socket.close();
                    System.out.println("Socket Closed");
                }

            } catch (IOException ie) {
                System.out.println("Socket Close Error");
            }
        }//end finally
    }

}

