import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
public class RidingHood extends Applet implements ActionListener
{
    JLabel pic;
    JLabel line;
    int counter = 0;
    String story[] = new String [11];
    public void init ()
    {
	resize (875, 400);

	JLabel title = new JLabel ("Little Red Riding Hood");
	title.setFont (new Font ("Jokerman", Font.BOLD, 20));
	title.setForeground (Color.red);

	story [0] = "Once upon a time, Little Red Riding Hood went to visit her sick grandmother.";
	story [1] = "She walked through the woods and over bridges.";
	story [2] = "After a while, she met a wolf who tricked her into picking flowers for her grandmother.";
	story [3] = "The wolf ran ahead and ate her sick grandmother, then he disguised himself.";
	story [4] = "When Red arrived, she was puzzled. She said, \"Grandmother, what big ears you have!\".";
	story [5] = "Then Red said, \"Grandmother, what sharp teeth you have!\" and the wolf ate her.";
	story [6] = "Full, the wolf went to sleep and snored loudly. A nearby woodcutter heard him.";
	story [7] = "When the woodcutter came to investigate, he noticed a scarf coming out of the wolf's mouth.";
	story [8] = "The scarf was from the grandmother's knitting in the wolf's stomach.";
	story [9] = "The woodcutter pulled Little Red Riding Hood and her Grandmother free!";
	story [10] = "The wolf was put in prison and everybody else lived happily ever after. The End.";

	pic = new JLabel (createImageIcon ("red1.jpg"));

	line = new JLabel (story [0]);

	JButton next = new JButton ("Next");
	next.addActionListener (this);
	next.setActionCommand ("next");

	Panel p = new Panel (new GridLayout (2, 1));
	Panel p2 = new Panel (new GridLayout (2, 1));

	p2.add (title);
	p2.add (pic);
	p.add (line);
	p.add (next);
	add (p2);
	add (p);



    }


    public void actionPerformed (ActionEvent e)
    {
	counter++;
	if (counter >= 11)
	    counter = 0;
	pic.setIcon (createImageIcon ("red" + (counter + 1) + ".jpg"));
	line.setText (story [counter]);
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
