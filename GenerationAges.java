import java.util.Scanner;
/**
 * Problem to solve:
 *    Grandchild is in days as old as child is in weeks. 
 *    Granchild is in months as old as parent is in years.
 *    Ages of grandchild, child, and parent together is some (ex. 120) years
 *    Find ages in years of each generation
 *
 * @author Isabella Sturm
 * @version 02-24-2018
 */
public class GenerationAges{

   public static void main(String [] args){
   
      final double GRANDCHILD_TO_PARENT = 1/12.0;   // need to divide child months by factor to get years
      final double CHILD_TO_PARENT = (1.0/12.0) *365/52; // also need to divide by 12 (child months to years to days to weeks ==> child years)

      int generationX = 0;
      double millenial = generationX * CHILD_TO_PARENT;
      double iGeneration = generationX * GRANDCHILD_TO_PARENT;
      int target;
      double percentError = 0;
      
      Scanner scan = new Scanner(System.in);
      do{
         System.out.print("Enter a target sum: ");
         target = scan.nextInt();
      }
      while(target < 0);
      
      while(generationX + millenial + iGeneration <= target ){
         generationX++;
         millenial = generationX * CHILD_TO_PARENT;
         iGeneration = generationX * GRANDCHILD_TO_PARENT;
      }
      percentError = ((generationX + millenial + iGeneration) - target) / (target *1.0);
      System.out.printf("The Parent is %d years old\nThe Child is %d years old\nThe Grandchild is %d years old", generationX, Math.round(millenial), Math.round(iGeneration));
      System.out.printf("\nPercent Error: %.3f%%",percentError);
   }
}
