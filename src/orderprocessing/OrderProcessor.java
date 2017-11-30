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
    
    public void read()
    {
        try{
            for(int i = 0; i < 7; i++)
            {
                line = input.readLine();
                process(line);
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
        }
            
    }
    
    public void process(String lineP)
    {
        orders = lineP.split("|");
        
        try{
        price = Double.parseDouble(orders[2]);
        quan = Integer.parseInt(orders[3]);
        }
        catch(Exception e)
        {       
        }
        
        double preTax = price*quan;
        
        
    }
    
    public void write()
    {
        try
        {
            
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
