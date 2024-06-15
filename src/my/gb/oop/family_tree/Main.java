package my.gb.oop.family_tree;

import my.gb.oop.family_tree.model.Family_Tree.Family_tree;
import my.gb.oop.family_tree.model.Human.Human;
import my.gb.oop.family_tree.model.Service.FileHandler;
import my.gb.oop.family_tree.model.Service.Writable;
import my.gb.oop.family_tree.view.ConsoleUI;
import my.gb.oop.family_tree.view.View;

import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) {
        View v = new ConsoleUI();
        v.start();
    }
}

