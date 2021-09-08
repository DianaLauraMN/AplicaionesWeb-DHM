package businessObjects;

import java.util.Date;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.types.ObjectId;

@BsonDiscriminator
public class Common extends Post {

    public Common(){
        super();
    }
    
    public Common(ObjectId id){
        super(id);
    }
    
    public Common(ObjectId idUser, Date dateTimeCreation, String title, String content, Date dateTimeEdition, List<ObjectId> comments) {
        super(idUser, dateTimeCreation, title, content, dateTimeEdition, comments);
    }

}
