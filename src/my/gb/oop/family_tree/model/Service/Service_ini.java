package my.gb.oop.family_tree.model.Service;

import my.gb.oop.family_tree.model.Family_Tree.Family_tree;
import my.gb.oop.family_tree.model.Family_Tree.InicialisationTree;
import my.gb.oop.family_tree.model.Human.Human;

import static my.gb.oop.family_tree.model.Human.CreaterHuman.i;

public class Service_ini {

    protected Family_tree<Human> ft;
    public Service_ini() {this.ft = new Family_tree<>();}
    public Family_tree<Human> getTreeFromFile(String path) {
        Writable wt = new FileHandler();
        ft = new Family_tree<>();
        ft = (Family_tree<Human>) wt.read(path);
        if (ft != null) {i = ft.getSizeTree();}
        else {i = 0; ft = new Family_tree<>();}

        return ft;
    }
    public Family_tree<Human> getTreeFromHear(){
        InicialisationTree iT = new InicialisationTree();
        i = 0;
        ft = iT.ini();
        return ft;
    }
    public Family_tree<Human> getNewTree (){
        i = 0;
        ft = new Family_tree<>();
        return ft;
    }

    public void saveToFile (String path) {
        Writable wt = new FileHandler();
        wt.write(ft,path);
    }
}