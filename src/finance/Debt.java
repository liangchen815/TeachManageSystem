package finance;

public class Debt {
	private String start;
	private String due;
	private String debtor;
    private double amount;
    private double interestRate;
    
    public Debt(){
    	
    }
    
    public Debt(String start , String due , String debtor , double amount , double interestRate) {
    	setStart(start);
    	setDue(due);
    	setDebtor(debtor);
    	setAmount(amount);
    	setInterestRate(interestRate);	
    }
    
    public void setStart(String start){
    	this.start = start;
    }
    
    public void setDue(String due){
    	this.due = due;
    }
    
    public void setDebtor(String debtor){
    	this.debtor = debtor;
    }
    
    public void setAmount(double amount){
    	this.amount = amount;
    }
    
    public void setInterestRate(double interestRate){
    	this.interestRate = interestRate;
    }
    
    public String getStart(){
    	return this.start;
    }
    
    public String getDue(){
    	return this.due;
    }
    
    public String getDebtor(){
    	return this.debtor;
    }
    
    public double getAmount(){
    	return this.amount;
    }
    
    public double getInterestRate(){
    	return this.interestRate;
    }
	

}
