package finance;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import util.DBOper;

public class CreditDAOImpl extends HttpServlet implements CreditDAO {
	
	DBOper dbo = new DBOper();
	ServletContext ctx=this.getServletContext();
	String server=ctx.getInitParameter("server");
	String dbname=ctx.getInitParameter("dbname");
	String dbuser=ctx.getInitParameter("user");
	String pwd=ctx.getInitParameter("pwd");
	
	public List<Credit> findAll() throws Exception {
		
		Connection conn = dbo.getConn(server , dbname , dbuser , pwd);
		
		String sql = "select * from f_credit;";
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet result = stat.executeQuery();
		
		List<Credit> Credits = new ArrayList<Credit>();
		
		while (result.next()) {
			
			Credit c = new Credit();
			c.setStart(result.getString("start"));
			c.setDue(result.getString("due"));
			c.setLender(result.getString("lender"));
			c.setAmount(result.getDouble("amount"));
			c.setInterestRate(result.getDouble("interestRate"));
			Credits.add(c);
			
		}
		
		dbo.closeAll();
		return Credits;
		
	}
	
	public void delete(int serialNo) throws Exception {
		
        Connection conn = dbo.getConn(server , dbname , dbuser , pwd);
		
		String sql = "delete from f_credit where serialNo=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, serialNo);
		int n = stat.executeUpdate();
		
		dbo.closeAll();
		
	}
	
    public void save(Credit c) throws Exception {
		
        Connection conn = dbo.getConn(server , dbname , dbuser , pwd);
		
		String sql = "insert into f_credit (start,due,lender,amount,interestRate) values (?,?,?,?,?)";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1 , c.getStart());
		stat.setString(2 , c.getDue());
		stat.setString(3 , c.getLender());
		stat.setDouble(4 , c.getAmount());
		stat.setDouble(5 , c.getInterestRate());
		int n = stat.executeUpdate();
		
		dbo.closeAll();
		
	}
    
    public Credit findBySerialNo(int SerialNo) throws Exception {
    	
        Connection conn = dbo.getConn(server , dbname , dbuser , pwd);
		
		String sql = "select * from f_credit where name=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1 , SerialNo);
		ResultSet result = stat.executeQuery();
		
		
		Credit c = new Credit();
		
		if (result.next()) {
						
			c.setStart(result.getString("start"));
			c.setDue(result.getString("due"));
			c.setLender(result.getString("lender"));
			c.setAmount(result.getDouble("amount"));
			c.setInterestRate(result.getDouble("interestRate"));
						
		}
		
		dbo.closeAll();
		return c;
    }
    
    public void update(Credit c) throws Exception {
		
        Connection conn = dbo.getConn(server , dbname , dbuser , pwd);
		
		String sql = "update f_credit set start=?,due=?,lender=?,amount=?,interestRate=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1 , c.getStart());
		stat.setString(2 , c.getDue());
		stat.setString(3 , c.getLender());
		stat.setDouble(4 , c.getAmount());
		stat.setDouble(5 , c.getInterestRate());
		int n = stat.executeUpdate();
		
		dbo.closeAll();
		
	}
    
    

}
