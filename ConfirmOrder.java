
package estore;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class ConfirmOrder extends JFrame implements ActionListener{
    public static ConfirmOrder instance;
    private JScrollPane scrollPane;
    private JPanel panel,control,addressP,otherP;
    private JLabel priceL,amountL,addressLab,massageLab;
    private TextArea address;    
    private JButton cancel,confirm;
    private JPanel[] data;
    
    public  ConfirmOrder(JPanel []data,String statics[] ){
        setResizable(false);
        setTitle("Confirm Order");
        setBounds(400,240,550,350);       
        setLayout(null);        
        this.data=data;        
        control= new JPanel();
        addressP= new JPanel(null);
        otherP= new JPanel(null);
        panel= new JPanel(new GridLayout(3,0));
        scrollPane = new JScrollPane(panel);       
        amountL= new JLabel("Total Amount item in cart is "+statics[0]);        
        priceL= new JLabel("Total Amount price of items in cart is "+statics[1]);                        
        addressLab= new JLabel("Shopping Address in : >> ");
        massageLab= new JLabel("TO cancel Order Press here >>");
        address= new TextArea(statics[2]);
        cancel= new JButton("Cancel Checkout", new ImageIcon(this.getClass().getResource("/images/delete.png")));
        confirm= new JButton("Confirm order", new ImageIcon(this.getClass().getResource("/images/ok.png")));   
        confirm.addActionListener(this);
        cancel.addActionListener(this);        
        control.add(massageLab);
        control.add(cancel);  
        otherP.add(confirm);        
        otherP.add(priceL);        
        otherP.add(amountL);
        confirm.setBounds(5,20,150,30);
        amountL.setBounds(170,10,250,25); 
        priceL.setBounds(170,35,250,25);                               
        addressP.add(addressLab);
        addressP.add(address);
        addressLab.setBounds(5,0,160,25);
        address.setBounds(5,30,160,110);         
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);              
        for(int i=0;i<data.length;i++){            
            panel.add(data[i]);            
        }            
        add(control);
        add(scrollPane);
        add(addressP);
        add(otherP);
        control.setBounds(5, 0, 530, 35);        
        addressP.setBounds(5, 40, 170, 150);
        scrollPane.setBounds(185, 40, 350, 150);
        otherP.setBounds(5, 190, 530, 100);        
        this.setVisible(true);
    }    
    public void actionPerformed(ActionEvent e)
    
    {        
        if(e.getSource()==cancel){
            StoreCust.order = new HashMap<>();
            JOptionPane.showMessageDialog(this, "Your order is canceld", "Info", 1);                        
            this.setVisible(false);
        }else if(e.getSource()==confirm){
            Iterator<Map.Entry<Order,Integer>> i =StoreCust.order.entrySet().iterator();
            while(i.hasNext()){
                Map.Entry<Order,Integer> temp = i.next();
                temp.getKey().getProduct().quntity-=temp.getValue();
            }
            StoreCust.order = new HashMap<>();
            JOptionPane.showMessageDialog(this,"Your order is submit sucessfully \n Thank you ( its ok )!!","Information :)", 1);
            this.setVisible(false);
        }                
    }    
}
