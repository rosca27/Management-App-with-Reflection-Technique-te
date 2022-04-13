package DataAcces;

import ConnectionFactory.ConnectionFactory;
import Model.Clients;
import Model.Products;

import javax.swing.*;
import javax.xml.transform.Result;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
/**
 * in this class product insertion in basket list and order placement is made
 * Last order id was selected and the field for the connection in Product will be the id + 1 because the order with id equals to selected id already exist
 * For bill making all products with the connection field equals to id + 1 will be written in the bill
 * The bill also contains details about the client who places the order and the total sum of profucts
 */
public class OrderDAO {


    public static int insertIntoOrder(Products product){
        int id = 0;
        product.setProductStock(product.getProductStock() - 1);
        try{
            Connection connection = ConnectionFactory.getConnection();
            String query = "select orderId from orders order by orderId desc limit 1;";
            CallableStatement stmt = connection.prepareCall(query);
            stmt.execute();
            boolean hasResult = stmt.execute();
            if(hasResult){
                ResultSet rs = stmt.getResultSet();
                while(rs.next()){
                    id= rs.getInt(1);
                }
            }

            String query2 = "update products set ordersId = ? where productName = ?;";
            CallableStatement stmt2 = connection.prepareCall(query2);
            stmt2.setInt(1,id + 1);
            stmt2.setString(2,product.getProductName());
            stmt2.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return id;
    }

    public static float placeOrder(DefaultListModel v, Clients client){
        final DecimalFormat df = new DecimalFormat("0.00");
        float suma = 0;

        for(int i = 0; i < v.size(); i++){
            String[] x = v.get(i).toString().split(" ");
            suma += Float.parseFloat(x[3]) * Integer.parseInt(x[x.length-1]);
        }

        if(suma != 0){
            try{
                int id =0 ;
                Connection connection = ConnectionFactory.getConnection();
                String query = "insert into orders(orderSum) values(?);";
                CallableStatement stmt = connection.prepareCall(query);
                stmt.setFloat(1,suma);
                stmt.execute();

                String query2 = "select orderId from orders order by orderId desc limit 1;";
                CallableStatement stmt2 = connection.prepareCall(query2);
                stmt2.execute();
                boolean hasResult = stmt2.execute();
                if(hasResult){
                    ResultSet rs = stmt2.getResultSet();
                    while(rs.next()){
                        id= rs.getInt(1);
                    }
                }
                for(int i = 0; i < v.size(); i++) {
                    String z[] = v.get(i).toString().split(" ");

                    String query3 = "update products set productStock = productStock - ? where productName = ?";
                    CallableStatement stmt3 = connection.prepareCall(query3);
                    stmt3.setInt(1, Integer.parseInt(z[z.length - 1]));
                    stmt3.setString(2,z[1]);
                    stmt3.execute();
                }
                File file = new File("Comanda"+String.valueOf(id)+".txt");
                FileWriter writer = new FileWriter("Comanda"+String.valueOf(id)+".txt");
                writer.append("Clientul:" + client.getName() + " " + client.getClientSurname() + " " + "Varsta: " + client.getAge() + " a plasat comanda:"+ "\n");


                writer.append("\n"+"Produse:" + "\n" + "\n");
                for(int i = 0; i < v.size() ; i++){
                    String z[] = v.get(i).toString().split(" ");
                    writer.append(z[1] + " Pret: " + z[3] + " Cantitate: "+ z[z.length-1] + "\n");
                }
                writer.append("\n" + "Suma totala: "+ String.valueOf(df.format(suma)));
                writer.close();
            }catch (SQLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return suma;
    }

}
