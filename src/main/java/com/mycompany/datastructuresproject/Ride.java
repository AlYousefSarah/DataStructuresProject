public abstract class Ride implements IRide {

//the atrributes in the interface and the pdf
   private final int rideId;
   private String pickupLocation;
   private final IDateTime pickupTime;
   private final IDateTime dropoffTime;
   private String dropoffLocation;
   private IDriver driver;

   private static int countID = 1;
//

   public Ride(String pickupLocation, IDateTime pickupTime, IDateTime dropoffTime , String dropoffLocation, IDriver driver){
   
      if( pickupTime == null || dropoffTime == null)
         throw new IllegalArgumentException("Pick up or Drop off time can not be null.");
   
      if(dropoffTime.compareTo(pickupTime) <= 0)
         throw new IllegalArgumentException("Drop off Time must be after the pick up time.");
   
      this.rideId = countID++;
      this.pickupLocation = pickupLocation;
      this.pickupTime = pickupTime;
      this.dropoffTime = dropoffTime;
      this.dropoffLocation = dropoffLocation;
      this.driver = driver;
   }//end const

//getters and setters

   public int getRideId(){
      return rideId;
   }
   public String getPickupLocation(){
      return pickupLocation;
   }
   public void setPickupLocation(String pickupLocation){
      this.pickupLocation = pickupLocation;
   }
   public IDateTime getPickupTime(){
      return pickupTime;
   }
   public IDateTime getDropoffTime(){
      return dropoffTime;
   }
   public String getDropoffLocation(){
      return dropoffLocation;
   }
   public void setDropoffLocation(String dropoffLocation){
      this.dropoffLocation = dropoffLocation;
   }
   public IDriver getDriver(){
      return driver;
   }
   public void setDriver(IDriver driver){
      this.driver = driver;
   }
//end of getters and setters

   public int compareTo(IRide other){
      return this.pickupLocation.compareToIgnoreCase(other.getPickupLocation());
   } //compare pick up location alphabetically

   public String toString(){
      String driverText = null;
      if(driver ==null)
         driverText = "none";
      else
         driver.getName();
      return "Ride #" + rideId + " At:" + pickupLocation + " (" + pickupTime.format() + ")" + " -->" + dropoffLocation + " (" + dropoffTime.format() + ")" +" Driver: "+ driverText;
   }//formatted string describing the ride.

    String toSting() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}//class end