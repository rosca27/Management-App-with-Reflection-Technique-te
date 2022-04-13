package DataAcces;

import ConnectionFactory.ConnectionFactory;
import Model.Products;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * In this Class we call methods from AbstracDAO and because reflection techniques is used methods are called with Products type objects
 * For products the operations are: add, edit, remove, view
 */
public class ProductDAO {


    public static int addProduct(Products p) {
        int id = -1;
        try {
            Connection connection = ConnectionFactory.getConnection();
            AbstracDAO.insertStatement(p);
            id = AbstracDAO.selectQuery(p,"productId");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(id);
        return id;
    }

    public static int removeProduct(Products p) {
        int id = -1;
        try {
            Connection connection = ConnectionFactory.getConnection();
            id = AbstracDAO.selectQuery(p, "productId");
            AbstracDAO.deleteStatement(p);
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println(id);
        return id;
    }

    public static DefaultListModel viewProducts() {
        DefaultListModel v = new DefaultListModel();

        try {
            Connection connection = ConnectionFactory.getConnection();
            v = AbstracDAO.viewObjects(new Products("Null",0,0));
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v;
    }

    public static int editProduct(Products p, ArrayList<Object> b) {
        Connection connection = ConnectionFactory.getConnection();
        System.out.println(p.getProductPrice());
        int id = -1;
        try {
            AbstracDAO.editStatement(p,b);
            Products products = new Products(b.get(0).toString(),Float.parseFloat(b.get(1).toString()), Integer.parseInt(b.get(2).toString()));
            id = AbstracDAO.selectQuery(products,"productId");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(id);
        return id;
    }
}
