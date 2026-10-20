package com.mycompany.datastructuresproject;

public class Rider extends Person implements IRider {
private String email ; 
private String homeCity;

    public Rider(String email, String homeCity, int id, String name, String phoneNumber) {
        super(id, name, phoneNumber);
        this.email = email;
        this.homeCity = homeCity;
    }

@Override
    public String getEmail(){
        return email;
    }
    
    @Override
    public void setEmail(String email){
        this.email=email;
    }

    @Override
    public String getHomeCity(){
        return homeCity;
    }

  @Override
    public void setHomeCity(String homeCity){
        this.homeCity = homeCity;
    }

    /**
     * Compares this rider with another rider based on rider ID.
     * Returns a negative integer, zero, or a positive integer as this
     * rider's ID is less than, equal to, or greater than the other
     * rider's ID. This ordering must be consistent with equality by ID.
     */
    @Override
    public int compareTo(IRider other){
        return this.id-other.getId();
    }
    
 @Override
    public String toString(){
   return "Rider[" + super.toString() +", Email: " + email + ", homeCity: " + homeCity + "]";}
}
