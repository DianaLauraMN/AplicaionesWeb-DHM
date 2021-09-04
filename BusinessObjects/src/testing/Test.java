package testing;

import businessObjects.Municipality;
import businessObjects.State;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

//        List<Integer> municipalities = new ArrayList<>();
//        municipalities.add(1);
//        municipalities.add(3);
//        municipalities.add(4);
//        municipalities.add(5);
//        //Testing the state creation
//        State state = new State("Sonora", municipalities);
//        System.out.println("This is the base object: " + state);
//        //Testing the attribute id with its set and get
//        state.setId(1);
//        System.out.println("this is the state id: " + state.getId());
//        //Testing the attribute name with its set and get
//        state.setName("Sinaloa");
//        System.out.println("This is the state name: " + state.getName());
//        //Testing the attribute municipalities with its set and get
//
//        System.out.println("These are the municipalities of state: " + state.getMunicipalities());
//        List<Integer> listMunicipalities = state.getMunicipalities();
//        listMunicipalities.add(100);
//        listMunicipalities.add(12);
//        listMunicipalities.add(15);
//        state.setMunicipalities(listMunicipalities);
//        System.out.println("Now these are the municipalities updates of state: " + state.getMunicipalities());
        List<Integer> users = new ArrayList<>();
        users.add(1);
        users.add(2);
        users.add(3);
        users.add(4);
        //Testing the Municipality creation
        Municipality municipality = new Municipality("Cajeme", users);
        System.out.println("This is the base object: " + municipality);
        //Testing the attribute id with its set and get
        municipality.setId(100);
        System.out.println("this is the municipality id: " + municipality.getId());
        //Testing the attribute name with its set and get
        municipality.setName("Hermosillo");
        System.out.println("This is the municipality name: " + municipality.getName());
        //Testing the attribute users with its set and get

        System.out.println("These are the users of municipality: " + municipality.getUsers());
        List<Integer> listUsers = municipality.getUsers();
        listUsers.add(10);
        listUsers.add(11);
        listUsers.add(12);
        municipality.setUsers(listUsers);
        System.out.println("Now these are the users updates of municipality: " + municipality.getUsers());

    }
}
