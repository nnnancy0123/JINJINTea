/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import jin.tea.service.ProductService;
import org.junit.Test;

/**
 *
 * @author user
 */
public class ProductIntroTest {
    
    
    @Test
    public void test001(){
        
        ProductService productIntro = new ProductService();
        
        String productid = "8001";
        String productname = "523";
        String category = "555";
        int price = 999;
        int maxnum = 00;
        int warehouse = 522;
        
        productIntro.createProductInfo(productid, productname, 0, category, price, maxnum, warehouse);
        
    }
    
}
