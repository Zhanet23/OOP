package my.gb.oop.family_tree.model.Service;

import my.gb.oop.family_tree.model.Family_Tree.Family_tree;
import my.gb.oop.family_tree.model.Human.Human;

public class Service_sorting extends Service_ini{
    public Service_sorting() {super();}
    public Family_tree<Human> sortByYearBirthday() {return ft.sortByYearBirthday();}
    public Family_tree<Human> sortByName(){return ft.sortByName();}
    public Family_tree<Human> sortByAge (){
        return ft.sortByAge();
    }
}
