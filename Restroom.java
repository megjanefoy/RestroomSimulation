/** 
* Title: Assignment 2 
* Semester: COP3337 – Fall 2019
* @author Megan Jane Thompson
* 
* This program reads the number of stalls and adds the next 
* person in the middle of the longest empty section.
*/
public class Restroom{
   boolean[] booleanArray;
  
   /**
    * Constructs a restroom with a given number of stalls.
    *  @param ns the number of stalls
    */
   public Restroom(int ns){
      //creates array if number of stalls is between 5 & 30
      if ((ns >= 5) && (ns <=30)){     
         booleanArray = new boolean[ns+1];
      }
      else {
         System.out.println("Invalid entry, please insert number between 5 & 30");
      }
   }

   
   /**
    * Adds an occupant in the middle of the longest sequence of
    * unoccupied places. 
    */
   public void addOccupant(){
      int totalBetween = 0;  
      int largestSpace = 0;
      int largestStart = 0;
      int newPosition= 0;
      int oldStart = 0;
      int newStart = 0;
     

      //Evaluate positions, find largest space
      for (int i = 1; i < booleanArray.length; ++i){ 
         if ((i == booleanArray.length-1) && (!booleanArray[i])){
            totalBetween = i - newStart;
            oldStart = newStart;
         }
         else {
            if (booleanArray[i]){
               totalBetween = i - newStart-1;
               oldStart = newStart;
               newStart = i; 
            }  
         }
         if (totalBetween > largestSpace){
            largestSpace = totalBetween;
            largestStart = oldStart;
         }
      }

      if (largestSpace % 2 == 0){
         newPosition = (((largestSpace)/2) + largestStart) + 1;
      }
      else{
         newPosition = ((largestSpace + 1)/2) + largestStart;
      }
     
      booleanArray[newPosition] = true;
   }

   
   /**
    * Gets a string describing the current stall occupation
    * @return a string with _ for an empty stall and X for an occupied one
    */
   public String getStalls(){
      char[] charArray = new char[booleanArray.length-1]; 
      
      //converts array for "X" if occupied and "_" if available
      for (int i = 0; i < charArray.length; ++i){
         if (!booleanArray[i+1]){
            charArray[i] = '_';
         }
         else{
            charArray[i] = 'X';
         }
      }
      String string = new String(charArray);
      return string;
   }
}
