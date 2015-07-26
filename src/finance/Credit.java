package finance;

public class Credit {
	private String start;
	private String due;
	private String lender;
    private double amount;
    private double interestRate;
    
    public Credit(){
    	
    }
    
    public Credit(String start , String due , String lender , double amount , double interestRate) {
    	setStart(start);
    	setDue(due);
    	setLender(lender);
    	setAmount(amount);
    	setInterestRate(interestRate);	
    }
    
    public void setStart(String start){
    	this.start = start;
    }
    
    public void setDue(String due){
    	this.due = due;
    }
    
    public void setLender(String lender){
    	this.lender = lender;
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
    
    public String getLender(){
    	return this.lender;
    }
    
    public double getAmount(){
    	return this.amount;
    }
    
    public double getInterestRate(){
    	return this.interestRate;
    }
	

}
