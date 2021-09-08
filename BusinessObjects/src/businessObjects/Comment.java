package businessObjects;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.types.ObjectId;

/**
 *
 * @author Hector Zapata
 */
@BsonDiscriminator
public class Comment {

    private ObjectId id;
    private ObjectId userId;
    private Date dateTime;
    private String content;
    private List<ObjectId> comments;

    public Comment(){
        
    }
    public Comment(ObjectId id){
        this.id = id;
    }
    
    public Comment(ObjectId userId, Date dateTime, String content, List<ObjectId> comments) {
        this.userId = userId;
        this.dateTime = dateTime;
        this.content = content;
        this.comments = comments;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Comment other = (Comment) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", userId=" + userId + ", dateTime=" + dateTime + ", content=" + content + ", comments=" + comments + '}';
    }

}
