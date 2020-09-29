/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class stockmanagementTest {
    
    public stockmanagementTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of stockmanage method, of class stockmanagement.
     */
    @Test
    public void testStockmanage() {
        System.out.println("stockmanage");
        stockmanagement instance = new stockmanagement();
        String query = "select * from SABABAHMED.STOCK ";
        String url = "jdbc:derby://localhost:1527/LMSdatabase";
        String user = "sababahmed";
        String pass = "jkl123";
        int check = instance.connectioncheker(url, user, pass, query);
        assertEquals(1, check);
    }
    
}
