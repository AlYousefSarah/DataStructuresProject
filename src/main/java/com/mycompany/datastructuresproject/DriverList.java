package com.mycompany.datastructuresproject;

/**
 * Stores all drivers in a structure maintained in sorted order by driver ID.
 */
public class DriverList implements IDriverList {
    private LinkedList<IDriver> all_drivers;

    public DriverList() {
       all_drivers = new LinkedList<>();
    }

    @Override
  public LinkedList<IDriver> getAll(){
       return all_drivers;
   }
   
    // Inserts a driver into the list in sorted order by ID. If a driver with the same ID already exists, insertion fails.
    @Override
    public boolean add(IDriver driver){
    if(driver==null)
        return false ; 
    
    if(all_drivers.empty()){
        all_drivers.insert(driver);
        return true;
    }
    
    all_drivers.findfirst();
    while(true){
        IDriver current = all_drivers.retrieve();
        
        if(driver.compareTo(current)== 0 )
            return false;
        
        if ( driver.getVehiclePlate().equalsIgnoreCase(current.getVehiclePlate()))
        return false ;
      if(driver.compareTo(current)< 0 )  {
          all_drivers.insert_befor_current(driver);
          return true;
      }
      
      if(all_drivers.last())
          break;
      all_drivers.findnext();
    }
    all_drivers.insert(driver);
    return true;
}

    //Searches for a driver by ID.
    @Override
    public IDriver findById(int driverId){
    if(all_drivers.empty())    
      return null;
    
    all_drivers.findfirst();
    while(true){
        IDriver current = all_drivers.retrieve();
        if(current.getId() == driverId)
            return current;
        if(all_drivers.last())
            break;
        all_drivers.findnext();
    }
     return null;   
        
    }

    // Searches for all drivers with the given full name.
    @Override
    public LinkedList<IDriver> findByName(String fullName){
       LinkedList<IDriver> result = new LinkedList<>();
       if ( fullName == null || all_drivers.empty())
        return result ; 
       all_drivers.findfirst();
       while(true){
            IDriver current = all_drivers.retrieve();
        if(current.getName().equals(fullName))
          result.insert(current);
        if(all_drivers.last())
            break;
        all_drivers.findnext();
       }
       return result;
    }

    //Searches for a driver by vehicle plate number.
    @Override
    public IDriver findByVehiclePlate(String vehiclePlate){
     if(vehiclePlate == null || all_drivers.empty()) 
         return null ;
     
     all_drivers.findfirst();
     
     while(true){
      
         IDriver current = all_drivers.retrieve();
         
         if(current.getVehiclePlate().equalsIgnoreCase(vehiclePlate)){
             return current;
         }
         if(all_drivers.last())
             break;
         
         all_drivers.findnext();
     }
         return null;
        
        
    }

    //Returns all drivers with the specified vehicle type.
    @Override
    public LinkedList<IDriver> findByVehicleType(VehicleType vehicleType){
       LinkedList<IDriver> result = new LinkedList<>();
       if ( vehicleType == null || all_drivers.empty())
        return result ; 
       all_drivers.findfirst();
       while(true){
            IDriver current = all_drivers.retrieve();
        if(current.getVehicleType()==(vehicleType))
          result.insert(current);
        if(all_drivers.last())
            break;
        all_drivers.findnext();
       }
       return result;
    }



    //Removes a driver by ID. Returns true if a driver with that ID was found and removed; false otherwise.
    @Override
    public boolean removeById(int driverId){
    if(all_drivers.empty())    
      return false;
    
    all_drivers.findfirst();
    while(true){
        IDriver current = all_drivers.retrieve();
        if(current.getId() == driverId){
         all_drivers.remove();
        return true;}
        if(all_drivers.last())
            break;
        all_drivers.findnext();
    }
     return false;   
        
    }

    //Removes a driver by vehicle plate number. Returns true if a driver with that plate was found and removed; false otherwise.
    @Override
    public boolean removeByVehiclePlate(String vehiclePlate){
     if(vehiclePlate == null || all_drivers.empty())    
      return false;
    
    all_drivers.findfirst();
    while(true){
        IDriver current = all_drivers.retrieve();
        if(current.getVehicleType()== vehiclePlate){
           all_drivers.remove();
           return true ; 
        }
        if(all_drivers.last())
            break;
        all_drivers.findnext();
    }
     return false; 
}

    /**
     * Name and vehicle type are not unique, so more than one driver may match.
     * Removes every driver whose full name exactly matches the given name
     * (the same full-name equality used by findByName), not a first-name-only
     * or partial match.
     * Returns the number of drivers removed (0 if none matched).
     */
    @Override
    public int removeByName(String fullName){
     if ( fullName == null || all_drivers.empty()) 
         return 0 ; 
     
     int count = 0 ; 
     all_drivers.findfirst();
     while ( true ){
      IDriver current = all_drivers.retrieve();
        if(current.getName().equals(fullName)){
          all_drivers.remove(); 
        count ++;   
         
        if ( all_drivers.empty() )
            break;
        }
        
   
       else if (all_drivers.last())
           break;
       
       else
           all_drivers.findnext();
     }
     return count;  
       
   }

    /**
     * Removes every driver with the specified vehicle type.
     * Returns the number of drivers removed (0 if none matched).
     */
    @Override
    public int removeByVehicleType(VehicleType vehicleType){
     if ( vehicleType == null || all_drivers.empty()) 
         return 0 ; 
     
     int count = 0 ; 
     all_drivers.findfirst();
     while ( true ){
      IDriver current = all_drivers.retrieve();
        if(current.getVehicleType()== vehicleType){
          all_drivers.remove(); 
        count ++;   
        
        if ( all_drivers.empty() )
            break;
        }
        
      
       
       else if (all_drivers.last())
           break;
       
       else
           all_drivers.findnext();
     }
     return count;  
       
   }

    //return the total number of drivers stored.
    @Override
   public int size(){
       return all_drivers.size;
   }
}
