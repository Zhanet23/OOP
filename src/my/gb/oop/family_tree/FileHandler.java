package my.gb.oop.family_tree;

import java.io.*;

public class FileHandler implements Writable{

    @Override
    public void write(Serializable s, String path) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream(path)));
            out.writeObject(s); out.flush();
            //System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object read (String path) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));
            Object t = ois.readObject();
            if (t != null) System.out.println("считываемый из файла объект не пустой");
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


