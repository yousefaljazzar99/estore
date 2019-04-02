
package estore;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class ManagerGui extends JFrame implements ActionListener,MouseListener{
     JTabbedPane tappedPane;
            JLabel customersLab,
                     departmentsLab,
                          productsLab;
            JPanel deparMang,
                        proMang,
                            cusMang;
                 JList customers,
                        departments,
                                products;
   
    ///////////////////////////////////////////////  dep 
    Department currentDepartment;
    
     JTextField namefD;
     
     TextArea descriptionar;
     
     JLabel nameDL ,descriptionDL;   
     
     JButton newDep,updateDep;
     
    //////////////////////////////////////////////  product 
     Product currentProduct;        
     
     JTextField nameP,price,quantity;
     
     TextArea descriptionP;
     
     JComboBox departmentP;
     
     JLabel namePL ,descriptionPL,pricePL,quantityPL,departmentPL;
     
     JButton newPro,updatePro;
    ///////////////////////////////////////////////////////  customer 
     Customer currentCustomer;        
     
     JTextField customerID,customerName,customeraddress,customeruser,customerpass;
       
     
     JLabel idLabel,nameLabel,addressLabel,userLabel,passLabel;
     
     JButton newCustomer,insertCustomer,updateCustomer;
           
    public ManagerGui (){
        super("Manager Window");        
        setBounds(400,100,600,400);
        /////////GUI Manager////////////////////
        tappedPane = new JTabbedPane();
        deparMang = new JPanel(null);
        proMang = new JPanel(null);
        cusMang = new JPanel(null);
        ////////////////////DepartmentInfo////////////////////////
        namefD = new JTextField();
        namefD.setBounds(340, 20, 200, 25);
        
        descriptionar = new TextArea();
        descriptionar.setBounds(340, 60, 200, 170);
        
        nameDL = new JLabel("Name");
        nameDL.setFont(new Font("Tahoma", Font.BOLD, 15));
            nameDL.setBounds(220,20,120,25);
        
        descriptionDL = new JLabel("Description");     
        descriptionDL.setFont(new Font("Tahoma", Font.BOLD, 15));
           descriptionDL.setBounds(220,60,120,25); 
        
        
        departments = new JList(Main.data.keySet().toArray(new Department[]{}));
                departments.setBounds(20, 50, 170,180);

        departmentsLab = new JLabel("Department List");
        departmentsLab.setFont(new Font("Tahoma", Font.BOLD, 18));
        departmentsLab.setBounds(20, 20, 170,25);
              
        newDep = new JButton("Add New Department", new ImageIcon(this.getClass().getResource("/images/insert.png")));
        newDep.setFont(new Font("Tahoma", Font.BOLD, 15));
         newDep.setBounds(20, 240, 220,30);
          newDep.setForeground(Color.red);
         newDep.setBackground(Color.DARK_GRAY);
         
            updateDep = new JButton("Update Department", new ImageIcon(this.getClass().getResource("/images/update.png")));
            updateDep.setFont(new Font("Tahoma", Font.BOLD, 15));
           updateDep.setBounds(300, 240, 220,30);
            updateDep.setForeground(Color.red);
         updateDep.setBackground(Color.DARK_GRAY);
       
        /////////////////////////////////////productInfo  /////////////////////////      
        nameP = new JTextField();
          nameP.setBounds(340, 20, 200, 30);
        price = new JTextField();
         price.setBounds(340, 60, 200, 30);
        quantity = new JTextField();
         quantity.setBounds(340, 100, 200, 30);
        
        descriptionP = new TextArea();  
       descriptionP.setBounds(340, 180,200, 80); 
       
        departmentP = new JComboBox();    
         departmentP.setBounds(340, 140, 100, 30);
         
        departmentP.setModel(new DefaultComboBoxModel(Main.data.keySet().toArray(new Department[]{})));
        ArrayList<Product> tempData = new ArrayList<>();
        for(ArrayList<Product> x:Main.data.values())
        {           
            for(int i=0;i<x.size();i++)
                tempData.addAll(x);                      
        }               
        products = new JList(tempData.toArray(new Product[]{}));
         products.setBounds(20, 50, 170,180); 
         
            productsLab = new JLabel("Product List");
            productsLab.setBounds(20, 20, 170,30);
            productsLab.setFont(new Font("Tahoma", Font.BOLD, 18));
            
        namePL = new JLabel("Product Name");
        namePL.setFont(new Font("Tahoma", Font.BOLD, 15));
           namePL.setBounds(220,20,120,30); 
           
        descriptionPL = new JLabel("Description");
        descriptionPL.setFont(new Font("Tahoma", Font.BOLD, 15));
           descriptionPL.setBounds(220,180,120,30);
           
        pricePL = new JLabel("Price ($)");
        pricePL.setFont(new Font("Tahoma", Font.BOLD, 15));
           pricePL.setBounds(220,60,120,30);
           
        quantityPL = new JLabel("Quantity");
        quantityPL.setFont(new Font("Tahoma", Font.BOLD, 15));
         quantityPL.setBounds(220,100,120,30);
         
        departmentPL = new JLabel("Department"); 
        departmentPL.setBounds(220,140,120,30);
        departmentPL.setFont(new Font("Tahoma", Font.BOLD, 15));
        
       
         newPro = new JButton("New Product", new ImageIcon(this.getClass().getResource("/images/insert.png")));
         newPro.setBounds(20, 270, 220,30);
         newPro.setFont(new Font("Tahoma", Font.BOLD, 15));
         newPro.setForeground(Color.red);
         newPro.setBackground(Color.DARK_GRAY);
         
        updatePro = new JButton("Update", new ImageIcon(this.getClass().getResource("/images/update.png")));
        updatePro.setFont(new Font("Tahoma", Font.BOLD, 15));
        updatePro.setBounds(300, 270, 220,30);
        updatePro.setForeground(Color.red);
        updatePro.setBackground(Color.DARK_GRAY);

        ///////////////////////////////////////Customer info///////////////////////////////
        customerID = new JTextField();
        customerID.setBounds(350, 20, 150,30);
        customerName = new JTextField();
         customerName.setBounds(350, 60, 150,30);
        customeraddress = new JTextField();
         customeraddress.setBounds(350, 100,150,30);
        customeruser = new JTextField();
        customeruser.setBounds(350, 140,150,30);
        customerpass = new JTextField();
        customerpass.setBounds(350, 180, 150,30);
        customers = new JList();  
           customers.setBounds(20, 50, 170,180); 
           
        idLabel = new JLabel("Customer ID");
         idLabel.setBounds(220, 20,140,30);    
        idLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        
        nameLabel = new JLabel("Customer Name");
                nameLabel.setBounds(220, 60, 140,30);   
                    nameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        
       addressLabel = new JLabel("Address");
            addressLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
                    addressLabel.setBounds(220, 100, 140,30);   
        
        
        userLabel = new JLabel("User Name");
          userLabel.setBounds(220, 140, 140,30);  
                 userLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
       
        
        
        passLabel = new JLabel("Password");
         passLabel.setBounds(220, 180, 140,30);   
            passLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
         
        customersLab = new JLabel("Customer List"); 
          customersLab.setBounds(20, 20, 170,30);
                 customersLab.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        //////////////// new customer
        
        newCustomer = new JButton("New Customer");
         newCustomer.setBounds(20, 250, 150,30);
         newCustomer.setFont(new Font("Tahoma", Font.BOLD, 15));
         newCustomer.setForeground(Color.red);
         newCustomer.setBackground(Color.DARK_GRAY);
         
        
        
        /////////////////////////////// insert customer///////////////////////////
        
        
         insertCustomer = new JButton("Insert", new ImageIcon(this.getClass().getResource("/images/insert.png")));
         insertCustomer.setBounds(400, 250, 140,30);        
         insertCustomer.setFont(new Font("Tahoma", Font.BOLD, 15));
         insertCustomer.setForeground(Color.red);
         insertCustomer.setBackground(Color.DARK_GRAY);
         
        
        //////////////////////////// update customer////////////////////////////
        
        
        updateCustomer = new JButton("Update Customer", new ImageIcon(this.getClass().getResource("/images/update.png")));                
            updateCustomer.setBounds(190, 250, 200,30);
               updateCustomer.setFont(new Font("Tahoma", Font.BOLD, 15));
                 updateCustomer.setForeground(Color.red);
                    updateCustomer.setBackground(Color.DARK_GRAY);
         
                  
       
        /////////////// action components /////////////        
        
        newCustomer.addActionListener(this);
        insertCustomer.addActionListener(this);
        updateCustomer.addActionListener(this);
        
        newDep.addActionListener(this);
        updateDep.addActionListener(this);
        
        updatePro.addActionListener(this);  
        newPro.addActionListener(this);  
        
        departments.addMouseListener(this);        
        products.addMouseListener(this);        
        customers.addMouseListener(this);
        ////////////////////////////////////////add in  department  panel/////////////////////////////
        deparMang.add(newDep);
        deparMang.add(updateDep);
        deparMang.add(departmentsLab);
        deparMang.add(departments);               
        deparMang.add(namefD);
        deparMang.add(descriptionar);        
        deparMang.add(nameDL);
        deparMang.add(descriptionDL);        
    
        ///////////////////////////////////////////// add in product panel   //////////////////////////////     
        proMang.add(namePL);
        proMang.add(pricePL);
        proMang.add(quantityPL);
        proMang.add(descriptionPL);
        proMang.add(departmentPL);
        proMang.add(nameP);
        proMang.add(price);
        proMang.add(quantity);
        proMang.add(descriptionP);  
        proMang.add(departmentP);                  
        proMang.add(products);
        proMang.add(productsLab);
        proMang.add(newPro);
        proMang.add(updatePro);
       
        ////////////////////////////////////////add in  customer panel /////////////////////////////////
        cusMang.add(customerID);
        cusMang.add(customerName);
        cusMang.add(customeraddress);
        cusMang.add(customeruser);
        cusMang.add(customerpass);
        cusMang.add(customers);
        cusMang.add(idLabel);
        cusMang.add(nameLabel);
        cusMang.add(addressLabel);
        cusMang.add(userLabel);
        cusMang.add(passLabel);
        cusMang.add(customersLab);
        cusMang.add(newCustomer);
        cusMang.add(insertCustomer);
        cusMang.add(updateCustomer);  
     /////////////////////////////////////////////////////////////////////////////////////////////////
        this.add(tappedPane);
        tappedPane.addTab("Customer", cusMang);
        tappedPane.addTab("Department", deparMang);
        tappedPane.addTab("Product", proMang);
        this.setVisible(true);
    }    
    //////////////////////////////newCustomer/////////////////////////////////////////////////////////
    public void actionPerformed(ActionEvent e) 
    {        
        if(e.getSource()==newCustomer)
        {
            customerID.setText("");
            customerName.setText("");
            customeruser.setText("");
            customerpass.setText("");
            customeraddress.setText(""); 
        }else if(e.getSource()==insertCustomer)
        { 
            if(customerName.getText().length()==0)return;
            Customer temp = Main.mainFrame.findUser(customeruser.getText());
            if(temp==null)
            { 
                Main.user.add(new Customer(Integer.parseInt(customerID.getText()),customerName.getText(),customeruser.getText(),customerpass.getText(),customeraddress.getText()));
                this.clearData();
            } 
            else
            {
                JOptionPane.showMessageDialog(this, "The user is Used >> \n enter a new user !","Error",0);
            }
        } 
        else if(e.getSource()==updateCustomer)
        {
            if(currentCustomer!=null)
            {
                currentCustomer.idCustomer=Integer.parseInt(customerID.getText());
                currentCustomer.nameCustomer=customerName.getText().trim();
                currentCustomer.addressCustomer=customeraddress.getText();
                currentCustomer.passCustomer=customerpass.getText();
                currentCustomer.userCustomer=customeruser.getText();
            }  
            else{
                JOptionPane.showMessageDialog(null,"NO selected customer ");
            }
            this.clearData();
            ///////////////////////////////////////////////////
        }else if(e.getSource()==newDep)
        {
            new NewDepartment();
        }else if(e.getSource()==updateDep)
        {
            if(currentDepartment!=null)
            { 
                ArrayList<Product> temp = Main.data.remove(currentDepartment);
                currentDepartment.nameDepartment = namefD.getText().trim();
                currentDepartment.desDepartment=descriptionar.getText().trim();
                Main.data.put(currentDepartment, temp);
                this.clearData();
            }
        }else if(e.getSource()==newPro)
        {
            new NewProduct();
        }else if(e.getSource()==updatePro)
        {
            if(currentProduct!=null){
                if(!isAcceptedValues())
                {
                    JOptionPane.showMessageDialog(this, "error input","Error",0);
                    return;
                }
                currentProduct.nameProduct=nameP.getText();
                currentProduct.price=Double.parseDouble(price.getText());
                currentProduct.quntity=Integer.parseInt(quantity.getText());
                currentProduct.desProduct=descriptionP.getText();  
                currentProduct.update();
                if(!currentProduct.department.equals(Main.mainFrame.findDepartment(departmentP.getSelectedItem()+""))){
                    Main.data.get(currentProduct.department).remove(currentProduct);
                    currentProduct.department=Main.mainFrame.findDepartment(departmentP.getSelectedItem()+"");
                    Main.data.get(currentProduct.department).add(currentProduct);
                }                
            }                
            this.clearData();
        }
    } 
    public void clearData()
    {                
        ArrayList<Product> tempData = new ArrayList<>();
        for(ArrayList<Product> x:Main.data.values()){           
            for(int i=0;i<x.size();i++)
                tempData.add(x.get(i));                      
        }               
        products.removeAll();
        products.setListData(tempData.toArray(new Product []{}));
        departments.removeAll();
        departments.setListData(Main.data.keySet().toArray(new Department[]{}));   
        customers.removeAll();
        customers.setListData(Main.user.toArray());
        departmentP.setModel(new DefaultComboBoxModel(Main.data.keySet().toArray(new Department[]{})));
        customerID.setText("");  
        customerName.setText("");
        customeruser.setText("");
        customerpass.setText("");
        customeraddress.setText(""); 
        namefD.setText("");
        descriptionar.setText("");        
        nameP.setText("");
        price.setText("");
        quantity.setText("");
        descriptionP.setText("");                                                    
    }  
    public boolean isAcceptedValues(){     
        try{Double.parseDouble(price.getText());}catch(Exception e){
            return false;            
        }        
        return nameP.getText().matches("\\w[\\d\\s\\w]*")&&quantity.getText().matches("[\\d]+");
    }
    public void mouseClicked(MouseEvent e)
    {
        if(e.getSource()==customers)
        {            
            currentCustomer = (Customer)customers.getSelectedValue();            
            customerID.setText(currentCustomer.getId()+"");
            customerName.setText(currentCustomer.nameCustomer);
            customeruser.setText(currentCustomer.userCustomer);
            customerpass.setText(currentCustomer.passCustomer);
            customeraddress.setText(currentCustomer.addressCustomer); 
        }else if(e.getSource()==departments)
        {
            currentDepartment = Main.data.keySet().toArray(new Department[]{})[departments.getSelectedIndex()];
            namefD.setText(currentDepartment.nameDepartment);
            descriptionar.setText(currentDepartment.desDepartment);            
        }else if(e.getSource()==products)
        {
            currentProduct =(Product)products.getSelectedValue();   
            nameP.setText(currentProduct.nameProduct);
            price.setText(currentProduct.price+"");
            quantity.setText(currentProduct.quntity+"");
            descriptionP.setText(currentProduct.desProduct);     
            departmentP.setSelectedItem(currentProduct.department);            
        }
    }
    
    ///////////////////////////////////////override /////////////////////////////////////
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
  
     
    
    
}
