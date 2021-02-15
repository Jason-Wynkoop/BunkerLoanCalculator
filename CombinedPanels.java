import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Combined Panels is a panel in the center of the
 * GUI that holds for other panels (PaymentInfo, OptionsPanel,
 * Loan Term, and FinanceInfo)
 */
class CombinedPanels extends JPanel {

	private final PaymentInfo paymentInfo;
	private final LoanTerm loanTerm;
	private final FinanceInfo financeInfo;
	private final OptionsPanel optionsPanel;
	private final BunkerLoanInfo bunkerLoanInfo;

	public CombinedPanels(){
		
		setLayout(new BorderLayout());

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,2));
		
		//Creates instance of BunkerLoanInfo
		bunkerLoanInfo = new BunkerLoanInfo();
		
		//Creates instances of all the panels
		Header head = new Header();
		paymentInfo = new PaymentInfo();
		loanTerm = new LoanTerm(new LoanTermListener());
		financeInfo = new FinanceInfo();
		optionsPanel = new OptionsPanel();
		ActionButtons actionButtons = new ActionButtons(new ActionButtonListener());

		//Adds particular panels to a combined panel
		center.add(paymentInfo);
		center.add(loanTerm);
		center.add(financeInfo);
		center.add(optionsPanel);
		
		//Adds panels to appropriate location
		add(head, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(actionButtons, BorderLayout.SOUTH);
		
		//Sends values from panel components to BunkerInfoLoan
		bunkerLoanInfo.setPWO(optionsPanel.getPWO());
		bunkerLoanInfo.setBasePrice(Double.parseDouble(financeInfo.getBasePrice()));
		bunkerLoanInfo.setDownPayment(Double.parseDouble(financeInfo.getDownPayment()));
		bunkerLoanInfo.setSalesTax(Double.parseDouble(financeInfo.getSalesTax()));
		bunkerLoanInfo.setLoanRate(loanTerm.getLoanRate());
		bunkerLoanInfo.setLoanTerm(loanTerm.getLoanTerm());
		
	}
	
private class LoanTermListener implements ActionListener{
			
		
		public void actionPerformed(ActionEvent e){
			
			
			//Sets loanRate and loanTerm depending on what radio button is selected
			if(e.getActionCommand().equals("24 Months - Interest Rate of 4.5%")){
				
				loanTerm.setLoanRate(0.045);
				loanTerm.setLoanTerm(24.0);
	
			}
			
			else if(e.getActionCommand().equals("36 Months - Interest Rate of 5.5%")){
				
				loanTerm.setLoanRate(0.055);
				loanTerm.setLoanTerm(36.0);

			}
			
			else if(e.getActionCommand().equals("48 Months - Interest Rate of 6.5%")){
				
				loanTerm.setLoanRate(0.065);
				loanTerm.setLoanTerm(48.0);

			}
			
			else if(e.getActionCommand().equals("60 Months - Interest Rate of 7.0%")){
				
				loanTerm.setLoanRate(0.07);
				loanTerm.setLoanTerm(60.0);

			}
			
		}
		
	}

	private class ActionButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand().equals("Reset")) {

				paymentInfo.reset();

				loanTerm.setLoanTerm();

				financeInfo.setBasePrice();
				financeInfo.setDownPayment();
				financeInfo.setSalesTax();

				optionsPanel.setPWO();
			} else if (e.getActionCommand().equals("Exit")) {

				System.exit(0);

			} else if (e.getActionCommand().equals("Calculate")) {

				DecimalFormat df = new DecimalFormat("$#,##0.00");

				double loanAmount;
				double monthlyPayment;
				double totalPayment;

				bunkerLoanInfo.setPWO(optionsPanel.getPWO());
				bunkerLoanInfo.setBasePrice(Double.parseDouble(financeInfo.getBasePrice()));
				bunkerLoanInfo.setDownPayment(Double.parseDouble(financeInfo.getDownPayment()));
				bunkerLoanInfo.setSalesTax(Double.parseDouble(financeInfo.getSalesTax()));
				bunkerLoanInfo.setLoanRate(loanTerm.getLoanRate());
				bunkerLoanInfo.setLoanTerm(loanTerm.getLoanTerm());

				loanAmount = bunkerLoanInfo.calculateLoanAmount();
				monthlyPayment = bunkerLoanInfo.calculateMonthlyPayment();
				totalPayment = bunkerLoanInfo.calculateTotalPayment();

				paymentInfo.setTMP(String.valueOf(df.format(monthlyPayment)));
				paymentInfo.setTLA(String.valueOf(df.format(loanAmount)));
				paymentInfo.setTPA(String.valueOf(df.format(totalPayment)));

			}

		}

	}
	
}
