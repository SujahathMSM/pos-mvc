/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.mvc.controller;


import java.util.ArrayList;
import pos.mvc.model.ItemModel;
import java.sql.Connection;
import pos.mvc.db.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author sujah
 */
public class ItemController {
    
    public ArrayList<ItemModel> getAllItems() throws SQLException{
        
        ArrayList<ItemModel> items = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM item";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while(resultSet.next()){
            ItemModel item = new ItemModel(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getInt(5)
            );
            
            items.add(item);
        }
        
        return items;
        
    }
    
    public String saveItem(ItemModel itemModel) throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO item VALUES(?,?,?,?,?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        
        preparedStatement.setString(1,itemModel.getItemCode());
        preparedStatement.setString(2, itemModel.getDesc());
        preparedStatement.setString(3, itemModel.getPackSize());
        preparedStatement.setDouble(4,itemModel.getUnitPrice());
        preparedStatement.setInt(5,itemModel.getQuantity());
        
        if (preparedStatement.executeUpdate() > 0){
            return "Success";
        }
        
        return "False";
    }
    
    public ItemModel viewItem(String itemID) throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM item WHERE ItemCode=?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, itemID);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while(resultSet.next()){
            ItemModel itemModel;
            itemModel = new ItemModel(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getInt(5)
            );
            
            return itemModel;
        }
        
        return null;
    }
    
    public String updateItems(ItemModel itemModel) throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE item SET Description=?, PackSize=?,UnitPrice=?,QtyOnHand=? WHERE ItemCode=?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        
        preparedStatement.setString(1, itemModel.getDesc());
        preparedStatement.setString(2, itemModel.getPackSize());
        preparedStatement.setDouble(3, itemModel.getUnitPrice());
        preparedStatement.setInt(4, itemModel.getQuantity());
        preparedStatement.setString(5, itemModel.getItemCode());
        
        if (preparedStatement.executeUpdate() > 0){
            return "Success";
        }
        
        return "Fail";
        
    }
    
    public String deleteItem(String itemID) throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "DELETE FROM item WHERE ItemCode=?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        
        preparedStatement.setString(1, itemID);
        
        if(preparedStatement.executeUpdate() > 0){
            return "Successfully Deleted";
        }
        
        return "Failed to Delete";
        
    }
}
