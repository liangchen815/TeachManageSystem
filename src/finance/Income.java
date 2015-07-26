package finance;

public class Income {
	private String year;
	private String month;
	private double income;
    private String from;
 
    
    public Income(){
    	
    }
    
    public Income(String year , String month , double income , String from , boolean anticipated) {
    	setYear(year);
    	setMonth(month);
    	setIncome(income);
    	setFrom(from);
    		
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
    
    public void setFrom(String from){
    	this.from = from;
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
    
    public String getFrom(){
    	return this.from;
    }
    
    
	

}
