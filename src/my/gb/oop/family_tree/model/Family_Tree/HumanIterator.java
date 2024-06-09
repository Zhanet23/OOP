package my.gb.oop.family_tree.model.Family_Tree;

import my.gb.oop.family_tree.model.Human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T extends FamilyTreeItem<T>> implements Iterator<T> {
    private List<T> familyTree;
    public HumanIterator(List<T>familyTree) {
        this.familyTree = familyTree;
    }

    private int ind =0;
    @Override
    public boolean hasNext() {
        return ind < familyTree.size();
    }

    @Override
    public T next() {
        return familyTree.get(ind++);
    }
}
