package utilities;

import java.sql.SQLException;
import java.time.LocalDateTime;

public interface CustomerInterface {
    int update(int customerId, String name, String address,
               String postalCode, String phone, int divisionId)
            throws SQLException;

    int create(String name, String address, String postalCode,
               String phone, int divisionId)
            throws SQLException;

    int delete(int customerId) throws SQLException;

    void read() throws SQLException;
}
