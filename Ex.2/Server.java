import java.io.*;
import java.net.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Server {
    public static void main(String args[]) {
        try {
            ServerSocket server = null;
            Socket socket;

            // Create a server socket to listen for incoming connections
            server = new ServerSocket(4000);
            System.out.println("Server Waiting for image");

            // Accept connection from client
            socket = server.accept();
            System.out.println("Client connected.");

            // Read image data from client
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            int len = dis.readInt();
            System.out.println("Image Size: " + len / 1024 + "KB");
            byte[] data = new byte[len];
            dis.readFully(data);
            dis.close();
            in.close();
            socket.close();

            // Convert byte array to BufferedImage and display
            InputStream ian = new ByteArrayInputStream(data);
            BufferedImage bImage = ImageIO.read(ian);

            // Display the image in a JFrame
            JFrame f = new JFrame("Server");
            ImageIcon icon = new ImageIcon(bImage);
            JLabel l = new JLabel();
            l.setIcon(icon);
            f.add(l);
            f.pack();
            f.setVisible(true);
            
            // Close the server socket
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
