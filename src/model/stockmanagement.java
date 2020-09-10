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
public class stockmanagement extends Manager {

    public void stockmanage() {
        //showstock();

        //stablishing coonection
        Connection stconobj = null;
        Statement ststateobj = null;
        ResultSet stresobj = null;

        String url = "jdbc:derby://localhost:1527/LMSdatabase";
        String user = "sababahmed";
        String pass = "jkl123";
        String query="select * from SABABAHMED.STOCK ";
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

        System.out.println("1.Add new stock \n2.Delete Stock "
                + "\n3.Update stock \n4.back");
        int stockcommand = mg.nextInt();

        //Add stock
        if (stockcommand == 1) {
            System.out.println("Stock ID :");
            int SID = mg.nextInt();
            System.out.println("Stock Name :");
            String name = mg.next();
            System.out.println("Stock Amount :");
            double Sam = mg.nextDouble();
            
            String addquery = "INSERT INTO SABABAHMED.STOCK (ID, NAME, AMOUNT) " 
                    + "VALUES ("+SID+", '"+name+"', "+Sam+")" ;
            try {
                stconobj = DriverManager.getConnection(url, user, pass);
                ststateobj = stconobj.createStatement();
                ststateobj.executeUpdate(addquery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            managestock();

        } //Remove stock
        else if (stockcommand == 2) {
            System.out.println("Stock ID :");
            int SID = mg.nextInt();
            
            String delquery = "DELETE FROM  SABABAHMED.STOCK WHERE ID = " + SID ;
            try {
                stconobj = DriverManager.getConnection(url, user, pass);
                ststateobj = stconobj.createStatement();
                ststateobj.executeUpdate(delquery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            managestock();
        } //Add new Stock
        else if (stockcommand == 3) {
            System.out.println("Stock ID :");
            String SID = mg.next();
            System.out.println("Stock Amount :");
            double Sam = mg.nextDouble();
            String upquery = "update SABABAHMED.STOCK set AMOUNT = "+Sam+
                    " where id = "+SID ;
            try {
                stconobj = DriverManager.getConnection(url, user, pass);
                ststateobj = stconobj.createStatement();
                ststateobj.executeUpdate(upquery);
                System.out.println("ok");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            managestock();
        } else if (stockcommand == 4) {
            managercontroller();
        } else {
            System.out.println("Invalid command");
            managestock();
        }

    }

}
