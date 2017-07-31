package zw.co.tndangana.hrtp.domain;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tndangana on 7/5/17.
 */
public enum InternetAccessOnPhone {
    YES("Yes"),
    NO("No");


    private final String name;

    InternetAccessOnPhone(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<InternetAccessOnPhone> asList (){
        return Arrays.asList(InternetAccessOnPhone.values());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
