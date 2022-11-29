package utilities;

import javafx.collections.ObservableList;
import model.Customer;

import java.sql.SQLException;
import java.time.LocalDateTime;

public interface CustomerInterface {
    int updateCustomer(Customer customer);
    int createCustomer(Customer customer);
    int deleteCustomer(int customerId);
    Customer getCustomer(int customerId);
    void getAllCustomer();
}
