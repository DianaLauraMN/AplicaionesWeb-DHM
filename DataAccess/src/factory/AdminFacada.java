package factory;

import businessObjects.Comment;
import businessObjects.Municipality;
import businessObjects.Post;
import businessObjects.State;
import businessObjects.User;
import daos.CommentDAO;
import daos.DAO;
import daos.MunicipalityDAO;
import daos.PostDAO;
import daos.StateDAO;
import daos.UserDAO;

public class AdminFacada {

    private FactoryItem factoryItem;
    private DAO dao;

    public AdminFacada() {
        factoryItem = new FactoryItem();
    }

    public User createUserAdmin() {
        return factoryItem.createUserAdmin();
    }

    public User createUserNormal() {
        return factoryItem.createUserNormal();
    }

    public Comment createComment() {
        return factoryItem.createComment();
    }

    public Post createPostAnchored() {
        return factoryItem.createPostAnchored();
    }

    public Post createPostCommon() {
        return factoryItem.createPostCommon();
    }

    public State createState() {
        return factoryItem.createState();
    }

    public Municipality createMunicipality() {
        return factoryItem.createMunicipality();
    }

    public DAO getUserDAO() {
        return dao = new UserDAO();
    }

    public DAO getCommentDAO() {
        return dao = new CommentDAO();
    }

    public DAO getPostDAO() {
        return dao = new PostDAO();
    }

    public DAO getStateDAO() {
        return dao = new StateDAO();
    }

    public DAO getMunicipalityDAO() {
        return dao = new MunicipalityDAO();
    }
}
