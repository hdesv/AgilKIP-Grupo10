package com.mycompany.myapp.domain;

import com.mycompany.myapp.domain.enumeration.tourCity;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A BikePlan.
 */
@Entity
@Table(name = "bike_plan")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BikePlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "experience")
    private String experience;

    @Column(name = "name_client")
    private String nameClient;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "bike_number")
    private Integer bikeNumber;

    @Column(name = "tour_number")
    private Integer tourNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "tour_city")
    private tourCity tourCity;

    @Column(name = "cliente_number")
    private Integer clienteNumber;

    @Column(name = "want_tour")
    private String wantTour;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BikePlan id(Long id) {
        this.id = id;
        return this;
    }

    public String getExperience() {
        return this.experience;
    }

    public BikePlan experience(String experience) {
        this.experience = experience;
        return this;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getNameClient() {
        return this.nameClient;
    }

    public BikePlan nameClient(String nameClient) {
        this.nameClient = nameClient;
        return this;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }

    public BikePlan phoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return this.userName;
    }

    public BikePlan userName(String userName) {
        this.userName = userName;
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public BikePlan userEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public BikePlan startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public BikePlan endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getBikeNumber() {
        return this.bikeNumber;
    }

    public BikePlan bikeNumber(Integer bikeNumber) {
        this.bikeNumber = bikeNumber;
        return this;
    }

    public void setBikeNumber(Integer bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    public Integer getTourNumber() {
        return this.tourNumber;
    }

    public BikePlan tourNumber(Integer tourNumber) {
        this.tourNumber = tourNumber;
        return this;
    }

    public void setTourNumber(Integer tourNumber) {
        this.tourNumber = tourNumber;
    }

    public tourCity getTourCity() {
        return this.tourCity;
    }

    public BikePlan tourCity(tourCity tourCity) {
        this.tourCity = tourCity;
        return this;
    }

    public void setTourCity(tourCity tourCity) {
        this.tourCity = tourCity;
    }

    public Integer getClienteNumber() {
        return this.clienteNumber;
    }

    public BikePlan clienteNumber(Integer clienteNumber) {
        this.clienteNumber = clienteNumber;
        return this;
    }

    public void setClienteNumber(Integer clienteNumber) {
        this.clienteNumber = clienteNumber;
    }

    public String getWantTour() {
        return this.wantTour;
    }

    public BikePlan wantTour(String wantTour) {
        this.wantTour = wantTour;
        return this;
    }

    public void setWantTour(String wantTour) {
        this.wantTour = wantTour;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BikePlan)) {
            return false;
        }
        return id != null && id.equals(((BikePlan) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BikePlan{" +
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
