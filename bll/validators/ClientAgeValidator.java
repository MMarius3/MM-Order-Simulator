package bll.validators;

import model.Client;

/**
 * @author Macean Marius
 * @since Apr 06, 2021
 */
public class ClientAgeValidator implements Validator<Client> {
    private static final int MIN_AGE = 4;
    private static final int MAX_AGE = 99;

    public void validate(Client t) {

        if (t.getAge() < MIN_AGE || t.getAge() > MAX_AGE) {
            throw new IllegalArgumentException("The Client Age limit is not respected!");
        }

    }

}
