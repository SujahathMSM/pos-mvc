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
    
    public CustomerModel SearchCustomer(String CustID) throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM customer WHERE CustID=?";
        
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, CustID);
        
        ResultSet rst = statement.executeQuery();
        
        while(rst.next()){
            CustomerModel cm = new CustomerModel(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDouble(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9)      
            );
            
            return cm;
        }
        
        return null;
    }
    
    public String updateCustomer(CustomerModel customerModel) throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "UPDATE customer SET CustTitle=?, CustName=?, DOB=?, Salary=?, CustAddress=?, City=?, Province=?, PostalCode=? WHERE CustID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setString(1, customerModel.getTitle());
        preparedStatement.setString(2, customerModel.getName());
        preparedStatement.setString(3, customerModel.getDob());
        preparedStatement.setDouble(4, customerModel.getSalary());
        preparedStatement.setString(5, customerModel.getAddress());
        preparedStatement.setString(6, customerModel.getCity());
        preparedStatement.setString(7, customerModel.getProvince());
        preparedStatement.setString(8, customerModel.getZip());
        preparedStatement.setString(9, customerModel.getCustID());
        
        if (preparedStatement.executeUpdate() > 0){
            return "Success";
        }
        return "Fail";
        
    }
    
    public String deleteCustomer(String custID) throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "DELETE FROM customer WHERE CustID=?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, custID);
        
        if (preparedStatement.executeUpdate() > 0){
            return "Success";
        }
        return "Fail";
    }
}
