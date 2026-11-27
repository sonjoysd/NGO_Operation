package main.ngooperation;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BinaryFileReadWrite {

    public static void WriteObject(String fileName, Object obj){
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;

        try {

            File file = new File(fileName);

            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(obj);
        } catch (RuntimeException e1) {
            System.out.println("Run time exception");
        }catch (IOException e2){
            System.out.println("IO Exception while writing the object");
        } catch (Exception e) {
            System.out.println("Universal Exception while writing the object");
        }
    }
}
