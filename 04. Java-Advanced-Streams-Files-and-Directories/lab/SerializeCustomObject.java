package class04.lab;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeCustomObject {
    public static void main(String[] args) {
        Cube cube = new Cube();
        cube.color="green";
        cube.width =15.3d;
        cube.height =12.4d;
        cube.depth =3d;

        String path = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/save.txt";
        try (ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
