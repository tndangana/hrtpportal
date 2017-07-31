package zw.co.tndangana.hrtp.domain.psycho;

import zw.co.tndangana.hrtp.domain.AddressType;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tndangana on 7/13/17.
 */
public enum ZNNPAffiliation {

    YES("Yes"),
    NO("No");
    private String name;

    ZNNPAffiliation(String n)
    {this.name = n;}


    public String getName() {
        return name;
    }


    public List<ZNNPAffiliation> asList() {
        return Arrays.asList(ZNNPAffiliation.values());}
}
