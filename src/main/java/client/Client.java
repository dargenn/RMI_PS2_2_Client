package client;

import common.ObjectNames;
import common.SecurityUtils;
import server.PersonRepository;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) throws Exception {
        SecurityUtils.prepareSecurity();
        PersonRepository repository = getPersonRepository();
        System.out.println(repository.findAll());
    }

    private static PersonRepository getPersonRepository() throws Exception {
        return (PersonRepository) Naming.lookup("//192.168.0.103/" + (ObjectNames.DATABASE_CONNECTOR.name()));
    }
}
