import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * creates a new panel that holds the loan terms
 * and there interest rates for each term
 */
@SuppressWarnings("ALL")
class LoanTerm extends JPanel {

	private final JRadioButton twentyFour;
	private double loanTerm;
	private double loanRate;

	/**
	 *
	 * @param e
	 */
	public LoanTerm(ActionListener e){
		
		setLayout(new GridLayout(4,1));
		
		//Creates Radio Buttons
		twentyFour = new JRadioButton("24 Months - Interest Rate of 4.5%", true);
		JRadioButton thirtySix = new JRadioButton("36 Months - Interest Rate of 5.5%");
		JRadioButton fourtyEight = new JRadioButton("48 Months - Interest Rate of 6.5%");
		JRadioButton sixty = new JRadioButton("60 Months - Interest Rate of 7.0%");
		
		//Adds them to button group
		ButtonGroup bg = new ButtonGroup();
		bg.add(twentyFour);
		bg.add(thirtySix);
		bg.add(fourtyEight);
		bg.add(sixty);
		
		twentyFour.addActionListener(e);
		thirtySix.addActionListener(e);
		fourtyEight.addActionListener(e);
		sixty.addActionListener(e);
		
		//Adds them to panel
		add(twentyFour);
		add(thirtySix);
		add(fourtyEight);
		add(sixty);
		
		//Creates Border
		setBorder(BorderFactory.createTitledBorder("Loan Term"));
		
	}

	public void setLoanRate(double lr){
		
		loanRate = lr;
	}

	public void setLoanTerm(double lt){
		
		loanTerm = lt;		
	}

	public double getLoanRate(){
		
		return(loanRate);
	}

	public double getLoanTerm(){
		
		return(loanTerm);
	}

	public void setLoanTerm(){
		
		twentyFour.setSelected(true);
	}
	
}