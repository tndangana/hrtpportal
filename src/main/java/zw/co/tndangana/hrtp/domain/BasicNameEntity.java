package zw.co.tndangana.hrtp.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.MappedSuperclass;

/**
 * Created by tndangana on 6/16/17.
 */
@MappedSuperclass
public abstract class BasicNameEntity extends BaseEntityUniqueId {

    private String name;
    private String description;


    public String getName(){
        return  name;
     }
     public void setName(String name)
     {
         this.name = name;
     }

     public String getDescription()
     {
         return description;
     }

    public void setDescription(String description)
    {
        this.description = description;
    }


    @Override
    public String toString() {
        return getName() + "" + getDescription();
    }
}
