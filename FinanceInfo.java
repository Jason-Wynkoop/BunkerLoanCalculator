import javax.swing.*;
import java.awt.*;

/**
 * A Panel that holds the base price,
 * down payment, and sales tax
 */
class FinanceInfo extends JPanel {

	private final JTextField bP;
	private final JTextField dP;
	private final JTextField sT;

	public FinanceInfo(){
		
		setLayout(new GridLayout(3,2));
		
		//Creates labels and text-fields
		JLabel basePrice = new JLabel("Base Contract Price:");
		bP = new JTextField("0.00");

		JLabel dPay = new JLabel("Down Payment:");
		dP = new JTextField("0.00");

		JLabel salesTax = new JLabel("Sales Tax Percentage:");
		sT = new JTextField("7.00");
		
		//Adds them to panel
		add(basePrice);
		add(bP);
		add(dPay);
		add(dP);
		add(salesTax);
		add(sT);
		
		//Creates border
		setBorder(BorderFactory.createTitledBorder("Financing Information"));

	}
	
	//Allows base price to be retrieved
	public String getBasePrice(){
		
		return(bP.getText());		
	}
	
	//Allows down payment to be retrieved
	public String getDownPayment(){
		
		return(dP.getText());
	}
	
	//Allows sales tax to be retrieved
	public String getSalesTax(){
		
		return(sT.getText());
	}
	
	public void setBasePrice(){
		
		bP.setText("0.00");
	}
	
	public void setDownPayment(){
		
		dP.setText("0.00");
	}
	
	public void setSalesTax(){
		
		sT.setText("7.00");
	}

}