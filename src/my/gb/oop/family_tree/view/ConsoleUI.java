package my.gb.oop.family_tree.view;

import my.gb.oop.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean flag; private boolean iniflag;
    private MainMenu menu;
    String path;

   public ConsoleUI() {
    scanner = new Scanner(System.in);
    presenter = new Presenter(this);
    flag = true; iniflag = false;
    //path = "D:/My/GB/OOP/src/my/gb/oop/family_tree/fam.txt";
    path = "src/my/gb/oop/family_tree/fam.txt";
    menu = new MainMenu(this);

    }
    //--------------------------------------------------------------------------------------
    @Override
    public void start() {
        ini();
        while(flag){ printMenu(); action();}
    }
    @Override
    public void printAnswer(String info) {System.out.println(info);}
    @Override
    public void finish() {
        System.out.println("Работа с деревом закончена"); flag = false;
    }
    //--------------------получить / записать дерево------------------------------------------------------
    public void getTreeFromFile() { presenter.getTreeFromFile(path);}
    public void getTreeFromHear(){ presenter.getTreeFromHear();}
    public void getNewTree() { presenter.getNewTree();}
    public void saveToFile () {
        presenter.saveToFile(path);
    }
    //--------------------------------------------------------------------------------------------
    //----------------------сортировки------------------------------------------------------------
    public void sortByAge() {presenter.sortByAge();}
    public void sortByName(){presenter.sortByName();}
    public void sortByYearBirthday(){presenter.sortByYearBirthday();}
    //--------------------------------------------------------------------------------------------
    //--------------------работа с деревом--------------------------------------------------------
    public void getTreeInfo() { presenter.getTreeInfo();}
    public void addObject(){
        System.out.println("Введите имя: ");       String name = scanner.nextLine();
        System.out.println("Введите отчество: ");  String middleName = scanner.nextLine();
        System.out.println("Введите фамилию: ");   String secondName = scanner.nextLine();
        LocalDate dateB = checkInputDate("Введите дату рождения (гггг-мм-дд): ");

        //TODO здесь надо доделывать ввод и проерку др полей
        //пока сделано кратко только, чтобы проверить работу, что человек добавляется в дерево
        //только фио и дата рождения
         presenter.addObject(name,secondName,middleName,
                LocalDate.of(dateB.getYear(),dateB.getMonthValue(),dateB.getDayOfMonth()),
                null);
    }

    public void getObjectByID(){
        int id = checkInputID ();
        if (id != -1) {presenter.getObjectByID(id);}
        else printError();
    }
    public void getObjectByID_withSublins(){
        int id = checkInputID ();
        if (id != -1) {presenter.getObjectByID_withSublins(id);}
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

    public void getSublinsByIDObject(){
        int id = checkInputID ();
        if (id != -1) {presenter.getSublinsByIDObject(id);}
        else printError();
    }

    //--------------------------------------------------------------------------------------------
    private LocalDate checkInputDate(String description){

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  //BASIC_ISO_DATE
        DateValidator validator = new DateValidatorUsingLocalDate(dateFormatter);
        boolean f = false; String inf = "";
        while (!f) {
            System.out.println(description);
            inf = scanner.nextLine();
            if (validator.isValid(inf)) f = true;
        }
        return LocalDate.parse(inf,dateFormatter);
    }

    private void ini () {
        while (!iniflag) {
            System.out.println("Выберите, где брать информацию для дерева:");
            System.out.println("1 - из файла, 2 - из этой программы, 3 - создавать новое");
            String inf = scanner.nextLine();
            if (checkInfoForInt(inf)) {
                int num = Integer.parseInt(inf);
                switch (num) {
                    case 1: {getTreeFromFile();break;}
                    case 2: {getTreeFromHear();break;}
                    default: {getNewTree();break;}
                }
                iniflag = true;
            } else System.out.println("Введите значение из диапазона [1-3]");
        }
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


