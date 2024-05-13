/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.mvc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pos.mvc.db.DBConnection;
import pos.mvc.model.OrderDetailModel;
import pos.mvc.model.OrderModel;
import java.sql.PreparedStatement;


/**
 *
 * @author sujah
 */
public class OrderController {

    public String placeOrder(OrderModel ordermodel, ArrayList<OrderDetailModel> orderDetailModels) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            String orderQuery = "INSERT INTO orders VALUES(?,?,?)";
            
            PreparedStatement statementOrder = connection.prepareStatement(orderQuery);
            statementOrder.setString(1, ordermodel.getOrderID());
            statementOrder.setString(2, ordermodel.getOrderDate());
            statementOrder.setString(3, ordermodel.getCustID());
            
            if (statementOrder.executeUpdate() > 0){
                
                boolean isOrderDetailSaved = true;
                String orderDetailQuery = "INSERT INTO orderdetail VALUES (?,?,?,?)";
                for (OrderDetailModel orderDetailModel : orderDetailModels) {
                    PreparedStatement statmentOrderDetail = connection.prepareStatement(orderDetailQuery);
                    statmentOrderDetail.setString(1, ordermodel.getOrderID());
                    statmentOrderDetail.setString(2, orderDetailModel.getItemCode());
                    statmentOrderDetail.setInt(3, orderDetailModel.getQty());
                    statmentOrderDetail.setDouble(4, orderDetailModel.getDiscount());
                    
                    if (!(statmentOrderDetail.executeUpdate() > 0)){
                        isOrderDetailSaved = false;
                    }
                }
                
                if (isOrderDetailSaved){
                    boolean isItemUpdated = true;
                    String itemQuery = "UPDATE item set QtyOnHand = QtyOnHand - ? WHERE ItemCode=?";
                    
                    for (OrderDetailModel orderDetailModel : orderDetailModels) {
                        PreparedStatement statementItem = connection.prepareStatement(itemQuery);
                        statementItem.setInt(1, orderDetailModel.getQty());
                        statementItem.setString(2, orderDetailModel.getItemCode());
                        
                        if(!(statementItem.executeUpdate() > 0)){
                            isItemUpdated = false;
                        }
                    }
                    
                    if (isItemUpdated){
                        connection.commit();
                        return "Success";
                    } else {
                        connection.rollback();
                        return "Item Update ERROR";
                    }
                } else {
                    connection.rollback();
                    return "Order Detail Save ERROR";
                }
                
            } else {
                connection.rollback();
                return "Order Save ERROR";
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
            connection.rollback();
            ex.printStackTrace();
            return ex.getMessage();
        } finally{
            connection.setAutoCommit(true);
        }
        
    }
    
}
