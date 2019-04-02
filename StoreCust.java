package estore;
import estore.CartCheckout;
import estore.Main;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class StoreCust extends JFrame implements ActionListener,MouseListener{
    /* design Coustomer to buy
    tree estore and infoproduct and login */
     Customer c;    
     JComboBox quantityComb;
     JButton login,shop,cart,addToCart;
     JLabel descriptionL,quantityL,productL,priceL,product,price;
     JTextArea description;    
     JTree tree;
     JPanel controlCustomer,infoCustomer,mainCustomer;
     Product current;
    public  static HashMap<Order,Integer> order; //hash map order 
    public StoreCust(){
        this.setResizable(false);
        this.setTitle("Customer TO BUY  Window");
        this.setBounds(400,100,600,400);  //400,100,500,400    
        order = new HashMap<>();
        /////////////////////////// Tree >> root and child
        getTreeInPanelWithData(null,"eStore");         
        ////////////////////////////////////////////////////* panels */
        controlCustomer = new JPanel();        
        infoCustomer = new JPanel(null);
        mainCustomer = new JPanel(null);
        ///////////////////////////////////////////* buttons in customer gui */
        login = new JButton("Login", new ImageIcon(this.getClass().getResource("/images/login.png")));
        login.setBackground(Color.DARK_GRAY);
        login.setFont(new Font("Tahoma", Font.BOLD, 14));
        login.setForeground(Color.RED);
        
        
        shop = new JButton("View Shop Product", new ImageIcon(this.getClass().getResource("/images/ok.png")));        
        shop.setBackground(Color.DARK_GRAY);
        shop.setFont(new Font("Tahoma", Font.BOLD, 14));
        shop.setForeground(Color.RED);
        
        cart = new JButton("View Cart", new ImageIcon(this.getClass().getResource("/images/cart.png")));
        cart.setBackground(Color.DARK_GRAY);
        cart.setFont(new Font("Tahoma", Font.BOLD, 14));
        cart.setForeground(Color.RED);
        
        addToCart = new JButton("Add to cart", new ImageIcon(this.getClass().getResource("/images/buying.png")));
        
        addToCart.setBounds(130, 6, 140,24);
        //////////////////* lapels */
        quantityL = new JLabel("Quantity:");
        
        quantityL.setBounds(5, 5, 50,25);
        productL = new JLabel("Product:");
        productL.setBounds(5, 30, 50,25);
        priceL = new JLabel("Price: ");
        descriptionL = new JLabel("Description");
        descriptionL.setBounds(5, 80, 80,25);
        product = new JLabel();
        product.setBounds(60, 30, 80,25);
        price = new JLabel();
        priceL.setBounds(5, 55, 50,25); 
        price.setBounds(60, 55, 50,25);
         //////////////////////////////////////////////// QUANTITS COMBOBOX //
        quantityComb = new JComboBox(new String[]{"1","2","3","4","5","6","7","8"});
        quantityComb.setBounds(61, 6, 48,26);
        description = new JTextArea();       
        description.setBounds(90, 80, 150,90);
        ///////////////////////////////////////////////ACTION LISTENER 
        login.addActionListener(this);
        shop.addActionListener(this);        
        cart.addActionListener(this);
        addToCart.addActionListener(this);               
        ////////////////////////////////////////////// ADD label in panel 
        infoCustomer.add(productL);
        infoCustomer.add(priceL);
        infoCustomer.add(descriptionL);
        infoCustomer.add(product);
        infoCustomer.add(price);
        infoCustomer.add(addToCart);        
        infoCustomer.add(quantityComb);
        infoCustomer.add(quantityL);        
        infoCustomer.add(description);            
        ////////////////////////////////////////////// add buttons in panels 
        controlCustomer.add(login);
        controlCustomer.add(shop);        
        controlCustomer.add(cart);
        
        //////////////////////////////////////////////// size control customer 
        controlCustomer.setPreferredSize(new Dimension(530,45));
        //////////////////////////////////////////////// size info customer 
        infoCustomer.setPreferredSize(new Dimension(260,180));        
        controlCustomer.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,1));
        infoCustomer.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,1));
        //////////////////////////////////////////////// tree size estore 
        tree.setBounds(10, 50, 250, 200);
       
        infoCustomer.setBounds(270, 50, 280,180);
        mainCustomer.add(tree);
        mainCustomer.add(infoCustomer);
        // Place panels 3 buttons in north 
        this.add(controlCustomer,"North");
        this.add(mainCustomer);
        // hide buttons >> if we find c its shown
        cart.setEnabled(c!=null);
        addToCart.setEnabled(c!=null);
        shop.setEnabled(c!=null);
        this.setVisible(true);
    }
    ////////////////////////////// hash map ( tree estore )
    public void getTreeInPanelWithData( HashMap<Department,ArrayList<Product>> m,String name){        
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(name);   
        
        JTree t = new JTree(top);tree=t;
        t.addMouseListener(this);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());        
        p.add(new JScrollPane(t));
        p.add(new JLabel(name),"North");
        p.setBorder(BorderFactory.createLineBorder(Color.black,1));
        p.setPreferredSize(new Dimension(250,180)); 
        if(m==null || m.size()==0)return ;        
        DefaultMutableTreeNode node = null;        
        Iterator<Department> depart = m.keySet().iterator();   
        
        while(depart.hasNext()){
            Department temp = depart.next();
            node = new DefaultMutableTreeNode(temp);
            top.add(node);
            ArrayList child = m.get(temp);
            for(int i=0;i<child.size();i++){                
                node.add(new DefaultMutableTreeNode(child.get(i)));
            }            
        }   
              
    }  
     ////////////////////////////////////////////////////////// action  eveny 
    public void actionPerformed(ActionEvent e) {        
        if(e.getSource()==login){
            if(login.getText().equals("Login")){
                if(Main.loginFrame==null)
                    Main.loginFrame = new LoginUser();             
                else
                    Main.loginFrame.setVisible(true); 
            }else{
                login_out(null);
                this.setVisible(false);
                Main.mainFrame.setVisible(true);
            }
            order = new HashMap<>();            
            mainCustomer.remove(tree);
            getTreeInPanelWithData(null,"eStore");             
            mainCustomer.add(tree);
            tree.setBounds(10, 50, 250, 200);            
        }else if(e.getSource()==shop){
            mainCustomer.remove(tree);
            getTreeInPanelWithData(Main.data,"eStore");  
            mainCustomer.add(tree);
            tree.setBounds(10, 50, 250, 200);                  
            this.setVisible(true);
        }else if(e.getSource()==cart){
            CartCheckout.instance=new CartCheckout(order.keySet().toArray(new Order[]{}),c);
        }else if(e.getSource()==addToCart){
            if(current==null){
                JOptionPane.showMessageDialog(this, "Please :( !! choose any  product at first","Error",0);
            }else
                if(addOrder(new Order(current),quantityComb.getSelectedIndex()+1)){
                    JOptionPane.showMessageDialog(this, "Order you need is  added \n thanks you and let us see you again ","Done",1);
                }else{
                    if(JOptionPane.showConfirmDialog(this, "Your quntity order  is higher than avilable quntity, do you need to told you if its Avilable  ?","Error :(",0)==0)
                        current.addCustomer(c, quantityComb.getSelectedIndex()+1);
                }               
        }
        
    }
    public Product getSelectedProduct(){
        String tempx =tree.getAnchorSelectionPath()+"";          
        String x[] = tempx.split(",");
        if(x.length!=3) return null;
        x[2]= x[2].substring(0, x[2].length()-1);
        ArrayList<Product> temp;        
        temp = Main.data.get(new Department(x[1].trim(),""));        
        for(Product e: temp){
            if(e.nameProduct.equals(x[2].trim())){
                return e;
            }
        }        
        return null;
    }
    public boolean addOrder(Order k,int num){      
        
        Integer fre = order.get(k);
        if(fre==null){
            if(num <= k.getProduct().quntity){
                order.put(k, num); 
                k.setCount(num);                
                return true;
            }else{                
                return false;
            }
        }else{
            Order []key = order.keySet().toArray(new Order[]{});
            for(int i=0;i<key.length;i++){
                if(key[i].equals(k)){
                    if((fre+num) <= key[i].getProduct().quntity){
                        order.put(key[i], num+fre); 
                        key[i].setCount(num+fre);                        
                        return true;
                    }else{                        
                        return false;
                    }
                }
            }  
        } 
        return false;
        
    }
    public void login_out(Customer c){
        this.c=c;
        if(c==null){
            login.setText("Login");
        }else{
            login.setText("Logout");
        }
        cart.setEnabled(c!=null);
        addToCart.setEnabled(c!=null);
        shop.setEnabled(c!=null);
    }             
    public void mouseClicked(MouseEvent e) {
        Product temp = this.getSelectedProduct();
        if(temp!=null){
            current = temp;            
            product.setText(temp.nameProduct);
            price.setText(temp.price+"");
            description.setText(temp.desProduct);                        
        }            
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}    
}
////////////////////////////// END CLASS STORE 