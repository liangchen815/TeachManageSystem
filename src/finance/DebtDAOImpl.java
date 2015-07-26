package finance;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import util.DBOper;
import util.dbUtil;

public class DebtDAOImpl extends HttpServlet implements DebtDAO {
	
	public List<Debt> findAll() throws Exception {
		
		Connection conn = dbUtil.getConnection();
		
		String sql = "select * from f_debt;";
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet result = stat.executeQuery();
		
		List<Debt> debts = new ArrayList<Debt>();
		
		while (result.next()) {
			
			Debt d = new Debt();
			d.setStart(result.getString("start"));
			d.setDue(result.getString("due"));
			d.setDebtor(result.getString("debtor"));
			d.setAmount(result.getDouble("amount"));
			d.setInterestRate(result.getDouble("interestRate"));
			debts.add(d);
			
		}
		
		dbUtil.close(conn);
		return debts;
		
	}
	
	public void delete(int serialNo) throws Exception {
		
		Connection conn = dbUtil.getConnection();
		
		String sql = "delete from f_debt where serialNo=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, serialNo);
		int n = stat.executeUpdate();
		
		dbUtil.close(conn);
		
	}
	
    public void save(Debt d) throws Exception {
		
    	Connection conn = dbUtil.getConnection();
		
		String sql = "insert into f_debt (start,due,debtor,amount,interestRate) values (?,?,?,?,?)";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1 , d.getStart());
		stat.setString(2 , d.getDue());
		stat.setString(3 , d.getDebtor());
		stat.setDouble(4 , d.getAmount());
		stat.setDouble(5 , d.getInterestRate());
		int n = stat.executeUpdate();
		
		dbUtil.close(conn);
		
	}
    
    public Debt findBySerialNo(int serialNo) throws Exception {
    	
    	Connection conn = dbUtil.getConnection();
		
		String sql = "select * from f_debt where serialNo=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1 , serialNo);
		ResultSet result = stat.executeQuery();
		
		
		Debt d = new Debt();
		
		if (result.next()) {
						
			d.setStart(result.getString("start"));
			d.setDue(result.getString("due"));
			d.setDebtor(result.getString("debtor"));
			d.setAmount(result.getDouble("amount"));
			d.setInterestRate(result.getDouble("interestRate"));
						
		}
		
		dbUtil.close(conn);
		return d;
    }
    
    public void update(Debt d) throws Exception {
		
    	Connection conn = dbUtil.getConnection();
		
		String sql = "update f_debt set start=?,due=?,debtor=?,amount=?,interestRate=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1 , d.getStart());
		stat.setString(2 , d.getDue());
		stat.setString(3 , d.getDebtor());
		stat.setDouble(4 , d.getAmount());
		stat.setDouble(5 , d.getInterestRate());
		int n = stat.executeUpdate();
		
		dbUtil.close(conn);
		
	}
    
    

}
