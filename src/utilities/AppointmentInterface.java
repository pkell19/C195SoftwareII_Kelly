package utilities;

import javafx.collections.ObservableList;
import model.Appointment;

public interface AppointmentInterface {

    public static ObservableList<Appointment> getAllAppointments() {
        return null;
    }

    public int updateAppointment(Appointment appointment);
    public int deleteAppointment(Appointment appointment);
    public int createAppointment(Appointment appointment);
}
