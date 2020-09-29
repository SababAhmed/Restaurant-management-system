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
public class employeemanagementTest {
    
    public employeemanagementTest() {
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
     * Test of manageemployee method, of class employeemanagement.
     */
    @Test
    public void testManageemployee() {
        System.out.println("manageemployee");
        employeemanagement instance = new employeemanagement();
        String query="select * from SABABAHMED.EMPLOYEEDATA ";
        String url="jdbc:derby://localhost:1527/LMSdatabase";
        String user="sababahmed";
        String pass="jkl123";
        int check=instance.connectioncheker(url, user, pass, query);
        //assertEquals(1,check);
        //add
        
        
    }
    
    @Test
    public void testaddemployee(){
        System.out.println("addemployee");
        employeemanagement instance = new employeemanagement();
        String url="jdbc:derby://localhost:1527/LMSdatabase";
        String user="sababahmed";
        String pass="jkl123";
        int EID=5;
        String Ename="Hossinna";
        String Eshift="Both";
        int Esalary=25000;
        String addquery = "INSERT INTO SABABAHMED.EMPLOYEEDATA (ID,name, shift, salary) " 
                    + "VALUES ("+EID+", '"+Ename+"', '"+Eshift+"', "+Esalary+")" ;
        int check2=instance.connectioncheker2(url, user, pass, addquery);
        assertEquals(0,check2);
    }

    
    @Test
    public void testDeleteemployee(){
        System.out.println("Deletemployee");
        employeemanagement instance = new employeemanagement();
        String url="jdbc:derby://localhost:1527/LMSdatabase";
        String user="sababahmed";
        String pass="jkl123";
        int EID=6;
        String delquery = "DELETE FROM  SABABAHMED.EMPLOYEEDATA WHERE ID = " + EID ;
        int check2=instance.connectioncheker2(url, user, pass, delquery);
        assertEquals(1,check2);
    }
    
    @Test
    public void testupdateshift(){
        System.out.println("addemployee");
        employeemanagement instance = new employeemanagement();
        String url="jdbc:derby://localhost:1527/LMSdatabase";
        String user="sababahmed";
        String pass="jkl123";
        int EID=5;
        String Eshift="Both";
        String upquery = "update SABABAHMED.EMPLOYEEDATA set SHIFT ="
                    + " '"+Eshift+"' where id = "+EID ;
        int check2=instance.connectioncheker2(url, user, pass, upquery);
        assertEquals(0,check2);
    }
    
    @Test
    public void testupdatesalary(){
        System.out.println("addemployee");
        employeemanagement instance = new employeemanagement();
        String url="jdbc:derby://localhost:1527/LMSdatabase";
        String user="sababahmed";
        String pass="jkl123";
        int EID=4;
        int Esalary=15000;
        String upquery = "update SABABAHMED.EMPLOYEEDATA set SALARY = "+Esalary+
                    " where id = "+EID ;
        int check2=instance.connectioncheker2(url, user, pass, upquery);
        assertEquals(0,check2);
    }
    
    /**
     * Test of connectioncheker method, of class employeemanagement.
     */
    /*
    @Test
    public void testConnectioncheker() {
        System.out.println("connectioncheker");
        String url = "";
        String user = "";
        String pass = "";
        String query = "";
        employeemanagement instance = new employeemanagement();
        int expResult = 0;
        int result = instance.connectioncheker(url, user, pass, query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    
}
