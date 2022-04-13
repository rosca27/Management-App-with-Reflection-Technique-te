/**
 * This package contains all methods for operations on objects
 */
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
 * In this class all methods for operations are made
 * Using the reflection techniques we can call these methods with any object, in this case Clients and products
 * Methods getAttributes and getTableFields are made to take easier fields and values of those fields from an object
 * All these methods are implemented similarly by building the query specific for each operation
 * For insert we start the query with "select ", for edit with " update ", for delete with "delete " etc
 * These methods for operations will be called in ClientDAO and ProductDAO
 */
public class AbstracDAO {

    public static void insertStatement(Object o){
        ArrayList<String> v = getTableFields(o);
        ArrayList<String> c = getAttributes(o);
        String query = "insert into "+ o.getClass().getSimpleName() +"( ";
        for(int i = 0; i < v.size(); i++){
            if(i == v.size() -1 )
                query += v.get(i) +" )";
            else
                query += v.get(i) +", ";
        }
        query += " values (";
        for(int i = 0; i < v.size() ; i++){
            if ( i == c.size() -1)
                query += "? );";
            else
                query +=  " ?, ";
        }
        System.out.println(query);
        Connection connection =ConnectionFactory.getConnection();
        try{
            Object value;
            CallableStatement stmt = connection.prepareCall(query);
            int index = 1;
            for(Field  field : o.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                value = field.get(o);
                if (field.toString().contains("Id"))
                    continue;
                if (value instanceof Integer) {
                    stmt.setInt(index, (Integer) value);
                } else if (value instanceof String) {
                    stmt.setString(index, (String) value);
                }
                else if( value instanceof Float){
                    stmt.setFloat(index, (Float) value);
                }
                index++;
            }
            stmt.execute();
        }catch (SQLException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
    public static int selectQuery(Object o, String attribute){
        ArrayList<String> v = getTableFields(o);
        String query = "select " + attribute +" from "+o.getClass().getSimpleName()+ " where ";
        if(o.getClass().getSimpleName().toString().contains("duct"))
            query +=" " + v.get(0) + "= ? ;";
        else
            for(int i = 0; i<v.size();i++){
                if (i == v.size() - 1)
                    query += v.get(i) + " = ? ;";
                else
                    query += " " + v.get(i) + " = ? and ";
            }
        Connection connection = ConnectionFactory.getConnection();
        int id = -1;
        try {
            CallableStatement stmt = connection.prepareCall(query);
            Object value;
            int index = 1;
            for(Field field : o.getClass().getDeclaredFields()){
                field.setAccessible(true);
                value = field.get(o);
                System.out.println(value);
                if(field.toString().contains("Id"))
                    continue;
                if(field.toString().contains("productPrice"))
                    continue;
                if(field.toString().contains("Stock"))
                    continue;
                if (value instanceof Integer) {
                    stmt.setInt(index, (Integer) value);
                } else if (value instanceof String) {
                    stmt.setString(index, (String) value);
                }
                else if( value instanceof Float){
                    stmt.setFloat(index, (Float) value);
                }
                index++;
            }
            stmt.execute();
            boolean hasResults = stmt.execute();
            if(hasResults){
                ResultSet rs = stmt.getResultSet();
                while(rs.next()){
                    id = rs.getInt(1);
                }
            }
        }catch (SQLException | IllegalAccessException e){
            e.printStackTrace();
        }
        return id;
    }
    public static void deleteStatement(Object o){
        String query = "delete from " + o.getClass().getSimpleName() + " where ";
        ArrayList<String> c = getTableFields(o);
        if(o.getClass().getSimpleName().equals("Products")){
            query += c.get(0) + " = ? ;";
        }
        else
        {
            for(int i = 0; i < c.size() ; i++){
                if(i == c.size() -1)
                    query += c.get(i) + " = ? ;";
                else
                    query += c.get(i) + " = ? and ";
            }
        }
        System.out.println(query);
        Connection connection = ConnectionFactory.getConnection();
        try{
            int index = 1;
            CallableStatement stmt = connection.prepareCall(query);
            for(Field field : o.getClass().getDeclaredFields()){
                field.setAccessible(true);
                Object value;
                value = field.get(o);
                if(field.toString().contains("Id"))
                    continue;
                if(field.toString().contains("productPrice"))
                    continue;
                if(field.toString().contains("Stock"))
                    continue;
                if (value instanceof Integer) {
                    stmt.setInt(index, (Integer) value);
                } else if (value instanceof String) {
                    stmt.setString(index, (String) value);
                }
                else if( value instanceof Float){
                    stmt.setFloat(index, (Float) value);
                }
                index++;
            }
            stmt.execute();
        }catch (SQLException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
    public static void editStatement(Object o, ArrayList<Object> newAttributes) {
        ArrayList<String> c = getTableFields(o);
        String query = " update " + o.getClass().getSimpleName() + " set ";
        Connection connection = ConnectionFactory.getConnection();
        for (int i = 0; i < c.size(); i++) {
            if (i == c.size() - 1)
                query += c.get(i) + " = ? where ";
            else
                query += c.get(i) + " =? , ";
        }
        if(o.getClass().getSimpleName().equals("Products"))
            query += c.get(0) + " = ?;";
        else
            for(int i = 0; i < c.size() ; i++){
                if (i == c.size() - 1)
                    query += c.get(i) + " = ? ; ";
                else
                    query += c.get(i) + " =? and ";
            }
        System.out.println(query);
            try {
                int index = 1;
                CallableStatement stmt2 = connection.prepareCall(query);for(int i = 0 ; i < newAttributes.size(); i++){
                    if(newAttributes.get(i) instanceof String) {
                        stmt2.setString(index, (String) newAttributes.get(i));
                    } else if(newAttributes.get(i) instanceof Integer) {
                        stmt2.setInt(index, (Integer) newAttributes.get(i));
                    }else if(newAttributes.get(i) instanceof Float) {
                        stmt2.setFloat(index, (Float) newAttributes.get(i));
                    }
                    System.out.println(newAttributes.get(i));
                    index++;

                }
                for(Field field : o.getClass().getDeclaredFields()){
                    field.setAccessible(true);
                    Object value;
                    value = field.get(o);
                    if(field.toString().contains("Id"))
                        continue;
                    if(field.toString().contains("Price"))
                        continue;
                    if(field.toString().contains("Stock"))
                        continue;
                    if (value instanceof Integer) {
                        stmt2.setInt(index, (Integer) value);
                    } else if (value instanceof String) {
                        stmt2.setString(index, (String) value);
                    }
                    else if( value instanceof Float){
                        stmt2.setFloat(index, (Float) value);
                    }
                    System.out.println(value);
                    index++;
                }
                stmt2.execute();
            }catch (SQLException | IllegalAccessException e){
                e.printStackTrace();
            }

    }
    public static DefaultListModel viewObjects(Object o) {
        ArrayList<String> c = getTableFields(o);
        String query = "select ";
        for(int i = 0; i < c.size(); i++){
            if( i == c.size() -1)
                query += c.get(i) + " from " + o.getClass().getSimpleName() +" ;";
            else
                query += c.get(i) + ", ";
        }
        Connection connection = ConnectionFactory.getConnection();
        DefaultListModel v = new DefaultListModel();
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.execute();
            boolean hasResults = stmt.execute();
            if (hasResults) {
                ResultSet rs = stmt.getResultSet();
                while (rs.next()) {
                    if (query.contains("client")) {
                        String namee = rs.getString(1);
                        String surnamee = rs.getString(2);
                        String agee = String.valueOf(rs.getInt(4));
                        String eMaill = rs.getString(3);
                        v.addElement("Nume: " + namee + " " + surnamee + " " + "Varsta: " + agee + " " + "Mail: " + eMaill);
                    } else if (query.contains("product")) {
                        v.addElement("Nume: " + rs.getString(1) + " " + "Pret: " + rs.getString(2) + " " + "Stock:" + " " + rs.getString(3));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v;
    }
    public static ArrayList<String> getAttributes(Object o) {
        ArrayList<String> v = new ArrayList<String>();
        Object value;
        try {
            for (Field field : o.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                value = field.get(o);
                if (field.toString().contains("Id")) {
                    continue;
                }
                v.add(value.toString());
                System.out.println(value);
            }
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return v;
    }
    public static ArrayList<String> getTableFields(Object o){
        ArrayList<String> v = new ArrayList<String>();

            for (Field field : o.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.toString().contains("Id")) {
                    continue;
                }
                String x[] = field.toString().split("\\.");
                v.add(x[x.length - 1]);
            }
        return v;
    }
}
