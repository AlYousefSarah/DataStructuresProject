public class RideList implements IRideList{

   private LinkedList<IRide> rides = new LinkedList<IRide>();
   private int count = 0;

   public boolean addRide(IRide ride){
      if(ride == null)
         return false;
   
      if(!rides.empty()){
         rides.findfirst();
         while(true){
            if(rides.retrieve().getRideId() == ride.getRideId())
               return false;
            if(rides.last())
               break;
            rides.findnext();
         }
      }
   
      if(rides.empty()) {
         rides.insert(ride);
         count++;
         return true;
      }
   
      rides.findfirst();
      while(true) {
         IRide curr = rides.retrieve();
         if(ride.compareTo(curr) < 0) {
            rides.update(ride);
            rides.insert(curr);
            count++;
            return true;
         }//if end
      
         if(rides.last()) {
            rides.insert(ride);
            count++;
            return true;
         }//if end
         rides.findnext();
      }//while end
   }//add end
   
   @Override
   public  boolean removeRideById(int rideId)
   {
      if(rides.empty())
         return false;
   
      rides.findfirst();
      while(true){
         if(rides.retrieve().getRideId() == rideId){
            rides.remove();
            count--;
            return true;
         }//if end
      
         if(rides.last())
            return false;
      }//while end
   
   }//remove end

   public LinkedList<IRide> getAllAlphabetically(){
      LinkedList<IRide> alphrides = new LinkedList<IRide>();
   
      if(rides.empty())
         return alphrides;
      rides.findfirst();
      while(true){
         alphrides.insert(rides.retrieve());
         if(rides.last())
            break;
         rides.findnext();
      }//end while
      return alphrides;
   }//get all alphabetically end , we did not sort it because it is already sorted we we added the rides.

   public LinkedList<IRide> findByPickupLocation(String pickupLocation){
      LinkedList<IRide> ridespick = new LinkedList<IRide>();
      if(rides.empty())
         return ridespick; //empty list ( we can not say null because it not an obj)
      rides.findfirst();
      while(true){
         IRide r = rides.retrieve();
         if(r.getPickupLocation().equalsIgnoreCase(pickupLocation))
            ridespick.insert(r);
         if(rides.last())
            break;
         rides.findnext();
      }//end while
      return ridespick;
   }//end of find by pick up location

   public LinkedList<IRide> findByRiderName(String riderFullName){
      LinkedList<IRide> ridesRN = new LinkedList<IRide>();
      if(rides.empty())
         return ridesRN;
   
      rides.findfirst();
      while(true){
         IRide r = rides.retrieve();
         boolean match = false;
      
         if( r instanceof IPrivateRide) {
            IPrivateRide pr = (IPrivateRide)r;
            match = pr.getRider().getName().equals(riderFullName);
         }//end of if
         
         else if(r instanceof ISharedRide) {
            LinkedList<IRider> shrider =((ISharedRide)r).getParticipants();
            if(!shrider.empty()) {
               shrider.findfirst();
            
               while(true) {
               
                  if(shrider.retrieve().getName().equals(riderFullName)){
                     match = true;
                     break;
                  }//end if
                  if(shrider.last())
                     break;
                  shrider.findnext();
               }//while end
            }//end if
         }//end of else if
         if(match)
            ridesRN.insert(r);
         if(rides.last())
            break;
         rides.findnext();
      }//while
      return ridesRN;
   }//end find by rider name

   public int size(){
      return count;
   }
}//class end 

