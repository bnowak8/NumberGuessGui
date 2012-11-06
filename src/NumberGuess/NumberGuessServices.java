
package NumberGuess;

import java.util.Random;

public class NumberGuessServices {
   private String num;
   private Random rndNum = new Random();
   
     
   public final void setNum(){
       num = "" + rndNum.nextInt(50);
   }
   
   public boolean checkNum(String guess){
       return guess.equals(num);
   }
   public String showNum(){
       return num;
   }
   
   
    
}
