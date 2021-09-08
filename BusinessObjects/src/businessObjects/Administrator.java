package businessObjects;

import java.util.Date;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.types.ObjectId;

@BsonDiscriminator
public class Administrator extends User {

    public Administrator() {
        super();
    }

    public Administrator(ObjectId id) {
        super(id);
    }

    public Administrator(String fullName, String email, String password, String avatar, String city, Date birthDay, char gender, String phoneNumber) {
        super(fullName, email, password, avatar, city, birthDay, gender, phoneNumber);

    }

}
