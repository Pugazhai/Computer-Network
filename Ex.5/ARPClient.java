import java.net.*;

public class ARPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();

            String ipAddress = "192.168.1.100"; // Example IP address
            byte[] sendData = ipAddress.getBytes();
            // System.out.println("Send Data Variable : ");
            // System.out.println(sendData);
            InetAddress serverAddress = InetAddress.getByName("localhost");
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);

            socket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String macAddress = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("MAC Address for " + ipAddress + ": " + macAddress);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}