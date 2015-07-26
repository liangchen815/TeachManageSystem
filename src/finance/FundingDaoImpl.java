package finance;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import finance.funding;

import util.DBOper;

public class FundingDaoImpl extends DBOper{


public funding findByDate(String Year, String Month) throws Exception{
	String sql="select * from f_research where Year=? and Month=?";
	String[] fund=new String[]{Year,Month};
	ResultSet rsfund=this.executeQuery(sql,fund);
	funding f=null;
	if(rsfund.next()){
		f=new funding();
		f.setYear(Year);
		f.setMonth(Month);
		f.setr1(rsfund.getString("r1"));
		f.setr2(rsfund.getString("r2"));
		f.setr3(rsfund.getString("r3"));
		f.setr4(rsfund.getString("r4"));
		f.setr5(rsfund.getString("r5"));
	}
	this.closeAll();
	return f;
}

public funding findByDate2(String Year,String Month) throws Exception{
	String sql="select * from f_funding where Year=? and Month=?";
	String[] date=new String[]{Year,Month};
	ResultSet rsdate=this.executeQuery(sql, date);
	funding d=null;
	if(rsdate.next()){
		d=new funding();
		d.setYear(Year);
		d.setMonth(Month);
		d.setResearchId(rsdate.getString("ResearchId"));
		d.setResearchName(rsdate.getString("ResearchName"));
		d.setTno(rsdate.getString("Tno"));
		d.setRealAmount(rsdate.getString("RealAmount"));
		d.setExpense(rsdate.getString("Expense"));
		d.setr1(rsdate.getString("r1"));
		d.setr2(rsdate.getString("r2"));
		d.setr3(rsdate.getString("r3"));
		d.setr4(rsdate.getString("r4"));
		d.setr5(rsdate.getString("r5"));
	}
	this.closeAll();
	return d;
}

    public int update(funding f) throws Exception{
    	int u=0;
    	String sql="update f_funding set ResearchId=?,ResearchName=?,Tno=?,RealAmount=?,Year=?,Month=?,Expense=?,r1=?,r2=?,r3=?,r4=? and r5=?";
    	String[] up=new String[]{f.getResearchId(),f.getResearchName(),f.getTno(),f.getRealAmount(),f.getYear(),f.getMonth(),f.getExpense(),f.getr1(),f.getr2(),f.getr3(),f.getr4(),f.getr5()};
    	this.executeUpdate(sql, up);
    	this.closeAll();
    	return u;
    }


	public int save(funding s) throws Exception{
		int i=0;
		String sql="insert into f_funding(ResearchId,ResearchName,Tno,RealAmount,Year,Month,Expense,r1,r2,r3,r4,r5) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		String[] fund=new String[]{ s.getResearchId(),s.getResearchName(),s.getTno(),s.getRealAmount(),s.getYear(),s.getMonth(),s.getExpense(),s.getr1(),
				s.getr2(),s.getr3(),s.getr4(),s.getr5()};
		i=this.executeUpdate(sql, fund);
		this.closeAll();
		return i;
	}
}
