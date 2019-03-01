//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifter
{
	public static int[] makeLucky7Array( int size)
	{
		int[] arr = new int[size];
		return arr;
	}
	public static void shiftEm(int[] arr)
	{
		int count = 0;
		int temp = 0;
		int[] array = makeLucky7Array(arr.length);
		for (int i=0; i<arr.length; i++){
			if (arr[i]==7){
				temp=arr[count];
				arr[count]=7;
				arr[i]=temp;
				count += 1;
			}
		}
	}
}
