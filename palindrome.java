public class palindrome
{
    public static void main (String args[])
    {
	new palindrome ();
    }


    public palindrome ()
    {

	char a1[] = {'R', 'A', 'D', 'A', 'R'};
	char a2[] = {'A', 'M', 'A', 'N', 'A', 'P', 'L', 'A', 'N', 'A', 'C', 'A', 'N', 'A', 'L', 'P', 'A', 'N', 'A', 'M', 'A'};
	// A man, a plan, a canal: Panama
	char a3[] = {'H', 'A', 'N', 'N', 'A', 'H'};
	char a4[] = {'C', 'A', 'T', 'A'};
	char a5[] = {'A', 'B', 'C', 'A'};
	char a6[] = {'A'};

	isit (a1);
	isit (a2);
	isit (a3);
	isit (a4);
	isit (a5);
	isit (a6);



    }


    public void isit (int a[])
    {
	int which = 0;
	for (int b = 0 ; b < a.length ; b++)
	{
	    if (a [b] == a [a.length - 1 - b])
		which += 1;
	}


	if (which == a.length)
	    System.out.println ("True");
	else
	    System.out.println ("False");
    }
}
