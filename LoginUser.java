package estore;

import estore.Main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginUser extends JFrame  {
    private JTextField username;    
    private JPasswordField password; 
    private JLabel userLab,passLab;
    private JButton confirm,cancel;    
    // constuctor 
    public LoginUser()
    {        
        setResizable(false); // no edit size 
        setTitle("Login");
        setBounds(515,210,290,180);//380,160,550,280
        setLayout(null);
        username = new JTextField();
         username.setBounds(140, 10, 120,30);
            password = new JPasswordField();
                 password.setBounds(140, 60, 120,30);           
        userLab = new JLabel("User Name");      
         userLab.setBounds(20, 10, 120,30);
          userLab.setFont(new Font("Tahoma", Font.BOLD, 18));
        passLab = new JLabel("Password");
          passLab.setBounds(20, 60, 120,30);
            passLab.setFont(new Font("Tahoma", Font.BOLD, 18));
        confirm = new JButton("Login", new ImageIcon(this.getClass().getResource("/images/login.png")));
         confirm.setBounds(30, 110, 100,30);
          cancel = new JButton("Cancel", new ImageIcon(this.getClass().getResource("/images/delete.png")));
            cancel.setBounds(150, 110, 120,30);  
            
            ///////////////action ///////////////////////
            
        confirm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Customer c= Main.mainFrame.findUser(username.getText());            
                if(c!=null){                
                    Main.store.login_out(c);
                    Main.loginFrame.setVisible(false);            
                }else{
                    JOptionPane.showMessageDialog(Main.loginFrame, "faild user Name or password try enter this correctly please ", "Error :(", 0);
                } 
            }
        });
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Main.loginFrame.setVisible(false);  
            }
        });                  
        
        //////////// addddd
        add(username);
        add(password);
        add(userLab);
        add(passLab);
        add(confirm);
        add(cancel);
       
        setVisible(true);        
    }            
}
////////////////////////////////////////////Done 