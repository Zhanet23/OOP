package my.gb.oop.family_tree.view.commands;


//import my.gb.oop.family_tree.view.ConsoleUI;
import my.gb.oop.family_tree.view.View;


public abstract class Command {
    protected String description;
    private View viewer;

    public Command(View viewer) {this.viewer = viewer;}

     public String getDescription(){
        return description;
     }

     public abstract void action();

    //дефолтный модификатор - видимость только наследникам этого класса в пакете commands
     View getConsoleUI() {return viewer;}



}
