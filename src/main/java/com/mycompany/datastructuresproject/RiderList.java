package com.mycompany.datastructuresproject;

/**
 * Stores all riders in a structure maintained in sorted order by rider ID.
 */
public class RiderList implements IRiderList {
private LinkedList<IRider> all_riders;

    public RiderList() {
       all_riders = new LinkedList<>();
    }
    
     //Returns all riders in the linked list.
@Override
   public LinkedList<IRider> getAll(){
       return all_riders;
   }

    // Inserts a rider into the list in sorted order by ID. If a rider with the same ID already exists, insertion fails.
   @Override
public boolean add(IRider rider){
    if(rider==null)
        return false ; 
    
    if(all_riders.empty()){
        all_riders.insert(rider);
        return true;
    }
    
    all_riders.findfirst();
    while(true){
        IRider current = all_riders.retrieve();
        
        if(rider.compareTo(current)== 0 )
            return false;
        
      if(rider.compareTo(current)< 0 )  {
          all_riders.insert_befor_current(rider);
          return true;
      }
      
      if(all_riders.last())
          break;
      all_riders.findnext();
    }
    all_riders.insert(rider);
    return true;
}


    //return the total number of riders stored.
@Override
   public int size(){
       return all_riders.size;
   }
   
    //Searches for a rider by ID.
@Override
    public IRider findById(int riderId){
    if(all_riders.empty())    
      return null;
    
    all_riders.findfirst();
    while(true){
        IRider current = all_riders.retrieve();
        if(current.getId() == riderId)
            return current;
        if(all_riders.last())
            break;
        all_riders.findnext();
    }
     return null;   
        
    }

    
        //Searches for a rider by email address.
@Override
    public IRider findByEmail(String email){
     if(email == null || all_riders.empty())    
      return null;
    
    all_riders.findfirst();
    while(true){
        IRider current = all_riders.retrieve();
        if(current.getEmail().equalsIgnoreCase(email))
            return current;
        if(all_riders.last())
            break;
        all_riders.findnext();
    }
     return null; 
}

    
    // Searches for all riders with the given full name.
@Override
    public LinkedList<IRider> findByName(String fullName){
       LinkedList<IRider> result = new LinkedList<>();
       if ( fullName == null || all_riders.empty())
        return result ; 
       all_riders.findfirst();
       while(true){
            IRider current = all_riders.retrieve();
        if(current.getName().equals(fullName))
          result.insert(current);
        if(all_riders.last())
            break;
        all_riders.findnext();
       }
       return result;
    }



    //Returns all riders from the specified home city.
@Override
    public LinkedList<IRider> findByHomeCity(String homeCity){
       LinkedList<IRider> result = new LinkedList<>();
       if ( homeCity == null || all_riders.empty())
        return result ; 
       all_riders.findfirst();
       while(true){
            IRider current = all_riders.retrieve();
        if(current.getHomeCity().equalsIgnoreCase(homeCity))
          result.insert(current);
        if(all_riders.last())
            break;
        all_riders.findnext();
       }
       return result;
    }

   

    //Removes a rider by ID. Returns true if a rider with that ID was found and removed; false otherwise.
@Override
    public boolean removeById(int riderId){
    if(all_riders.empty())    
      return false;
    
    all_riders.findfirst();
    while(true){
        IRider current = all_riders.retrieve();
        if(current.getId() == riderId){
         all_riders.remove();
        return true;}
        if(all_riders.last())
            break;
        all_riders.findnext();
    }
     return false;   
        
    }

    //Removes a rider by email address. Returns true if a rider with that email was found and removed; false otherwise.
@Override
    public boolean removeByEmail(String email){
     if(email == null || all_riders.empty())    
      return false;
    
    all_riders.findfirst();
    while(true){
        IRider current = all_riders.retrieve();
        if(current.getEmail().equalsIgnoreCase(email)){
           all_riders.remove();
           return true ; 
        }
        if(all_riders.last())
            break;
        all_riders.findnext();
    }
     return false; 
}

    /**
     * Name and home city are not unique, so more than one rider may match.
     * Removes every rider whose full name exactly matches the given name
     * (the same full-name equality used by findByName), not a first-name-only
     * or partial match.
     * Returns the number of riders removed (0 if none matched).
     */
@Override
   public int removeByName(String fullName){
     if ( fullName == null || all_riders.empty()) 
         return 0 ; 
     
     int count = 0 ; 
     all_riders.findfirst();
     while ( true ){
      IRider current = all_riders.retrieve();
        if(current.getName().equals(fullName)){
          all_riders.remove(); 
        count ++;   
         
        if ( all_riders.empty() )
            break;
        }
        
   
       else if (all_riders.last())
           break;
       
       else
           all_riders.findnext();
     }
     return count;  
       
   }

    /**
     * Removes every rider from the specified home city.
     * Returns the number of riders removed (0 if none matched).
     */
@Override
    public int removeByHomeCity(String homeCity){
     if ( homeCity == null || all_riders.empty()) 
         return 0 ; 
     
     int count = 0 ; 
     all_riders.findfirst();
     while ( true ){
      IRider current = all_riders.retrieve();
        if(current.getHomeCity().equalsIgnoreCase(homeCity)){
          all_riders.remove(); 
        count ++;   
        
        if ( all_riders.empty() )
            break;
        }
        
      
       
       else if (all_riders.last())
           break;
       
       else
           all_riders.findnext();
     }
     return count;  
       
   }


}
