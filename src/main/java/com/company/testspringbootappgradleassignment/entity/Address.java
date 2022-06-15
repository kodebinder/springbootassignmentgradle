package com.company.testspringbootappgradleassignment.entity;

public class Address {
    private long id;
    private String addressId;
    private String addressType;
    private String city;
    private String street;
    private String state;
    private String country;
    private String zip;

    public Address(){}

    public Address(long id, String addressId, String addressType, String city, String street, String state, String country, String zip) {
        this.id = id;
        this.addressId = addressId;
        this.addressType = addressType;
        this.city = city;
        this.street = street;
        this.state = state;
        this.country = country;
        this.zip = zip;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != address.id) return false;
        if (addressId != null ? !addressId.equals(address.addressId) : address.addressId != null) return false;
        if (addressType != null ? !addressType.equals(address.addressType) : address.addressType != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (state != null ? !state.equals(address.state) : address.state != null) return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        return zip != null ? zip.equals(address.zip) : address.zip == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (addressType != null ? addressType.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressId='" + addressId + '\'' +
                ", addressType='" + addressType + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
