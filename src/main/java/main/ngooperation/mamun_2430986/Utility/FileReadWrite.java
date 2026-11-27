package main.ngooperation.mamun_2430986.Utility;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class FileReadWrite {

    private static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
        }
    }

    public static <T> ObservableList<T> loadData(Class<T> className, String fileName) {
        ObservableList<T> list = FXCollections.observableArrayList();

        File file = new File(fileName);
        if (!file.exists()) {
            return list;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (className.isInstance(obj)) {
                        list.add(className.cast(obj));
                    }
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static <T> void saveData(ObservableList<T> list, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (T obj : list) {
                oos.writeObject(obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void append(T object, String fileName) {
        try {
            File file = new File(fileName);
            boolean appendRequiresSkip = file.exists() && file.length() > 0;
            ObjectOutputStream oos;

            if (appendRequiresSkip) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(fileName, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(fileName, true));
            }

            oos.writeObject(object);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
