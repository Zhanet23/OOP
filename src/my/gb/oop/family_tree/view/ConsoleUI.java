package my.gb.oop.family_tree.view;

public class ConsoleUI extends ConsoleUI_ini{

    public ConsoleUI() {
        super();
    }

    @Override
    public void getObjectByNames() {
        System.out.println("Это расширенная версия функционала. Метод поиска по именам в разработке \n");
        System.out.println("Введите имя: "); String name = scanner.nextLine();
        System.out.println("Введите отчество: ");  String middleName = scanner.nextLine();
        System.out.println("Введите фамилию: ");   String secondName = scanner.nextLine();
        presenter.getObjectByNames(name, middleName,secondName);
    }
}
