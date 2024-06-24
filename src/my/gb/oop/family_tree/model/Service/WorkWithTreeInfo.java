package my.gb.oop.family_tree.model.Service;


import my.gb.oop.family_tree.model.Family_Tree.Family_tree;


import java.util.List;

public interface WorkWithTreeInfo<Е>  {
    java.lang.Object getObjectByID(int id);
    StringBuilder getObjectByID_withSublins(int id);
    List<Object> getTreeInfo();
    List<Object> getParentsByIDChild(int id);
    List<Object> getChildrenByIDParent(int id);
    List<Object> getSublinsByIDObject(int id);

}
