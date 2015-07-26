package finance;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import util.DBOper;
import util.dbUtil;

public class IncomeDAOImpl extends HttpServlet implements IncomeDAO {
	
	public List<Income> findAll() throws Exception {
		
		Connection conn = dbUtil.getConnection();
		
		String sql = "select * from f_income;";
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet result = stat.executeQuery();
		
		List<Income> is = new ArrayList<Income>();
		
		while (result.next()) {
			
			Income i = new Income();
			i.setYear(result.getString("year"));
			i.setMonth(result.getString("month"));
			i.setIncome(result.getDouble("income"));
			i.setFrom(result.getString("from"));
			
			is.add(i);
			
		}
		
		dbUtil.close(conn);
		return is;
		
	}
	
	public void delete(String year , String month) throws Exception {
		
		Connection conn = dbUtil.getConnection();
		
		String sql = "delete from f_income where year=? and month=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, year);
		stat.setString(2, month);
		int n = stat.executeUpdate();
		
		dbUtil.close(conn);
		
	}
	
    public void save(Income i) throws Exception {
		
    	Connection conn = dbUtil.getConnection();
		
		String sql = "insert into f_income (year,month,income,from) values (?,?,?,?)";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1 , i.getYear());
		stat.setString(2 , i.getMonth());
		stat.setDouble(3 , i.getIncome());
		stat.setString(4 , i.getFrom());
		
		int n = stat.executeUpdate();
		
		dbUtil.close(conn);
		
	}
    
    public Income findByYM(String year , String month) throws Exception {
    	
    	Connection conn = dbUtil.getConnection();
		
		String sql = "select * from f_income where year=? and month=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, year);
		stat.setString(2, month);
		ResultSet result = stat.executeQuery();
		
		
		Income i = new Income();
		
		if (result.next()) {
						
			i.setYear(result.getString("year"));
			i.setMonth(result.getString("month"));
			i.setIncome(result.getDouble("income"));
			i.setFrom(result.getString("from"));
			
						
		}
		
		dbUtil.close(conn);
		return i;
    }
    
    public void update(Income i) throws Exception {
		
    	Connection conn = dbUtil.getConnection();
		
		String sql = "update f_income set year=?,month=?,income=?,from=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1 , i.getYear());
		stat.setString(2 , i.getMonth());
		stat.setDouble(3 , i.getIncome());
		stat.setString(4 , i.getFrom());
		
		int n = stat.executeUpdate();
		
		dbUtil.close(conn);
		
	}
    
    

}
