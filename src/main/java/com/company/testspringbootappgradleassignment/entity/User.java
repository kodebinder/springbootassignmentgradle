package com.company.testspringbootappgradleassignment.entity;

import java.util.List;

public class User {
    private long id;
    private Address address;
    private List<String> mobileNumbers;
    private String email;
    private String userFirstName;
    private String userId;
    private String userLastName;

    public User(){}

    public User(long id, Address address, List<String> mobileNumbers, String email, String userFirstName, String userId, String userLastName) {
        this.id = id;
        this.address = address;
        this.mobileNumbers = mobileNumbers;
        this.email = email;
        this.userFirstName = userFirstName;
        this.userId = userId;
        this.userLastName = userLastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(List<String> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (mobileNumbers != null ? !mobileNumbers.equals(user.mobileNumbers) : user.mobileNumbers != null)
            return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (userFirstName != null ? !userFirstName.equals(user.userFirstName) : user.userFirstName != null)
            return false;
        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        return userLastName != null ? userLastName.equals(user.userLastName) : user.userLastName == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (mobileNumbers != null ? mobileNumbers.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userFirstName != null ? userFirstName.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userLastName != null ? userLastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", address=" + address +
                ", mobileNumbers=" + mobileNumbers +
                ", email='" + email + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userId='" + userId + '\'' +
                ", userLastName='" + userLastName + '\'' +
                '}';
    }
}
