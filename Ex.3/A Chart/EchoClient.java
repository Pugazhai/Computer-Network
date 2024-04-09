import java.net.*;
import java.io.*;

public class EchoClient {
    public static void main(String arg[]) {
        Socket socket = null;
        try {
            InetAddress ia = InetAddress.getLocalHost();
            socket = new Socket(ia, 9000);

            // Input and output streams for the socket
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String line;
            while (true) {
                System.out.println("Enter message (type 'end' to quit):");
                line = userInput.readLine();
                if (line.equals("end")) {
                    break;
                }
                out.println(line);
                System.out.println("Server: " + in.readLine());
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing socket: " + e.getMessage());
            }
        }
    }
}
