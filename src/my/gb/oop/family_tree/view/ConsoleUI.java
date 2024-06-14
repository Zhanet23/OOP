package my.gb.oop.family_tree.view;

import my.gb.oop.family_tree.InicialisationTree;
import my.gb.oop.family_tree.model.Family_Tree.FamilyTreeItem;
import my.gb.oop.family_tree.model.Family_Tree.Family_tree;
import my.gb.oop.family_tree.model.Human.Gender;
import my.gb.oop.family_tree.model.Human.Human;
import my.gb.oop.family_tree.model.Service.DateValidator;
import my.gb.oop.family_tree.model.Service.DateValidatorUsingLocalDate;
import my.gb.oop.family_tree.model.Service.FileHandler;
import my.gb.oop.family_tree.model.Service.Writable;
import my.gb.oop.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static my.gb.oop.family_tree.model.Human.CreaterHuman.i;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private Family_tree<Human> ft;
    private boolean flag; private boolean iniflag;
    private MainMenu menu;
    String path;

    public ConsoleUI(Family_tree<Human> ft) {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this, ft);
        flag = true;
        iniflag = false;
        this.ft = ft;
        path = "src/my/gb/oop/family_tree/fam.txt";
        menu = new MainMenu(this);
    }

    public void ini (String path) {
        while (!iniflag) {
            System.out.println("Выберите, где брать информацию для дерева:");
            System.out.println("1 - из файла, 2 - из этой программы, 3 - создавать новое");
            String inf = scanner.nextLine();
            if (checkInfoForInt(inf)) {
                int num = Integer.parseInt(inf);
                switch (num) {
                    case 1: {
                        ft = presenter.getTreeFromFile(path);
                        break;
                    }
                    case 2: {
                        ft = presenter.getTreeFromHear();
                        break;
                    }
                    default: {
                        ft = presenter.getNewTree();
                        break;
                    }
                }
                new ConsoleUI(ft);
                presenter = new Presenter(this, ft); iniflag = true;
            } else System.out.println("Введите значение из диапазона [1-3]");
        }
    }

    @Override
    public void start() {
        ini(path); //с каким деревом начинаем работать
        while(flag){
            printMenu();
            action();
        }
    }

    public void finish() {
        System.out.println("Работа с древом закончена");
        flag = false;
    }

    public void getTreeFromFile() {
        ft = presenter.getTreeFromFile(path);
    }

    public Family_tree<Human> getNewTree() {
        ft =presenter.getNewTree();
        presenter = new Presenter(this, ft);
        return ft;

    }

    public void saveToFile () {
        presenter.SaveToFile(ft,path);
    }

    public Family_tree<Human> getTreeFromHear(){
        ft = presenter.getTreeFromHear();
        return ft;
    }

    @Override
    public void printAnswer(String info) {System.out.println(info);}

    public void getTreeInfo() {
        presenter = new Presenter(this, ft);  //обязательно переопределять, тк иначе будет инф из предыдущего дерева
        presenter.getTreeInfo();
    }

    public void sortByAge() {presenter.sortByAge();}

    public void sortByName(){presenter.sortByName();}
    public void sortByYearBirthday(){presenter.sortByYearBirthday();}

    public void addObject(){

        System.out.println("Введите имя: ");       String name = scanner.nextLine();
        System.out.println("Введите отчество: ");  String middleName = scanner.nextLine();
        System.out.println("Введите фамилию: ");   String secondName = scanner.nextLine();

        LocalDate dateB = checkInputDate("Введите дату рождения (гггг-мм-дд): ");

        //TODO здесь надо доделывать ввод и проерку др полей
        //пока сделано кратко только, чтобы проверить работу, что человек добавляется в дерево
        //только фио и дата рождения

         presenter.addObject(name,secondName,middleName,null,
                LocalDate.of(dateB.getYear(),dateB.getMonthValue(),dateB.getDayOfMonth()),
                null,null,null,null,null);
    }

    private LocalDate checkInputDate(String decription){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  //BASIC_ISO_DATE
        DateValidator validator = new DateValidatorUsingLocalDate(dateFormatter);
        boolean f = false; String inf = "";
        while (!f) {
            System.out.println(decription);
            inf = scanner.nextLine();
            if (validator.isValid(inf)) f = true;
        }
        return LocalDate.parse(inf,dateFormatter);
    }

    public void findObjectByID(){
        int id = checkInputID ();
        if (id != -1) {presenter.findObjectByID(id);}
        else printError();
    }

    public void getParentsByIDChild(){
        int id = checkInputID ();
        if (id != -1) {presenter.getParentsByIDChild(id);}
        else printError();
    }

    public void getChildrenByIDParent(){
        int id = checkInputID ();
        if (id != -1) {presenter.getChildrenByIDParent(id);}
        else printError();
    }

    public void getSublins(){
        int id = checkInputID ();
        if (id != -1) {presenter.getSublins(id);}
        else printError();
    }

    private Integer checkInputID (){
        System.out.printf("Введите id объекта [%s - %s]:",1,getSizeTree());
        String line = scanner.nextLine();
        if (checkInfoForInt(line)) {
            int num = Integer.parseInt(line);
            if (num >=1 && num <= getSizeTree()) return num;
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

    private int getSizeTree(){
        return presenter.getSizeTree();
    }

}
