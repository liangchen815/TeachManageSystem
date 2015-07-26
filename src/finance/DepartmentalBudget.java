package finance;

public class DepartmentalBudget {
	private String year;
	private String month;
	private double income;
    private double expense;
    private double debt;
    private double credit;
    private String department;
    private boolean adjustment;
    
    
    public DepartmentalBudget(){
    	
    }
    
    public DepartmentalBudget(String year , String month , double income , double expense , double debt , double credit , String department) {
    	setYear(year);
    	setMonth(month);
    	setIncome(income);
    	setExpense(expense);
    	setDebt(debt);
    	setCredit(credit);
    	setDepartment(department);	
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
    
    public void setDepartment(String department){
    	this.department = department;
    }
    
    public void setAdjustment(boolean adjustment){
    	this.adjustment = adjustment;
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
    
    public String getDepartment(){
    	return this.department;
    }
    
    public boolean getAdjustment(){
    	return this.adjustment;
    }

}
