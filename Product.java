
package estore;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Product {
    public String nameProduct,desProduct;
    public Department department;
    public int quntity;
    public double price;
   
    private Map<Customer,Integer> notification;
    public Product(String nameP,double priceP,int quntityP,Department departmentP,String descriptionP){
        notification=new HashMap<Customer,Integer>();
       this.nameProduct=nameP;
        this.price=priceP;
        this.department=departmentP;
        this.desProduct=descriptionP;
        this.quntity=quntityP;
       
        
    }        
    public boolean equals(Object o){
        return this.nameProduct.equals(((Product)o).nameProduct)&&this.department.equals(((Product)o).department);
    }
    public String toString(){
        return nameProduct;
    }
     ///////////////////////////////////////////////// hash 
    public int hashCode(){
        int value=0;
        for(byte e:nameProduct.getBytes()){
            value+=e;
        }
        return value;
    }
    ////////////////////////////// add customer 
    public void addCustomer(Customer e,Integer quntity)
    {
        Integer temp = notification.get(e);
        if(temp!=null){
            quntity += temp;
        }
        notification.put(e,quntity);
    }
    ////////////////////////////// update with notification 
    public void update()
    {
        Iterator<Map.Entry<Customer,Integer>> i = notification.entrySet().iterator();
        while(i.hasNext())
        {
            Map.Entry<Customer,Integer> temp = i.next();
            if(temp.getValue()<=quntity)
            {
                temp.getKey().updateNotf(null, nameProduct+" "+temp.getValue());
                notification.remove(temp.getKey());
            }
        }        
    }   
}

//////////////////////////////end class product