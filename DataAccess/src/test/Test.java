/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import businessObjects.Administrator;
import businessObjects.Anchored;
import businessObjects.Normal;
import businessObjects.Post;
import businessObjects.User;
import daos.DAO;
import daos.PostDAO;
import daos.UserDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Hector Zapata
 */
public class Test {

    public static void main(String[] args) {
        DAO dao = new PostDAO();
        System.out.println(dao.findMany(2));
    }
}
