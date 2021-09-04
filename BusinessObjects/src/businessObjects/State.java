package businessObjects;

import java.util.ArrayList;

public class State {

    private int id;
    private String name;
    private ArrayList Municipalities = new ArrayList();

    public State() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList getMunicipalities() {
        return Municipalities;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMunicipalities(ArrayList Municipalities) {
        this.Municipalities = Municipalities;
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
        return  "id=" + id + ", name=" + name + ", Municipalities=" + Municipalities;
    }

}
