/**
 * This package contains all objects with their attributes and methods
 */
package Model;

/**
 * In this class is made the object for client
 * Fields are clientName, clientSurname, clientMail, clientAge
 * Also getters and setters are made for each attribute
 */
public class Clients {
    private String clientName;
    private String clientSurname;
    private String clientMail;
    private int clientAge;

    public String getName() {
        return clientName;
    }

    public void setName(String name) {
        this.clientName = name;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getClienteMail() {
        return clientMail;
    }

    public void setClienteMail(String clienteMail) {
        this.clientMail = clienteMail;
    }

    public int getAge() {
        return clientAge;
    }

    public void setAge(int age) {
        this.clientAge = age;
    }

    public Clients(String clientName, String clientSurname, String eMail, int age) {
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientMail = eMail;
        this.clientAge = age;
    }
}
