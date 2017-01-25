public class warming
{
    public static void main (String args[])
    {
	new warming ();
    }


    public warming ()
    {
	int a[] = {25, 30, 3, 45, 12, 23, 34, 12, 23, 43, 25, 34, 4, 3, 8, 14, 2, 6, 3, 12, 23, 33, 12, 23, 34};
	System.out.println ("Temperatures:");
	for (int i = 0 ; i < a.length ; i++)
	{
	    System.out.print (a [i] + " ");
	}
	System.out.println ("\nChange:");
	double total = 0;
	for (int c = 0 ; c < (a.length - 1) ; c++)
	{
	    int change = a [c + 1] - a [c];
	    total += change;
	    if (change > 0)
		System.out.print ("+" + change + " ");
	    else
		System.out.print (change + " ");

	}
	System.out.println ("\nAverage Change:");
	if (total > 0)
	    System.out.println ("+" + total / (a.length - 1));
	else
	    System.out.println (total / (a.length - 1));
    }
}
