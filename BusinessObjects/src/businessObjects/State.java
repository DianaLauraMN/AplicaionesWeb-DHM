package businessObjects;

import java.util.List;
import java.util.Objects;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.types.ObjectId;

@BsonDiscriminator
public class State {

    private ObjectId id;
    private String name;
    private List<ObjectId> municipalities;

    public State(){
        
    }
    public State(ObjectId id){
        this.id = id;
    }
    
    public State(String name, List<ObjectId> municipalities) {
        this.name = name;
        this.municipalities = municipalities;
    }

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ObjectId> getMunicipalities() {
        return municipalities;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMunicipalities(List<ObjectId> municipalities) {
        this.municipalities = municipalities;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final State other = (State) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "State{" + "id=" + id + ", name=" + name + ", municipalities=" + municipalities + '}';
    }

}
