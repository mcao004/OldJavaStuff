//********************************************************************
//  PigLatin.java       Author: Lewis/Loftus
//
//  Driver to exercise the PigLatinTranslator class.
//********************************************************************

import java.util.Scanner;

public class PigLatin
{
   //-----------------------------------------------------------------
   //  Reads sentences and translates them into Pig Latin.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      String sentence, result, another;
      PigLatinTranslator translator = new PigLatinTranslator();
      Scanner input = new Scanner(System.in);

      do
      {
         System.out.println ();
         System.out.println ("Enter a sentence (no punctuation):");
         sentence = input.nextLine();

         System.out.println ();
         result = translator.translate (sentence);
         System.out.println ("That sentence in Pig Latin is:");
         System.out.println (result);

         System.out.println ();
         System.out.print ("Translate another sentence (y/n)? ");
         another = input.nextLine();
      }
      while (another.equalsIgnoreCase("y"));
   }
}
