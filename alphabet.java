import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class alphabet extends Applet implements ActionListener
{
    JTextField text;
    public void init ()
    {
	text = new JTextField (40);
	text.setBackground(Color.lightGray);
	JButton a[] = new JButton [26];
	Panel g = new Panel (new GridLayout (2, 13));
	for (int i = 0 ; i < a.length ; i++)
	{
	    a [i] = new JButton ("" + (char) (i + 97));
	    a [i].addActionListener (this);
	    a [i].setActionCommand ("" + (char) (i + 97));
	    a [i].setBackground (Color.green);
	    g.add (a [i]);
	}

	JButton space = new JButton ("              Space                 ");
	space.addActionListener (this);
	space.setActionCommand (" ");
	space.setBackground(Color.blue);

	JButton nums[] = new JButton [10];
	Panel n = new Panel (new GridLayout (1, 10));
	for (int i = 0 ; i < nums.length ; i++)
	{
	    nums [i] = new JButton ("" + (int) (i));
	    nums [i].addActionListener (this);
	    nums [i].setActionCommand ("" + (int) (i));
	    nums [i].setBackground (Color.yellow);
	    n.add (nums [i]);
	}


	add (text);
	add (n);
	add (g);
	add (space);
	resize (600, 100);
    }


    public void actionPerformed (ActionEvent e)
    {
	text.setText (text.getText () + e.getActionCommand ());
    }
}
