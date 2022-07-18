/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jin.tea.service;

import jin.tea.object.CategoryObj;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jin.tea.object.ProductObj;

/**
 *
 * @author user
 */
public class ProductService {

    public void createProductInfo(String productid, String productname, int sort, String category, int price, int maxnum, int warehouse) {

        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";
        LocalDateTime date = LocalDateTime.now();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();
            String sql = "insert into tbl_product( product_id,product_name,sort,category_id,price,max_num,warehouse,date_created,date_modified) "
                    + "values('" + productid + "','" + productname + "','" + sort + "'," + "'" + category + "'" + ",'" + price + "','" + maxnum + "','" + warehouse + "'," + "'" + date + "'," + "'" + date + "'" + ")";

            System.out.println(sql);
            query.execute(sql);
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException----NG");
        }

    }

    public List<ProductObj> listIntro() {
        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";
        List<ProductObj> list = new ArrayList<ProductObj>();
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement query = conn.createStatement();
            ResultSet resultset = query.executeQuery("select p.*,c.category_name from tbl_product p\n"
                    + "left join tbl_category c\n"
                    + "on p.category_id = c.category_id order by sort asc");
            while (resultset.next()) {

                ProductObj productlist = new ProductObj();
                productlist.setProductId(resultset.getString("product_id"));
                productlist.setProductName(resultset.getString("product_name"));
                productlist.setSort(String.valueOf(resultset.getInt("sort")));
                productlist.setCategory(resultset.getString("category_name"));
                productlist.setPrice(String.valueOf(resultset.getInt("price")));
                productlist.setMaxnum(String.valueOf(resultset.getInt("max_num")));
                productlist.setWarehouse(String.valueOf(resultset.getInt("warehouse")));
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

    public void productUpdate(ProductObj cl) {

        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();

            StringBuffer sb = new StringBuffer();
            sb.append("update tbl_product set ");
            sb.append("product_name = '" + cl.getProductName() + "',");
            sb.append(" sort = " + cl.getSort() + ",");
            sb.append(" category = '" + cl.getCategory() + "',");
            sb.append(" price = '" + cl.getPrice() + "',");
            sb.append(" max_nom = '" + cl.getMaxnum() + "',");
            sb.append(" warehouse = '" + cl.getWarehouse() + "'");
            sb.append(" where ");
            sb.append("product_id = '" + cl.getProductId() + "'");
            sb.append(";");

            System.out.println(sb.toString());
            query.executeUpdate(sb.toString());

        } catch (SQLException e) {
            System.out.println("SQLException");
        }

    }

    public void productDelete(ProductObj cl) {

        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();

            StringBuffer sb = new StringBuffer();
            sb.append("delete from tbl_product ");
            sb.append(" where ");
            sb.append("product_id = '" + cl.getProductId() + "'");
            sb.append(";");
            System.out.println(sb.toString());
            query.execute(sb.toString());

        } catch (SQLException e) {
            System.out.println("SQLException");
        }
    }

    public List<CategoryObj> getCategoryName() {
        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";
        List<CategoryObj> list = new ArrayList<CategoryObj>();
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement query = conn.createStatement();
            ResultSet resultset = query.executeQuery("SELECT * FROM tbl_category");
            while (resultset.next()) {

                CategoryObj categoryObj = new CategoryObj();
                categoryObj.setCategoryId(resultset.getString("category_id"));
                categoryObj.setCategoryName(resultset.getString("category_name"));

                list.add(categoryObj);
            }

            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }
        return list;
    }

}
