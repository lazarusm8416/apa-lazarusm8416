//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
  public static int go( List<Integer> ray )
  {
	int fOdd = 0;
	int lEven = 0;
	for (int i =0; i<ray.size(); i++)
		if (ray.get(i)%2==1){
			fOdd=i;
			break;
		}
	
	for (int j = fOdd; j<ray.size(); j++)
		if (ray.get(j)%2==0)
			lEven=j;
	
	if (fOdd==0&&lEven==0)
		return -1;
    return Math.abs(fOdd-lEven+1);
  }
}
