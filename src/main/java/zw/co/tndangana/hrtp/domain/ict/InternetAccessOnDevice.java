package zw.co.tndangana.hrtp.domain.ict;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tndangana on 7/10/17.
 */
public enum InternetAccessOnDevice {

    YES("Yes"),
    NO("No"),
   ;

    private final String name;

    InternetAccessOnDevice(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<InternetAccessOnDevice> asList (){
        return Arrays.asList(InternetAccessOnDevice.values());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
