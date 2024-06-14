package my.gb.oop.family_tree.model.Family_Tree;

import my.gb.oop.family_tree.model.Human.CreaterHuman;

import javax.print.DocFlavor;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import static java.util.Collections.sort;

public class Family_tree<T extends FamilyTreeItem<T>> implements Serializable, Iterable<T>{
    private List<T> familyTree;
    //-----------------конструкторы----------------------------------------------------------
    public Family_tree() {
        this(new ArrayList<>());
    }

    public Family_tree(List<T> familyTree) {this.familyTree = familyTree;}
    //----------------------------------------------------------------------------------------
     private StringBuilder addHuman (T h) {
        StringBuilder sb = new StringBuilder();
        if (h == null) sb.append("не введен человек");
        else {
            if (!familyTree.contains(h)) {
                System.out.println("+++++++++++++++++++++++++++++");
                System.out.println(CreaterHuman.i);
                CreaterHuman.i = familyTree.size()+1;
                System.out.println(CreaterHuman.i);

                familyTree.add(h);
                sb.append(h.getNames(h)).append(" - добавлен в древо");
                // если у человека есть информация о родителях, то добавим и родителям информацию о ребенке
                if (h.getMother() != null) {h.getMother().addChild(h);}
                if (h.getFather() != null) {h.getFather().addChild(h);}
                //если вводится информация о старшем родственнике и известны дети у него
                // то надо добавить детям информацию о родителе
                if (h.getChildren() != null) {addParentToChildren(h);}


            }
            else {sb.append("идентичная информация о человеке с введенными данными ").append(h.getNames(h).
                    append(" уже есть в базе, ").
                    append("id - ").append(findByFIO(h.getName(),h.getMiddleName(),h.getSecondName()).getId())).
                    append(" Текущие данные НЕ добавлены в древо.");

                    CreaterHuman.i = CreaterHuman.i -1;}
            }
        return sb;
    }

     public int getSizeTree () {
        return familyTree.size();
     }
    //---------------------------------сортировки------------------------------------------------
    // возвращает отсортированное древо по возрастанию года рождения людей. Возвращает StringBuilder
    public Family_tree<T> sortByYearBirthday (){
        Family_tree<T> ft_sort = new Family_tree<>();
        Comparator<T> cc = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {return o1.getDateB().getYear() - o2.getDateB().getYear();}
        };
        familyTree.stream().sorted(cc).forEach(ft_sort::add);
        return ft_sort;
    }

    // сортирует список людей по имени
    public Family_tree<T> printSortName (){
        //Collections.sort(familyTree);
        Family_tree<T> ft_sort = new Family_tree<>();
        Comparator<T> cc = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {return o1.getName().compareTo(o2.getName());}
        };
        familyTree.stream().sorted(cc).forEach(ft_sort::add);
        return ft_sort;


    }

    public Family_tree<T> sortByAge (){
        Family_tree<T> ft_sort = new Family_tree<>();
        Comparator<T> cc = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {return o1.getAge(o1) - o2.getAge(o2);}
        };
        familyTree.stream().sorted(cc).forEach(ft_sort::add);
        return ft_sort;
    }
    //--------------------------------------------------------------------------------------

    // используется в методе addHuman
    private void addParentToChildren (T h){
        //добавляем отца
        if (String.valueOf(h.getGender()).equals("Male")) {
            for (T child : h.getChildren()) { child.addFather(h);}
        }
        else {
            for (T child : h.getChildren()) {child.addMother(h);}
        }
    }

    /**
     * Без входящих параметров. Возвращает всю информацию из базы (данные типа StringBuilder)
     * отсортировано по id
     */
    private String FullInfAboutTree () {
        StringBuilder sb = new StringBuilder();
        for (var i : familyTree) { sb.append(i); sb.append("\n");}
        return sb.toString();
    }

    /**
     * поиск человека по его ФИО, возвращает данные типа Human
     */
     private T findByFIO (String name, String middleName, String secondName) {
        T tempHuman = null;
        for (var i : familyTree) {
            if (i.getName().equalsIgnoreCase(name) && i.getMiddleName().equalsIgnoreCase(middleName) &&
                    i.getSecondName().equalsIgnoreCase(secondName))
            {tempHuman = i; break;}
        }
        return tempHuman;
    }

    /**
     * поиск человека по его id, возвращает данные типа Human
     */
    private T findByID (int id){
        T tempHuman = null;
        for (var i : familyTree) {
            if (i.getId() == id) {tempHuman = i; break;}
        }
        return tempHuman;
    }

    /**
     * возвращает ФИО, д.рожд и смерти(если человек умер уже), и возраст человека,
     * на вход принимает переменную типа Human, возвращает данные типа StringBuilder
     */
     private StringBuilder getFio_Dates (T obj) {
        LocalDate now = LocalDate.now();
        StringBuilder sb = new StringBuilder();
        if (obj != null) {
            sb.append(obj.getFIO(obj)).append(", ").append(obj.getDatesOfHuman(obj));
        }
        return sb;
    }

    private StringBuilder findParentsByID_ft (int id){
        T child; StringBuilder sb = new StringBuilder();
        child = findByID(id); // ищем в базе человека по id, для которого хотим напечатать инф о его родителях
        if (child != null) {
            sb.append("информация о родителях ").append(child.getFIO(child)).append(":\n");
            if (child.getMother() != null) {
                sb.append("мама: ").append(getFio_Dates(child.getMother())).append("\n");
            } else sb.append("нет информации, ");

            if (child.getFather() != null) {
                sb.append("папа: ").append(getFio_Dates(child.getFather()));
            } else sb.append("нет информации");
        }
        else sb.append("нет информации о человеке с  id = ").append(id);
        return sb;
    }

    private StringBuilder findParentsByFIO_ft (String name, String middleName, String secondName){
        StringBuilder sb = new StringBuilder();
        T child = findByFIO(name,middleName, secondName);
        if (child != null)  sb.append(findParentsByID_ft (child.getId()));
        else {
            sb.append("человек с таким именем: ").append(name).append(" ");
            sb.append(middleName).append(" ").append(secondName).append(", ");
            sb.append("отсутствует в древе");
        }
        return sb;
    }

    // выдает полную информацию о человеке по его фио
    private StringBuilder findHumanByFIO_ft(String name, String middleName, String secondName) {
        StringBuilder sb = new StringBuilder();
        T obj;
        obj = findByFIO (name, middleName, secondName);
        if (obj != null) { //человек есть в базе
            sb.append(obj);
            // добавим информацию о братьях/сестрах
            sb.append("информация о сестрах/братьях:").append("\n");
            //*List<Human> sublins = new ArrayList<>();
            List<T> sublins = new ArrayList<>();
            sublins = getSubl(obj.getId());
            if (!sublins.isEmpty()) {
                for (var i : sublins) {
                    sb.append(i.getFIO(i)).append(", ").append(i.getDatesOfHuman(i)).append("\n");
                }
            }
            else sb.append("нет или нет информации");
        }
        else sb.append("нет информации об этом человеке: ").append(name).append(" ").
                append(middleName).append(" ").append(secondName);
        return sb;
    }

    private StringBuilder findChildrenByIDParent_ft (int id){      // поиск объекта по id
        T temp = findByID(id); //нашли родителя по id
        StringBuilder sb = new StringBuilder();
        if (temp != null) {  //если родитель есть в базе
            sb.append("Информация о детях для человека: ");
            sb.append(temp.getFIO(temp)).append("\n");
            if (temp.getChildren() != null) {  //если у него есть дети
                sb.append("дети: ");
                for (var i: temp.getChildren()) {
                    sb.append(getFio_Dates(i).append(", "));
                }
                sb.append("\n");
            }
            else sb.append("нет детей или нет информации"); //если детей нет
        }
        return sb;
    }

    private StringBuilder findChildrenByFIOParent_ft (String name, String middleName, String secondName) {
        StringBuilder sb = new StringBuilder();
        T parent = findByFIO(name, middleName,secondName); //сначала ищем родителя по заданному ФИО в базе
        if (parent != null) {
            sb.append(findChildrenByIDParent(parent.getId())); //получаем инф по id найденного родителя
        }
        else sb.append("такого человека нет в древе");
        return sb;
    }

    private List<T> getParents (T h){
        List<T> parents = new ArrayList<>();
        if (h.getMother() != null) parents.add(h.getMother());
        if (h.getFather() != null ) parents.add(h.getFather());
        return parents;
    }

    // вызов из метода getSublins
    private StringBuilder sublins (int id) { //родных и сводных
        StringBuilder sb = new StringBuilder();
        T h = findByID(id); //получили человека, для которого ищем сестер/братьев
        if (h == null) sb.append("человека с таким id нет в базе");
        else {
            List<T> sublins = new ArrayList<>();
            sb.append("\n").append("Информация о сестрах/братьях для человека: ").append(h.getFIO(h)).append("\n");
            sublins = getSubl(id); //получили список братьев и сестер
            if (!sublins.isEmpty()) {
                for (var i : sublins) {
                    String t; int idh =i.getId();
                    String str = String.valueOf(findByID(idh).getGender());
                    if (str.equals("Male")) t = "брат"; else t = "сестра";
                    sb.append(t).append(":\n");
                    T s = findByID(idh);
                    sb.append(s.getFIO(s)).append(", ").append(s.getDatesOfHuman(s)).append("\n");
                }
            }
            else sb.append("нет братьев/сестер или нет информации");
        }
        return sb;
    }

    //возвращает список sublins List<Human>
     private List<T> getSubl (int id) { //родных и сводных
        List<T> sublins = new ArrayList<>(); //инициация списка sublins
        T h = findByID(id); //получили человека, для которого ищем сестер/братьев
        if (h != null) {
            // set - чтобы дети не повторялись, двое родителей - т.к. могут быть siblins сводные
            // в set нельзя добавить Human, тк equals по всем полям, кроме id
            //это для того, чтобы не добавлялась абсолютно идентичная инф о человеке, а id считается автоматически
            Set<Integer> sub = new HashSet<>();
            for (T par : getParents(h)){ //для каждого родителя
                for (T child : par.getChildren()) { //по списку детей родителя
                    if (h.getId() != child.getId()) sub.add(child.getId());
                }
            }
            // в set находятся id братьев и сестер
            if (!sub.isEmpty()) { // если set не пустой
                for (int i : sub) { sublins.add(findByID(i));}
            }
        }
        return sublins;
    }

    // ---------------------- public methods -------------------------------------------

    /**
     * Ищет данные о братьях/сестрах человека по его id
     */
    public StringBuilder getSublins (int id) {
        return sublins(id);
    }
    /**
     * Добавляет данные о человеке в базу данных
     */

    public StringBuilder add (T human) {return addHuman(human);}

    /**
     * поиск данных(ФИО, даты рожд/смерти(если уже умер) и возраст) о родителях ребенка по id ребенка,
     * возвращает данные типа StringBuilder
     */
    public StringBuilder findParentsByID (int id){
        return findParentsByID_ft(id);
    }

    /**
     * поиск данных(ФИО, даты рожд/смерти(если уже умер) и возраст) о родителях ребенка по ФИО ребенка,
     * возвращает данные типа StringBuilder
     */
    public StringBuilder findParentsByFIO (String name, String middleName, String secondName){
        return findParentsByFIO_ft(name,middleName,secondName);
    }

    /**
     * поиск данных по ФИО человека, возвращает данные типа StringBuilder
     */
    public StringBuilder findHumanByFIO(String name, String middleName, String secondName) {
        return findHumanByFIO_ft(name, middleName, secondName);
    }
    public StringBuilder findOjectdByID (int id){
        T temp; temp = findByID(id);
        return findHumanByFIO_ft(temp.getName(), temp.getMiddleName(), temp.getSecondName());

    }

    //поиск детей по ID родителя
    public StringBuilder findChildrenByIDParent (int id){      // поиск человека по id
        return findChildrenByIDParent_ft(id);
    }

    //поиск детей по ФИО родителя
    public StringBuilder findChildrenByFIOParent (String name, String middleName, String secondName) {
        return findChildrenByFIOParent_ft(name, middleName, secondName);
    }

    @Override
    public String toString() {return FullInfAboutTree();}


    @Override
    public Iterator<T> iterator() {
        return familyTree.iterator();
    }


}
