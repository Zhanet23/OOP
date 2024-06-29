package my.gb.oop.family_tree.presenter;

import my.gb.oop.family_tree.view.View;

import java.time.LocalDate;

public class Presenter_funcTree extends Presenter_sorting{
    public Presenter_funcTree(View v) {
        super(v);
    }

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
public void addObject(String name, String secondName, String middleName,LocalDate dateB, LocalDate dateD,int mother_ID, int father_ID){
    service.addObject(name, secondName,middleName, null,dateB, dateD, null, null,mother_ID, father_ID);
}
public void setMotherToObject(int child_ID, int mother_ID) {
        service.setMotherToObject(child_ID, mother_ID);
}
public void setFatherToObject(int child_ID, int father_ID) {
        service.setFatherToObject(child_ID, father_ID);
    }

public void setSpouse(int w, int h) {service.setSpouse(w,h);}


}
