/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderprocessing;

/**
 *
 * @author zroehl
 */
public class OrderProcessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OrderProcessor order = new OrderProcessor("Orders.txt", "OrdersProcessed.txt");
        
        order.skip();
    }
    
}
