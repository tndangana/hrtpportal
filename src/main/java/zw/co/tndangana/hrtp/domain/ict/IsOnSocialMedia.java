package zw.co.tndangana.hrtp.domain.ict;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tndangana on 7/5/17.
 */

public enum  IsOnSocialMedia {

    YES("Yes"),
    NO("No");

    private final String name;

    IsOnSocialMedia(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<IsOnSocialMedia> asList (){
        return Arrays.asList(IsOnSocialMedia.values());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
