package my.gb.oop.family_tree.view;

import my.gb.oop.family_tree.presenter.Presenter;


public class ConsoleUI_ext extends ConsoleUI{

    public ConsoleUI_ext() {
        super();

    }

    @Override
    public void getObjectByNames() {
        System.out.println("Это расширенная версия функционала. Метод поиска по именам в разработке \n");

    }
}
