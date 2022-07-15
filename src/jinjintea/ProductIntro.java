/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jinjintea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ProductIntro {

    public void createProductInfo(String productid, String productname, int sort, String category, String price, String maxnom, String warehouse) {

        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";
        LocalDateTime date = LocalDateTime.now();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();
            String sql = "insert into tbl_product( product_id,product_name,sort,category,price,max_nom,warehouse,date_created,date_modified) "
                    + "values('" + productid + "','" + productname + "','" + sort + "'," + "'category '" + "," + "'" + price + "'," + "'maxnom'," + "'" + warehouse + "'," + "'" + date + "'," + "'" + date + "'" + ")";

            System.out.println(sql);
            query.execute(sql);
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException----NG");
        }

    }

    public List<ProductList> listIntro() {
        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";
        List<ProductList> list = new ArrayList<ProductList>();
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement query = conn.createStatement();
            ResultSet resultset = query.executeQuery("SELECT * FROM tbl_product");
            while (resultset.next()) {

                ProductList productlist = new ProductList();
                productlist.setProductId(resultset.getString("product_id"));
                productlist.setProductName(resultset.getString("product_name"));
                productlist.setSort(String.valueOf(resultset.getInt("sort")));
                productlist.setCategory(resultset.getString("category"));
                productlist.setPrice(resultset.getString("price"));
                productlist.setMaxnom(resultset.getString("max_nom"));
                productlist.setWarehouse(resultset.getString("warehouse"));
                productlist.setDateCreated(resultset.getString("date_created"));
                productlist.setDate_modified(resultset.getString("date_modified"));

                list.add(productlist);
            }

            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }
        return list;
    }

    public void productUpdate(ProductList cl) {

        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();

            StringBuffer sb = new StringBuffer();
            sb.append("update tbl_product set ");
            sb.append("product_name = '" + cl.getProductName()+ "',");
            sb.append(" sort = " + cl.getSort()+ ",");
            sb.append(" category = '" + cl.getCategory()+ "',");
            sb.append(" price = '" + cl.getPrice()+ "',");
            sb.append(" max_nom = '" + cl.getMaxnom()+ "',");
            sb.append(" warehouse = '" + cl.getWarehouse()+ "'");
            sb.append(" where ");
            sb.append("product_id = '" + cl.getProductId()+ "'");
            sb.append(";");

            System.out.println(sb.toString());
            query.executeUpdate(sb.toString());

        } catch (SQLException e) {
            System.out.println("SQLException");
        }

    }
     public void productDelete(ProductList cl) {

        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();

            StringBuffer sb = new StringBuffer();
            sb.append("delete from tbl_product ");
            sb.append(" where ");
            sb.append("product_id = '" +cl.getProductId()+ "'");
            sb.append(";");
       System.out.println(sb.toString());
            query.execute(sb.toString());

        } catch (SQLException e) {
            System.out.println("SQLException");
        }
    }
}

