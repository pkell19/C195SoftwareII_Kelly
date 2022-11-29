package utilities;

import javafx.collections.ObservableList;
import model.Appointment;

public interface AppointmentInterface {

    static ObservableList<Appointment> getAllAppointments() {
        return null;
    }

    int updateAppointment(Appointment appointment);
    int deleteAppointment(Appointment appointment);
    int createAppointment(Appointment appointment);
}
