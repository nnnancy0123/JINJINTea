/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jin.tea.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jin.tea.object.OrderNumObj;
import jin.tea.object.OrderObj;

/**
 *
 * @author user
 */
public class AccountHelpService {

    public void createOrderInfo(OrderObj orderObj) {

        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";

        //＠システムの時間を取る  
        LocalDateTime date = LocalDateTime.now();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();
            String sql = "insert into tbl_order( order_id,product_id,product_name,product_price,product_num,date_created,date_modified) "
                    + "values('" + orderObj.getOrderId() + "','" + orderObj.getProductId() + "','" + orderObj.getProductName() + "'," + orderObj.getProductPrice() + "," + orderObj.getProductNum() + ",'" + date + "'," + "'" + date + "'" + ")";

            System.out.println(sql);
            query.execute(sql);
//
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }

    }

    public void conn(int sum) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * オーダー情報一覧取得処理
     *
     * @return オーダーリスト
     */
    public List<OrderObj> orderList() {
        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";
        List<OrderObj> list = new ArrayList<OrderObj>();
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();
            ResultSet resultset = query.executeQuery("SELECT * FROM tbl_order order by order_id");
            while (resultset.next()) {
                OrderObj orderlistinfo = new OrderObj();
                orderlistinfo.setOrderId(resultset.getString("order_id"));
                orderlistinfo.setProductId(resultset.getString("product_id"));
                orderlistinfo.setProductName(resultset.getString("product_name"));
                orderlistinfo.setProductPrice(resultset.getInt("product_price"));
                orderlistinfo.setProductNum(resultset.getInt("product_num"));
                orderlistinfo.setDateCreated(resultset.getString("date_created"));
                orderlistinfo.setDateModified(resultset.getString("date_modified"));

                list.add(orderlistinfo);
            }

            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }
        return list;
    }

    public void createOrderNumInfo(String orderid, int orderprice) {

        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";

        //＠システムの時間を取る  
        LocalDateTime date = LocalDateTime.now();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();
            String sql = "insert into tbl_orderNum( order_id,order_price,date_created,date_modified) "
                    + "values('" + orderid + "'," +orderprice + ",'" + date + "'," + "'" + date + "'" + ")";

            System.out.println(sql);
            query.execute(sql);

            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }

    }


    public void conn(String orderId, int sum1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public List<OrderNumObj> orderNumList() {
        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";
        List<OrderNumObj> list = new ArrayList<OrderNumObj>();
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();
            ResultSet resultset = query.executeQuery("SELECT * FROM tbl_orderNum ");
            while (resultset.next()) {
                OrderNumObj orderlistinfo = new OrderNumObj();
                orderlistinfo.setOrderId(resultset.getString("order_id"));
                orderlistinfo.setOrderPrice(resultset.getInt("order_price"));
                orderlistinfo.setDateCreated(resultset.getString("date_created"));
                orderlistinfo.setDateModified(resultset.getString("date_modified"));

                list.add(orderlistinfo);
            }

            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }
        return list;
    }

}
