/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
import model.employeemanagement;
import model.stockmanagement;
import model.menumanagement;
import java.util.Scanner;
import java.io.*;
import java.text.*;
import java.sql.*;

public class Manager {

    Scanner mg = new Scanner(System.in);

    public void managercontroller() {
        System.out.println("1.Show stcok \n2.Manage Stock \n3.showsales "
                + "\n4.Manage employee \n5.Show Employee DB \n6.Show Menu"
                + "\n7.Manage menu items \n8.Log out");
        
        int manageComamand = mg.nextInt();

        if (manageComamand == 1) {
            showstock();
        } else if (manageComamand == 2) {
            managestock();
        } else if (manageComamand == 3) {
            showsales();
        } else if (manageComamand == 4) {
            manageemployee();
        } else if (manageComamand == 5) {
            employeeDB();
        } else if (manageComamand == 6) {
            showmenu();
        } else if (manageComamand == 7) {
            managemenuitems();
        } else if (manageComamand == 8) {

        } else {
            System.out.println("command not rec");
        }
    }
//show stock
    public void showstock() {
        
        Connection stconobj=null;
        Statement ststateobj=null;
        ResultSet stresobj=null;
        String query="select * from SABABAHMED.STOCK ";
        String url="jdbc:derby://localhost:1527/LMSdatabase";
        String user="sababahmed";
        String pass="jkl123";
        
        try{
            stconobj = DriverManager.getConnection(url, user, pass);
            ststateobj=stconobj.createStatement();
            stresobj= ststateobj.executeQuery(query);
            
            System.out.println("ID"+"\t     "+"Name"+"\t     "+"Amount(kg)");
            while(stresobj.next() ){
                int id=stresobj.getInt("ID");
                String name=stresobj.getString("NAME");
                Double amount=stresobj.getDouble("AMOUNT");
                System.out.println(id+"\t     "+name+"\t     "+amount);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        managercontroller();
    }
//stock management part
    public void managestock() {
       stockmanagement nstockmanagement=new stockmanagement();
       nstockmanagement.stockmanage();
    }

    public void showsales() {
        
        Connection stconobj=null;
        Statement ststateobj=null;
        ResultSet stresobj=null;
        String query="select * from SABABAHMED.salesdb ";
        String url="jdbc:derby://localhost:1527/LMSdatabase";
        String user="sababahmed";
        String pass="jkl123";
        
        try{
            stconobj = DriverManager.getConnection(url, user, pass);
            ststateobj=stconobj.createStatement();
            stresobj= ststateobj.executeQuery(query);
            
            System.out.println("Date"+"\t     "+"Sales(tk)");
            while(stresobj.next() ){
                Date date = stresobj.getDate("CDate");
                Double sales=stresobj.getDouble("SALES");
                System.out.println(date+"\t     "+sales);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        managercontroller();
    }

    public void manageemployee() {
        employeemanagement nemployeemanagement=new employeemanagement();
        nemployeemanagement.manageemployee();
    }

    public void employeeDB() {
        
        Connection stconobj=null;
        Statement ststateobj=null;
        ResultSet stresobj=null;
        String query="select * from SABABAHMED.EMPLOYEEDATA ";
        String url="jdbc:derby://localhost:1527/LMSdatabase";
        String user="sababahmed";
        String pass="jkl123";
        
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
        
        managercontroller();
    }

    public void showmenu() {
        
        Connection stconobj = null;
        Statement ststateobj = null;
        ResultSet stresobj = null;

        String url = "jdbc:derby://localhost:1527/LMSdatabase";
        String user = "sababahmed";
        String pass = "jkl123";
        String query="select * from SABABAHMED.menuDB ";
        try{
            stconobj = DriverManager.getConnection(url, user, pass);
            ststateobj=stconobj.createStatement();
            stresobj= ststateobj.executeQuery(query);
            
            System.out.println("ID"+"\t     "+"Name"+"\t     "+"Price(tk)");
            while(stresobj.next() ){
                int id=stresobj.getInt("ID");
                String name=stresobj.getString("NAME");
                int price=stresobj.getInt("Price");
                System.out.println(id+"\t     "+name+"\t     "+price);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        managercontroller();
    }

    public void managemenuitems() {
        menumanagement nmenumanagement=new menumanagement();
        nmenumanagement.managemenu();
    }
    
}    
        


