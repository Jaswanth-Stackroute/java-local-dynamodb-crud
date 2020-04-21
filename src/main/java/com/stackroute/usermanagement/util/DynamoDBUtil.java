package com.stackroute.usermanagement.util;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.local.main.ServerRunner;
import com.amazonaws.services.dynamodbv2.local.server.DynamoDBProxyServer;
import org.apache.commons.cli.ParseException;

public class DynamoDBUtil {

    private  static DynamoDBProxyServer server;
    private static AmazonDynamoDB client;

    public static boolean startDynamoDB(String port) throws ParseException {
        boolean started=false;
        System.setProperty("sqlite4java.library.path", "native-libs");
        server = ServerRunner.createServerFromCommandLineArgs(
                new String[]{"-inMemory", "-port",port});

        try {
            server.start();
            System.out.println("DynamoDB Server started...");
             started=true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return started;
    }

    public static boolean stopDynamoDB(String port) throws ParseException {
        boolean started=true;
        System.setProperty("sqlite4java.library.path", "native-libs");
        server = ServerRunner.createServerFromCommandLineArgs(
                new String[]{"-inMemory", "-port",port});

        try {
            server.stop();
            System.out.println("DynamoDB Server stopped...");
            started=false;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return started;
    }

    public static AmazonDynamoDB getClient() {
        client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
                new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
                .build();
        return client;
    }

    public static DynamoDBMapper getMapper() {
        return new DynamoDBMapper(client);
    }
}



