import java.io.*;
import java.net.*;

public class UDPServer {
    public static DatagramSocket ds;
    public static byte buffer[] = new byte[1024];
    public static int clientPort = 789;
    public static int serverPort = 790;

    public static void main(String args[]) throws Exception {
        ds = new DatagramSocket(serverPort);
        System.out.println("Server is running...");
        BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
        InetAddress ia = InetAddress.getLocalHost();
        while (true) {
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            ds.receive(p);
            String receivedMessage = new String(p.getData(), 0, p.getLength());
            System.out.println("Client: " + receivedMessage);
            System.out.print("Server: ");
            String str = dis.readLine();
            if (str.equals("end")) {
                break;
            }
            buffer = str.getBytes();
            DatagramPacket replyPacket = new DatagramPacket(buffer, str.length(), ia, clientPort);
            ds.send(replyPacket);
        }
        ds.close();
    }
}
