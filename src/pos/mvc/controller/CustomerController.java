/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.mvc.controller;
import java.sql.ResultSet;
import pos.mvc.model.CustomerModel;
import java.sql.Connection;
import pos.mvc.db.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sujah
 */
public class CustomerController {
    public String saveCustomer(CustomerModel customer) throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        
        String query = "INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        
        preparedStatement.setString(1, customer.getCustID());
        preparedStatement.setString(2, customer.getTitle());
        preparedStatement.setString(3, customer.getName());
        preparedStatement.setString(4, customer.getDob());
        preparedStatement.setDouble(5, customer.getSalary());
        preparedStatement.setString(6, customer.getAddress());
        preparedStatement.setString(7, customer.getCity());
        preparedStatement.setString(8, customer.getProvince());
        preparedStatement.setString(9, customer.getZip());
        
        if (preparedStatement.executeUpdate() > 0){
            return "Success";
        }
        return "Fail";
    }
    
    public ArrayList<CustomerModel> getAllCustomer() throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM customer";
        
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet result = statement.executeQuery();
        
        ArrayList<CustomerModel> customers = new ArrayList<>();
        
        while(result.next()) {
            CustomerModel cm = new CustomerModel(
                    result.getString(1), 
                    result.getString(2), 
                    result.getString(3),
                    result.getString(4),
                    result.getDouble(5), 
                    result.getString(6), 
                    result.getString(7), 
                    result.getString(8), 
                    result.getString(9)
            );
            
            customers.add(cm);
        }
        
        return customers;
        
        
    }
}
