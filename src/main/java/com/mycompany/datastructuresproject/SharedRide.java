public class SharedRide extends Ride implements ISharedRide {

private LinkedList<IRider> participants = new LinkedList<IRider>();

public SharedRide(String pickupLocation, IDateTime pickupTime, IDateTime dropoffTime , String dropoffLocation, IDriver driver){

super(pickupLocation, pickupTime, dropoffTime, dropoffLocation, driver);
}//const end

public LinkedList<IRider> getParticipants(){
return participants;
}

public boolean addParticipant(IRider rider){
if( rider == null)
return false;
if(hasRider(rider.getId()))
return false;
participants.insert(rider);
return true;
}

public boolean removeParticipantById(int riderId){
if(participants.empty())
return false;

participants.findfirst();
while(true){
if(participants.retrieve().getId() == riderId){
participants.remove();
return true;
}//it will try to look for the id

if(participants.last())
return false; //if it did not find it
participants.findnext();//it moves the current
}
}//remove end

public boolean isEmpty(){
return participants.empty();
}

public boolean hasRider(int riderId){
if(participants.empty())
return false;

participants.findfirst();
while(true){
if(participants.retrieve().getId() == riderId)
return true;

if(participants.last())
return false;

participants.findnext();
}
}

public String toString(){
String names ="";

if(!participants.empty()){
participants.findfirst();

while(true){
names += participants.retrieve().getName();
if (participants.last())
break;
names += " , ";
participants.findnext();
}//while end
}//if end
return super.toString() + " Shared Riders " + names;
}//end of tostring

}//end of class
