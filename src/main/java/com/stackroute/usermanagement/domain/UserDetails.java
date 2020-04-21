package com.stackroute.usermanagement.domain;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class UserDetails{
    private String name;
    private String gender;
    private String contactNumber;
    public UserDetails(){

    }
    public UserDetails(String name, String gender, String contactNumber) {
        this.name = name;
        this.gender = gender;
        this.contactNumber = contactNumber;
    }
    @DynamoDBAttribute(attributeName="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @DynamoDBAttribute(attributeName="gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    @DynamoDBAttribute(attributeName="contactNumber")
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

}