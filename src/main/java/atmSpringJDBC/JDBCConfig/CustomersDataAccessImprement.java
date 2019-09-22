package atmSpringJDBC.JDBCConfig;

import atmSpringJDBC.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomersDataAccessImprement implements CustomerDataAccessObject {

    private JdbcTemplate jdbcTemplate;
    public CustomersDataAccessImprement(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Customer customer) {
//        String query = "INSERT INTO customers (name, pin, currentBalance) VALUES (?, ?, ?);";
//        Object[] data = new Object[]
//                { customer.getCustomerNumber(), customer.-------(), customer.----------() };
//        jdbcTemplate.update(query, data);
    }

    public void update(int id, Customer customer) {
//        String query = "UPDATE book SET number = ?, pin = ? WHERE id = ?;";
//        jdbcTemplate.update(query,customer.getCustomerNumber(), customer.-------(), customer.----------());
    }

    public void deleteById(int id) {
//        String query = "DELETE FROM customers WHERE id = " + id;
//        jdbcTemplate.update(query);
    }

    public Customer findById(int id) {
        return null;
    }

    public List<Customer> findAll() {
        String query = "SELECT * FROM customers";
             List<Customer> customers = jdbcTemplate.query(query, new CustomerRowMapper());
        return customers;
    }


    public class CustomerRowMapper implements RowMapper {
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            Customer customer = new Customer(resultSet.getInt("customerID"),
                    resultSet.getInt("pin"),
                    resultSet.getInt("account"));
            return customer;
        }
    }
}
