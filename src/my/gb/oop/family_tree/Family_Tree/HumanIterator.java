package my.gb.oop.family_tree.Family_Tree;

import my.gb.oop.family_tree.Human.Human;

import javax.swing.*;
import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private List<Human> familyTree;
    public HumanIterator(List<Human>familyTree) {
        this.familyTree = familyTree;
    }

    private int ind =0;
    @Override
    public boolean hasNext() {
        return ind < familyTree.size();
    }

    @Override
    public Human next() {
        return familyTree.get(ind++);
    }
}
