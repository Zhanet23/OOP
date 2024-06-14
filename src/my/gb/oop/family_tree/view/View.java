package my.gb.oop.family_tree.view;

import my.gb.oop.family_tree.model.Family_Tree.FamilyTreeItem;
import my.gb.oop.family_tree.model.Family_Tree.Family_tree;
import my.gb.oop.family_tree.model.Human.Human;

public interface View {
    void printAnswer(String info);

    void start();
}
