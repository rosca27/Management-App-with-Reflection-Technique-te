package BusinessLogic;

import Model.Clients;

import java.util.regex.Pattern;
/**
 * In this class is being verified the main introduced by user when a customer is added in database
 * It should contain character "@" and no other special symbols before it
 * If the string matches the pattern and other fields matches their required patterns all fields will be introduced in database
 */
public class MailValidator implements Validator<Clients> {

    String mailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    @Override
    public void validate(Clients client){
        Pattern pattern = Pattern.compile(mailRegex);
        if(!pattern.matcher(client.getClienteMail()).matches()){
            throw new IllegalArgumentException("Email is not valid!");
        }
    }
}
