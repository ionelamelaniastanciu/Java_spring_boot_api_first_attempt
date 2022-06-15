package com.rest_api_java.api.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "counties")
public class County {

    //----------------------------------------------------------------------
    //Attributes
    //----------------------------------------------------------------------

    @Id
    @Column(name = "id")
    private int idCounty;

    @Column(name = "county_name")
    private String countyName;

    @Column(name = "county_code")
    private String countyCode;

    //----------------------------------------------------------------------
    //Constructor
    //----------------------------------------------------------------------

    public County() {
    }

    //----------------------------------------------------------------------

    public County(int idCounty, String countyName, String countyCode) {
        this.idCounty = idCounty;
        this.countyName = countyName;
        this.countyCode = countyCode;
    }

    //----------------------------------------------------------------------
    //Methods
    //----------------------------------------------------------------------

    public int getIdCounty() {
        return idCounty;
    }

    //----------------------------------------------------------------------

    public void setIdCounty(int idCounty) {
        this.idCounty = idCounty;
    }

    //----------------------------------------------------------------------

    public String getCountyName() {
        return countyName;
    }

    //----------------------------------------------------------------------

    public void setCountyName(String countyName) {
        this.countyName = countyName;
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
        return "County{" +
                "idCounty=" + idCounty +
                ", countyName='" + countyName + '\'' +
                ", countyCode='" + countyCode + '\'' +
                '}';
    }
}
