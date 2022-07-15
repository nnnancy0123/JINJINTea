/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jinjintea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

/**
 *
 * @author user
 */
public class ProductIntro {

    public void conn(String productid, String productname, String category, String price, String maxnom, String warehouse) {

        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";


        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();
            String sql = "insert into tbl_product( product_id,product_name,category,price,max_nom,warehouse) "
                    + "values('" + productid + "','" + productname + "'," + "'category '"+ "," + "'" + price + "'," + "'maxnom'," + "'" + warehouse + "')";

            System.out.println(sql);
            query.execute(sql);
//
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }

    }
}
