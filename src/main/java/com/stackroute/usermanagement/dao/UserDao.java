package com.stackroute.usermanagement.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.stackroute.usermanagement.domain.User;
import com.stackroute.usermanagement.util.DynamoDBUtil;

import java.util.List;

public class UserDao {
    private DynamoDBMapper dynamoDBMapper;

    public UserDao() {
         dynamoDBMapper= DynamoDBUtil.getMapper();
    }
    public List<User> batchSaveUser(List<User> userList){
        DynamoDBMapper dynamoDBMapper= DynamoDBUtil.getMapper();
        List<DynamoDBMapper.FailedBatch> failedBatchUsers= dynamoDBMapper.batchSave(userList);
        return userList;
    }

    public User saveUser(User user){
        DynamoDBMapper dynamoDBMapper= DynamoDBUtil.getMapper();
        return dynamoDBMapper.load(User.class, user.getId());
    }
    public User getUserById(String id){
        DynamoDBMapper dynamoDBMapper= DynamoDBUtil.getMapper();
        return dynamoDBMapper.load(User.class, id);
    }

    public List<User> getAllUsers(){
        DynamoDBMapper dynamoDBMapper= DynamoDBUtil.getMapper();
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List < User > userList = dynamoDBMapper.scan(User.class,scanExpression);
        return userList;
    }

}
