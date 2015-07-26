package finance;

public class Expense {
	private String year;
	private String month;
	private double expense;
    private String ffor;
    private boolean anticipated;
    
    public Expense(){
    	
    }
    
    public Expense(String year , String month , double expense , String ffor , boolean anticipated) {
    	setYear(year);
    	setMonth(month);
    	setExpense(expense);
    	setFor(ffor);
    	setAnticipated(anticipated);	
    }
    
    public void setYear(String year){
    	this.year = year;
    }
    
    public void setMonth(String month){
    	this.month = month;
    }
    
    public void setExpense(double expense){
    	this.expense = expense;
    }
    
    public void setFor(String ffor){
    	this.ffor = ffor;
    }
    
    public void setAnticipated(boolean anticipated){
    	this.anticipated = anticipated;
    }
    
    public String getYear(){
    	return this.year;
    }
    
    public String getMonth(){
    	return this.month;
    }
    
    public double getExpense(){
    	return this.expense;
    }
    
    public String getFor(){
    	return this.ffor;
    }
    
    public boolean getAnticipated(){
    	return this.anticipated;
    }
	

}
