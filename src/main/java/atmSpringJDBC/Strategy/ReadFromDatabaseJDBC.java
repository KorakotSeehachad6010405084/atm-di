package atmSpringJDBC.Strategy;

import atmSpringJDBC.JDBCConfig.CustomerDataAccessObject;
import atmSpringJDBC.JDBCConfig.CustomersDataAccessImprement;
import atmSpringJDBC.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadFromDatabaseJDBC implements ReadDataSource {
    public Map<Integer, Customer> readCustomers() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("configDatabaseJDBC.xml");
        CustomerDataAccessObject customersDaoi = context.getBean("customerDataAccessObjectImp", CustomersDataAccessImprement.class);

        Map<Integer, Customer> mapCustomer = new HashMap<Integer, Customer>();
        List<Customer> customers = customersDaoi.findAll();
        for (Customer customer : customers) {
            mapCustomer.put(customer.getCustomerNumber(), customer);
        }
        return mapCustomer;
    }
}
