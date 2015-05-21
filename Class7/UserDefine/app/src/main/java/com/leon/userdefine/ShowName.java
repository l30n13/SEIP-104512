package com.leon.userdefine;


public class ShowName {
    private String FirstName;
    private String MiddleName;
    private String LastName;

    public ShowName(String firstName, String middleName, String lastName) {
        this.FirstName = firstName;
        this.FirstName = middleName;
        this.LastName = lastName;
    }

    public ShowName() {

    }

    public String getFirstName() {
        return FirstName;
    }

    public String getMiddletName() {
        return MiddleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setMiddletName(String middleName) {
        MiddleName = middleName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
