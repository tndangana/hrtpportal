package zw.co.tndangana.hrtp.domain.ict;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tndangana on 7/5/17.
 */
public enum SocialMediaTraining {
    YES("Yes"),
    NO("No");


    private final String name;

    SocialMediaTraining(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
   public static List<SocialMediaTraining> asList (){
        return Arrays.asList(SocialMediaTraining.values());
    }
 @Override
    public String toString() {
        return super.toString();
    }
}
