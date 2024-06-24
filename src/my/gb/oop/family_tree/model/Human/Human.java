package my.gb.oop.family_tree.model.Human;

import my.gb.oop.family_tree.model.Family_Tree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human extends CreaterHuman implements Serializable, FamilyTreeItem<Human> {

    private int id;  //уникальный идентификатор человека (инициализация при создании человека)
    private String name;
    private String secondName;
    private String middleName;
    Gender gender;
    private LocalDate dateB;
    private LocalDate dateD;
    private Human spouse;
    private List<Human> children = new ArrayList<>();
    private Human mother;
    private Human father;

    //------------------------------- КОНСТРУКТОРЫ ---------------------------------------------------------
    public Human() {
        id = i;
    }
    public Human(String name, String secondName, String middleName, Gender gender,LocalDate dateB, LocalDate dateD, Human spouse, List<Human> children, Human mother, Human father) {

        this();
        this.name = name; this.secondName = secondName; this.middleName = middleName;
        this.gender = gender;
        this.dateB = dateB; this.dateD = dateD;
        this.spouse = spouse;
        this.children = children;
        this.mother = mother; this.father = father;
    }
    public Human(List<Human> children) {
        this.children = children;
    }

    //---------------------------------------------------------------------------------------------------
    public StringBuilder getNamesAndID(Human h) { //---> names + id
        StringBuilder sb = new StringBuilder();
        if (h != null) {
            sb.append("(id-").append(h.id).append(") ");
            sb.append(h.getName()).append(" ").append(h.getMiddleName()).append(" ").append(h.getSecondName());
        }
        else sb.append(" нет данных");
        return sb;
    }
    public StringBuilder getNames (Human h){ //--->names
        StringBuilder sb = new StringBuilder();
        sb.append(h.getName()).append(" ").append(h.getMiddleName()).append(" ").append(h.getSecondName());
        return sb;
    }
    public StringBuilder getDates (Human h) {
        LocalDate now =LocalDate.now(); StringBuilder sb = new StringBuilder();
        int age = age(h);
        if (h.getDateD() == null) {
            sb.append("Дата рожд.: ").append(h.getDateB()).append(", Возраст: ").append(age);
        }
        else {
            sb.append(h.getDateB()).append(" - ").append(h.getDateD()).append(", прожил: ");
            sb.append(age).append(" лет");
        }
        sb.append("; ");
        return sb;
    }
    public int getAge (Human h) {
        return age(h);
    }

    //----------------------------добавить/изменить родителей/детей/супругов---------------------------------
    public void addChild (Human h){
        if (this.children!=null) {if (!this.children.contains(h)) this.children.add(h);}
        else {
            this.children = new ArrayList<>(); this.children.add(h);
        }
    }
    public void addMother (Human h){
        if (this.mother != h) {this.mother = h;}
    }
    public void addFather (Human h){
        if (this.father != h) {this.father = h;}
    }
    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }
    //--------------------------- переопределенные -----------------------------------------------------------
    @Override
    public String toString() {
        return getFullInfAboutObject();
    }
    @Override
    public boolean equals(Object o) {   //если совпадают все поля, кроме id
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return Objects.equals(getName(), human.getName()) && Objects.equals(getSecondName(), human.getSecondName()) && Objects.equals(getMiddleName(), human.getMiddleName()) && Objects.equals(getDateB(), human.getDateB()) && Objects.equals(getDateD(), human.getDateD()) && Objects.equals(getSpouse(), human.getSpouse()) && Objects.equals(getChildren(), human.getChildren()) && Objects.equals(getMother(), human.getMother()) && Objects.equals(getFather(), human.getFather());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSecondName(), getMiddleName(), getDateB(), getDateD(), getSpouse(), getChildren(), getMother(), getFather());
    }
    @Override
    public int compareTo(Human o) {
        return this.getName().compareTo(o.getName());
    }

    //----------------------------------getters-------------------------------------------------
    public int getId() {return id;}
    public String getName() {return name;}
    public String getSecondName() {return secondName;}
    public String getMiddleName() {return middleName;}
    public LocalDate getDateB() {return dateB;}
    public LocalDate getDateD() {return dateD;}
    public Human getSpouse() {return spouse;}
    public Human getMother() {return mother;}
    public Human getFather() {return father;}
    public List<Human> getChildren() {return children;}
    public Gender getGender() {return gender;}

    //---------------------private-----------------------------------------------------------------------------
    private int age (Human h) {
        int age; LocalDate now =LocalDate.now();
        if (h.dateD == null) {
            age = (int) compare(h.dateB,now);
        }
        else {
            age = (int) compare(h.dateB,h.dateD);
        }
        return age;
    }
   // расчет возраста
    private long compare(LocalDate first, LocalDate second) {
        return ChronoUnit.YEARS.between(first,second);
    }

    private String getFullInfAboutObject () {   //вызывается из toString
        StringBuilder sb = new StringBuilder();
        sb.append("----------------------------------------------------------").append("\n");
        sb.append(getNamesAndID(this)).append(", ").append(getDates(this));

        String t = "";
        if (String.valueOf(getGender()).equals("Male")) t = "м";
        if (String.valueOf(getGender()).equals("Female")) t = "ж";

        sb.append(", ").append(t).append("\n");

        if (spouse != null)  sb.append("супруг(а): ").append(getNamesAndID(spouse).append(", ").append(getDates(spouse)));
        else sb.append("супруг(а): нет информации");
        sb.append("\n");

        sb.append(getChildrenInf(this));
        sb.append(getParentsInf(this));
        sb.append("\n");
        return   sb.toString();
    }
    private StringBuilder getChildrenInf(Human h) {
        StringBuilder sb = new StringBuilder();
        if (h.children != null) {
            sb.append("дети: ");
            for (var i: h.children) {
                sb.append(getNamesAndID(i).append(", ").append(" ").append(getDates(i)));
            }
            sb.append("\n");
        }
        else sb.append("детей нет (либо нет инфоррмации,").append("\n");
        return sb;

    }
    private StringBuilder getParentsInf(Human h) {
        StringBuilder sb = new StringBuilder();
        sb.append("информация о родителях: \n");
        if (h.mother!=null) sb.append("мама: ").append(getNamesAndID(h.mother)).append(" ").append(getDates(h.mother)).append("\n");
        else sb.append("мама: нет данных\n");

        if (h.father!=null) sb.append("папа: ").append(getNamesAndID(h.father)).append(" ").append(getDates(h.father));
        else sb.append("папа: нет данных");
        sb.append("\n");
        return   sb;
    }


}


