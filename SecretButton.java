import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class SecretButton extends Applet implements ActionListener
{
    JButton a[] = new JButton [7];
    int secret = (int) (Math.random () * 6) + 0;
    public void init ()
    {
	Panel g = new Panel ();
	for (int i = 0 ; i < a.length ; i++)
	{
	    a [i] = new JButton ("" + i);
	    a [i].addActionListener (this);
	    a [i].setActionCommand ("" + i);
	    a [i].setBackground (Color.green);
	    g.add (a [i]);
	}
	add (g);
	resize (400, 50);
    }


    public void actionPerformed (ActionEvent e)
    {
	int i = Integer.parseInt (e.getActionCommand ());
	if (i == secret)
	{
	    showStatus ("You found it!");
	    secret = (int) (Math.random () * 6) + 0;
	    for (int b = 0 ; b < a.length ; b++)
		a [b].setBackground (Color.green);
	}
	else
	{
	    showStatus ("You pressed button #" + i);
	    a [i].setBackground (Color.black);
	}
    }
}

