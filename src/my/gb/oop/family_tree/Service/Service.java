package my.gb.oop.family_tree.Service;

import my.gb.oop.family_tree.Family_Tree.FamilyTreeItem;
import my.gb.oop.family_tree.Family_Tree.Family_tree;

//*public class Service {
public class Service<T extends FamilyTreeItem<T>> {


    public Service() {
    }

    public String GetTreeInfo(Family_tree<T> ft) {
        StringBuilder sb = new StringBuilder();
//        Iterator<Human> iterator = ft.iterator();
//        while (iterator.hasNext()) {
//            Human h  = iterator.next();
//            sb.append(h).append("\n"); }

        //*for (Human h : ft) {
        for (T h : ft) {
            sb.append(h).append("\n");
        }
        return sb.toString();
    }

//    public StringBuilder sortByYearBirthday (Family_tree ft) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(ft.sortByYearBirthday());
//        return sb;
//    }
    public Family_tree<T> sortByYearBirthday (Family_tree<T> ft) {
        return ft.sortByYearBirthday();
    }
    public void sortByName(Family_tree<T> ft){
        ft.printSortName();
    }

    public Family_tree<T> sortByAge (Family_tree<T> ft){
        return ft.sortByAge();
    }







}
