/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import businessObjects.Administrator;
import businessObjects.Anchored;
import businessObjects.Comment;
import businessObjects.Common;
import businessObjects.Municipality;
import businessObjects.Normal;
import businessObjects.Post;
import businessObjects.State;
import businessObjects.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Hector Zapata
 */
public class FactoryItem {

    public User createUserAdmin(String fullName, String email, String password,
            String phoneNumber, String avatar, String city, Date birthDay, char gender) {
        return new Administrator(fullName, email, password, avatar, city, birthDay, gender);
    }

    public User createUserNormal(String fullName, String email, String password,
            String phoneNumber, String avatar, String city, Date birthDay, char gender) {
        return new Normal(fullName, email, password, avatar, city, birthDay, gender);
    }

    public Comment createComment(int idUser, Date dateTime, String content, List<Integer> comments) {
        return new Comment(idUser, dateTime, content, comments);
    }

    public Post createPostAnchored(int idUser, Date dateTimeCreation, String title,
            String content, Date dateTimeEdition, List<Integer> comments) {
        return new Anchored(idUser, dateTimeCreation, title, content, dateTimeEdition, comments);
    }

    public Post createPostCommon(int idUser, Date dateTimeCreation, String title,
            String content, Date dateTimeEdition, List<Integer> comments) {
        return new Common(idUser, dateTimeCreation, title, content, dateTimeEdition, comments);
    }

    public State createState(String name, List<Integer> municipalities) {
        return new State(name, municipalities);
    }

    public Municipality createMunicipality(String name, List<Integer> users) {
        return new Municipality(name, users);
    }
}
