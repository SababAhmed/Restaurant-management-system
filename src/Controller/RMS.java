/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author ASUS
 */
import model.CashRegister;
import java.util.*;
import java.io.*;
import java.text.*;
import model.Manager;


public class RMS {

    /**
     * @param args the command line arguments
     */
    //protected static String CID= "CR";
    protected static String Cpass= "112233";
    
    //protected static String Manager="Manager";
    protected static String Password="123654";
    static int status;
    
    public static void main(String[] args) {
        
        
        
        status=0;
        Scanner sc=new Scanner(System.in);
        
        String pass ="";
        
        while(status == 0){
            System.out.println("Enter 1 to login \nEnter 2 to log Off");
            int x=sc.nextInt();
            if(x==1){
                //System.out.println("Enter ID");
                //ID=sc.nextLine();
                System.out.println("Enter Password");
                pass=sc.next();
                
                if(pass.equals(Cpass)){
                    
                    CashRegister nCashRegister=new CashRegister();
                    nCashRegister.cashRcontroller();
                    
                }
                else if(pass.equals(Password)){
                    Manager nManager=new Manager();
                    nManager.managercontroller();
                    
                }
                else{
                    System.out.println("Wrong Password ");
                }
            }else if(x==2){
            turnoff();
        }else{
                System.out.println("Wrong command");
            }
            
        }
        
        
        
 }
    
    public static void turnoff(){
            status=1;
        }
}
