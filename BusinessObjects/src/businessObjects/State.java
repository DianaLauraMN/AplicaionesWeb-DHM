package businessObjects;
import java.util.List;

public class State {

    private int id;
    private String name;
    private List municipalities;

    public State(String name, List<Integer> municipalities) {
        this.name = name;
        this.municipalities = municipalities;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List getMunicipalities() {
        return municipalities;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMunicipalities(List<Integer> municipalities) {
        this.municipalities = municipalities;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
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
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", Municipalities=" + municipalities;
    }

}
