package my.gb.oop.family_tree.model.Family_Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Family_tree_ini <T extends FamilyTreeItem<T>> implements Serializable, Iterable<T>{
    protected List<T> familyTree;
    //-----------------конструкторы----------------------------------------------------------
    public Family_tree_ini() { this(new ArrayList<>());}

    public Family_tree_ini(List<T> familyTree) {this.familyTree = familyTree;}
    //---------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return printFullInfAboutTree();
    }

    @Override
    public Iterator<T> iterator() {
        return familyTree.iterator();
    }
    protected String printFullInfAboutTree() {
        StringBuilder sb = new StringBuilder();
        for (var i : familyTree) {
            sb.append(i);
            sb.append("\n");
        }
        return sb.toString();
    }
    //---------------------------------сортировки------------------------------------------------

    public Family_tree<T> sortByYearBirthday() {
        Family_tree<T> ft_sort = new Family_tree<>();
        Comparator<T> cc = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getDateB().getYear() - o2.getDateB().getYear();
            }
        };
        familyTree.stream().sorted(cc).forEach(ft_sort::addObject);
        return ft_sort;
    }

    public Family_tree<T> sortByName() {
        Family_tree<T> ft_sort = new Family_tree<>();
        Comparator<T> cc = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        familyTree.stream().sorted(cc).forEach(ft_sort::addObject);
        return ft_sort;
    }

    public Family_tree<T> sortByAge() {
        Family_tree<T> ft_sort = new Family_tree<>();
        Comparator<T> cc = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getAge(o1) - o2.getAge(o2);
            }
        };
        familyTree.stream().sorted(cc).forEach(ft_sort::addObject);
        return ft_sort;
    }


}
