import javax.swing.*;

/**
 * Creates a frame and calls a instance of combined panels
 * and sets the size, title, and close operation
 */
class LoanCalculateGUI extends JFrame {

	public LoanCalculateGUI(){
		
		//Adds combined panels object
		CombinedPanels CP = new CombinedPanels();
		
		//Sets title
		setTitle("BunkerTech LLC");
		int height = 500;
		int width = 700;
		setSize(width, height);
		//Sets close operation
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//setLayout(new FlowLayout());
		setLocationRelativeTo(null);

		//Adds combined panels to frame
		add(CP);

	}

}