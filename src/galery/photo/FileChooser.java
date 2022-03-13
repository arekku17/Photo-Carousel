package galery.photo;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class FileChooser {

    public void processImage(String path, int num) {
        File f;
        BufferedImage image = null;
        //read
        try {
            f = new File(path); //image file path
            image = ImageIO.read(f);
            System.out.println("Reading complete.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error en la lectura");
        }

        //write
        //write image
        try {
            String url = System.getProperty("user.dir") + "\\src\\fotos\\" + num;
            System.out.println(url);
            f = new File(url + ".jpg");  //output file path
            ImageIO.write(image, "jpg", f);
            JOptionPane.showMessageDialog(null, "Guardado con Éxito");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error en el guardado");
        }
    }

    public void CreateFile() {
        try {
            String url = System.getProperty("user.dir") + "\\src\\longitud.txt";
            File myObj = new File(url);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeFile(int num) {
        try {
            String url = System.getProperty("user.dir") + "\\src\\longitud.txt";
            FileWriter myWriter = new FileWriter(url);
            myWriter.write("" + num);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public int readFile() {
        int numeroSalida = 0;
        String data = "";
        try {
            String url = System.getProperty("user.dir") + "\\src\\longitud.txt";
            File myObj = new File(url);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            numeroSalida = Integer.parseInt(data);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return numeroSalida;
    }

}
