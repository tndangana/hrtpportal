package zw.co.tndangana.hrtp.domain.ict;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tndangana on 7/11/17.
 */
public enum UsedSocialMForMarketing {

    YES("Yes"),
    NO("No");


    private final String name;

    UsedSocialMForMarketing(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public static List<UsedSocialMForMarketing> asList (){
        return Arrays.asList(UsedSocialMForMarketing.values());
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
