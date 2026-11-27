package main.ngooperation.mamun_2430986.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileReadWrite {

    public static ArrayList<Object> loadData(String fileName) {
        ArrayList<Object> list = new ArrayList<Object>();
        File f = new File(fileName);
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            if (f.exists()) {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                while (true) {
                    list.add(ois.readObject());
                }
            }
        } catch (Exception e) {
            if (ois != null) {
                try {
                    ois.close();
                } catch (Exception e2) {
                }
            }
        }
        return list;
    }

    public static void saveData(ArrayList<Object> list, String fileName) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            for (Object obj : list) {
                oos.writeObject(obj);
            }
            oos.close();
        } catch (Exception e) {
        }
    }

    public static void append(Object object, String fileName) {
        File f = new File(fileName);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if (f.exists() && f.length() > 0) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(object);
            oos.close();
        } catch (Exception e) {
        }
    }
}
