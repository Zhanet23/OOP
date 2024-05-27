package my.gb.oop.family_tree;

import java.io.Serializable;

public interface Writable {

    void write(Serializable s, String path);

    Object read(String path);
}

