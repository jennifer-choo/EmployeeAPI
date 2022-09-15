package com.kainos.ea.db;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.kainos.ea.db.DbConnection.getConnection;

public class InsertEmployee {

    public static List<Employee> insertEmployees(List<Employee> employeesToAdd) {
        List<Employee> bigEmps = new ArrayList<> ();
        ResultSet rs = null;

        String values = "";

        values = "('" + employeesToAdd.get(0).getFName() + "', '" + employeesToAdd.get(0).getLName() + "', '" + employeesToAdd.get(0).getPostCode() +
                "', '" + employeesToAdd.get(0).getAddress() + "', " +employeesToAdd.get(0).getNIN() + ", '" + employeesToAdd.get(0).getBankAccount()
                + "', '" + employeesToAdd.get(0).getStartingSalary() + "', '" + employeesToAdd.get(0).getIsManager() + "', '" + getDepartment() + "')";

        if(employeesToAdd.size() > 1) {

            for (Employee employee : employeesToAdd) {

                values = values + ",('" + employee.getFname() + "', '" + employee.getLName() + "', '" + employee.getPostcode() +
                        "', '" + employee.getAddress() + "', '" + employee.getNIN() + "', '"
                        + employee.getBankAccount() + "', '" + getStartingSalary() + "', '" + getIsManager() + "', '" + getDepartment() + "')";

            }

        }
        values += ";";

        try (
                Connection myConnection = getConnection();
                Statement st = (myConnection == null) ? null : myConnection.createStatement()) {

            if (myConnection == null)
                throw new SQLException ("Database connection null");

            st.executeUpdate("insert into Employee(fname,lname,postcode,address,nin,bankAccount, startingSalary, isManager, department)" +
                    " values " + values);

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

        return bigEmps;

    }
}
