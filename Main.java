package estore;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
public class Main extends JFrame {
    private JMenuBar mb;
    private JMenu m1;
    private JMenuItem exit,customer,manager;
    public static ManagerGui managerF;    
    
    public static Main mainFrame;    
    public static LoginUser loginFrame;
    public static HashMap<Department,ArrayList<Product>> data ;
    public static ArrayList<Customer> user ;
    public static StoreCust store;    
    
    Container c;
    JLabel Lab1;
    public Main(){
        super("Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(400,100,400,400);
        setLocationRelativeTo(null);
        c=getContentPane();
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);
        Lab1=new JLabel("WELCOME TO STORE");
        Lab1.setFont(new Font("Tahoma", Font.BOLD, 18));
        Lab1.setForeground(Color.red);
        Lab1.setBounds(95, 75, 300, 200);
        c.add(Lab1);
   
        mb = new JMenuBar();
        m1 = new JMenu("eStore");
         m1.setFont(new Font("Tahoma", Font.BOLD, 14));
        exit = new JMenuItem("Exit", new ImageIcon(this.getClass().getResource("/images/exit.png")));
          exit.setFont(new Font("Tahoma", Font.BOLD, 12));
             exit.setForeground(Color.red);
        customer = new JMenuItem("Customer Window", new ImageIcon(this.getClass().getResource("/images/Customer.png"))); 
         customer.setFont(new Font("Tahoma", Font.BOLD, 12));
            customer.setForeground(Color.blue);
        manager = new JMenuItem("Manager Window", new ImageIcon(this.getClass().getResource("/images/manager.png")));     
         manager.setFont(new Font("Tahoma", Font.BOLD, 12));
            manager.setForeground(Color.blue);
        
        ///////////////////////////exit ////////////////////////////////////
        
          exit.addActionListener(new ActionListener()
        
        
        {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }); 
          
          
          /////////////////////////manager //////////////////////////////////////
        manager.addActionListener(new ActionListener()
        
        {
            public void actionPerformed(ActionEvent e) 
            {
                if(managerF==null)
                    managerF = new ManagerGui();            
                else
                    managerF.setVisible(true);
            }
        });
        
       //////////////////////////////customer ////////////////////////////
        customer.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                if(store==null)
                store = new StoreCust();             
            else
                store.setVisible(true);
            }
        });
             ////////// add in menu 
        this.setJMenuBar(mb);
        mb.add(m1);
        m1.add(manager);
        m1.add(customer);
        m1.add(exit);      
        setVisible(true);
    }           ///////////////////////////////////main//////////////////////////////
    public static void main(String []args) 
    { 
            mainFrame=new Main();
            data = new HashMap<>();
            user = new ArrayList<>();
            
    }     
    public Customer findUser(String p){
        for(Customer c:user.toArray(new Customer[]{})){
            if(c.userCustomer.equals(p)){
                return c;
            }                    
        }
        return null;
    }
    public Department findDepartment(String n){
        for(Department c:data.keySet()){
            if(c.nameDepartment.equals(n)){
                return c;
            }                    
        }
        return null;
    }
}
/////////////////////// done ////////////////////