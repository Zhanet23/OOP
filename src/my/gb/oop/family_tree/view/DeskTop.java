package my.gb.oop.family_tree.view;

import my.gb.oop.family_tree.presenter.Presenter;

import java.util.Scanner;

public class DeskTop extends View{


    public DeskTop() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        flag = true; iniflag = false;
        path = "src/my/gb/oop/family_tree/fam.txt";
        menu = new MainMenu(this);
    }

    @Override
    public void start() {

        while(flag){
            System.out.println("десктопное приложение");printMenu(); action();}
    }
}
