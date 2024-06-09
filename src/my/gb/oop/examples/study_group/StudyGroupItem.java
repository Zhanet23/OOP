package my.gb.oop.examples.study_group;

import java.time.LocalDate;

public interface StudyGroupItem <T> extends Comparable<T>{
    LocalDate getBirthDate();
    String getName();
}
