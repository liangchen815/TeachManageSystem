package finance;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import util.DBOper;

public class ExpenseDAOImpl extends HttpServlet implements ExpenseDAO {
	
	DBOper dbo = new DBOper();
	ServletContext ctx=this.getServletContext();
	String server=ctx.getInitParameter("server");
	String dbname=ctx.getInitParameter("dbname");
	String dbuser=ctx.getInitParameter("user");
	String pwd=ctx.getInitParameter("pwd");
	
	public List<Expense> findAll() throws Exception {
		
		Connection conn = dbo.getConn(server , dbname , dbuser , pwd);
		
		String sql = "select * from f_expense;";
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet result = stat.executeQuery();
		
		List<Expense> is = new ArrayList<Expense>();
		
		while (result.next()) {
			
			Expense i = new Expense();
			i.setYear(result.getString("year"));
			i.setMonth(result.getString("month"));
			i.setExpense(result.getDouble("Expense"));
			i.setFor(result.getString("for"));
			i.setAnticipated(result.getBoolean("anticipated"));
			is.add(i);
			
		}
		
		dbo.closeAll();
		return is;
		
	}
	
	public void delete(String year , String month) throws Exception {
		
        Connection conn = dbo.getConn(server , dbname , dbuser , pwd);
		
		String sql = "delete from f_expense where year=? and month=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, year);
		stat.setString(2, month);
		int n = stat.executeUpdate();
		
		dbo.closeAll();
		
	}
	
    public void save(Expense i) throws Exception {
		
        Connection conn = dbo.getConn(server , dbname , dbuser , pwd);
		
		String sql = "insert into f_expense (year,month,Expense,for,anticipated) values (?,?,?,?,?)";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1 , i.getYear());
		stat.setString(2 , i.getMonth());
		stat.setDouble(3 , i.getExpense());
		stat.setString(4 , i.getFor());
		stat.setBoolean(5 , i.getAnticipated());
		int n = stat.executeUpdate();
		
		dbo.closeAll();
		
	}
    
    public Expense findByYM(String year , String month) throws Exception {
    	
        Connection conn = dbo.getConn(server , dbname , dbuser , pwd);
		
		String sql = "select * from f_expense where year=? and month=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, year);
		stat.setString(2, month);
		ResultSet result = stat.executeQuery();
		
		
		Expense i = new Expense();
		
		if (result.next()) {
						
			i.setYear(result.getString("year"));
			i.setMonth(result.getString("month"));
			i.setExpense(result.getDouble("Expense"));
			i.setFor(result.getString("for"));
			i.setAnticipated(result.getBoolean("anticipated"));
						
		}
		
		dbo.closeAll();
		return i;
    }
    
    public void update(Expense i) throws Exception {
		
        Connection conn = dbo.getConn(server , dbname , dbuser , pwd);
		
		String sql = "update f_expense set year=?,month=?,Expense=?,for=?anticipated=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1 , i.getYear());
		stat.setString(2 , i.getMonth());
		stat.setDouble(3 , i.getExpense());
		stat.setString(4 , i.getFor());
		stat.setBoolean(5 , i.getAnticipated());
		int n = stat.executeUpdate();
		
		dbo.closeAll();
		
	}
    
    

}
