package com.mycs.rk.myapplication1.util;

import android.content.Context;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.document.Table;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class DBUtil {

    private final static String identity_pool = "identityPoolId";

    public static Table loadTable(Context context, String tableName){
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                context,   identity_pool,   Regions.US_EAST_1);

        AmazonDynamoDBClient dbClient = new AmazonDynamoDBClient(credentialsProvider);
//        DynamoDBClient client = new DynamoDBClient(awsCredentialProvider, config);
        return Table.loadTable(dbClient, tableName);
    }
}
