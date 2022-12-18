package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Appointment {
    private int apptId;
    private String apptTitle;
    private String apptDescription;
    private String apptLocation;
    private String apptType;
    private LocalDateTime apptStartDateTime;
    private LocalDateTime apptEndDateTime;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime lastUpdate;
    private String lastUpdatedBy;
    private int apptCustomerId;
    private int apptUserId;
    private int apptContactId;

    public static final LocalTime BUSINESS_OPENING = LocalTime.of(8, 0);
    public static final LocalTime BUSINESS_CLOSING = LocalTime.of(22, 0);

    public static ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();

    public Appointment(int apptId, String apptTitle, String apptDescription, String apptLocation, String apptType,
                       LocalDateTime apptStartDateTime, LocalDateTime apptEndDateTime, int apptCustomerId,
                       int apptUserId, int apptContactId) {
        this.apptId = apptId;
        this.apptTitle = apptTitle;
        this.apptDescription = apptDescription;
        this.apptLocation = apptLocation;
        this.apptType = apptType;
        this.apptStartDateTime = apptStartDateTime;
        this.apptEndDateTime = apptEndDateTime;
        this.apptCustomerId = apptCustomerId;
        this.apptUserId = apptUserId;
        this.apptContactId = apptContactId;
    }

    public Appointment(String apptTitle, String apptDescription, String apptLocation, String apptType,
                       LocalDateTime apptStartDateTime, LocalDateTime apptEndDateTime, int apptCustomerId, int apptUserId,
                       int apptContactId) {
        this.apptTitle = apptTitle;
        this.apptDescription = apptDescription;
        this.apptLocation = apptLocation;
        this.apptType = apptType;
        this.apptStartDateTime = apptStartDateTime;
        this.apptEndDateTime = apptEndDateTime;
        this.apptCustomerId = apptCustomerId;
        this.apptUserId = apptUserId;
        this.apptContactId = apptContactId;
    }

    public Appointment(int apptId, String apptTitle, String apptDescription, String apptLocation, String apptType,
                       LocalDateTime apptStartDateTime, LocalDateTime apptEndDateTime,
                       LocalDateTime createdDate, String createdBy, LocalDateTime lastUpdate, String lastUpdatedBy,
                       int apptCustomerId, int apptUserId, int apptContactId) {
        this.apptId = apptId;
        this.apptTitle = apptTitle;
        this.apptDescription = apptDescription;
        this.apptLocation = apptLocation;
        this.apptType = apptType;
        this.apptStartDateTime = apptStartDateTime;
        this.apptEndDateTime = apptEndDateTime;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.apptCustomerId = apptCustomerId;
        this.apptUserId = apptUserId;
        this.apptContactId = apptContactId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public int getApptId() {
        return apptId;
    }

    public void setApptId(int apptId) {
        this.apptId = apptId;
    }

    public String getApptTitle() {
        return apptTitle;
    }

    public void setApptTitle(String apptTitle) {
        this.apptTitle = apptTitle;
    }

    public String getApptDescription() {
        return apptDescription;
    }

    public void setApptDescription(String apptDescription) {
        this.apptDescription = apptDescription;
    }

    public String getApptLocation() {
        return apptLocation;
    }

    public void setApptLocation(String apptLocation) {
        this.apptLocation = apptLocation;
    }

    public String getApptType() {
        return apptType;
    }

    public void setApptType(String apptType) {
        this.apptType = apptType;
    }

    public LocalDateTime getApptStartDateTime() {
        return apptStartDateTime;
    }

    public void setApptStartDateTime(LocalDateTime apptStartDateTime) {
        this.apptStartDateTime = apptStartDateTime;
    }

    public LocalDateTime getApptEndDateTime() {
        return apptEndDateTime;
    }

    public void setApptEndDateTime(LocalDateTime apptEndDateTime) {
        this.apptEndDateTime = apptEndDateTime;
    }

    public int getApptCustomerId() {
        return apptCustomerId;
    }

    public void setApptCustomerId(int apptCustomerId) {
        this.apptCustomerId = apptCustomerId;
    }

    public int getApptUserId() {
        return apptUserId;
    }

    public void setApptUserId(int apptUserId) {
        this.apptUserId = apptUserId;
    }

    public int getApptContactId() {
        return apptContactId;
    }

    public void setApptContactId(int apptContactId) {
        this.apptContactId = apptContactId;
    }

    @Override
    public String toString() {
        return (apptType);
    }
}
