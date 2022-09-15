package com.kainos.ea.db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbConnection {
    private static Connection myConnection;
    static Connection getConnection() {

        String user;
        String password;
        String host;

        if (myConnection != null)
            return myConnection;

        try(FileInputStream propsStream = new FileInputStream("employeesdb.properties")) {

            Properties props = new Properties();
            props.load(propsStream);

            user = props.getProperty("user");
            password = props.getProperty("password");
            host = props.getProperty("host");

            if (user == null || password == null || host == null)
                throw new IllegalArgumentException(
                        "Properties file must exist and must contain " + "user, password, and host properties.");
            myConnection = DriverManager.getConnection("jdbc:mysql://" + host +
                    "/company_JennicaM?useSSL=false", user, password);
            return myConnection;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }
}
