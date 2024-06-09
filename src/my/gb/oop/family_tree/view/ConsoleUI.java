package my.gb.oop.family_tree.view;

import my.gb.oop.family_tree.model.Family_Tree.FamilyTreeItem;
import my.gb.oop.family_tree.model.Family_Tree.Family_tree;
import my.gb.oop.family_tree.model.Human.Gender;
import my.gb.oop.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

import static my.gb.oop.family_tree.model.Human.CreaterHuman.i;

public class ConsoleUI<T extends FamilyTreeItem<T>> implements View{
    private Scanner scanner;
    private Presenter presenter;
    private Family_tree<T> ft;
    private boolean flag;
    private MainMenu menu;

    public ConsoleUI(Family_tree<T> ft) {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this, ft);
        flag = true;
        this.ft = ft;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Работа с деревом начата.");

        while(flag){
            printMenu();
            action();
        }
    }
    public void finish() {
        System.out.println("Работа с древом закончена");
        flag = false;
    }
    @Override
    public void printAnswer(String info) {System.out.println(info);}

    public void getTreeInfo() {presenter.getTreeInfo();}

    public void sortByAge() {presenter.sortByAge();}

    public void sortByName(){presenter.sortByName();}
    public void sortByYearBirthday(){presenter.sortByYearBirthday();}

    public void addObject(){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите отчество: ");
        String middleName = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String secondName = scanner.nextLine();
        //TODO здесь надо доделывать ввод и проверку дат и др полей
        //пока сделано кратко только, чтобы проверить работу, что человек добавляется в дерево
        //дата здесь по умолчанию 1.1.1900
        //если проверить древо после этого добавления, человек там будет
        presenter.addObject(name,secondName,middleName,Gender.Female,LocalDate.of(1900,1,1),null,null,null,null,null);


    }

    public void findObjectByID(){
        int id = checkInputID ();
        if (id != -1) {presenter.findObjectByID(id,ft);}
        else System.out.println("не правильно введен id");
    }

    public void getParentsByIDChild(){
        int id = checkInputID ();
        if (id != -1) {presenter.getParentsByIDChild(id,ft);}
        else System.out.println("не правильно введен id");
    }

    public void getChildrenByIDParent(){
        int id = checkInputID ();
        if (id != -1) {presenter.getChildrenByIDParent(id,ft);}
        else System.out.println("не правильно введен id");
    }

    public void getSublins(){
        int id = checkInputID ();
        if (id != -1) {presenter.getSublins(id,ft);}
        else System.out.println("не правильно введен id");
    }

    private Integer checkInputID (){
        System.out.printf("Введите id объекта [%s - %s]:",1,i);
        String line = scanner.nextLine();
        if (checkInfoForInt(line)) {
            int num = Integer.parseInt(line);
            if (num >=1 && num <= i) return num;
            else return -1;
        }
        else return -1;
    }

    private void printMenu() {System.out.println(menu.menu());}

    private void action(){
        String line = scanner.nextLine();
        if (checkInfoForInt(line)) {
            int num = Integer.parseInt(line);
            if (checkCommand(num)) menu.action(num);
        }
    }

    private boolean checkInfoForInt(String info){
        if (info.matches("[0-9]+")) {
            return true;
        }
        else {printError(); return false;}
    }
    private void printError() {System.out.println("Введено не верное значение");}

    private boolean checkCommand (int c){
        if (c <= menu.getSize()){
            return true;
        } else {printError();return false;}
    }


}
