package finance;

public class funding {
	private String ResearchId;
    private String ResearchName;
    private String Tno;
    private String RealAmount;
    private String Year;
    private String Month;
    private String Expense;
    private String r1;
    private String r2;
    private String r3;
    private String r4;
    private String r5;
    
    public funding(){
    	
    }

    public funding(String ResearchId,String ResearchName,String Tno,String RealAmount,String Year,String Month,String Expense,String cailiao,String shebei,String ziliao,String jiaotong,String bangong){
    	setTno(Tno);
    	setResearchId(ResearchId);
    	setResearchName(ResearchName);
    	setRealAmount(RealAmount);
    	setYear(Year);
    	setMonth(Month);
    	setExpense(Expense);
    	setr1(cailiao);
    	setr2(shebei);
    	setr3(ziliao);
    	setr4(jiaotong);
    	setr5(bangong);
    }
    public String getTno(){return Tno;}
    public void setTno(String Tno){this.Tno=Tno;}
    
    public String getResearchId(){return ResearchId;}
    public void setResearchId(String ResearchId){this.ResearchId=ResearchId;}
    
    public String getResearchName(){return ResearchName;}
    public void setResearchName(String ResearchName){this.ResearchName=ResearchName;}
    
    public String getRealAmount(){return RealAmount;}
    public void setRealAmount(String RealAmount){this.RealAmount=RealAmount;}
    
    public String getYear(){return Year;}
    public void setYear(String Year){this.Year=Year;}
    
    public String getMonth(){return Month;}
    public void setMonth(String Month){this.Month=Month;}
    
    public String getExpense(){return Expense;}
    public void setExpense(String Expense){this.Expense=Expense;}

	public String getr1(){return r1;}
	public void setr1(String r1){this.r1=r1;}
	
	public String getr2(){return r2;}
	public void setr2(String r2){this.r2=r2;}
	
	public String getr3(){return r3;}
	public void setr3(String r3){this.r3=r3;}
	
	public String getr4(){return r4;}
	public void setr4(String r4){this.r4=r4;}
	
	public String getr5(){return r5;}
	public void setr5(String r5){this.r5=r5;}
	
	
}
