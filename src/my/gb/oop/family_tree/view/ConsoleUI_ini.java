package my.gb.oop.family_tree.view;

import my.gb.oop.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class ConsoleUI_ini extends View {

   public ConsoleUI_ini() {
    scanner = new Scanner(System.in);
    presenter = new Presenter(this);
    flag = true; iniflag = false;
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
    @Override
    public void getTreeFromFile() { presenter.getTreeFromFile(path);}
    @Override
    public void getTreeFromHear(){ presenter.getTreeFromHear();}
    @Override
    public void getNewTree() { presenter.getNewTree();}
    @Override
    public void saveToFile () {
        presenter.saveToFile(path);
    }
    //--------------------------------------------------------------------------------------------
    //----------------------сортировки------------------------------------------------------------
    @Override
    public void sortByAge() {presenter.sortByAge();}
    @Override
    public void sortByName(){presenter.sortByName();}
    @Override
    public void sortByYearBirthday(){presenter.sortByYearBirthday();}
    //--------------------------------------------------------------------------------------------
    //--------------------работа с деревом--------------------------------------------------------


    @Override
    public void getTreeInfo() { presenter.getTreeInfo();}
    @Override
    public void addObject(){
        System.out.println("Введите имя: ");       String name = scanner.nextLine();
        System.out.println("Введите отчество: ");  String middleName = scanner.nextLine();
        System.out.println("Введите фамилию: ");   String secondName = scanner.nextLine();
        LocalDate dateB = checkInputDate("Введите дату рождения (гггг-мм-дд): ");

        //TODO здесь надо доделывать ввод и проерку др полей
        System.out.println("Введите информацию о матери по имеющемуся id:\n");
        int mother_ID = checkInputID();
        System.out.println("Введите информацию об отце по имеющемуся id:\n");
        int father_ID = checkInputID();

         presenter.addObject(name,secondName,middleName,
                LocalDate.of(dateB.getYear(),dateB.getMonthValue(),dateB.getDayOfMonth()),
                null,mother_ID, father_ID);
    }
    @Override
    public void  setMotherToObject() {
        System.out.println("Введите id объекта, для которого нужно записать информацию о матери: \n");
        int child_ID = checkInputID();
        System.out.println("Введите id матери объекта:\n");
        int mother_ID = checkInputID();
        if ((child_ID != -1 && mother_ID != -1) && (child_ID != mother_ID)) {
           presenter.setMotherToObject(child_ID,mother_ID);
        }

    }
    @Override
    public void  setFatherToObject() {
        System.out.println("Введите id объекта, для которого нужно записать информацию об отце: \n");
        int child_ID = checkInputID();
        System.out.println("Введите id отца объекта:\n");
        int father_ID = checkInputID();
        if ((child_ID != -1 && father_ID != -1) && (child_ID != father_ID)) {
            presenter.setFatherToObject(child_ID,father_ID);
        }
    }
    @Override
    public void setSpouse(){
        System.out.println("Введите id супруги:\n");
        int w = checkInputID();
        System.out.println("Введите id супруга:\n");
        int h = checkInputID();
        if (w != -1 && h != -1) {presenter.setSpouse(w,h);}
    }



    @Override
    public void getObjectByID(){
        int id = checkInputID ();
        if (id != -1) {presenter.getObjectByID(id);}
        else printError();
    }

    @Override
    public void getObjectByID_withSublins(){
        int id = checkInputID ();
        if (id != -1) {presenter.getObjectByID_withSublins(id);}
        else printError();
    }
    @Override
    public void getParentsByIDChild(){
        int id = checkInputID ();
        if (id != -1) {presenter.getParentsByIDChild(id);}
        else printError();
    }
    @Override
    public void getChildrenByIDParent(){
        int id = checkInputID ();
        if (id != -1) {presenter.getChildrenByIDParent(id);}
        else printError();
    }
    @Override
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

    public int getSizeTree(){
        return presenter.getSizeTree();
    }

}


