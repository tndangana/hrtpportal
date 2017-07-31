package zw.co.tndangana.hrtp.domain.psycho;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tndangana on 7/13/17.
 */
public enum SurplusProduce {

    YES("Yes"),
    NO("No");
    private String name;

    SurplusProduce(String n)
    {this.name = n;}


    public String getName() {
        return name;
    }


    public List<SurplusProduce> asList() {
        return Arrays.asList(SurplusProduce.values());}
}
