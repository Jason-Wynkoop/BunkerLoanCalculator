/**
 * Does the calculations needed for the total
 * loan amount, monthly payment, and ending total
 */
class BunkerLoanInfo {

	//Loan Term Panel
	private double loanTerm;
	private double loanRate;
	
	//Financing Information panel
	private double basePrice;
	private double downPayment;
	private double salesTax;
	
	//Price with Options panel
	private Double totalOptions;
	
	//Constructor
	public BunkerLoanInfo(){
		
		loanTerm = 0.045;
		salesTax = 0.07;
		totalOptions = 1200.0;

	}

	//Gets Loan Term and returns it where called
	private double getLoanTerm(){

		return(loanTerm);
	}
	
	//Sets Loan Term and allows it to be retrieved
	public void setLoanTerm(double lT){

		loanTerm = lT;
	}
	
	//Sets Loan Rate and allows it to be retrieved
	public void setLoanRate(double lR){
		
		loanRate = lR;

	}

	
	//Sets Base Price and allows it to be retrieved
	public void setBasePrice(double bP){
		
		basePrice = bP;
	}

	//Gets DownPayment and returns it where called
	private double getDownPayment(){

		return(downPayment);
	}
	
	//Sets Down Payment and allows it to be retrieved
	public void setDownPayment(double dP){

		downPayment = dP;
	}
	
	//Sets Sales Tax and allow sit to be retrieved
	public void setSalesTax(double sT){
		
		salesTax = sT /100;
	}

	
	//Sets Price with Options and allows it to be retrieved
	public void setPWO(double pwo){
		
		totalOptions = pwo;

	}
	
	//Calculates Sales Tax Amount
	private double calculateSalesTaxAmount(){

		return((basePrice - downPayment + totalOptions) * salesTax);
	}
	
	//Calculates Loan Amount
	public double calculateLoanAmount(){

		return(basePrice - downPayment + totalOptions + calculateSalesTaxAmount());
	}
	
	//Calculates Monthly Payment
	public double calculateMonthlyPayment(){

		return(calculateLoanAmount() * (loanRate / 12) / (1 - (Math.pow(1 / (1 + (loanRate / 12)), loanTerm))));
	}
	
	//Calculates Total Payment
	public double calculateTotalPayment(){

		return(calculateMonthlyPayment() * getLoanTerm() + getDownPayment());
	}

}