package my.gb.oop.family_tree.model.Human;

import java.io.Serializable;

// класс предназначен для подсчета всех людей в данной базе, даже если человек из другого древа
//*public class CreaterHuman implements Serializable {
public class CreaterHuman implements Serializable {
    public  static int i = 0;
    static {
        i = 0;
    }
    public CreaterHuman() {
        i++;
    }


}
