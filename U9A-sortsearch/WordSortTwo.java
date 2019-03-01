//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo
{
	private String[] wordRay;

	public WordSortTwo(String sentence)
	{
    int space = sentence.length();
    int words = 0;

    for (int i = 0; i<sentence.length(); i++)
      if (sentence.charAt(i)==' ')
        words+=1;

    wordRay = new String[words];

    for (int j = sentence.length()-1;j>-1; j--)
      if (sentence.charAt(j) ==' '){
        wordRay[j] = sentence.substring(j, space);
        space = j-1;
      }
    sort();
	}

	public void sort()
	{
    String temp = "";
    for (int c = 0; c < wordRay.length; c++)
      for (int b = 0; b<wordRay.length-1; b++)
        if (wordRay[b].compareTo(wordRay[b+1])>=0){
          temp = wordRay[b];
          wordRay[b] = wordRay[b+1];
          wordRay[b+1]=temp;
        }
	}

	public String toString()
	{
		String output="";
    for (int a = 0; a < wordRay.length; a++)
      output+= wordRay[a] + "\n";
		return output;
	}
}
