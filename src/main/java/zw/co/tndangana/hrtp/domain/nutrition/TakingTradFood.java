
package zw.co.tndangana.hrtp.domain.nutrition;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tndangana on 7/13/17.
 */
public enum TakingTradFood {

    YES("Yes"),
    NO("No");
    private String name;

    TakingTradFood(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static List<TakingTradFood> asList(){
        return Arrays.asList(TakingTradFood.values());
    }
}
