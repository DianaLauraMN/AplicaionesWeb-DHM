package businessObjects;

import java.util.Date;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.types.ObjectId;

@BsonDiscriminator
public class Normal extends User {

    public Normal() {
        super();
    }

    public Normal(ObjectId id) {
        super(id);
    }

    public Normal(String fullName, String email, String password, String avatar, String city, Date birthDay, char gender) {
        super(fullName, email, password, avatar, city, birthDay, gender);
    }

  
}
