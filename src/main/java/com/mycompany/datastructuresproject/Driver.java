package com.mycompany.datastructuresproject;

public class Driver extends Person implements IDriver{
private String vehiclePlate; 
private VehicleType vehicleType; 

    public Driver(String vehiclePlate, VehicleType vehicleType, int id, String name, String phoneNumber) {
        super(id, name, phoneNumber);
        setVehiclePlate(vehiclePlate);
        this.vehicleType = vehicleType;
    }

@Override
    public String getVehiclePlate(){
        return vehiclePlate;
    }

@Override
public void setVehiclePlate (String vehiclePlate) {
if (vehiclePlate == null || vehiclePlate.length() != 7)
{
throw new IllegalArgumentException ("Vehicle plate must be 3 uppercase letters followed by 4 digits (e.g. ABC1234).");
}
for (int i=0 ; i< 3 ; i++){
    char c = vehiclePlate.charAt(i) ;
if (!Character. isUpperCase (c)) {
throw new IllegalArgumentException ("Vehicle plate must start with 3 uppercase letters.");
}
}
for (int i = 3; i < 7; i++) {
char c = vehiclePlate.charAt(i);
if (!Character. isDigit (c)) {
throw new IllegalArgumentException ("Vehicle plate must end with 4 digits.");}
}
this.vehiclePlate = vehiclePlate;
}

    //return the driver's vehicle type.
    @Override
    public VehicleType getVehicleType(){
        return vehicleType;
    }

    //Sets the driver's vehicle type.
     @Override
    public void setVehicleType(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }

   
    @Override
    public int compareTo(IDriver other){
        return this.id - other.getId();
    }
    
     @Override
    public String toString(){
   return "Driver[" + super.toString() +", Plate: " + vehiclePlate + ", Vehicle Type: " + vehicleType + "]";}
}
