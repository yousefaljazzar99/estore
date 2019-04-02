
package estore;

//import estore.Main;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class NewDepartment extends JFrame implements ActionListener{
    private JTextField nameNewDep;
    private TextArea descriptionNewDep;
    private JLabel nameLabNewDep ,descriptionLabNewDep; 
    private JButton cancelButton,addButton;
    
    public NewDepartment (){
        super("Add new Department");         
        setBounds(400,100,400,300);
        //////////////////////////////////////
        nameNewDep = new JTextField();
        descriptionNewDep = new TextArea();
       // description.setEnabled(false);
        nameLabNewDep = new JLabel("Name");
         nameLabNewDep.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        descriptionLabNewDep = new JLabel("Description");  
         descriptionLabNewDep.setFont(new Font("Tahoma", Font.BOLD, 15));
         
        addButton = new JButton("Add new Department", new ImageIcon(this.getClass().getResource("/images/add-product.png")));
              addButton.setFont(new Font("Tahoma", Font.BOLD, 15));
                   addButton.setForeground(Color.red);
                          addButton.setBackground(Color.DARK_GRAY);
        
        cancelButton = new JButton("Cancel", new ImageIcon(this.getClass().getResource("/images/delete.png")));
         cancelButton.setFont(new Font("Tahoma", Font.BOLD, 15));
             cancelButton.setForeground(Color.red);
                 cancelButton.setBackground(Color.DARK_GRAY);
        
        ////        
        addButton.addActionListener(this);
        cancelButton.addActionListener(this);
        /////////set properties of components component//////////////////////
        this.setLayout(null);        
        nameLabNewDep.setBounds(20,20,120,25);          
        nameNewDep.setBounds(140, 20, 200, 25);
        descriptionLabNewDep.setBounds(20,60,120,25);   
        descriptionNewDep.setBounds(140, 60, 200, 100);                            
        addButton.setBounds(20, 185, 220,25);
        cancelButton.setBounds(250, 185, 120,25);
        //        
        this.add(addButton);
        this.add(cancelButton); 
        this.add(nameNewDep);
        this.add(descriptionNewDep);        
        this.add(nameLabNewDep);
        this.add(descriptionLabNewDep);        
        setVisible(true);
    }    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addButton){
            add();
        }else if(e.getSource()==cancelButton){
            Main.managerF.clearData();
            this.setVisible(false);
        }
    }    
    public void add(){
        String n= nameNewDep.getText();
        String d=descriptionNewDep.getText();
        if(n.length()>0){
            Department temp = new Department(n.trim(),d.trim());                
            if(Main.data.get(temp)==null){
                Main.data.put(temp, new ArrayList<>());    
                Main.managerF.clearData();                                   
                nameNewDep.setText("");
                descriptionNewDep.setText("");
                this.setVisible(false);
            }else
                JOptionPane.showMessageDialog(this, "this department is avilable","Error",0);
        }else               
            JOptionPane.showMessageDialog(this, "Please Enter legal values","Error",0);
    }
}
