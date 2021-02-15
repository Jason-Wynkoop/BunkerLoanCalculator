import java.awt.*;
import javax.swing.*;

/**
 * A panel that holds the header in the Norther part
 * of the frame (LoanCalculateGUI)
 */
class Header extends JPanel {

	public Header(){
		
		setLayout(new FlowLayout());		
		
		//Creates Bunker Loan Calculator Label
		JLabel BunkerLoanCalc = new JLabel("BUNKER LOAN CALCULATOR", SwingConstants.CENTER);
		BunkerLoanCalc.setFont(new Font("Source Code Pro", Font.PLAIN, 30));
		
		//Sets foreground and background colors
		BunkerLoanCalc.setForeground(Color.YELLOW);
		setBackground(Color.GRAY);
		
		//Add to panel
		add(BunkerLoanCalc);
		
	}

}