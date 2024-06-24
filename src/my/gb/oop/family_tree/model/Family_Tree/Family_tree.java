package my.gb.oop.family_tree.model.Family_Tree;

import my.gb.oop.family_tree.model.Human.CreaterHuman;
import my.gb.oop.family_tree.model.Service.WorkWithTreeInfo;
import my.gb.oop.family_tree.model.Human.Human;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

//public class Family_tree <T extends FamilyTreeItem<T>> extends Family_tree_ini<T>
// implements WorkWithTreeInfo, Serializable, Iterable<T> {

public class Family_tree <T extends FamilyTreeItem<T>> implements Serializable, Iterable<T>, WorkWithTreeInfo {
    private List<T> familyTree;

    //-----------------конструкторы----------------------------------------------------------
    public Family_tree() {
        this(new ArrayList<>());
        //super();
    }
    public Family_tree(List<T> familyTree) {
        this.familyTree = familyTree;
        //super(familyTree);
    }

 //---------------------------------сортировки------------------------------------------------
    public Family_tree<T> sortByYearBirthday() {
        Family_tree<T> ft_sort = new Family_tree<>();
        Comparator<T> cc = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getDateB().getYear() - o2.getDateB().getYear();
            }
        };
        familyTree.stream().sorted(cc).forEach(ft_sort::addObject);
        return ft_sort;
    }

    public Family_tree<T> sortByName() {
        Family_tree<T> ft_sort = new Family_tree<>();
        Comparator<T> cc = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        familyTree.stream().sorted(cc).forEach(ft_sort::addObject);
        return ft_sort;
    }

    public Family_tree<T> sortByAge() {
        Family_tree<T> ft_sort = new Family_tree<>();
        Comparator<T> cc = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getAge(o1) - o2.getAge(o2);
            }
        };
        familyTree.stream().sorted(cc).forEach(ft_sort::addObject);
        return ft_sort;
    }
    //--------------------------------------------------------------------------------------
    public int getSizeTree() {
        return familyTree.size();
    }
    @Override
    public T getObjectByID(int id) {
        T temp = null;
        for (var i : familyTree) {
            if (i.getId() == id) {
                temp = i;
                break;
            }
        }
        return temp;
    }
    @Override
    public StringBuilder getObjectByID_withSublins(int id) {
        StringBuilder sb = new StringBuilder();
        T obj = getObjectByID(id);
        if (obj != null) { //человек есть в базе
            sb.append(obj);
            // добавим информацию о братьях/сестрах
            sb.append("информация о сестрах/братьях:").append("\n");
            List<T> sublins = getSublinsByIDObject(obj.getId());
            if (!sublins.isEmpty()) {
                for (var i : sublins) {
                    sb.append(i.getNamesAndID(i)).append(", ").append(i.getDates(i)).append("\n");
                }
            } else sb.append("нет или нет информации");
        } else sb.append("нет информации об этом человеке: ");
        return sb;
    }
    @Override
    public List<T> getTreeInfo() {
        return familyTree;
    }
    @Override
    public List<T> getParentsByIDChild(int id) {
        T child = getObjectByID(id); // ищем в базе человека по id, для которого хотим найти его родителей
        if (child != null) {
            return getParents(child);
        } else return null;
    }
    @Override
    public List<T> getChildrenByIDParent(int id) {      // поиск объекта по id
        T temp = getObjectByID(id); //нашли родителя по id
        List<T> children = new ArrayList<>();
        if (temp != null) {  //если родитель есть в базе
            if (temp.getChildren() != null) children = temp.getChildren();
        }
        return children;
    }
    @Override
    public List<T> getSublinsByIDObject(int id) { //родных и сводных
        List<T> sublins = new ArrayList<>(); //инициация списка sublins
        T h = getObjectByID(id); //получили человека, для которого ищем сестер/братьев
        if (h != null) {
            // set - чтобы дети не повторялись, двое родителей - т.к. могут быть siblins сводные
            // в set нельзя добавить Human, тк equals по всем полям, кроме id
            //это для того, чтобы не добавлялась абсолютно идентичная инф о человеке, а id считается автоматически
            Set<Integer> sub = new HashSet<>();
            for (T par : getParents(h)) { //для каждого родителя
                for (T child : par.getChildren()) { //по списку детей родителя
                    if (h.getId() != child.getId()) sub.add(child.getId());
                }
            }
            // в set находятся id братьев и сестер
            if (!sub.isEmpty()) { // если set не пустой
                for (int i : sub) {
                    sublins.add(getObjectByID(i));
                }
            }
        }
        return sublins;
    }

    public StringBuilder addObject(T human) {return addObj(human);}
    //-----------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return printFullInfAboutTree();
    }

    @Override
    public Iterator<T> iterator() {
        return familyTree.iterator();
    }

    public StringBuilder getNamesForPrintSublins(int id) {
        StringBuilder sb = new StringBuilder();
        sb.append("информация о братьях / сестрах для: ").append(getObjectNames(id)).append("\n");
        return sb;
    }

    //------------------------------------------------------------------------------------------
    private StringBuilder getObjectNames(int id) {
        StringBuilder sb = new StringBuilder();
        T object = getObjectByID(id);
        sb.append(object.getNames(object));
        return sb;
    }

    private String printFullInfAboutTree() {
        StringBuilder sb = new StringBuilder();
        for (var i : familyTree) {
            sb.append(i);
            sb.append("\n");
        }
        return sb.toString();
    }

    private StringBuilder addObj(T h) {
        StringBuilder sb = new StringBuilder();
        if (h == null) sb.append("не введен человек");
        else {
            if (!familyTree.contains(h)) {
                CreaterHuman.i = familyTree.size() + 1;

                familyTree.add(h);

                sb.append(h.getNames(h)).append(" - добавлен в древо");
                // если у человека есть информация о родителях, то добавим и родителям информацию о ребенке
                if (h.getMother() != null) {
                    h.getMother().addChild(h);
                }
                if (h.getFather() != null) {
                    h.getFather().addChild(h);
                }
                //если вводится информация о старшем родственнике и известны дети у него
                // то надо добавить детям информацию о родителе
                if (h.getChildren() != null) {
                    addParentToChildren(h);
                }
            } else {
                sb.append("идентичная информация о человеке с введенными данными ").append(h.getNames(h).
                                append(" уже есть в базе, ").
                                append("id - ").append(getObjectByObjectNames(h.getName(), h.getMiddleName(), h.getSecondName()).getId())).
                        append(" Текущие данные НЕ добавлены в древо.");

                CreaterHuman.i = CreaterHuman.i - 1;
            }
        }
        return sb;
    }

    // используется в методе addObj
    private void addParentToChildren(T h) {
        //добавляем отца
        if (String.valueOf(h.getGender()).equals("Male")) {
            for (T child : h.getChildren()) {
                child.addFather(h);
            }
        } else {
            for (T child : h.getChildren()) {
                child.addMother(h);
            }
        }
    }

    private T getObjectByObjectNames(String name, String middleName, String secondName) {
        T temp = null;
        for (var i : familyTree) {
            if (i.getName().equalsIgnoreCase(name) && i.getMiddleName().equalsIgnoreCase(middleName) &&
                    i.getSecondName().equalsIgnoreCase(secondName)) {
                temp = i;
                break;
            }
        }
        return temp;
    }

    private List<T> getParents(T o) {
        List<T> parents = new ArrayList<>();
        if (o.getMother() != null) parents.add(o.getMother());
        if (o.getFather() != null) parents.add(o.getFather());
        return parents;
    }
}





