package my.gb.oop.family_tree.presenter;


import my.gb.oop.family_tree.view.View;

public class Presenter_getTree extends Presenter_ini{

    public Presenter_getTree(View v) {
        super(v);
    }
    public void getTreeFromFile(String path) { service.getTreeFromFile(path); }
    public void getTreeFromHear(){ service.getTreeFromHear();}
    public void getNewTree(){
        service.getNewTree();
    }
    public void saveToFile (String path) {
        service.saveToFile(path);
    }
}
