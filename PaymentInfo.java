import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * Payment Information panel that holds
 * payment information
 */
class PaymentInfo extends JPanel {

	private final JLabel totalLoanAmount;
	private final JLabel monthlyPaymentAmount;
	private final JLabel totalPaymentAmount;
	private final DecimalFormat df = new DecimalFormat("$#,##0.00");
	
	
	public PaymentInfo(){
		
		setLayout(new GridLayout(3,3));
		
		//Creates labels that will hold the amounts
		JLabel totalLoan = new JLabel("Total Loan Amount:");
		totalLoanAmount = new JLabel("$0.00", SwingConstants.CENTER);

		JLabel monthlyPayment = new JLabel("Monthly Payment:");
		monthlyPaymentAmount = new JLabel("$0.00", SwingConstants.CENTER);

		JLabel totalPayment = new JLabel("Total Payment:");
		totalPaymentAmount = new JLabel("$0.00", SwingConstants.CENTER);
		
		//Adds labels to panel
		add(totalLoan);
		add(totalLoanAmount);
		add(monthlyPayment);
		add(monthlyPaymentAmount);
		add(totalPayment);
		add(totalPaymentAmount);
		
		//Creates Border
		setBorder(BorderFactory.createTitledBorder("Payment Information"));		
		
	}
	
	public void setTLA(String i){
		
		totalLoanAmount.setText(i);

	}
	
	public void setTMP(String i){
		
		monthlyPaymentAmount.setText(i);

	}
	
	public void setTPA(String i){
		
		totalPaymentAmount.setText(i);
	}
	
	public void reset(){
		totalPaymentAmount.setText(df.format(0));
		monthlyPaymentAmount.setText(df.format(0));
		totalLoanAmount.setText(df.format(0));
	}

}