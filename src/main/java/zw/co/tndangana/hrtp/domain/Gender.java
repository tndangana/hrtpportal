package zw.co.tndangana.hrtp.domain;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tndangana on 6/22/17.
 */
public enum Gender {

    M("M"),
    F("F");

    private String name;

    Gender(String n){
        this.name = n;
    }

    public String getName(){return name;}

    public static List<Gender> asList(){return Arrays.asList(Gender.values());}

    public String toString(){ return name;}
}
