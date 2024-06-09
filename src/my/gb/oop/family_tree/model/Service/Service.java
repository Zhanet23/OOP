package my.gb.oop.family_tree.model.Service;

import my.gb.oop.family_tree.model.Family_Tree.FamilyTreeItem;
import my.gb.oop.family_tree.model.Family_Tree.Family_tree;

public class Service<T extends FamilyTreeItem<T>> {
    public Service() {}

    public String getTreeInfo(Family_tree<T> ft) {
        StringBuilder sb = new StringBuilder();
        for (T h : ft) {sb.append(h).append("\n");}
        return sb.toString();
    }

    public Family_tree<T> sortByYearBirthday (Family_tree<T> ft) {
        return ft.sortByYearBirthday();
    }
    public Family_tree<T> sortByName(Family_tree<T> ft){
        return ft.printSortName();
    }

    public Family_tree<T> sortByAge (Family_tree<T> ft){
        return ft.sortByAge();
    }

    public StringBuilder findObjectByID(int id,Family_tree<T> ft) {
        return ft.findOjectdByID(id);
    }

    public StringBuilder getParentsByIDChild (int id, Family_tree<T> ft){ // поиск родителей по коду ребенка
        return ft.findParentsByID(id);
    }
    public StringBuilder getChildrenByIDParent (int id,Family_tree<T> ft){      // поиск детей по id родителя
        return ft.findChildrenByIDParent(id);
    }
    public StringBuilder add (T human,Family_tree<T> ft) {return ft.add(human);}   // добавить объект в дерево
    public StringBuilder getSublins (int id,Family_tree<T> ft) {return ft.getSublins(id);} // найти братьев/сестер по коду объекта
}
