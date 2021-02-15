import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Holds the Calculate, Reset, and Exit buttons
 * at the bottom of the frame
 */
class ActionButtons extends JPanel {

	public ActionButtons(ActionListener e){
		
		setLayout(new GridLayout(1,0,0,0));
		
		//Creates buttons
		JButton calculate = new JButton("Calculate");
		JButton reset = new JButton("Reset");
		JButton exit = new JButton("Exit");

		//Adds listener to each button
		calculate.addActionListener(e);
		reset.addActionListener(e);
		exit.addActionListener(e);
	
		//Adds buttons to panel
		add(calculate);
		add(reset);
		add(exit);

	}

		
}
