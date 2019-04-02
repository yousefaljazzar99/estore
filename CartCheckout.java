package estore;



import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class CartCheckout extends JFrame implements ActionListener{
    public static CartCheckout instance;
    private JScrollPane scrollPane;
    private JPanel panel,control;
    private JLabel totalpriceL,priceL;
    private double price;
    private JButton b;
    private Order[] data;
    private Customer c;
    public CartCheckout (Order[] data,Customer c){        
        setResizable(false);
        setTitle("Order Window");
        setBounds(400,240,500,450);       //380,160,550,280
        this.data=data;
        this.c=c;
        control= new JPanel(null);
        panel= new JPanel(new GridLayout(3,0));
        b= new JButton("Proceed To Checkout", new ImageIcon(this.getClass().getResource("/images/Checkout.png")));
        b.addActionListener(this);
        priceL= new JLabel("Total Amount price of items in cart is ");
        totalpriceL= new JLabel();   
        totalpriceL.setBackground(Color.BLACK);
        totalpriceL.setForeground(Color.WHITE);
        totalpriceL.setOpaque(true);
        scrollPane = new JScrollPane(panel);
        control.add(b);control.add(priceL);control.add(totalpriceL);              
        control.setPreferredSize(new Dimension(500,35));
        b.setBounds(20, 5, 190, 25);
        priceL.setBounds(220, 5, 220, 25);
        totalpriceL.setBounds(430, 5, 60, 25);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        price=0;
        for(int i=0;i<data.length;i++){
            price += data[i].getTotalPrice();           
            panel.add(data[i]);            
        }   
        totalpriceL.setText(price+"$");
        add(control,"North");
        add(scrollPane);
        this.setVisible(true);
    }
    public void updateCart(){
        this.price=0;
        for(int i=0;i<data.length;i++){
            this.price += data[i].getTotalPrice();                        
        }        
        this.totalpriceL.setText(this.price+"$");
    }       
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b){
           // if(JOptionPane.showConfirmDialog(this, "Do you Want to confirm order an show Summary?","Confirm",JOptionPane.YES_NO_OPTION)==0){
                ArrayList<JPanel> temp = new ArrayList<>();           
                int num=0;
                for(int i=0;i<data.length;i++){
                    JPanel order = data[i].getInfo();
                    if(order != null){
                        temp.add(order);
                        num+=data[i].getNumber();
                    }
                }
                this.setVisible(false);
                ConfirmOrder.instance = new ConfirmOrder(temp.toArray(new JPanel[]{}),new String[]{num+"",price+"",c.addressCustomer});
            }
        }
    }      
//}
