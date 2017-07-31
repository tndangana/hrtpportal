package zw.co.tndangana.hrtp.domain;



import java.util.Arrays;
import java.util.List;

/**
 * Created by tndangana on 6/22/17.
 */
public enum AddressType {

    RESIDENTIAL("Residential"),
    POSTAL("Postal");
    private String name;

    AddressType(String n)
    {this.name = n;}


    public String getName() {
        return name;
    }


    public List<AddressType> asList() {
        return Arrays.asList(AddressType.values());}
}
