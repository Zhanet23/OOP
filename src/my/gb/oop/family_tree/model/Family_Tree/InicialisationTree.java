package my.gb.oop.family_tree.model.Family_Tree;

import my.gb.oop.family_tree.model.Family_Tree.Family_tree;
import my.gb.oop.family_tree.model.Human.Gender;
import my.gb.oop.family_tree.model.Human.Human;

import java.time.LocalDate;
import java.util.List;

public class InicialisationTree {
    private Family_tree<Human> ft = new Family_tree<>();
    public  Family_tree<Human> ini () {

        Human h1 = new Human("Нина", "М", "Николаевна", Gender.Female,
                LocalDate.of(1920, 1, 20), LocalDate.of(2000, 6, 22), null, null,
                null, null);
        System.out.println(add(h1));

        Human h2 = new Human("Аркадий", "М", "Александрович", Gender.Male,
                LocalDate.of(1924, 11, 17), LocalDate.of(1996, 3, 15), null, null, null, null);
        System.out.println(add(h2));
        h1.setSpouse(h2);
        h2.setSpouse(h1); //запись информации о партнере

        Human h3 = new Human("Елизавета", "К", "Петровна", Gender.Female,
                LocalDate.of(1925, 3, 30), LocalDate.of(1975, 5, 15), null, null, null, null);
        System.out.println(add(h3));

        Human h4 = new Human("Александр", "К", "Михайлович", Gender.Male,
                LocalDate.of(1927, 7, 10), LocalDate.of(1987, 12, 28), null, null, null, null);
        System.out.println(add(h4));
        h3.setSpouse(h4);
        h4.setSpouse(h3); //запись информации о партнере

        Human h5 = new Human("Владимир", "М", "Аркадьевич", Gender.Male,
                LocalDate.of(1947, 2, 4), null, null, null, h1, h2);
        System.out.println(add(h5));

        Human h6 = new Human("Людмила", "М", "Александровна", Gender.Female,
                LocalDate.of(1950, 1, 5), null, null, null, h3, h4);
        System.out.println(add(h6));
        h5.setSpouse(h6);
        h6.setSpouse(h5); //запись информации о партнере

        Human h7 = new Human("Евдокия", "В", "Федоровна", Gender.Female,
                LocalDate.of(1948, 9, 16), LocalDate.of(2004, 8, 8), null, null, null, null);
        System.out.println(add(h7));

        Human h8 = new Human("Сергей", "В", "Алексеевич", Gender.Male,
                LocalDate.of(1946, 12, 27), LocalDate.of(2022, 4, 8), null, null, null, null);
        System.out.println(add(h8));
        h7.setSpouse(h8);
        h8.setSpouse(h7); //запись информации о партнере

        Human h9 = new Human("Игорь", "В", "Сергеевич", Gender.Male,
                LocalDate.of(1974, 8, 7), null, null, null, h7, h8);
        System.out.println(add(h9));

        Human h10 = new Human("Людмила", "П", "Сергеевна", Gender.Female,
                LocalDate.of(1976, 3, 20), null, null, null, h7, h8);
        System.out.println(add(h10));

        Human h11 = new Human("Жанна", "В", "Владимировна", Gender.Female,
                LocalDate.of(1980, 10, 8), null, null, null, h6, h5);
        System.out.println(add(h11));
        h9.setSpouse(h11);
        h11.setSpouse(h9);//запись информации о партнере

        Human h12 = new Human("Диана", "В", "Игоревна", Gender.Female,
                LocalDate.of(2005, 6, 19), null, null, null, h11, h9);
        System.out.println(add(h12));

        Human h13 = new Human("Максим", "В", "Игоревич", Gender.Male,
                LocalDate.of(2008, 10, 10), null, null, null, h11, h9);
        System.out.println(add(h13));

        Human h14 = new Human("Николай", "М", "Алексеевич", Gender.Male,
                LocalDate.of(1900, 6, 2),
                LocalDate.of(1961, 6, 22), null, List.of(h1), null, null);
        System.out.println(add(h14));

        Human h15 = new Human("Илья", "К", "Иванович", Gender.Male,
                LocalDate.of(2019, 7, 15), null, null, null, h11, null);
        System.out.println(add(h15));

//        Human h16 = new Human("Илья", "К", "Иванович", Gender.Male,
//                LocalDate.of(2019, 7, 15), null, null, null, h11, null);
//        System.out.println(ft.add(h16));
        return ft;
    }

    private String add(Human h){
       return ft.addObject(h).toString();
    }
}
