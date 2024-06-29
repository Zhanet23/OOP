package my.gb.oop.family_tree.model.Service;

import my.gb.oop.family_tree.model.Family_Tree.FamilyTreeItem;
import my.gb.oop.family_tree.model.Human.Human;



public class Service extends Service_funcTree{

    public Service() {super();}

    public FamilyTreeItem<Human> getObjectByNames (String name,String middleName,String secondName){

        return ft.getObjectByNames(name, middleName,secondName);
    }



}