package finance;

public class JournalSheet {
	private String year;
	private String month;
	private double income;
    private double expense;
    private double debt;
    private double credit;
    private double deposit;
    private boolean anticipated;
    
    public JournalSheet(){
    	
    }
    
    public JournalSheet(String year , String month , double income , double expense , double debt , double credit , double deposit , boolean anticipated) {
    	setYear(year);
    	setMonth(month);
    	setIncome(income);
    	setExpense(expense);
    	setDebt(debt);
    	setCredit(credit);
    	setDeposit(deposit);
    	setAnticipated(anticipated);	
    }
    
    public void setYear(String year){
    	this.year = year;
    }
    
    public void setMonth(String month){
    	this.month = month;
    }
    
    public void setIncome(double income){
    	this.income = income;
    }
    
    public void setExpense(double expense){
    	this.expense = expense;
    }
    
    public void setDebt(double debt){
    	this.debt = debt;
    }
    
    public void setCredit(double credit){
    	this.credit = credit;
    }
    
    public void setDeposit(double deposit){
    	this.deposit = deposit;
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
    
    public double getIncome(){
    	return this.income;
    }
    
    public double getExpense(){
    	return this.expense;
    }
    
    public double getDebt(){
    	return this.debt;
    }
    
    public double getCredit(){
    	return this.credit;
    }
    
    public double getDeposit(){
    	return this.deposit;
    }
    
    public boolean getAnticipated(){
    	return this.anticipated;
    }
	

}
