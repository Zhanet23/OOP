package my.gb.oop.family_tree.view.commands;

//import my.gb.oop.family_tree.view.ConsoleUI;
import my.gb.oop.family_tree.view.View;

public class ExtractFromFile extends Command{

    public ExtractFromFile(View viewer) {
        super(viewer);
        description = "извлечь информацию из файла и работать с ней";
    }

    @Override
    public void action() {getConsoleUI().getTreeFromFile();}

    }

