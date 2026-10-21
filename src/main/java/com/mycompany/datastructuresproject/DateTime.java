public class DateTime implements IDateTime {

//time fields, it is final because it should not be modified once it's created.
   private final int year;
   private final int month;
   private final int day;
   private final int hour;
   private final int minute;
//

//constructors
   public DateTime(int year, int month, int day, int hour, int minute){
   
   //to make sure it's valid numbers
      if(month < 1 || month > 12)
         throw new IllegalArgumentException("Months must be between 1 and 12");
   
      if(day < 1 || day > 31)
         throw new IllegalArgumentException("Days must be between 1 and 31");
   
      if(hour < 0 || hour > 23)
         throw new IllegalArgumentException("Hours must be between 0 and 23");
   
      if(minute < 0 || minute > 59)
         throw new IllegalArgumentException("Minutes must be between 0 and 59");
   
   //because the argument has the same name as the parameter
      this.year = year;
      this.month = month;
      this.day = day;
      this.hour = hour;
      this.minute = minute;
   
   }//end of constructor

//getters
   public int getYear(){
      return year;
   }

   public int getMonth(){
      return month;
   }

   public int getDay(){
      return day;
   }

   public int getHour(){
      return hour;
   }

   public int getMinute(){
      return minute;
   }
//getter end

public int compareTo(IDateTime other){
//pre-defined method compare do the same as required.

if( year != other.getYear())
return Integer.compare(year, other.getYear());

if( month != other.getMonth())
return Integer.compare(month, other.getMonth());

if( day != other.getDay())
return Integer.compare( day, other.getDay());

if( hour != other.getHour())
return Integer.compare( hour, other.getHour());

return Integer.compare(minute, other.getMinute());

}//end of compare to

public String format(){
return String.format("%02d/%02d/%04d %02d:%02d" , month , day, year , hour, minute);
//the format in the pdf is MM/DD/YYYY HH:MM

}//end of format

public String toString(){
return format();
}//end of tostring

}//end of class