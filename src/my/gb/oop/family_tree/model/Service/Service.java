package my.gb.oop.family_tree.model.Service;

import my.gb.oop.family_tree.model.Family_Tree.FamilyTreeItem;
import my.gb.oop.family_tree.model.Family_Tree.Family_tree;
import my.gb.oop.family_tree.model.Family_Tree.InicialisationTree;
import my.gb.oop.family_tree.model.Human.Gender;
import my.gb.oop.family_tree.model.Human.Human;

import java.time.LocalDate;
import java.util.List;

import static my.gb.oop.family_tree.model.Human.CreaterHuman.i;

public class Service extends Service_funcTree{
    //Family_tree<Human> ft;

    //public Service() {this.ft = new Family_tree<>();}
    public Service() {super();}
//
//    //------------------------получить / сохранить дерево----------------------------------------------------
//    public Family_tree<Human> getTreeFromFile(String path) {
//        Writable wt = new FileHandler();
//        //ft = new Family_tree<>();
//        ft = (Family_tree<Human>) wt.read(path);
//        if (ft != null) {i = ft.getSizeTree();}
//        else {i = 0; ft = new Family_tree<>();}
//
//        return ft;
//    }
//    public Family_tree<Human> getTreeFromHear(){
//        InicialisationTree iT = new InicialisationTree();
//        i = 0;
//        ft = iT.ini();
//        return ft;
//    }
//    public Family_tree<Human> getNewTree (){
//        i = 0;
//        ft = new Family_tree<>();
//        return ft;
//    }
//    public int getSizeTree(){
//        return ft.getSizeTree();
//    }
//    public void saveToFile (String path) {
//        Writable wt = new FileHandler();
//        wt.write(ft,path);
//    }
    //-------------------------------сортировки----------------------------------------------------------------

//    public Family_tree<Human> sortByYearBirthday() {return ft.sortByYearBirthday();}
//    public Family_tree<Human> sortByName(){return ft.sortByName();}
//    public Family_tree<Human> sortByAge (){
//        return ft.sortByAge();
//    }
//    public int getSizeTree(){
//        return ft.getSizeTree();
//    }
//    //---------------------------------------------------------------------------------------------------------
//    @Override
//    public FamilyTreeItem<Human> getObjectByID (int id){
//        return ft.getObjectByID(id);
//    }
//    @Override
//    public StringBuilder getObjectByID_withSublins(int id) {return ft.getObjectByID_withSublins(id);}
//    //@Override
//    public List<Human> getTreeInfo(){
//        return ft.getTreeInfo();
//    }
//    @Override
//    public List<Human> getParentsByIDChild(int id){
//        return ft.getParentsByIDChild(id);
//    }
//    @Override
//    public List<Human> getChildrenByIDParent(int id){
//        return ft.getChildrenByIDParent(id);
//    }
//    @Override
//    public List<Human> getSublinsByIDObject (int id) {// найти братьев/сестер по коду объекта
//         return  ft.getSublinsByIDObject(id);
//    }
//    //-----------------------------------------------------------------------------------------------
//
//    public StringBuilder addObject (String name, String secondName, String middleName, Gender gender, LocalDate dateB, LocalDate dateD, Human spouse, List<Human> children, Human mother, Human father) {
//        i = ft.getSizeTree();
//        Human h = new Human(name,secondName,middleName,gender,dateB,dateD,spouse,children,mother,father);
//        return ft.addObject(h);
//    }
//
//    //-----------------------------------------------------------------------------------------------
//    public StringBuilder getObjectNames(int id) {return ft.getNamesForPrintSublins(id);}
     public FamilyTreeItem<Human> getObjectByNames (String name,String middleName,String secondName){
        //System.out.println(ft);
       return ft.getObjectByNames(name, middleName,secondName);
     }



}
