package zw.co.tndangana.hrtp.domain.ict;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tndangana on 7/5/17.
 */
public enum IsSocialMediaGeneratingIncome {


    YES("Yes"),
    NO("No"),
    OTHER("Other");

    private final String name;

    IsSocialMediaGeneratingIncome(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<IsSocialMediaGeneratingIncome> asList (){
        return Arrays.asList(IsSocialMediaGeneratingIncome.values());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
