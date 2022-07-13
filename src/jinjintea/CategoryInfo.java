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
public class CategoryInfo {

    public void conn(String categoryid, String categoryname, int sort) {

        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";

        LocalDateTime date = LocalDateTime.now();//取系统时间

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();
            String sql = "insert into tbl_category( category_id,category_name,sort,show_flg,del_flg,date_created,date_modified) "
                    + "values('" + categoryid + "','" + categoryname + "'," + sort + "," + "'" + 0 + "'," + "'0'," + "'" + date + "'," + "'" + date + "'" + ")";

            System.out.println(sql);
            query.execute(sql);
//
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }

    }

    public void CategoryInfoChat() {

        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();
            ResultSet resultset = query.executeQuery("SELECT * FROM tbl_category");
            while (resultset.next()) {
                System.out.println(resultset.getString("category_id") + "\t" + resultset.getString("category_name") + "\t" + resultset.getString("surname") + "\t" + resultset.getString("sort") + "\t" + resultset.getString("show_flg") + "\t" + resultset.getString("del_flg") + "\t" + resultset.getString("date_created") + "\t" + resultset.getString("date_modified"));
            }

            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }
    }

    public List<CategoryListInfo> listInfo() {
        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";
        List<CategoryListInfo> list = new ArrayList<CategoryListInfo>();
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();
            ResultSet resultset = query.executeQuery("SELECT * FROM tbl_category");
            while (resultset.next()) {

                CategoryListInfo categorylistinfo = new CategoryListInfo();
                categorylistinfo.setCategoryId(resultset.getString("category_id"));
                categorylistinfo.setCategoryName(resultset.getString("category_name"));
                categorylistinfo.setSort(String.valueOf(resultset.getInt("sort")));
                categorylistinfo.setShowFlg(resultset.getString("show_flg"));
                categorylistinfo.setDelFlg(resultset.getString("del_flg"));
                categorylistinfo.setDateCreated(resultset.getString("date_created"));
                categorylistinfo.setDate_modified(resultset.getString("date_modified"));

                list.add(categorylistinfo);
            }

            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }
        return list;

    }

    public void categoryUpdate(CategoryListInfo cl) {

        String url = "jdbc:postgresql://localhost:5432/kin";
        String user = "postgres";
        String password = "postgres";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();

            StringBuffer sb = new StringBuffer();
            sb.append("update tbl_category set ");
            sb.append("category_name = '" + cl.getCategoryName() + "',");
            sb.append(" sort = " + cl.getSort() + ",");
            sb.append(" show_flg = '" + cl.getShowFlg() + "'");
            sb.append(" where ");
            sb.append("category_id = '" + cl.getCategoryId() + "'");
            sb.append(";");

            System.out.println(sb.toString());
            query.executeUpdate(sb.toString());

        } catch (SQLException e) {
            System.out.println("SQLException");
        }

    }
}
