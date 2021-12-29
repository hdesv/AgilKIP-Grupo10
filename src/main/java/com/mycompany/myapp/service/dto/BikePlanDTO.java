package com.mycompany.myapp.service.dto;

import com.mycompany.myapp.domain.enumeration.tourCity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.BikePlan} entity.
 */
public class BikePlanDTO implements Serializable {

    private Long id;

    private String experience;

    private String nameClient;

    private Integer phoneNumber;

    private String userName;

    private String userEmail;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer bikeNumber;

    private Integer tourNumber;

    private tourCity tourCity;

    private Integer clienteNumber;

    private String wantTour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getBikeNumber() {
        return bikeNumber;
    }

    public void setBikeNumber(Integer bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    public Integer getTourNumber() {
        return tourNumber;
    }

    public void setTourNumber(Integer tourNumber) {
        this.tourNumber = tourNumber;
    }

    public tourCity getTourCity() {
        return tourCity;
    }

    public void setTourCity(tourCity tourCity) {
        this.tourCity = tourCity;
    }

    public Integer getClienteNumber() {
        return clienteNumber;
    }

    public void setClienteNumber(Integer clienteNumber) {
        this.clienteNumber = clienteNumber;
    }

    public String getWantTour() {
        return wantTour;
    }

    public void setWantTour(String wantTour) {
        this.wantTour = wantTour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BikePlanDTO)) {
            return false;
        }

        BikePlanDTO bikePlanDTO = (BikePlanDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, bikePlanDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BikePlanDTO{" +
            "id=" + getId() +
            ", experience='" + getExperience() + "'" +
            ", nameClient='" + getNameClient() + "'" +
            ", phoneNumber=" + getPhoneNumber() +
            ", userName='" + getUserName() + "'" +
            ", userEmail='" + getUserEmail() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", bikeNumber=" + getBikeNumber() +
            ", tourNumber=" + getTourNumber() +
            ", tourCity='" + getTourCity() + "'" +
            ", clienteNumber=" + getClienteNumber() +
            ", wantTour='" + getWantTour() + "'" +
            "}";
    }
}
