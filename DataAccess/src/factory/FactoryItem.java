
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


public class FactoryItem {

    public User createUserAdmin() {
        return new Administrator();
    }

    public User createUserNormal() {
        return new Normal();
    }

    public Comment createComment() {
        return new Comment();
    }

    public Post createPostAnchored() {
        return new Anchored();
    }

    public Post createPostCommon() {
        return new Common();
    }

    public State createState() {
        return new State();
    }

    public Municipality createMunicipality() {
        return new Municipality();
    }
}
