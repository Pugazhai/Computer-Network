import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class ARPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876);

            byte[] receiveData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String ipAddress = new String(receivePacket.getData(), 0, receivePacket.getLength());
                String macAddress = getMacAddress(ipAddress);

                byte[] sendData = macAddress.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static String getMacAddress(String ipAddress) {
        return "00:1A:2B:3C:4D:5E"; 
    }
}
