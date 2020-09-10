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
public class menumanagement extends Manager{
    
    public void managemenu(){
        
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
        
        System.out.println("1.Add Item \n2.Delete Item"
                + " \n3.Update item \n4.Back ");
        int ecommand=mg.nextInt();
        
        //add new item
        if(ecommand==1){
            System.out.println("Item name :");
            String Mname=mg.next();
            System.out.println("Price :");
            int price=mg.nextInt();
            
            String addquery = "INSERT INTO SABABAHMED.MENUDB (\"NAME\", \"Price\")  " 
                    + "VALUES ('"+Mname+"', "+price+")" ;
            try {
                stconobj = DriverManager.getConnection(url, user, pass);
                ststateobj = stconobj.createStatement();
                ststateobj.executeUpdate(addquery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            managemenuitems();
        }
        
        //delete item
        else if(ecommand==2){
            System.out.println("Item ID :");
            int MID=mg.nextInt();
            String delquery = "DELETE FROM  SABABAHMED.menudb WHERE ID = " + MID ;
            try {
                stconobj = DriverManager.getConnection(url, user, pass);
                ststateobj = stconobj.createStatement();
                ststateobj.executeUpdate(delquery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            managemenuitems();
        }
        else if(ecommand==3){
            System.out.println("Item Id :");
            int IID=mg.nextInt();
            System.out.println("Price :");
            int Iprice=mg.nextInt();
            
            String upquery = "update SABABAHMED.MENUDB set \"Price\" = "+Iprice+" where id = "+IID ;
            try {
                stconobj = DriverManager.getConnection(url, user, pass);
                ststateobj = stconobj.createStatement();
                ststateobj.executeUpdate(upquery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            managemenuitems();
        }
        
        else if(ecommand==4){
            
           managercontroller();
        }
        else{
            System.out.println("Invalid command");
            managemenuitems();
        }
        
    }
    
    
}
