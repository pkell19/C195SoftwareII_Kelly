package model;

import javafx.collections.ObservableList;

import java.time.LocalDateTime;

public class Appointment {
    private int apptId;
    private String apptTitle;
    private String apptDescription;
    private String apptLocation;
    private String apptType;
    private LocalDateTime apptDate;
    private LocalDateTime apptStartTime;
    private LocalDateTime apptEndTime;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime lastUpdate;
    private String lastUpdatedBy;
    private int apptCustomerId;
    private int apptUserId;
    private int apptContactId;

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

    public Appointment(int apptId, String apptTitle, String apptDescription, String apptLocation, String apptType,
                       LocalDateTime apptDate, LocalDateTime apptStartTime, LocalDateTime apptEndTime,
                       LocalDateTime createdDate, String createdBy, LocalDateTime lastUpdate, String lastUpdatedBy,
                       int apptCustomerId, int apptUserId, int apptContactId) {
        this.apptId = apptId;
        this.apptTitle = apptTitle;
        this.apptDescription = apptDescription;
        this.apptLocation = apptLocation;
        this.apptType = apptType;
        this.apptDate = apptDate;
        this.apptStartTime = apptStartTime;
        this.apptEndTime = apptEndTime;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.apptCustomerId = apptCustomerId;
        this.apptUserId = apptUserId;
        this.apptContactId = apptContactId;
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

    public LocalDateTime getApptDate() {
        return apptDate;
    }

    public void setApptDate(LocalDateTime apptDate) {
        this.apptDate = apptDate;
    }

    public LocalDateTime getApptStartTime() {
        return apptStartTime;
    }

    public void setApptStartTime(LocalDateTime apptStartTime) {
        this.apptStartTime = apptStartTime;
    }

    public LocalDateTime getApptEndTime() {
        return apptEndTime;
    }

    public void setApptEndTime(LocalDateTime apptEndTime) {
        this.apptEndTime = apptEndTime;
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
}
