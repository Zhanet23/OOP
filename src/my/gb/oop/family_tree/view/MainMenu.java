package my.gb.oop.family_tree.view;

import my.gb.oop.family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> clist;
    public MainMenu(ConsoleUI consoleUI){
        clist = new ArrayList<>();
        clist.add(new GetTreeInfo(consoleUI));
        clist.add(new FindObjectByID(consoleUI));
        clist.add(new SorttByName(consoleUI));
        clist.add(new SortByAge(consoleUI));
        clist.add(new SortByYearBirthday(consoleUI));
        clist.add(new GetParentsByIDChild(consoleUI));
        clist.add(new GetChildrenByIDParent(consoleUI));
        clist.add(new GetSublins(consoleUI));
        clist.add(new AddObject(consoleUI));
        clist.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < clist.size(); k++){
            sb.append(k+1).append(". ").append(clist.get(k).getDescription()).append("\n");
        }
        return sb.toString();
    }

    public void action (int choice){
        Command command = clist.get(choice - 1);
        command.action();
    }
    public int getSize(){
        return clist.size();
    }


}
