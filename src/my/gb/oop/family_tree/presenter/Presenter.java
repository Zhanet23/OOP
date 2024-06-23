package my.gb.oop.family_tree.presenter;

import my.gb.oop.family_tree.model.Service.Service;
import my.gb.oop.family_tree.view.View;
import my.gb.oop.family_tree.model.Service.WorkWithTreeInfo;

import java.time.LocalDate;

    public class Presenter extends Presenter_sorting{
        public Presenter(View v) {
            super(v);
        }
        //private View v;  private Service service;

//    public Presenter(View v) {
//        this.v = v;
//        service = new Service();
//    }
    //-------------------------------------------------------------------------------------------------
//    public void getTreeFromFile(String path) { service.getTreeFromFile(path); }
//    public void getTreeFromHear(){ service.getTreeFromHear();}
//    public void getNewTree(){
//        service.getNewTree();
//   }

//    public void saveToFile (String path) {
//         service.saveToFile(path);
//    }

    //----------------------------------------------------------------------------------------------------
//    public void sortByYearBirthday (){
//        String info = service.sortByYearBirthday().toString();
//        v.printAnswer(info);
//    }
//    public void sortByName (){
//        String info = service.sortByName().toString();
//        v.printAnswer(info);
//    }
//    public void sortByAge (){
//        String info = service.sortByAge().toString();
//        v.printAnswer(info);
//    }
    //-----------------------------------------------------------------------------------------------------
    //----------------------------функционал работы с элементами дерева------------------------------------
    public int getSizeTree(){
        return service.getSizeTree();
    }
    public void getObjectByID(int id) {
        String info = service.getObjectByID(id).toString();
        v.printAnswer(info);
    }
        public void getObjectByID_withSublins(int id) {
            String info = service.getObjectByID_withSublins(id).toString();
            v.printAnswer(info);
        }

    public void getTreeInfo (){
         String info = service.getTreeInfo().toString();
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

    public void getSublinsByIDObject(int id) {
        String info = service.getObjectNames(id).toString();
        v.printAnswer(info);
        info = service.getSublinsByIDObject(id).toString();
        v.printAnswer(info);
    }

    public void addObject(String name, String secondName, String middleName,LocalDate dateB, LocalDate dateD){
        service.addObject(name, secondName,middleName, null,dateB, dateD, null, null,null, null);
    }
}
