public class shoppingList
{
    public static void main (String args[])
    {
	new shoppingList ();
    }


    public shoppingList ()
    {
	String items[] = new String [10];
	items [0] = "Running Shoes";
	items [1] = "Monkey";
	int num = 2;
	char cont = 'a';
	while (cont != 'q')
	{
	    System.out.println ("\n**Shopping List Manager**");
	    System.out.println (" (a) Add an item");
	    System.out.println (" (b) Delete an item");
	    System.out.println (" (q) Quit");
	    cont = IBIO.inputChar ("Your choice>>");
	    if (cont == 'a')
	    {
		String toAdd = IBIO.inputString ("Add what? ");
		items [num] = toAdd;
		num++;
		System.out.println ("\nShopping List");
		for (int i = 0 ; i < num ; i++)
		    System.out.println ((i + 1) + " " + items [i]);
	    }
	    else if (cont == 'b')
	    {
		String toDelete = IBIO.inputString ("Delete what? ");
		int pos = -1;
		for (int i = 0 ; i < num ; i++)
		{
		    if (toDelete.equals (items [i]))
			pos = i;
		}
		if (pos == -1)
		    System.out.println ("Sorry it is not in the array");
		else
		{
		    num--;
		    for (int i = pos ; i < num ; i++)
			items [i] = items [i + 1];
		}
		System.out.println ("\nShopping List");
		for (int i = 0 ; i < num ; i++)
		    System.out.println ((i + 1) + " " + items [i]);
	    }
	}
    }
}
