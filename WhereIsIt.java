import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
public class WhereIsIt extends Applet implements ActionListener
{
    JButton[] a;
    int row = 10;
    int col = 10;
    int total = row * col;
    int hiddenX = (int) ((Math.random () * 9) + 1);
    int hiddenY = (int) ((Math.random () * 9) + 1);
    int counter = 0;
    JLabel guesses;
    public void init ()
    {
	JLabel title = new JLabel ("Where is it?");
	title.setFont (new Font ("Jokerman", Font.BOLD, 20));
	title.setForeground (Color.red);
	add (title);
	JLabel blank = new JLabel ("                                                                                                                                                                             ");
	add (blank);
	JLabel ins = new JLabel ("Click to find the red button.");
	JLabel ins2 = new JLabel ("If you select a cell that is touching the \"hot\" square, the square turns orange.");
	JLabel ins3 = new JLabel ("If you select a cell that is in the row or column of the \"hot\" square, the square turns yellow");
	JLabel ins4 = new JLabel ("The game keeps track of the number of turns that you have taken.");
	JLabel ins5 = new JLabel ("It also resets to another randomly selected hot square.");
	add (ins);
	add (ins2);
	add (ins3);
	add (ins4);
	add (ins5);
	Panel p = new Panel (new GridLayout (row, col, 0, 0));
	resize (500, 400);
	a = new JButton [total];
	for (int nNum = 0 ; nNum < total ; nNum++)
	{
	    a [nNum] = new JButton ("0");
	    p.add (a [nNum]);
	    a [nNum].addActionListener (this);
	    a [nNum].setBackground (Color.white);
	    a [nNum].setActionCommand ("" + nNum);
	}
	add (p);
	JButton reset = new JButton ("Reset");
	reset.addActionListener (this);
	reset.setActionCommand ("-1");
	add (reset);
	guesses = new JLabel ("Number of Guesses: 0");
	add (guesses);
    }


    public void actionPerformed (ActionEvent e)
    {
	int pos = Integer.parseInt (e.getActionCommand ());
	if (pos == -1)
	{ //add reset code here
	    for (int i = 0 ; i < total ; i++)
		a [i].setBackground (Color.white);
	    hiddenX = (int) ((Math.random () * 9) + 1);
	    hiddenY = (int) ((Math.random () * 9) + 1);
	    counter = 0;
	    guesses.setText ("Number of Guesses: 0");
	}
	else
	{
	    counter++;
	    guesses.setText ("Number of Guesses: " + counter);
	    //find i and j
	    int i = pos / row;
	    int j = pos % row;
	    if (i == hiddenX && j == hiddenY)
	    {
		a [pos].setBackground (Color.red);
		showStatus ("You win!");
	    }
	    else if ((i + 1 == hiddenX || i == hiddenX || i - 1 == hiddenX)
		    && j + 1 == hiddenY)
	    {
		a [pos].setBackground (Color.orange);
	    }
	    else if ((i + 1 == hiddenX || i - 1 == hiddenX) && j == hiddenY)
	    {
		a [pos].setBackground (Color.orange);
	    }
	    else if ((i + 1 == hiddenX || i == hiddenX || i - 1 == hiddenX)
		    && j - 1 == hiddenY)
	    {
		a [pos].setBackground (Color.orange);
	    }
	    else if (i == hiddenX || j == hiddenY)
	    {
		a [pos].setBackground (Color.yellow);
	    }
	    else
		a [pos].setBackground (Color.black);
	}
    }
}
