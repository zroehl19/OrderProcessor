/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderprocessing;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zroehl
 */
public class OrderProcessor {
    
    BufferedReader input;
    PrintWriter output;
    String line;
    String[] orders;
    double price;
    int quan;
    double taxes;
    double shipping;
    double total;
    
    private final double tax = 0.02;
    private final double ship = 0.05;
    
    public OrderProcessor(String fileIn, String fileOut)
    {
        try
        {
            input = new BufferedReader(new FileReader(new File(fileIn)));
            output = new PrintWriter(new BufferedWriter(new FileWriter(fileOut, true)));
        }
        catch(IOException e)
        {
            System.out.println("Cannot open file.");
        }
        
    }
    
    public void skip()
    {
        System.out.println("Start processing orders.");
        try
        {
            input.readLine();
            read();
        }
        catch(IOException e)
        {
        }
    }
    
    public void read()
    {
        try{
            for(int i = 0; i < 7; i++)
            {
                line = input.readLine();
                process();
            }
        }
        catch(IOException e)
        {
            System.out.println("Cannot read line.");
        }
        finally
        {
            try{
                if(input != null)
                {
                    input.close();
                }
            }
            catch(IOException e)
            {
                System.out.println("Cannot close reader.");
            }
            
            System.out.println("Finished processing orders.");
        }
            
    }
    
    public void process()
    {
        orders = line.split("|");
        
        try{
            price = Double.parseDouble(orders[2]);
            quan = Integer.parseInt(orders[3]);
        }
        catch(Exception e)
        {       
        }
        
        double preTax = price*quan;
        
        taxes = preTax * tax;
        shipping = preTax * ship;
        
        total = taxes + shipping;
        
        write();
    }
    
    public void write()
    {
        try
        {
            output.println("Order_ID: " + orders[0] + "\n" + "Part_Num: " + orders[1] + "\n" + 
                    "Price: " + orders[2] + "\n" + "Quantity: " + orders[3] + "\n" + "Tax: " + taxes + "\n" +
                    "Shipping: " + shipping + "\n" + "Total: " + total);
            
            read();
            
        }
        catch(Exception e)
        {
            System.out.println("Cannot write line.");
        }
        finally
        {
            if(output != null)
            {
                output.close();
            }
        }
        
    }
}
