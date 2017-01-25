public class heights
{
    public static void main (String args[])
    {
	new heights ();
    }


    public heights ()
    {
	int height[] = new int [31];
	height[0] = 156;
	height[1] =172;
	height[2] =168;
	height[3] =170;
	height[4] = 160;
	height[5] = 152;
	int num = 6;
	char cont = 'a';
	while (cont != 'q')
	{
	    System.out.println ("\n**Heights Survey**");
	    System.out.println (" (a) Add a Height");
	    System.out.println (" (b) Delete a Height");
	    System.out.println (" (c) Find Average");
	    System.out.println (" (q) Quit");
	    cont = IBIO.inputChar ("Your choice>>");
	    if (cont == 'a')
	    {
		int toAdd = IBIO.inputInt ("Add what? ");
		height [num] = toAdd;
		num++;
		System.out.println ("\nHeights");
		for (int i = 0 ; i < num ; i++)
		    System.out.println ((i + 1) + " " + height [i]);
	    }
	    else if (cont == 'b')
	    {
		int toDelete = IBIO.inputInt ("Delete what? ");
		int pos = -1;
		for (int i = 0 ; i < num ; i++)
		{
		    if (toDelete == (height [i]))
			pos = i;
		}
		if (pos == -1)
		    System.out.println ("Sorry it is not in the array");
		else
		{
		    num--;
		    for (int i = pos ; i < num ; i++)
			height [i] = height [i + 1];
		}
		System.out.println ("\nHeights");
		for (int i = 0 ; i < num ; i++)
		    System.out.println ((i + 1) + " " + height [i]);
	    }
	    else if (cont == 'c')
	    {
	    double total = 0;
	    for (int i = 0 ; i < num ; i++)
		{
		    total += height [i];
		}
		System.out.println("Average: "+total/num);
	    }
	    else
		cont = 'q';
	}
    }
}
