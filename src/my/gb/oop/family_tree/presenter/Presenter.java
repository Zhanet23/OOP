package my.gb.oop.family_tree.presenter;

import my.gb.oop.family_tree.model.Service.Service;
import my.gb.oop.family_tree.view.View;

import java.time.LocalDate;



    public class Presenter {
    private View v;  private Service service;

    public Presenter(View v) {
        this.v = v;
        service = new Service();
    }


    public void getTreeFromFile(String path) { service.getTreeFromFile(path); }
    public void getTreeFromHear(){ service.getTreeFromHear();}
    public void getNewTree(){
        service.getNewTree();
   }
    public int getSizeTree(){
        return service.getSizeTree();
   }
    public void SaveToFile (String path) {
         service.SaveToFile(path);
    }


    //----------------------------------------------------------------------------------------------------
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

    public void addObject(String name, String secondName, String middleName,LocalDate dateB, LocalDate dateD){
        service.add(name, secondName,middleName, null,dateB, dateD, null, null,null, null);
    }
}
