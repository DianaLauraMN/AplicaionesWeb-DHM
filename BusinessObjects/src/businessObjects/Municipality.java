package businessObjects;

import java.util.ArrayList;

public class Municipality {
    private int id;
    private String name;
    private ArrayList users = new ArrayList();

    public Municipality() {
   
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList getUsers() {
        return users;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(ArrayList users) {
        this.users = users;
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
        final Municipality other = (Municipality) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", users=" + users;
    }
    
    
}
