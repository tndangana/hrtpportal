package zw.co.tndangana.hrtp.domain;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tndangana on 6/22/17.
 */
public enum IdentityType {

    IDENTITYNUMBER("Identification Number"),
    PASSPORT("Passport");

    private String name;

    IdentityType(String n){this.name = n;}

    public String getName() {
        return name;
    }
    public List<IdentityType> asList(){return Arrays.asList(IdentityType.values()); }
}
