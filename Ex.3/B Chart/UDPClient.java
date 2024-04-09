import java.io.*;
import java.net.*;

public class UDPClient {
    public static DatagramSocket ds;
    public static int clientPort = 789;
    public static int serverPort = 790;

    public static void main(String args[]) throws Exception {
        ds = new DatagramSocket(clientPort);
        System.out.println("Server waiting...");
        BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
        InetAddress ia = InetAddress.getLocalHost();
        while (true) {
            System.out.print("Client: ");
            String str = dis.readLine();
            if (str.equals("end")) {
                break;
            }
            byte buffer[] = new byte[1024];
            buffer = str.getBytes();
            DatagramPacket p = new DatagramPacket(buffer, str.length(), ia, serverPort);
            ds.send(p);
            DatagramPacket replyPacket = new DatagramPacket(buffer, buffer.length);
            ds.receive(replyPacket);
            String receivedMessage = new String(replyPacket.getData(), 0, replyPacket.getLength());
            System.out.println("Server: " + receivedMessage);
        }
        ds.close();
    }
}
