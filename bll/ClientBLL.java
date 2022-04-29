package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.ClientAgeValidator;
import bll.validators.ClientEmailValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;

/**
 * @author Macean Marius
 * @since Apr 06, 2021
 */
public class ClientBLL {

    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;

    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new ClientEmailValidator());
        validators.add(new ClientAgeValidator());

        clientDAO = new ClientDAO();
    }

    /*public Client findStudentById(int id) {
        Client st = ClientDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return st;
    }*/

}
