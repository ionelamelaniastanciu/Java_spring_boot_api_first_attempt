package com.rest_api_java.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "localities")
public class Locality {

    //----------------------------------------------------------------------
    //Attributes
    //----------------------------------------------------------------------

    @Id
    @Column(name = "id")
    private int idLocality;

    @Column(name = "locality_name")
    private String localityName;

    @Column(name = "county_code")
    private String countyCode;

    //----------------------------------------------------------------------
    //Constructor
    //----------------------------------------------------------------------

    public Locality() {
    }

    //----------------------------------------------------------------------

    public Locality(int idLocality, String localityName, String countyCode) {
        this.idLocality = idLocality;
        this.localityName = localityName;
        this.countyCode = countyCode;
    }

    //----------------------------------------------------------------------
    //Methods
    //----------------------------------------------------------------------

    public int getIdLocality() {
        return idLocality;
    }

    //----------------------------------------------------------------------

    public void setIdLocality(int idLocality) {
        this.idLocality = idLocality;
    }

    //----------------------------------------------------------------------

    public String getLocalityName() {
        return localityName;
    }

    //----------------------------------------------------------------------

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    //----------------------------------------------------------------------

    public String getCountyCode() {
        return countyCode;
    }

    //----------------------------------------------------------------------

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    //----------------------------------------------------------------------

    @Override
    public String toString() {

        return "Locality{" +
                "idLocality=" + idLocality +
                ", localityName='" + localityName + '\'' +
                ", countyCode='" + countyCode + '\'' +
                '}';
    }
}