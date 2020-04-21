package com.stackroute.usermanagement.service;

import com.stackroute.usermanagement.domain.User;
import com.stackroute.usermanagement.domain.UserDetails;
import com.stackroute.usermanagement.util.DynamoDBUtil;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private User user1, user2,user3;
    private List<User> userList;
    private UserService userService;

    @BeforeAll
    public static void setUpOnce() throws Exception{
        System.out.println("Starting DB");
        DynamoDBUtil.startDynamoDB("9000");
    }
    @AfterAll
    public static void tearDownOnce() throws Exception {
        System.out.println("Stopping DB");
        DynamoDBUtil.stopDynamoDB("9000");
    }
   @BeforeEach
   public void setup() throws Exception{
       userService=new UserServiceImpl();
       user1 = new User("1","John","Male","877665345");
       user2 = new User("2", "Meghri","Female","3696939363");
       user3 = new User ("3","Sam","Male","9977664563");

       userList=new ArrayList<>();
       userList.add(user1);
       userList.add(user2);
   }
   @AfterEach
  public void tearDown() throws Exception{
     userService=null;
   }
    @Test
    void addUsers() {
        System.out.println(userList);
        List<User> savedUserList=userService.addUsers(userList);
        assertEquals(2,savedUserList.size());
    }

    @Test
    void addUser() {
        User savedUser=userService.addUser(user3);
        assertNotNull(savedUser);
        assertEquals("Sam",savedUser.getName());
        assertEquals("Male",savedUser.getGender());
        assertEquals("9977664563",savedUser.getContactNumber());
    }

    @Test
    void getUsers() {

        List<User> userList=userService.getUsers();
        assertNotNull(userList);
        assertEquals(2, userList.size());
        assertEquals(userList.get(0),user1);
    }
}