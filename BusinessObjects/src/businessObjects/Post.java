package businessObjects;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author DianaMedina
 */
public abstract class Post {

    private ObjectId id;
    private ObjectId idUser;
    private Date dateTimeCreation;
    private String title;
    private String content;
    private Date dateTimeEdition;
    private List<ObjectId> comments;

    
    public Post(){
        
    }
    public Post(ObjectId id){
        this.id = id;
    }
    
    public Post(ObjectId idUser, Date dateTimeCreation, String title, String content, Date dateTimeEdition, List<ObjectId> comments) {
        this.idUser = idUser;
        this.dateTimeCreation = dateTimeCreation;
        this.title = title;
        this.content = content;
        this.dateTimeEdition = dateTimeEdition;
        this.comments = comments;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getIdUser() {
        return idUser;
    }

    public void setIdUser(ObjectId idUser) {
        this.idUser = idUser;
    }

    public Date getDateTimeCreation() {
        return dateTimeCreation;
    }

    public void setDateTimeCreation(Date dateTimeCreation) {
        this.dateTimeCreation = dateTimeCreation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateTimeEdition() {
        return dateTimeEdition;
    }

    public void setDateTimeEdition(Date dateTimeEdition) {
        this.dateTimeEdition = dateTimeEdition;
    }

    public List<ObjectId> getComments() {
        return comments;
    }

    public void setComments(List<ObjectId> comments) {
        this.comments = comments;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Post other = (Post) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", idUser=" + idUser + ", dateTimeCreation=" + dateTimeCreation + ", title=" + title + ", content=" + content + ", dateTimeEdition=" + dateTimeEdition + ", comments=" + comments + '}';
    }

}
