package my.gb.oop.family_tree.model.Service;


import java.util.List;

public interface WorkWithTreeInfo<E>  {
    E getObjectByID(int id);
    StringBuilder getObjectByID_withSublins(int id);
    List<E> getTreeInfo();
    List<E> getParentsByIDChild(int id);
    List<E> getChildrenByIDParent(int id);
    List<E> getSublinsByIDObject(int id);

}
