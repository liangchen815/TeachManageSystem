package finance;

public class Salary {
	private String Tno;
	private String Rank;
	private Double BasicSalary;
	private Double Bonus;
	private Double Allowance;
	private Double SalarySum;
	private String Ps;
	private String Date;
	public String getTno(){return Tno;}
	public void setTno (String Tno){this.Tno=Tno;}
	public String getRank(){return Rank;}
	public void setRank(String rank){this.Rank=rank;}
	public Double getBasicSalary(){return BasicSalary;}
	public void setBasicSalary(double BasicSalary){this.BasicSalary=BasicSalary;}
	public Double getBonus(){return Bonus;}
	public void setBonus(double Bonus){this.Bonus=Bonus;}
	public Double getAllowance(){return Allowance;}
	public void setAllowance(double Allowance){this.Allowance=Allowance;}
	public Double getSalarySum(){return SalarySum;}
	public void setSalarySum(double SalarySum){this.SalarySum=SalarySum;}
	public String getPs(){return Ps;}
	public void setPs (String Ps){this.Ps=Ps;}
	public String getDate(){return Date;}
	public void setDate (String Date){this.Date=Date;}
}