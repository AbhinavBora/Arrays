import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
public class ButtonArray extends Applet implements ActionListener
{
    JButton[] a;
    int row = 10;
    public void init ()
    { //a grid to layout the screen nicely
	Panel p = new Panel ();
	resize (500, 100);
	//declare a new array of buttons
	a = new JButton [row];
	//initialize each of the buttons in the array
	//with an empty label
	for (int nNum = 0 ; nNum < row ; nNum++)
	{
	    a [nNum] = new JButton ("0");
	    p.add (a [nNum]);
	    //each button will have an action listener
	    a [nNum].addActionListener (this);
	    a [nNum].setBackground (Color.yellow);
	    //each button will send a message with its number
	    a [nNum].setActionCommand ("" + nNum);
	}
	add (p);
    }


    public void actionPerformed (ActionEvent e)
    {
	int pos = Integer.parseInt (e.getActionCommand ());
	int count = Integer.parseInt (a [pos].getText ());
	count++;
	a [pos].setLabel (count + "");
	if (count == 0)
	    a [pos].setBackground (Color.yellow);
	else if (count == 1)
	    a [pos].setBackground (Color.orange);
	else if (count == 2)
	    a [pos].setBackground (Color.red);
	else if (count == 3)
	    a [pos].setBackground (Color.magenta);
	else if (count == 4)
	    a [pos].setBackground (Color.blue);
	else if (count == 5)
	    a [pos].setBackground (Color.green);
	else
	    a [pos].setBackground (Color.white);
    }
}
