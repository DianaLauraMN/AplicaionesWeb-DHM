
package businessObjects;

import java.util.Date;
import java.util.List;

/**
 *
 * @author DianaMedina
 */
public class Anchored extends Post{
    
    public Anchored(int idUser, Date dateTimeCreation, String title, String content, Date dateTimeEdition, List<Integer> comments) {
        super(idUser, dateTimeCreation, title, content, dateTimeEdition, comments);
    }
    
}
