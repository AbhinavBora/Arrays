public class airline
{
    public static void main (String args[])
    {
	new airline ();
    }


    public airline ()
    {
	String airline[] = new String [8];
	airline [0] = "";
	airline [1] = "George Boole";
	airline [2] = "";
	airline [3] = "";
	airline [4] = "Alan Turing";
	airline [5] = "";
	airline [6] = "";
	airline [7] = "";

	int num = 6;
	char cont = 'a';
	while (cont != 'q')
	{
	    System.out.println ("\n**Airline Reservation System**");
	    System.out.println (" (a) See the plane's passengers");
	    System.out.println (" (b) Book a Ticket");
	    System.out.println (" (c) Delete a ticket");
	    System.out.println (" (q) Quit");
	    cont = IBIO.inputChar ("Your choice>>");
	    if (cont == 'a')
	    {
		System.out.println ("\nPassengers");
		for (int i = 0 ; i < airline.length ; i++)
		{
		    System.out.println (i + ". " + airline [i]);
		}
	    }
	    else if (cont == 'b')
	    {
		System.out.println ("");
		System.out.println ("************Booking a Ticket************");
		System.out.println ("");
		int seat = IBIO.inputInt ("Which seat would you like? ");
		int available = 1;
		if (!airline [seat].equals (""))
		{
		    System.out.println ("Sorry, that seat is already taken");
		    available = 0;
		}
		if (available == 1)
		{
		    String name = IBIO.inputString ("What is your name?");
		    airline [seat] = name;
		}
	    }
	    else if (cont == 'c')
	    {
		System.out.println ("");
		System.out.println ("************Deleting a Ticket************");
		System.out.println ("");
		int delete = IBIO.inputInt ("Delete which seat? ");
		if (!airline[delete].equals (""))
		{
		    System.out.println (airline [delete] + " has been deleted.");
		    airline [delete] = "";
		}
		else
		    System.out.println ("No one has that seat");
	    }
	    else
		cont = 'q';
	}
    }
}


