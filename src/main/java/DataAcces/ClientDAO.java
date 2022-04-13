package DataAcces;

import ConnectionFactory.ConnectionFactory;
import Model.Clients;

import javax.swing.*;
import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * In this Class we call methods from AbstracDAO and because reflection techniques is used methods are called with Clients type objects
 * For clients the operations are: add, edit, remove, view
 */
public class ClientDAO {

    public static int addClient(Clients e){
        int id = -1;
        try {
            AbstracDAO.insertStatement(e);
            Connection connection = ConnectionFactory.getConnection();
            id = AbstracDAO.selectQuery(e,"clientId");
            connection.close();
        }catch (SQLException d){
            d.printStackTrace();
        }
        System.out.println(id);
        return id;
    }
    public static int removeClient(Clients e){
        int id = -1;
        try {
            Connection connection = ConnectionFactory.getConnection();
            id = AbstracDAO.selectQuery(e,"clientId");
            AbstracDAO.deleteStatement(e);
            connection.close();
        }catch (SQLException d){
            d.printStackTrace();
        }
        System.out.println(id);
        return id;
    }
    public static DefaultListModel viewClients(){
        DefaultListModel v = new DefaultListModel();
        try {
            Connection connection = ConnectionFactory.getConnection();
            v = AbstracDAO.viewObjects(new Clients("Null","Null","null@null.com",19));
            connection.close();
        }catch (SQLException d){
            d.printStackTrace();
        }
        return v;
    }
    public static int editClient(Clients e, ArrayList<Object> n){
        Connection connection = ConnectionFactory.getConnection();
        int id = -1;
        try{
            AbstracDAO.editStatement(e,n);
            Clients c2 = new Clients(String.valueOf(n.get(0)),String.valueOf(n.get(1)),String.valueOf(n.get(2)),Integer.parseInt( n.get(3).toString()));
            id = AbstracDAO.selectQuery(c2,"clientId");
            connection.close();
        }catch (SQLException d){
            d.printStackTrace();
        }
        System.out.println(id);
        return id;
    }

}
