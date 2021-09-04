
package businessObjects;

import java.util.Date;
import java.util.List;

/**
 *
 * @author DianaMedina
 */
public class Common extends Post{
    
    public Common(int idUser, Date dateTimeCreation, String title, String content, Date dateTimeEdition, List<Integer> comments) {
        super(idUser, dateTimeCreation, title, content, dateTimeEdition, comments);
    }
    
}
