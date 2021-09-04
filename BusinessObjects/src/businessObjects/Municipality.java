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
    public String toString() {
        return "id=" + id + ", name=" + name + ", users=" + users;
    }
    
    
}
