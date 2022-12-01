package model;

import java.time.LocalDateTime;

public class Division {
    private int divisionId;
    private String division;
    private int countryId;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime lastUpdate;
    private String lastUpdatedBy;

    public Division(int divisionId, String division, int countryId) {
        this.divisionId = divisionId;
        this.division = division;
        this.countryId = countryId;
    }

    public Division(int divisionId, String division, int countryId, LocalDateTime createdDate, String createdBy, LocalDateTime lastUpdate, String lastUpdatedBy) {
        this.divisionId = divisionId;
        this.division = division;
        this.countryId = countryId;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public String getDivision() {
        return division;
    }

    public int getCountryId() {
        return countryId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    @Override
    public String toString() {
        return (division + " (" + divisionId + ")");
    }
}
