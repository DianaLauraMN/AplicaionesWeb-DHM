
package businessObjects;

import java.util.Date;
import java.util.List;

/**
 *
 * @author DianaMedina
 */
public abstract class Post {
    private int id;
    private int idUser;
    private Date dateTimeCreation;
    private String title;
    private String content;
    private Date dateTimeEdition;
    private List<Integer> comments;

    
    public Post(int idUser, Date dateTimeCreation, String title, String content, Date dateTimeEdition, List<Integer> comments) {
        this.idUser = idUser;
        this.dateTimeCreation = dateTimeCreation;
        this.title = title;
        this.content = content;
        this.dateTimeEdition = dateTimeEdition;
        this.comments = comments;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
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

    public List<Integer> getComments() {
        return comments;
    }

    public void setComments(List<Integer> comments) {
        this.comments = comments;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
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
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id=" + id + ", idUser=" + idUser + ", dateTimeCreation=" + dateTimeCreation + ", title=" + title + ", content=" + content + ", dateTimeEdition=" + dateTimeEdition + ", comments=" + comments;
    }
    
    
}
