package model;

import java.time.LocalDateTime;

public class Country {
    private int countryId;
    private String country;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime lastUpdated;
    private String lastUpdatedBy;

    public Country(int countryId, String country) {
        this.countryId = countryId;
        this.country = country;
    }

    public Country(int countryId, String country, LocalDateTime createdDate, String createdBy, LocalDateTime lastUpdated, String lastUpdatedBy) {
        this.countryId = countryId;
        this.country = country;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.lastUpdated = lastUpdated;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString(){
        return (country);
    }
}
