package com.mycompany.datastructuresproject;

public abstract class Person implements IPerson{
    protected final int id; 
    protected String name ; 
    protected String phoneNumber ; 
    protected LinkedList<IRide> rideHistory ;

    public Person(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
       setPhoneNumber(phoneNumber);
       rideHistory = new LinkedList<IRide>();
    }

    //return the unique ID of this person.
    @Override
    public int getId()
    {
    return id;}

    //return the full name of this person.
    @Override
    public String getName(){
    return name;
    }

    //Sets the full name of this person.
    @Override
    public void setName(String name){
    this.name = name ;}

    //return the phone number of this person.
    @Override
    public String getPhoneNumber(){
         return phoneNumber;
    }

    /**
     * Sets the phone number of this person.
     * The phone number must be exactly 10 digits (numeric characters only,
     * e.g., "0551234567"). Implementations must validate the format and
     * throw IllegalArgumentException if it does not match.
     */
    @Override
    public void setPhoneNumber(String phoneNumber){
    if (phoneNumber == null || phoneNumber.length() != 10)
        throw new IllegalArgumentException ("phone number must be 10 digits!");
     for ( int i=0 ; i < phoneNumber.length() ; i++){
         if(!Character.isDigit(phoneNumber.charAt(i))){
                     throw new IllegalArgumentException ("phone number must be only digits!");
         }
     }       
     this.phoneNumber = phoneNumber ;
                }

    //return the list of rides associated with this person (as a rider, or as an assigned driver).
    @Override
    public LinkedList<IRide> getRideHistory(){
        return rideHistory;
    }

    // Returns a formatted string describing this person.
    @Override
    public String toString(){
   return "ID: " + id +", Name: " + name + ", Phone: " + phoneNumber;}
    
    }

