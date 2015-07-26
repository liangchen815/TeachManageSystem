package finance;

import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

import util.DBOper;



public class SalaryDAOImpl extends DBOper{
	
	public List<Salary> findAll()
		throws Exception{
		String sql="select * from f_salary";
		List<Salary> p=new ArrayList<Salary>();
		ResultSet rs=this.executeQuery(sql, null);
		while(rs.next()){
			Salary s=new Salary();
			s.setTno(rs.getString("Tno"));
			s.setRank(rs.getString("Rank"));
			s.setBasicSalary(rs.getDouble("BasicSalary"));
			s.setBonus(rs.getDouble("Bonus"));
			s.setAllowance(rs.getDouble("Allowance"));
			s.setSalarySum(rs.getDouble("SalarySum"));
			s.setPs(rs.getString("Ps"));
			s.setDate(rs.getString("Date"));
			p.add(s);
		}
		return p;
	}
	
	public void delete(String Tno,String Date)
		throws Exception{
		String sql="delete from f_salary where Tno=? and Date=?";
		String[] pa = new String[]{Tno,Date};
		this.executeUpdate(sql, pa);
		this.closeAll();
	}
	
	public void save(Salary s)
	    throws Exception{
		String sql="insert into f_salary(Tno,Rank,BasicSalary,Bonus,Allowance,SalarySum,Ps,Date)"
		  + "values(?,?,?,?,?,?,?,?)";
		String[] pa=new String[]{s.getTno(),s.getRank(),s.getBasicSalary()+""
				,s.getBonus()+"",s.getAllowance()+"",s.getSalarySum()+"",s.getPs(),s.getDate()};
		this.executeUpdate(sql, pa);
		this.closeAll();
    }
	
	public Salary findByTno(String Tno,String Date)
		throws Exception{
		String sql="select * from f_salary where Tno =? and Date=? ";
		String[] pa=new String[]{Tno,Date};
		Salary s=new Salary();
		ResultSet rs=this.executeQuery(sql,pa);
		while(rs.next()){
			s.setTno(rs.getString("Tno"));
			s.setRank(rs.getString("Rank"));
			s.setBasicSalary(rs.getDouble("BasicSalary"));
			s.setBonus(rs.getDouble("Bonus"));
			s.setAllowance(rs.getDouble("Allowance"));
			s.setSalarySum(rs.getDouble("SalarySum"));
			s.setPs(rs.getString("Ps"));
			s.setDate(rs.getString("Date"));
		}
		return s;
	}
	
	public Salary findByDate(String Date)
		throws Exception{
		String sql="select * from f_salary where Date=? ";
		String[] pa=new String[]{Date};
		Salary s=new Salary();
		ResultSet rs=this.executeQuery(sql,pa);
		while(rs.next()){
			s.setTno(rs.getString("Tno"));
			s.setRank(rs.getString("Rank"));
			s.setBasicSalary(rs.getDouble("BasicSalary"));
			s.setBonus(rs.getDouble("Bonus"));
			s.setAllowance(rs.getDouble("Allowance"));
			s.setSalarySum(rs.getDouble("SalarySum"));
			s.setPs(rs.getString("Ps"));
			s.setDate(rs.getString("Date"));
		}
		return s;
	}

	public void update(String Tno,String Date)
		throws Exception{
		String sql="update f_salary "+"set Rank=?,BasicSalary=?,Bonus=?,Allowance=?,SalarySum=?,Ps=?"
		+"where Tno=? and Date=?";
			String[] pa=new String[]{Tno,Date};
			this.executeUpdate(sql, pa);
			this.closeAll();
	}
}
