package com.kainos.ea.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.kainos.ea.db.DbConnection.getConnection;

public class GetEmployee {
    private static Connection myConnection;
    public static List<Employee> getEmployees() {

        List<Employee> bigEmps = new ArrayList<> ();
        ResultSet rs = null;

        try (Connection myConnection = getConnection();
             Statement st = (myConnection == null) ? null : myConnection.createStatement()) {

            if (myConnection == null)
                throw new SQLException ("Database connection null");

            rs = st.executeQuery("select * from Employee");

            while (rs.next()) {
                Employee dbEmp = new Employee(
                        rs.getString("fname"), rs.getString("lname"),
                        rs.getString("postcode"),rs.getString("address"),
                        rs.getInt("nin"), rs.getString("bank_account"),
                        rs.getFloat("starting_salary"), rs.getInt("isManager"), rs.getString("department"));
                bigEmps.add(dbEmp);
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

        return bigEmps;

    }
}