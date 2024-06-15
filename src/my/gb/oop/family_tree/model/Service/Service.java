package my.gb.oop.family_tree.model.Service;

import my.gb.oop.family_tree.model.Family_Tree.Family_tree;
import my.gb.oop.family_tree.InicialisationTree;
import my.gb.oop.family_tree.model.Human.Gender;
import my.gb.oop.family_tree.model.Human.Human;

import java.time.LocalDate;
import java.util.List;

import static my.gb.oop.family_tree.model.Human.CreaterHuman.i;

public class Service {
    Family_tree<Human> ft;

    public Service() {this.ft = new Family_tree<>();}

    public Family_tree<Human> getTreeFromFile(String path) {
        Writable wt = new FileHandler();
        ft = (Family_tree<Human>)wt.read(path);
        i = ft.getSizeTree();
        return ft;
    }

    public Family_tree<Human> getNewTree (){
        i = 0;
        ft = new Family_tree<>();
        return ft;
    }
    public Family_tree<Human> getTreeFromHear(){
        InicialisationTree iT = new InicialisationTree();
        i = 0;
        ft = iT.ini();
        return ft;
    }

    public Family_tree<Human> getCurrentTree(){
        return ft;
    }
    public String getTreeInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("имеющаяся информация в дереве:\n");
        for (Human h : ft) {sb.append(h).append("\n");}
        return sb.toString();
    }

    public void SaveToFile (String path) {

        Writable wt = new FileHandler();
        wt.write(ft,path);
    }

    public int getSizeTree(){
        return ft.getSizeTree();
    }

    public Family_tree<Human> sortByYearBirthday () {
        return ft.sortByYearBirthday();
    }
    public Family_tree<Human> sortByName(){
        return ft.printSortName();
    }

    public Family_tree<Human> sortByAge (){
        return ft.sortByAge();
    }

    public StringBuilder findObjectByID(int id) {
        return ft.findOjectdByID(id);
    }

    public StringBuilder getParentsByIDChild (int id){ // поиск родителей по коду ребенка
        return ft.findParentsByID(id);
    }
    public StringBuilder getChildrenByIDParent (int id){      // поиск детей по id родителя
        return ft.findChildrenByIDParent(id);
    }

    public StringBuilder add (String name, String secondName, String middleName, Gender gender, LocalDate dateB, LocalDate dateD, Human spouse, List<Human> children, Human mother, Human father) {
        i = ft.getSizeTree();
        Human h = new Human(name,secondName,middleName,gender,dateB,dateD,spouse,children,mother,father);
        return ft.add(h);}   // добавить объект в дерево

    public StringBuilder getSublins (int id) {return ft.getSublins(id);} // найти братьев/сестер по коду объекта


    }
