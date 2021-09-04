package businessObjects;

import java.util.Date;

public class Administrator extends User {

    public Administrator(String fullName, String email, String password, String avatar, String city, Date birthDay, char gender) {
    super(fullName, email, password, avatar, city, birthDay, gender);
    
    }   
}
