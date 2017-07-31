package zw.co.tndangana.hrtp.domain;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tndangana on 7/5/17.
 */
public enum DiscusStatusOnMedia {

    YES("Yes"),
    NO("No");


    private final String name;

    DiscusStatusOnMedia(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<DiscusStatusOnMedia> asList (){
        return Arrays.asList(DiscusStatusOnMedia.values());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
