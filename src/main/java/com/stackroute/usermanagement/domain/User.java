package com.stackroute.usermanagement.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "User")
public class User {
    private String id;
    private String name;
    private String gender;
    private String contactNumber;
    /*Default constructor*/
    public User() {
    }

    public User(String id, String name, String gender, String contactNumber) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.contactNumber = contactNumber;
    }

    @DynamoDBGeneratedUuid(DynamoDBAutoGenerateStrategy.CREATE)
    @DynamoDBHashKey(attributeName = "id")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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


