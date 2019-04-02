
package estore;
//import estore.CartCheckout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Order extends JPanel implements ActionListener{        
    JButton removeOrd;
    
    Product product;
    
    int number;
    
    float totalPrice ;
    
    JLabel  productJLOd,
            productL,
            total,totalL,
            quantity,
            quantityL,
            descriptionL;
    
    JTextArea description;    
    
    JPanel info;
    
    //////////////// prouduct class connec
    public Order(Product product){
        this(product,0);
    }
    public Order(Product product,int number){
       super(null);         
        this.setPreferredSize(new Dimension(471,111));                                
        this.product=product;        
        this.number=number;
        getTotalPrice();    
        removeOrd = new JButton("remove");  
            removeOrd.setBounds(10, 40, 80, 20);
        
        productL = new JLabel("Product"); 
            productL.setBounds(10, 5, 80, 30);
        
        quantityL = new JLabel("Quantity"); 
            quantityL.setBounds(10, 35, 80, 30);
        
        descriptionL = new JLabel("Description"); 
         descriptionL.setBounds(10,65,80,30); 
        
        totalL = new JLabel("Total price"); 
         totalL.setBounds(200, 5, 100, 30);  
        
        info = new JPanel(null); 
         info.setBounds(100, 2, 430, 98);
         
        info.setPreferredSize(new Dimension(370,95));        
        productJLOd = new JLabel(product.nameProduct); 
        productJLOd.setBounds(90, 5, 100, 30);   
        quantity = new JLabel(number+""); 
        quantity.setBounds(90, 35, 100, 30); 
        description = new JTextArea(product.desProduct); 
        description.setBounds(90, 65, 280, 30); 
        total = new JLabel(totalPrice+"$"); 
        total.setBounds(300, 5, 70, 30); 
        removeOrd.addActionListener(this);
        this.add(removeOrd);
        this.add(info);
        
        //////////////////////////////ADD to panel  
        info.add(quantityL);
        info.add(descriptionL);
        info.add(description);
        info.add(total);
        info.add(totalL); 
        info.add(productJLOd);
        info.add(productL);
        info.add(quantity);

    }
    
    //////////////////////get total price order 
    public float getTotalPrice()
    {
        this.totalPrice=(float) (number *product.price);
        return totalPrice;         
    }
    ////////////////////// setCount+total
    public void setCount(int number)
    {                
        this.number = number;
        quantity.setText(number+"");                
        total.setText(getTotalPrice()+"$");
    }
    
    
    public void addAddtionCount(int number)
    {                
        this.number += number;
        quantity.setText(number+"");                
        total.setText(getTotalPrice()+"$");
    }        
    
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==removeOrd){            
            this.number=0;
            this.getTotalPrice();
            this.setVisible(false);
            CartCheckout.instance.updateCart();        
        }
    }
    public void buyorderr()
    {
        product.quntity-=number;
    }
    public JPanel getInfo()
    {  
        if(number!=0)
            return info;
        return null;
    }
    public boolean equals(Object o)
    {
        try{
        return this.product.equals(((Order)o).product);}catch(Exception e)
        {
        }
        return false;
    }
    public int getNumber(){
        return number;
    }
    public Product getProduct()
    {
        return product;
    }
    
    public int hashCode(){
        return product.hashCode();
    }
}
    /////////// END CLASS Order 