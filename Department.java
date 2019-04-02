package estore;
public class Department  {
    public String nameDepartment;
    public String desDepartment;
    
    //Constructor
    public Department(String nameD,String desD)
    {
        this.nameDepartment=nameD;
        this.desDepartment=desD;        
    }    
   ///////////////////////////////////////// input  nameDepartment to string datatype 
    public String toString()
    {
        return nameDepartment;
    }
    ////////////////////////////////////// hashCode >> for each
   
    public int hashCode()
    {
        int value=0;
        for(int each:nameDepartment.getBytes())
        {
            value+=each;
        }
        return value;
    }
    //////////////////////department nameDepartment != same department nameDepartment 
  
     public boolean equals(Object ob)
     {       
        return nameDepartment.equals(((Department)ob).nameDepartment);
     }    
}

///////////////////// end class department