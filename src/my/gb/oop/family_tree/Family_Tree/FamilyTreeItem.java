package my.gb.oop.family_tree.Family_Tree;

import my.gb.oop.family_tree.Human.Gender;
import my.gb.oop.family_tree.Human.Human;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Comparable<T> {
    int getId();
    String getName();
    String getSecondName();
    String getMiddleName();
    LocalDate getDateB();
    LocalDate getDateD();
    T getSpouse();
    T getMother();
    T getFather();
    List<T> getChildren();

    Gender getGender();
    StringBuilder getNames(T o);
    void addChild(T o);
    int getAge(T o);
    void addFather(T o);
    void addMother(T o);
    StringBuilder getFIO(T o);
    StringBuilder getDatesOfHuman(T o);
}
