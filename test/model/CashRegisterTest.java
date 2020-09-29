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
public class CashRegisterTest {
    
    public CashRegisterTest() {
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
     * Test of cashRcontroller method, of class CashRegister.
     */
    @Test
    public void testCashRcontroller() {
        System.out.println("cashRcontroller");
        CashRegister instance = new CashRegister();
        String query="select * from SABABAHMED.menuDB ";
        String url = "jdbc:derby://localhost:1527/LMSdatabase";
        String user = "sababahmed";
        String pass = "jkl123";
        int check = instance.connectioncheker(url, user, pass, query);
        assertEquals(1, check);
    }

    /**
     * Test of orderitem method, of class CashRegister.
     */
    /*
    @Test
    public void testOrderitem() {
        System.out.println("orderitem");
        CashRegister instance = new CashRegister();
        instance.orderitem();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    */
    
}
