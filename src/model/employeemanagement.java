/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class employeemanagement extends Manager{
    
    public void manageemployee(){
        
        Connection stconobj = null;
        Statement ststateobj = null;
        ResultSet stresobj = null;

        String url = "jdbc:derby://localhost:1527/LMSdatabase";
        String user = "sababahmed";
        String pass = "jkl123";
        String query="select * from SABABAHMED.EMPLOYEEDATA ";
        try{
            stconobj = DriverManager.getConnection(url, user, pass);
            ststateobj=stconobj.createStatement();
            stresobj= ststateobj.executeQuery(query);
            
            System.out.println("ID"+"\t     "+"Name"+"\t     "+"Shift"+"\t     "+"Salary(tk)");
            while(stresobj.next() ){
                int id=stresobj.getInt("ID");
                String name=stresobj.getString("NAME");
                String shift=stresobj.getString("SHIFT");
                Double salary=stresobj.getDouble("SALARY");
                System.out.println(id+"\t     "+name+"\t     "+shift+"\t     "+salary);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        System.out.println("1.Add Employee \n2.Delete Employee\n3.Update Salary "
                + "\n4.Update Shift \n5.close");
        int ecommand=mg.nextInt();
        
        //add employee
        if(ecommand==1){
            System.out.println("Empolyee ID :");
            int EID=mg.nextInt();
            System.out.println("Employee name :");
            String Ename=mg.next();
            System.out.println("Shiift :");
            String Eshift=mg.next();
            System.out.println("Employee Salary :");
            int Esalary=mg.nextInt();
            
            String addquery = "INSERT INTO SABABAHMED.EMPLOYEEDATA (ID,name, shift, salary) " 
                    + "VALUES ("+EID+", '"+Ename+"', '"+Eshift+"', "+Esalary+")" ;
            try {
                stconobj = DriverManager.getConnection(url, user, pass);
                ststateobj = stconobj.createStatement();
                ststateobj.executeUpdate(addquery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            manageemployee();
        }
        //delete employee
        else if(ecommand==2){
            System.out.println("Employee ID :");
            int EID=mg.nextInt();
            
            String delquery = "DELETE FROM  SABABAHMED.EMPLOYEEDATA WHERE ID = " + EID ;
            try {
                stconobj = DriverManager.getConnection(url, user, pass);
                ststateobj = stconobj.createStatement();
                ststateobj.executeUpdate(delquery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            manageemployee();
        }
        //update salary
        else if(ecommand==3){
            System.out.println("Employee ID :");
            int EID=mg.nextInt();
            System.out.println("New Salary :");
            int Esalary=mg.nextInt();
            String upquery = "update SABABAHMED.EMPLOYEEDATA set SALARY = "+Esalary+
                    " where id = "+EID ;
            try {
                stconobj = DriverManager.getConnection(url, user, pass);
                ststateobj = stconobj.createStatement();
                ststateobj.executeUpdate(upquery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            manageemployee();
        }
        //update shift
        else if(ecommand==4){
            System.out.println("Employee ID :");
            int EID=mg.nextInt();
            System.out.println("New Shiift :");
            String Eshift=mg.next();
            String upquery = "update SABABAHMED.EMPLOYEEDATA set SHIFT ="
                    + " '"+Eshift+"' where id = "+EID ;
            try {
                stconobj = DriverManager.getConnection(url, user, pass);
                ststateobj = stconobj.createStatement();
                ststateobj.executeUpdate(upquery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            manageemployee();
        }
        else if(ecommand==5){
           managercontroller();
        }
        else{
            System.out.println("Invalid command");
            manageemployee();
        }
        
        
    }
    
    public int connectioncheker(String url ,String user ,String pass ,String query){
        
        Connection stconobj = null;
        Statement ststateobj = null;
        ResultSet stresobj = null;
        
        try{
            stconobj = DriverManager.getConnection(url, user, pass);
            ststateobj=stconobj.createStatement();
            stresobj= ststateobj.executeQuery(query);
            return 1;
            
        }catch(SQLException e){
            return 0;
        }/*
        if(stresobj!=null){
            
        }else{
            
        }*/
                    
    }
    
    public int connectioncheker2(String url ,String user ,String pass ,String query){
        
        Connection stconobj = null;
        Statement ststateobj = null;
        ResultSet stresobj = null;
        
        try{
            stconobj = DriverManager.getConnection(url, user, pass);
            ststateobj=stconobj.createStatement();
            ststateobj.executeQuery(query);
            return 1;
            
        }catch(SQLException e){
            return 0;
        }
                    
    }
    
}
