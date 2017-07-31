package zw.co.tndangana.hrtp.domain.ict;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tndangana on 7/10/17.
 */
public enum HivDiscusionOnMedia {
    YES("Yes"),
    NO("No"),
    OTHER("Other");

    private final String name;

    HivDiscusionOnMedia(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<HivDiscusionOnMedia> asList (){
        return Arrays.asList(HivDiscusionOnMedia.values());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
