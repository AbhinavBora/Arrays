public class PegGame
{
    public static void main (String args[])
    {
	new PegGame ();
    }


    public PegGame ()
    {
	char board[] = {'x', 'x', 'x', 'x', '_', 'y', 'y', 'y', 'y'};
	char done = 'n';
	int moves = 0;
	while (done == 'n')
	{ //print board
	    System.out.println ("\nYou have taken " + moves + " moves.\n");
	    for (int i = 0 ; i < board.length ; i++)
		System.out.print (board [i]);
	    System.out.println ();
	    for (int i = 0 ; i < 9 ; i++)
		System.out.print (i);
	    //ask for positions
	    int pos1 = IBIO.inputInt ("\n\nPosition 1: ");
	    int pos2 = IBIO.inputInt ("Position 2: ");
	    //swap
	    if (valid (board, pos1, pos2))
	    {
		char temp = board [pos1];
		board [pos1] = board [pos2];
		board [pos2] = temp;
		moves++;
	    }
	    //done?
	    char answers[] = {'y', 'y', 'y', 'y', '_', 'x', 'x', 'x', 'x'};
	    done = 'y';
	    for (int i = 0 ; i < board.length ; i++)
	    {
		if (board [i] != answers [i])
		    done = 'n';
	    }
	} //while
    } //method


    public boolean valid (char b[], int p1, int p2)
    { //off the board
	if (p1 < 0 || p1 >= b.length)
	{
	    System.out.println ("Position 1 must be between 0 and " + b.length);
	    return false;
	}
	//p2 else if goes here
	else if (p2 < 0 || p2 >= b.length)
	{
	    System.out.println ("Position 1 must be between 0 and " + b.length);
	    return false;
	}
	//p1 empty, p2 next to it - OK
	else if (b [p1] == '_' && (p2 == p1 + 1 || p2 == p1 - 1))
	    return true;
	//ADD p2 empty, p1 next to it - also OK
	else if (b [p2] == '_' && (p1 == p2 + 1 || p1 == p2 - 1))
	    return true;
	//p1 empty, piece next on left, p2 over 2 on right
	else if (b [p1] == '_' && (p1 == p2 - 2 && p1 + 1 != '_'))
	    return true;
	//ADD p2 empty, piece next on left, p1 over 2 on right
	else if (b [p2] == '_' && (p2 == p1 - 2 && p2 + 1 != '_'))
	    return true;
	//p1 empty, piece next on left, p2 over 2 on left
	else if (b [p1] == '_' && (p1 == p2 + 2 && p1 - 1 != '_'))
	    return true;
	//ADD p2 empty, piece next on left, p1 over 2 on left
	else if (b [p2] == '_' && (p2 == p1 + 2 && p2 - 1 != '_'))
	    return true;
	else
	{
	    System.out.println ("Invalid move. You can move in an empty space only.");
	    return false;
	}
    }
} //class
