
package businessObjects;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author DianaMedina
 */
public class Anchored extends Post{
    
    public Anchored(ObjectId idUser, Date dateTimeCreation, String title, String content, Date dateTimeEdition, List<ObjectId> comments) {
        super(idUser, dateTimeCreation, title, content, dateTimeEdition, comments);
    }
    
}
