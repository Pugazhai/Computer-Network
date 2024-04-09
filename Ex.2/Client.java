import java.io.*;
import java.net.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class Client {
    public static void main(String args[]) {
        try {
            Socket soc;
            BufferedImage img = null;
            // Connect to the server
            soc = new Socket("localhost", 4000);
            System.out.println("Client is running.");
            // Read the image from disk
            System.out.println("Reading image from disk.");
            img = ImageIO.read(new File("image.jpg"));
            // Convert image to bytes
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos);
            baos.flush();
            byte[] bytes = baos.toByteArray();
            baos.close();
            // Send image to server
            System.out.println("Sending image to server.");
            OutputStream out = soc.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeInt(bytes.length);
            dos.write(bytes, 0, bytes.length);
            System.out.println("Image sent to server.");
            
            // Close streams
            dos.close();
            out.close();
            soc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
