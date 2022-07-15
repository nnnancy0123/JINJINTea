/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import jinjintea.ProductIntro;
import org.junit.Test;

/**
 *
 * @author user
 */
public class ProductIntroTest {
    
    
    @Test
    public void test001(){
        
        ProductIntro productIntro = new ProductIntro();
        
        String productid = "8001";
        String productname = "523";
        String category = "555";
        String price = "999";
        String maxnom = "00";
        String warehouse = "522";
        
        productIntro.createProductInfo(productid, productname, 0, category, price, maxnom, warehouse);
        
    }
    
}
