
package estore;

import javax.swing.*;
import java.util.*;


public class Customer   {
    // customer properties 
    public int idCustomer;
    public String nameCustomer,userCustomer,passCustomer,addressCustomer;                        
    public Customer(int id,String name,String user,String pass,String address)
    {
        this.nameCustomer=name;
        this.userCustomer=user; 
        this.passCustomer=pass;
        this.addressCustomer=address;                 
        this.idCustomer=id;
    }
   
    
    public int getId()
    {
        return idCustomer;
    }
    
    /* public int hashCode()
     {
        return idCustomer;
     }*/
      public String toString()
      {
        return nameCustomer;
      }
      ///////////////////////////////////////////
    public boolean equals(Object o)
    {       
        return userCustomer.equals(((Customer)o).userCustomer);
    }               
   
    /////////////////////////////////// NOtification to told customer about quntity 
    public void updateNotf(JFrame frame,String massage)
    {
        JOptionPane.showMessageDialog(frame, "Customer "+nameCustomer+" has orderd from "+massage+" items, and its avilable now", "NOtification",1);
    }
               
   
}

/////////////////end of class Customers