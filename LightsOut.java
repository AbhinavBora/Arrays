import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
public class LightsOut extends Applet implements ActionListener
{
    JButton[] [] lv1;
    int[] [] which;

    public void init ()
    {
	resize (800, 800);

	lv1 = new JButton [5] [5];
	for (int a = 0 ; a < 5 ; a++)
	{
	    for (int b = 0 ; b < 5 ; b++)
	    {
		lv1 [a] [b] = new JButton (createImageIcon ("lightoff.jpg"));
		lv1 [a] [b].addActionListener (this);
		lv1 [a] [b].setActionCommand (a + "" + b);
		lv1 [a] [b].setBackground (Color.darkGray);
	    }
	}

	which = new int [5] [5];
	for (int a = 0 ; a < 5 ; a++)
	{
	    for (int b = 0 ; b < 5 ; b++)
	    {
		which [a] [b] = 0;
	    }
	}

	JLabel title = new JLabel ("Lights Out!!!");
	title.setFont (new Font ("Jokerman", Font.BOLD, 20));
	add (title);

	Panel p = new Panel (new GridLayout (5, 5));
	for (int a = 0 ; a < 5 ; a++)
	{
	    for (int b = 0 ; b < 5 ; b++)
	    {
		p.add (lv1 [a] [b]);
	    }
	}
	add (p);

	JLabel ins = new JLabel ("Click on a square to begin. Try to turn all the Lights on!");
	add (ins);

    }


    public void actionPerformed (ActionEvent e)
    {
	int i = Integer.parseInt (e.getActionCommand ());
	int c = i / 10;
	int d = i % 10;
	onoff (c, d);
	int counter = 0;
	for (int a = 0 ; a < 5 ; a++)
	{
	    for (int b = 0 ; b < 5 ; b++)
	    {
		if (which [a] [b] == 1)
		    counter++;
	    }
	}
	if (counter == 25)
	    showStatus ("YOU WON!!!");
    }


    public void onoff (int c, int d)
    {

	if (which [c] [d] == 0)
	{
	    which [c] [d] = 1;
	    lv1 [c] [d].setIcon (createImageIcon ("lighton.jpg"));
	}
	else if (which [c] [d] == 1)
	{
	    which [c] [d] = 0;
	    lv1 [c] [d].setIcon (createImageIcon ("lightoff.jpg"));
	}
	if ((c + 1) < 5 && which [c + 1] [d] == 0)
	{
	    which [c + 1] [d] = 1;
	    lv1 [c + 1] [d].setIcon (createImageIcon ("lighton.jpg"));
	}
	else if ((c + 1) < 5 && which [c + 1] [d] == 1)
	{
	    which [c + 1] [d] = 0;
	    lv1 [c + 1] [d].setIcon (createImageIcon ("lightoff.jpg"));
	}
	if ((c - 1) >= 0 && which [c - 1] [d] == 0)
	{
	    which [c - 1] [d] = 1;
	    lv1 [c - 1] [d].setIcon (createImageIcon ("lighton.jpg"));
	}
	else if ((c - 1) >= 0 && which [c - 1] [d] == 1)
	{
	    which [c - 1] [d] = 0;
	    lv1 [c - 1] [d].setIcon (createImageIcon ("lightoff.jpg"));
	}
	if ((d + 1) < 5 && which [c] [d + 1] == 0)
	{
	    which [c] [d + 1] = 1;
	    lv1 [c] [d + 1].setIcon (createImageIcon ("lighton.jpg"));
	}
	else if ((d + 1) < 5 && which [c] [d + 1] == 1)
	{
	    which [c] [d + 1] = 0;
	    lv1 [c] [d + 1].setIcon (createImageIcon ("lightoff.jpg"));
	}
	if ((d - 1) >= 0 && which [c] [d - 1] == 1)
	{
	    which [c] [d - 1] = 0;
	    lv1 [c] [d - 1].setIcon (createImageIcon ("lightoff.jpg"));
	}
	else if ((d - 1) >= 0 && which [c] [d - 1] == 0)
	{
	    which [c] [d - 1] = 1;
	    lv1 [c] [d - 1].setIcon (createImageIcon ("lighton.jpg"));
	}


    }


    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = RidingHood.class.getResource (path);
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }
}
