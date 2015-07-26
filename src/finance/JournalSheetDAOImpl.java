package finance;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.*;

public class JournalSheetDAOImpl implements JournalSheetDAO {
	
	//DBOper dbo = new DBOper();
	//ServletContext ctx=this.getServletContext();
	//String server=ctx.getInitParameter("server");
	//String dbname=ctx.getInitParameter("dbname");
	//String dbuser=ctx.getInitParameter("user");
	//String pwd=ctx.getInitParameter("pwd");
	
	public List<JournalSheet> findAll() throws Exception {
		
		//Connection conn = dbo.getConn(server , dbname , dbuser , pwd);
		Connection conn = dbUtil.getConnection();
		
		String sql = "select * from f_journalSheet;";
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet result = stat.executeQuery();
		
		List<JournalSheet> jss = new ArrayList<JournalSheet>();
		
		while (result.next()) {
			
			JournalSheet js = new JournalSheet();
			js.setYear(result.getString("year"));
			js.setMonth(result.getString("month"));
			js.setIncome(result.getDouble("income"));
			js.setExpense(result.getDouble("expense"));
			js.setDebt(result.getDouble("debt"));
			js.setCredit(result.getDouble("credit"));
			js.setDeposit(result.getDouble("deposit"));
			js.setAnticipated(result.getBoolean("anticipated"));
			jss.add(js);
			
		}
		
		//dbo.closeAll();
		dbUtil.close(conn);
		return jss;
		
	}
	
	public void delete(String year , String month) throws Exception {
		
		//Connection conn = dbo.getConn(server , dbname , dbuser , pwd);
		Connection conn = dbUtil.getConnection();
		
		String sql = "delete from f_journalSheet where year=? and month=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, year);
		stat.setString(2, month);
		int n = stat.executeUpdate();
		
		//dbo.closeAll();
		dbUtil.close(conn);
		
	}
	
    public void save(JournalSheet js) throws Exception {
		
    	//Connection conn = dbo.getConn(server , dbname , dbuser , pwd);
		Connection conn = dbUtil.getConnection();
		
		String sql = "insert into f_journalSheet (year,month,income,expense,debt,credit,deposit,anticipated) values (?,?,?,?,?,?,?,?)";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1 , js.getYear());
		stat.setString(2 , js.getMonth());
		stat.setDouble(3 , js.getIncome());
		stat.setDouble(4 , js.getExpense());
		stat.setDouble(5 , js.getDebt());
		stat.setDouble(6 , js.getCredit());
		stat.setDouble(7 , js.getDeposit());
		stat.setBoolean(8 , js.getAnticipated());
		int n = stat.executeUpdate();
		
		//dbo.closeAll();
		dbUtil.close(conn);
		
	}
    
    public JournalSheet findByYM(String year , String month) throws Exception {
    	
    	//Connection conn = dbo.getConn(server , dbname , dbuser , pwd);
		Connection conn = dbUtil.getConnection();
		
		String sql = "select * from f_journalSheet where year=? and month=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, year);
		stat.setString(2, month);
		ResultSet result = stat.executeQuery();
		
		
		JournalSheet js = new JournalSheet();
		
		if (result.next()) {
						
			js.setYear(result.getString("year"));
			js.setMonth(result.getString("month"));
			js.setIncome(result.getDouble("income"));
			js.setExpense(result.getDouble("expense"));
			js.setDebt(result.getDouble("debt"));
			js.setCredit(result.getDouble("credit"));
			js.setDeposit(result.getDouble("deposit"));
			js.setAnticipated(result.getBoolean("anticipated"));
						
		}
		
		//dbo.closeAll();
		dbUtil.close(conn);
		return js;
    }
    
    public void update(JournalSheet js) throws Exception {
		
    	//Connection conn = dbo.getConn(server , dbname , dbuser , pwd);
		Connection conn = dbUtil.getConnection();
		
		String sql = "update f_journalSheet set year=?,month=?,income=?,expense=?,debt=?,credit=?,deposit=?,anticipated=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1 , js.getYear());
		stat.setString(2 , js.getMonth());
		stat.setDouble(3 , js.getIncome());
		stat.setDouble(4 , js.getExpense());
		stat.setDouble(5 , js.getDebt());
		stat.setDouble(6 , js.getCredit());
		stat.setDouble(7 , js.getDeposit());
		stat.setBoolean(8 , js.getAnticipated());
		int n = stat.executeUpdate();
		
		//dbo.closeAll();
		dbUtil.close(conn);
		
	}
    
    

}
