package my.gb.oop.family_tree.view.commands;


import my.gb.oop.family_tree.view.ConsoleUI;

public abstract class Command {
    protected String description;
    private ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI) {this.consoleUI = consoleUI;}

     public String getDescription(){
        return description;
     }

     public abstract void action();

    //дефолтный модификатор - видимость только наследникам этого класса в пакете commands
     ConsoleUI getConsoleUI() {return consoleUI;}



}
