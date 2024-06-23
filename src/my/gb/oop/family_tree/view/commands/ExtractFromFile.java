package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.view.ConsoleUI;

public class ExtractFromFile extends Command{

    public ExtractFromFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "извлечь информацию из файла и работать с ней";
    }

    @Override
    public void action() {getConsoleUI().getTreeFromFile();}

    }

