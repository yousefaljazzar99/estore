
package estore;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class NewProduct extends JFrame implements ActionListener{
    private JTextField nameP,price,quantity;
    private TextArea descriptionP;
    private JComboBox department;
    private JLabel namePL ,descriptionPL,pricePL,quantityPL,departmentPL;
    
    private JButton add,cancel;    
    public NewProduct (){
        super("Add new Product");        
        setBounds(400,100,400,400);
        /////////GUI creation //////////////////////       
        nameP = new JTextField();
        price = new JTextField();
        quantity = new JTextField();
        descriptionP = new TextArea();        
        department = new JComboBox();
        department.setModel(new DefaultComboBoxModel(Main.data.keySet().toArray(new Department[]{})));
        namePL = new JLabel("Product Name");
         namePL.setFont(new Font("Tahoma", Font.BOLD, 15));
         
        descriptionPL = new JLabel("Description");
        descriptionPL.setFont(new Font("Tahoma", Font.BOLD, 15));
        pricePL = new JLabel("Price ($)");
        pricePL.setFont(new Font("Tahoma", Font.BOLD, 15));
        quantityPL = new JLabel("Quantity");
       quantityPL.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        departmentPL = new JLabel("Department");
            departmentPL.setFont(new Font("Tahoma", Font.BOLD, 15));
        add = new JButton("Add new Product", new ImageIcon(this.getClass().getResource("/images/add-product.png")));
           add.setFont(new Font("Tahoma", Font.BOLD, 15));
             add.setForeground(Color.red);
             add.setBackground(Color.DARK_GRAY);
        
        
                cancel = new JButton("Cancel", new ImageIcon(this.getClass().getResource("/images/delete.png")));
             cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
             cancel.setForeground(Color.red);
             cancel.setBackground(Color.DARK_GRAY);
        
        
        namePL.setBounds(20,20,120,25);         
        nameP.setBounds(140, 20, 120, 25);
        pricePL.setBounds(20,60,120,25);       
        price.setBounds(140, 60, 120, 25);
        quantityPL.setBounds(20,100,120,25);    
        quantity.setBounds(140, 100, 120, 25);
        departmentPL.setBounds(20,140,120,25);  
        department.setBounds(140, 140, 120, 25);
        descriptionPL.setBounds(20,180,120,25); 
        descriptionP.setBounds(140, 180, 200, 80);                
        add.setBounds(20, 285, 200,25);
        cancel.setBounds(240, 285, 130,25);
        ////////////////////////////////////////////////////////////////
        add.addActionListener(this);
        cancel.addActionListener(this);
        ////////////////////////////////////////////////////////////
        this.setLayout(null);        
        this.add(namePL);
        this.add(pricePL);
        this.add(quantityPL);
        this.add(descriptionPL);
        this.add(departmentPL);
        this.add(nameP);
        this.add(price);
        this.add(quantity);
        this.add(department);
        this.add(descriptionP); 
        add(cancel);
        add(add);        
        /////////////////////////////////////////////////////////////////////////
       
                
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            addProduct();
        }else if(e.getSource()==cancel){
            this.setVisible(false);
        }
    }
    public void addProduct(){
        if(Main.data.size()==0){
            JOptionPane.showMessageDialog(this, "Please Enter Department at first","Error",0);
        }else if(!isAcceptedValues()){
            JOptionPane.showMessageDialog(this, "Error Input","Error",0);
        }else {
            String n=nameP.getText();
            double p=Double.parseDouble(price.getText());
            int q=Integer.parseInt(quantity.getText());
            String des=descriptionP.getText();
            Department dep = Main.mainFrame.findDepartment(department.getSelectedItem()+"");;           
            ArrayList<Product> temp = Main.data.get(dep);                                    
            Product newPro = new Product(n,p,q,dep,des);                        
            if(temp.contains(newPro)){
                JOptionPane.showMessageDialog(this, "the product is avilable in this department","Error",0);
            }else{
                temp.add(newPro); 
                Main.managerF.clearData();
                JOptionPane.showMessageDialog(this, "add complete succefully ","Info",1);                                           
                nameP.setText("");
                price.setText("");
                quantity.setText("");
                descriptionP.setText("");
                this.setVisible(false);
            }            
        }
    }    
    public boolean isAcceptedValues(){       
        try{
            Double.parseDouble(price.getText());            
        }catch(Exception e){
            return false;            
        }        
        return nameP.getText().matches("\\w[\\d\\s\\w]*")&&quantity.getText().matches("[\\d]+");
    }    
}
