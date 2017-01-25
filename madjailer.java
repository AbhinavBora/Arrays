public class madjailer
{
    public static void main (String args[])
    {
	new madjailer ();
    }


    public madjailer ()
    {
	char jail[] = new char [100];
	for (int i = 0 ; i < jail.length ; i++)
	{
	    jail [i] = 'l';
	}

	for (int a = 1 ; a < 101 ; a++)
	{
	    System.out.println ("Pass #" + a);
	    for (int b = 0 ; b < jail.length ; b++)
	    {
		if ((b + 1) % a == 0 && jail [b] == 'l')
		{
		    jail [b] = 'u';
		}
		else if ((b + 1) % a == 0 && jail [b] == 'u')
		{
		    jail [b] = 'l';
		}
		System.out.print (jail [b]);
	    }
	    System.out.println();
	}
    }
}


