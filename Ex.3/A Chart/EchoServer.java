import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            serverSocket = new ServerSocket(9000);
            System.out.println("Server is running...");
            clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Input and output streams for the client socket
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Client: " + line);
                out.println("Server: " + line);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (clientSocket != null) {
                    clientSocket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing socket: " + e.getMessage());
            }
        }
    }
}
