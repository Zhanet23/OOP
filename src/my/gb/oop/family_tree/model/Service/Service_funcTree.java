package my.gb.oop.family_tree.model.Service;

import my.gb.oop.family_tree.model.Family_Tree.FamilyTreeItem;
import my.gb.oop.family_tree.model.Human.Gender;
import my.gb.oop.family_tree.model.Human.Human;

import java.time.LocalDate;
import java.util.List;

import static my.gb.oop.family_tree.model.Human.CreaterHuman.i;

public class Service_funcTree extends Service_sorting implements WorkWithTreeInfo{

    public Service_funcTree() {super();}

    public int getSizeTree(){
        return ft.getSizeTree();
    }
    //---------------------------------------------------------------------------------------------------------
    @Override
    public FamilyTreeItem<Human> getObjectByID (int id){
        return ft.getObjectByID(id);
    }
    @Override
    public StringBuilder getObjectByID_withSublins(int id) {return ft.getObjectByID_withSublins(id);}
    //@Override
    public List<Human> getTreeInfo(){
        return ft.getTreeInfo();
    }
    @Override
    public List<Human> getParentsByIDChild(int id){
        return ft.getParentsByIDChild(id);
    }
    @Override
    public List<Human> getChildrenByIDParent(int id){
        return ft.getChildrenByIDParent(id);
    }
    @Override
    public List<Human> getSublinsByIDObject (int id) {// найти братьев/сестер по коду объекта
         return  ft.getSublinsByIDObject(id);
    }
    //-----------------------------------------------------------------------------------------------

    public String addObject (String name, String secondName, String middleName, Gender gender, LocalDate dateB, LocalDate dateD, Human spouse, List<Human> children, int mother_ID, int father_ID) {
        i = ft.getSizeTree();

        Human h = new Human(name,secondName,middleName,gender,dateB,dateD,spouse,children, null,null);
        ft.addObject(h);
        if (mother_ID!= -1 && mother_ID != 0) { ft.setMotherToObject(h.getId(),mother_ID);}
        if (father_ID!= -1 && father_ID != 0) { ft.setFatherToObject(h.getId(),father_ID);}
        return ft.toString();
    }

    //-----------------------------------------------------------------------------------------------
    public StringBuilder getObjectNames(int id) {return ft.getNamesForPrintSublins(id);}
    public void setMotherToObject(int child_ID, int mother_ID) {
        ft.setMotherToObject(child_ID,mother_ID);
    }
    public void setFatherToObject(int child_ID, int father_ID) {
        ft.setFatherToObject(child_ID,father_ID);
    }

    public void setSpouse(int w, int h){
        ft.setSpouse(w,h);
    }

}
