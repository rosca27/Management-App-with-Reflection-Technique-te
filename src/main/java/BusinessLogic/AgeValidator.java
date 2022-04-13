/**
 * This package verifies all methods used
 */
package BusinessLogic;

import Model.Clients;
/**
 * Age limit check is made is this class. The client must be between 16 and 65 years old
 */
public class AgeValidator implements Validator<Clients> {

    @Override
    public void validate(Clients client){
        if(client.getAge() < 16 || client.getAge()>65){
            throw new IllegalArgumentException("Age limit is not respected!");
        }
    }
}
