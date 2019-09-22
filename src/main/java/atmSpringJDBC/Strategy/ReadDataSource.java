package atmSpringJDBC.Strategy;

import atmSpringJDBC.Customer;

import java.io.IOException;
import java.util.Map;

public interface ReadDataSource {
    public Map<Integer, Customer> readCustomers() throws IOException;
}
