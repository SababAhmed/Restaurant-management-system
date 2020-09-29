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
public class ManagerTest {
    
    public ManagerTest() {
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
     * Test of managercontroller method, of class Manager.
     */
    /*
    @Test
    public void testManagercontroller() {
        System.out.println("managercontroller");
        Manager instance = new Manager();
        instance.managercontroller();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showstock method, of class Manager.
     */
    @Test
    public void testShowstock() {
        System.out.println("showstock");
        Manager instance = new Manager();
        String query="select * from SABABAHMED.STOCK ";
        String url="jdbc:derby://localhost:1527/LMSdatabase";
        String user="sababahmed";
        String pass="jkl123";
        int check=instance.connectioncheker(url, user, pass, query);
        
        assertEquals(1,check);
    }

    /**
     * Test of managestock method, of class Manager.
     */
    /*    
    @Test
    public void testManagestock() {
        System.out.println("managestock");
        Manager instance = new Manager();
        instance.managestock();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showsales method, of class Manager.
     */
    
    @Test
    public void testShowsales() {
        System.out.println("showsales");
        Manager instance = new Manager();
        String query="select * from SABABAHMED.salesdb ";
        String url="jdbc:derby://localhost:1527/LMSdatabase";
        String user="sababahmed";
        String pass="jkl123";
        int check=instance.connectioncheker(url, user, pass, query);
        
        assertEquals(1,check);
    }

    /**
     * Test of manageemployee method, of class Manager.
     */
    /*
    @Test
    public void testManageemployee() {
        System.out.println("manageemployee");
        Manager instance = new Manager();
        instance.manageemployee();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of employeeDB method, of class Manager.
     */
    
    @Test
    public void testEmployeeDB() {
        System.out.println("employeeDB");
        Manager instance = new Manager();
        String query="select * from SABABAHMED.salesdb ";
        String url="jdbc:derby://localhost:1527/LMSdatabase";
        String user="sababahmed";
        String pass="jkl123";
        int check=instance.connectioncheker(url, user, pass, query);
        
        assertEquals(1,check);
    }

    /**
     * Test of showmenu method, of class Manager.
     */
    
    @Test
    public void testShowmenu() {
        System.out.println("showmenu");
        Manager instance = new Manager();
        String query="select * from SABABAHMED.salesdb ";
        String url="jdbc:derby://localhost:1527/LMSdatabase";
        String user="sababahmed";
        String pass="jkl123";
        int check=instance.connectioncheker(url, user, pass, query);
        
        assertEquals(1,check);
    }

    /**
     * Test of managemenuitems method, of class Manager.
     */
    /*
    @Test
    public void testManagemenuitems() {
        System.out.println("managemenuitems");
        Manager instance = new Manager();
        instance.managemenuitems();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of connectioncheker method, of class Manager.
     */
    /*
    @Test
    public void testConnectioncheker() {
        System.out.println("connectioncheker");
        String url = "";
        String user = "";
        String pass = "";
        String query = "";
        Manager instance = new Manager();
        int expResult = 0;
        int result = instance.connectioncheker(url, user, pass, query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    
}
