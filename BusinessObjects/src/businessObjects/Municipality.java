package businessObjects;

import java.util.List;
import java.util.Objects;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.types.ObjectId;

@BsonDiscriminator
public class Municipality {

    private ObjectId id;
    private String name;
    private List<ObjectId> users;

    public Municipality(){
        
    }
    public Municipality(ObjectId id){
        this.id = id;
    }
    public Municipality(String name, List<ObjectId> users) {
        this.name = name;
        this.users = users;
    }

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ObjectId> getUsers() {
        return this.users;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(List<ObjectId> users) {
        this.users = users;
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
        final Municipality other = (Municipality) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Municipality{" + "id=" + id + ", name=" + name + ", users=" + users + '}';
    }

}
