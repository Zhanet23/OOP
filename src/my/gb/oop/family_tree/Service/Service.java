package my.gb.oop.family_tree.Service;

import my.gb.oop.family_tree.Family_Tree.Family_tree;
import my.gb.oop.family_tree.Human.Human;

public class Service {
    //private Family_tree ft;

//    public Service() {
//        ft = new Family_tree();
//    }

    public Service() {
    }

    public String GetTreeInfo(Family_tree ft) {
        StringBuilder sb = new StringBuilder();
//        Iterator<Human> iterator = ft.iterator();
//        while (iterator.hasNext()) {
//            Human h  = iterator.next();
//            sb.append(h).append("\n"); }

        for (Human h : ft) {
            sb.append(h).append("\n");
        }
        return sb.toString();
    }

    public StringBuilder sortByYearBirthday (Family_tree ft) {
        StringBuilder sb = new StringBuilder();
        sb.append(ft.sortByYearBirthday());
        return sb;
    }

    public void sortByName(Family_tree ft){
        ft.printSortName();
    }

    public Family_tree sortByAge (Family_tree ft){
        return ft.sortByAge();
    }







}
