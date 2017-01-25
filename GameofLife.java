import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;

public class GameofLife extends Applet implements ActionListener
{

    JButton a[];  //the button array.
    int row = 10;
    int col = 10;
    int total = row * col;
    int current[] [];  //the tracking array for the alive and dead cells

    public void init ()
    {
	resize (650, 600);

	JLabel title = new JLabel ("The Game of Life");
	title.setFont (new Font ("Jokerman", Font.BOLD, 20));
	title.setForeground (new Color (0, 255, 0));
	add (title);

	JButton nextgen = new JButton ("Next Generation");
	nextgen.setBackground (Color.yellow);
	nextgen.addActionListener (this);
	nextgen.setActionCommand ("next");

	JButton glider = new JButton ("Blinker");
	glider.addActionListener (this);
	glider.setActionCommand ("blinker");

	JButton beacon = new JButton ("Beacon");
	beacon.addActionListener (this);
	beacon.setActionCommand ("beacon");

	JButton pi = new JButton ("Pi");
	pi.addActionListener (this);
	pi.setActionCommand ("pi");

	JButton rpentinomo = new JButton ("R-Pentinomo");
	rpentinomo.addActionListener (this);
	rpentinomo.setActionCommand ("rpentinomo");

	Panel g = new Panel (new GridLayout (1, 5));
	g.add (nextgen);
	g.add (glider);
	g.add (beacon);
	g.add (pi);
	g.add (rpentinomo);
	add (g);

	Panel p = new Panel (new GridLayout (row, col, 0, 0));
	//initialize tracking array to have all black backgrounds
	current = new int [row] [col];
	for (int i = 0 ; i < row ; i++)
	    for (int j = 0 ; j < col ; j++)
		current [i] [j] = 0;
	//declare a new array of buttons
	a = new JButton [total];
	//initialize each of the buttons in the array
	//with an empty label
	for (int i = 0 ; i < total ; i++)
	{
	    a [i] = new JButton ("0");
	    p.add (a [i]);
	}
	add (p);
    }


    public void actionPerformed (ActionEvent e)
    {
	if (e.getActionCommand ().equals ("pi"))
	{
	    //#1 reset current or tracking array to 0
	    for (int i = 0 ; i < row ; i++)
		for (int j = 0 ; j < col ; j++)
		    current [i] [j] = 0;
	    //#2 put our pattern into current or tracking array
	    current [4] [3] = 1;
	    current [5] [3] = 1;
	    current [6] [3] = 1;
	    current [4] [4] = 1;
	    current [4] [5] = 1;
	    current [5] [5] = 1;
	    current [6] [5] = 1;
	    //#3 draw the new pattern on the screen
	    redraw ();
	}
	else if (e.getActionCommand ().equals ("blinker"))
	{
	    //#1 reset current or tracking array to 0
	    for (int i = 0 ; i < row ; i++)
		for (int j = 0 ; j < col ; j++)
		    current [i] [j] = 0;
	    //#2 put our pattern into current or tracking array
	    current [3] [4] = 1;
	    current [4] [4] = 1;
	    current [5] [4] = 1;
	    //#3 draw the new pattern on the screen
	    redraw ();
	}
	else if (e.getActionCommand ().equals ("beacon"))
	{
	    //#1 reset current or tracking array to 0
	    for (int i = 0 ; i < row ; i++)
		for (int j = 0 ; j < col ; j++)
		    current [i] [j] = 0;
	    //#2 put our pattern into current or tracking array
	    current [2] [2] = 1;
	    current [3] [2] = 1;
	    current [2] [3] = 1;
	    current [5] [3] = 1;
	    current [5] [4] = 1;
	    current [4] [4] = 1;
	    //#3 draw the new pattern on the screen
	    redraw ();
	}
	else if (e.getActionCommand ().equals ("rpentinomo"))
	{
	    //#1 reset current or tracking array to 0
	    for (int i = 0 ; i < row ; i++)
		for (int j = 0 ; j < col ; j++)
		    current [i] [j] = 0;
	    //#2 put our pattern into current or tracking array
	    current [3] [2] = 1;
	    current [4] [2] = 1;
	    current [4] [3] = 1;
	    current [4] [4] = 1;
	    current [5] [3] = 1;
	    //#3 draw the new pattern on the screen
	    redraw ();
	}
	else
	{
	    nextgen ();
	    redraw ();
	}
    }


    public void redraw ()
    {
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		if (current [i] [j] == 0)
		    a [move].setLabel ("");
		else
		    a [move].setLabel ("" + current [i] [j]);
		move++;
	    }
	}
    }


    public void nextgen ()
    {
	int next[] [];
	next = new int [row] [col];
	for (int i = 0 ; i < row ; i++)
	    for (int j = 0 ; j < col ; j++)
		next [i] [j] = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		int count = 0;
		if (i - 1 > 0 && j - 1 > 0 && current [i - 1] [j - 1] == 1)
		    count++;
		if (i - 1 > 0 && current [i - 1] [j] == 1)
		    count++;
		if (i - 1 > 0 && j + 1 < col && current [i - 1] [j + 1] == 1)
		    count++;
		if (j - 1 > 0 && current [i] [j - 1] == 1)
		    count++;
		if (i + 1 < row && j - 1 > 0 && current [i + 1] [j - 1] == 1)
		    count++;
		if (i + 1 < row && current [i + 1] [j] == 1)
		    count++;
		if (j + 1 < col && current [i] [j + 1] == 1)
		    count++;
		if (i + 1 < row && j + 1 < col && current [i + 1] [j + 1] == 1)
		    count++;

		if (count == 3)
		    next [i] [j] = 1;
		else if (count == 2 && current [i] [j] == 1)
		    next [i] [j] = 1;
	    }
	}
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		current [i] [j] = next [i] [j];
	    }
	}
    }
}


