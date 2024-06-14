package my.gb.oop.family_tree.presenter;

import my.gb.oop.family_tree.model.Family_Tree.FamilyTreeItem;
import my.gb.oop.family_tree.model.Family_Tree.Family_tree;
import my.gb.oop.family_tree.model.Human.Gender;
import my.gb.oop.family_tree.model.Human.Human;
import my.gb.oop.family_tree.model.Service.FileHandler;
import my.gb.oop.family_tree.model.Service.Service;
import my.gb.oop.family_tree.model.Service.Writable;
import my.gb.oop.family_tree.view.View;

import java.time.LocalDate;
import java.util.List;


    public class Presenter {
    private View v;
    private Service service;


        public Presenter(View v,Family_tree<Human> ft) {
            this.v = v;
            service = new Service(ft);
        }


   public Family_tree<Human> getTreeFromFile(String path) {
       return service.getTreeFromFile(path);
        }

   public Family_tree<Human> getTreeFromHear(){
        return service.getTreeFromHear();
   }

   public Family_tree<Human> getNewTree(){
        return service.getNewTree();
   }
   public int getSizeTree(){
        return service.getSizeTree();
   }
    public void SaveToFile (Family_tree<Human> ft,String path) {
         service.SaveToFile(ft,path);
    }

    public void sortByYearBirthday (){
        String info = service.sortByYearBirthday().toString();
        v.printAnswer(info);
    }
    public void sortByName (){
        String info = service.sortByName().toString();
        v.printAnswer(info);
    }
    public void sortByAge (){
        String info = service.sortByAge().toString();
        v.printAnswer(info);
    }

    public void findObjectByID(int id) {
        String info = service.findObjectByID(id).toString();
        v.printAnswer(info);
    }

    public void getParentsByIDChild(int id) {
        String info = service.getParentsByIDChild(id).toString();
        v.printAnswer(info);
    }
    public void getChildrenByIDParent(int id) {
        String info = service.getChildrenByIDParent(id).toString();
        v.printAnswer(info);
    }
    public void getSublins(int id) {
        String info = service.getSublins(id).toString();
        v.printAnswer(info);
    }

    public void getTreeInfo (){
        String info =  service.getTreeInfo();
        v.printAnswer(info);
    }

    public void addObject(String name, String secondName, String middleName, Gender gender,LocalDate dateB, LocalDate dateD, Human spouse, List<Human> children, Human mother, Human father){

        service.add(name, secondName,middleName, gender,dateB, dateD, spouse, children,mother, father);
    }


    }
