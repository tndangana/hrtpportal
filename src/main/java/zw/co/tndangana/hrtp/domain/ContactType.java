package zw.co.tndangana.hrtp.domain;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tndangana on 6/22/17.
 */
public enum ContactType {

    PHONENUMBER("Phone Number"),
    EMAILADDRESS("Email Address");

    private String name;

    ContactType(String n){this.name = n;}

    public String getName() {
        return name;
    }
    public static List<ContactType> asList(){return Arrays.asList(ContactType.values());}

    @Override
    public String toString() {
        return super.toString();
    }
}
