package BusinessLogic;

import Model.Clients;

import java.util.regex.Pattern;
/**
 * In this class is verified the name and the surname of the client
 * Surname and name should start with capital letter else an exception will pop out
 */
public class NameValidator implements  Validator<Clients>{

    String nameRegex = "[A-Z][a-z]*";

    @Override
    public void validate(Clients client) {
        Pattern pattern = Pattern.compile(nameRegex);
        if(!pattern.matcher(client.getName()).matches() || !pattern.matcher(client.getClientSurname()).matches()){
            throw new IllegalArgumentException("Invalid name or surname!");
        }
    }
}
