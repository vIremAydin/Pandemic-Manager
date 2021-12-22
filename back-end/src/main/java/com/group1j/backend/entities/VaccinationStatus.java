package com.group1j.backend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class VaccinationStatus {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int vaccinationStatusID;

    private int numOfDoses;

    @ElementCollection
    @CollectionTable(name = "vaccination_list", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "vaccination_name")
    private List<String> vaccinationNames;

    @ElementCollection
    @CollectionTable(name = "dates_list", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "date")
    private List<String> datesOfDoses;

    //Constructor
    public VaccinationStatus(int vaccinationStatusID, int numOfDoses, List<String> vaccinationNames, List<String> datesOfDoses) {
        this.vaccinationStatusID = vaccinationStatusID;
        this.numOfDoses = numOfDoses;
        this.vaccinationNames = vaccinationNames;
        this.datesOfDoses = datesOfDoses;
    }

    //Default Constructor
    public VaccinationStatus() {

    }

    public int getVaccinationStatusID() {
        return vaccinationStatusID;
    }

    public void setVaccinationStatusID(int vaccinationStatusID) {
        this.vaccinationStatusID = vaccinationStatusID;
    }

    public int getNumOfDoses() {
        return numOfDoses;
    }

    public void setNumOfDoses(int numOfDoses) {
        this.numOfDoses = numOfDoses;
    }

    public List<String> getVaccinationNames() {
        return vaccinationNames;
    }

    public void setVaccinationNames(List<String> vaccinationNames) {
        this.vaccinationNames = vaccinationNames;
    }

    public List<String> getDatesOfDoses() {
        return datesOfDoses;
    }

    public void setDatesOfDoses(List<String> datesOfDoses) {
        this.datesOfDoses = datesOfDoses;
    }
}
