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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author ASUS
 */
public class CashRegister {
    
    Scanner cr = new Scanner(System.in);
    int price;
    
    public void cashRcontroller() {
        
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
            
            System.out.println("ID"+"\t     "+"Name"+"\t     "+"Priice(tk)");
            while(stresobj.next() ){
                int id=stresobj.getInt("ID");
                String name=stresobj.getString("NAME");
                int price=stresobj.getInt("price");
                System.out.println(id+"\t     "+name+"\t     "+price);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        System.out.println("1.OrderItem \n2.Log out");
        
        int manageComamand = cr.nextInt();
        
        if (manageComamand == 1) {
            orderitem();
        } 
        else if (manageComamand == 2) {

        } else {
            System.out.println("command not rec");
        }
    }
    
    public void orderitem(){
        
        System.out.println("Item ID");
        int IID=cr.nextInt();
        System.out.println("Item Amount");
        int Amount=cr.nextInt();
        
        Connection stconobj = null;
        Statement ststateobj = null;
        ResultSet stresobj = null;

        String url = "jdbc:derby://localhost:1527/LMSdatabase";
        String user = "sababahmed";
        String pass = "jkl123";
        String squery="select * from SABABAHMED.menuDB WHERE ID = " + IID ;
        try{
            stconobj = DriverManager.getConnection(url, user, pass);
            ststateobj=stconobj.createStatement();
            stresobj= ststateobj.executeQuery(squery);
            while(stresobj.next() ){
                int mprice=stresobj.getInt("price");
                price=price+mprice*Amount;
                System.out.println("Total price :"+price);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        System.out.println("1.Order more Item \n2.Finish");
        
        int manageComamand = cr.nextInt();
        
        if (manageComamand == 1) {
            orderitem();
        } 
        else if (manageComamand == 2) {
            
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String strDate1 = dtf.format(now);
            
            //String addquery = "INSERT INTO SABABAHMED.SALESDB (SALES) \n" +
            //"VALUES ("+ price+")" ;
        java.sql.Date ourJavaDateObject = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String addquery="INSERT INTO SABABAHMED.SALESDB "
                + "(Cdate ,SALES)VALUES (CURRENT_TIMESTAMP, "+price+")";
            try {
                stconobj = DriverManager.getConnection(url, user, pass);
                ststateobj = stconobj.createStatement();
                ststateobj.executeUpdate(addquery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            price=0;
            cashRcontroller();
        } else {
            System.out.println("command not rec");
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
            
            
        }catch(SQLException e){
            
        }
        if(stresobj!=null){
            return 1;
        }else{
            return 0;
        }
                    
    }
    
}
