/**
 * This package verifies all methods used
 */
package BusinessLogic;

import DataAcces.ClientDAO;
import Model.Clients;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * In this class we call methods from Client Data Access module for verifying all of them that are in use.
 * Each method must return a value which is not equal to -1
 * If value returned -1 then function doesn't make the operation it should make
 */
public class ClientBBL {

    private static List<Validator<Clients>> validatorList = new ArrayList<Validator<Clients>>();


    public ClientBBL(){
        validatorList = new ArrayList<Validator<Clients>>();
        validatorList.add(new AgeValidator());
        validatorList.add(new MailValidator());
        validatorList.add(new NameValidator());
    }

    public static void addNewClient(Clients client) {
        validatorList = new ArrayList<Validator<Clients>>();
        validatorList.add(new AgeValidator());
        validatorList.add(new MailValidator());
        validatorList.add(new NameValidator());
        for(Validator<Clients> v : validatorList){
            v.validate(client);
        }
        ClientDAO.addClient(client);
    }

    public static int editClient(Clients client, ArrayList<Object> c){
        int id = ClientDAO.editClient(client,c);
        if(id == -1){
            throw new NoSuchElementException("The client with id = " + id + " doesn't exist!");
        }
        return id;
    }

    public static int removeClient(Clients client){
        int id = ClientDAO.removeClient(client);
        if(id == -1){
            throw new NoSuchElementException("The client with id = " + id + " doesn't exist!");
        }
        return id;
    }
}
