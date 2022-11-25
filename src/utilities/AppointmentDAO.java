package utilities;

import java.sql.SQLException;
import java.time.LocalDateTime;

public interface AppointmentDAO {

    int update(String title, String desc, String location,
               String type, LocalDateTime start, LocalDateTime end,
               int customerId, int userId, int contactId, int apptId)
            throws SQLException;

    int create(String title, String desc, String location,
               String type, LocalDateTime start, LocalDateTime end,
               int customerId, int userId, int contactId)
            throws SQLException;

    int delete(int apptId) throws SQLException;

    void read() throws SQLException;
}
