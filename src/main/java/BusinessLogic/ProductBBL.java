package BusinessLogic;

import DataAcces.ClientDAO;
import DataAcces.ProductDAO;
import Model.Products;

import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * In this class we call methods from Product Data Access module for verifying all of them that are in use.
 * Each method must return a value which is not equal to -1
 * If value returned -1 then function doesn't make the operation it should make
 */
public class ProductBBL {



    public static int addProduct(Products products) {
        int id = ProductDAO.addProduct(products);
        if(id == -1){
            throw new NoSuchElementException("Elementul nu se poate insera");
        }
        return id;
    }

    public static int editProduct(Products products, ArrayList<Object> n){
        int id = ProductDAO.editProduct(products,n);
        if(id == -1){
            throw  new NoSuchElementException("The element doesn't exists");
        }
        return id;
    }

    public static int removeProduct(Products products){
        int id = ProductDAO.removeProduct(products);
        if(id == -1){
            throw new NoSuchElementException("The element doesn't exists");
        }

        return id;
    }

}
