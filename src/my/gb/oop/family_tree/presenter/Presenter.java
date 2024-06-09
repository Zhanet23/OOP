package my.gb.oop.family_tree.presenter;

import my.gb.oop.family_tree.model.Family_Tree.FamilyTreeItem;
import my.gb.oop.family_tree.model.Family_Tree.Family_tree;
import my.gb.oop.family_tree.model.Human.Gender;
import my.gb.oop.family_tree.model.Human.Human;
import my.gb.oop.family_tree.model.Service.Service;
import my.gb.oop.family_tree.view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter<T extends FamilyTreeItem<T>> {
    private View v;
    private Service service;
    private Family_tree ft;   //надо передавать, с каким деревом работаем
    private FamilyTreeItem<T> obj;
    public Presenter(View v, Family_tree ft) {
        this.v = v;
        service = new Service();
        this.ft = ft;
    }

    public void sortByYearBirthday (){
        String info = service.sortByYearBirthday(ft).toString();
        v.printAnswer(info);
    }
    public void sortByName (){
        String info = service.sortByName(ft).toString();
        v.printAnswer(info);
    }
    public void sortByAge (){
        String info = service.sortByAge(ft).toString();
        v.printAnswer(info);
    }

    public void findObjectByID(int id,Family_tree<T> ft) {
        String info = service.findObjectByID(id,ft).toString();
        v.printAnswer(info);
    }

    public void getParentsByIDChild(int id,Family_tree<T> ft) {
        String info = service.getParentsByIDChild(id,ft).toString();
        v.printAnswer(info);
    }
    public void getChildrenByIDParent(int id,Family_tree<T> ft) {
        String info = service.getChildrenByIDParent(id,ft).toString();
        v.printAnswer(info);
    }
    public void getSublins(int id,Family_tree<T> ft) {
        String info = service.getSublins(id,ft).toString();
        v.printAnswer(info);
    }

    public void getTreeInfo (){
        String info =  service.getTreeInfo(ft);
        v.printAnswer(info);
    }

    public void addObject(String name, String secondName, String middleName, Gender gender,LocalDate dateB, LocalDate dateD, Human spouse, List<Human> children, Human mother, Human father){
        //Family_tree<Human> ft = new Family_tree<>();
        Human h = new Human(name,secondName,middleName, gender,
                dateB,dateD,spouse,children,
                mother,father);
        System.out.println(h);
        service.add(h,ft);
    }
}
