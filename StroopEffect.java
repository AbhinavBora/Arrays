import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
public class StroopEffect extends Applet implements ActionListener
{
    JLabel word;
    int num1 = (int) (Math.random () * 7) + 0;
    int num2 = (int) (Math.random () * 7) + 0;
    String name[] = {"Black", "Blue", "Cyan", "Green", "Magenta", "Orange", "Red", "Yellow"};
    Color colours[] = {Color.black, Color.blue, Color.cyan, Color.green, Color.magenta, Color.orange, Color.red, Color.yellow};

    public void init ()
    {
	resize (500, 200);

	JLabel ins = new JLabel ("Call out the COLOUR, not the word");
	add (ins);

	word = new JLabel ("Magenta");
	word.setForeground (Color.green);
	word.setFont (new Font ("Arial", Font.BOLD, 100));
	add (word);

	JButton clue = new JButton ("New Clue");
	clue.addActionListener(this);
	clue.setActionCommand("clue");
	add (clue);

    }


    public void random ()
    {
	num1 = (int) (Math.random () * 7) + 0;
	num2 = (int) (Math.random () * 7) + 0;
	while (num1 == num2)
	    num2 = (int) (Math.random () * 7) + 0;
    }


    public void actionPerformed (ActionEvent e)
    {
	random ();
	word.setForeground (colours[num1]);
	word.setText (name[num2]);
    }



}
