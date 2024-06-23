package my.gb.oop.family_tree.view;


import my.gb.oop.family_tree.presenter.Presenter;

import java.util.Scanner;

public abstract class View {
    protected Scanner scanner;
    protected Presenter presenter;
    protected boolean flag; protected boolean iniflag;
    protected MainMenu menu;
    protected String path;


    public void printAnswer(String info) {};
    public void start() {};
    public void finish() {};


    public void getTreeFromHear() {};
    public void getTreeFromFile() {};
    public void getNewTree() {};
    public void saveToFile() {};

    public void sortByYearBirthday() {};
    public void sortByName() {};
    public void sortByAge() {};

    public void getObjectByID() {};
    public void getObjectByID_withSublins() {};
    public void getTreeInfo() {};
    public void getParentsByIDChild() {};
    public void getChildrenByIDParent() {};
    public void getSublinsByIDObject() {};
    public void addObject() {};
    public  void getObjectByNames() {};



    protected void printMenu() {System.out.println(menu.menu());}
    protected void action(){
        String line = scanner.nextLine();

        if (checkInfoForInt(line)) {
            int num = Integer.parseInt(line);
            if (checkCommand(num)) menu.action(num);
        }
    }
    protected boolean checkInfoForInt(String info){
        if (info.matches("[0-9]+")) {
            return true;
        }
        else {printError(); return false;}
    }
    protected void printError() {System.out.println("Введено не верное значение");}

    private boolean checkCommand (int c){
        if (c <= menu.getSize()){
            return true;
        } else {printError();return false;}
    }

}
