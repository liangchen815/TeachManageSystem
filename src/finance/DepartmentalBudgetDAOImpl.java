package finance;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import util.DBOper;
import util.dbUtil;

public class DepartmentalBudgetDAOImpl implements DepartmentalBudgetDAO {
	
	public List<DepartmentalBudget> findAll() throws Exception {
		
		Connection conn = dbUtil.getConnection();
		
		String sql = "select * from f_departmentalBudget;";
		PreparedStatement stat = conn.prepareStatement(sql);
		ResultSet result = stat.executeQuery();
		
		List<DepartmentalBudget> dbs = new ArrayList<DepartmentalBudget>();
		
		while (result.next()) {
			
			DepartmentalBudget db = new DepartmentalBudget();
			db.setYear(result.getString("year"));
			db.setMonth(result.getString("month"));
			db.setDepartment(result.getString("department"));
			db.setIncome(result.getDouble("income"));
			db.setExpense(result.getDouble("expense"));
			db.setDebt(result.getDouble("debt"));
			db.setCredit(result.getDouble("credit"));
			db.setAdjustment(result.getBoolean("adjustment"));
			dbs.add(db);
			
		}
		
		dbUtil.close(conn);
		return dbs;
		
	}
	
	public void delete(String year , String month) throws Exception {
		
		Connection conn = dbUtil.getConnection();
		
		String sql = "delete from f_departmentalBudget where year=? and month=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, year);
		stat.setString(2, month);
		int n = stat.executeUpdate();
		
		dbUtil.close(conn);
		
	}
	
    public void save(DepartmentalBudget db) throws Exception {
		
    	Connection conn = dbUtil.getConnection();
		
		String sql = "insert into f_departmentalBudget (year,month,department,income,expense,debt,credit,adjustment) values (?,?,?,?,?,?,?,?)";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1 , db.getYear());
		stat.setString(2 , db.getMonth());
		stat.setString(3 , db.getDepartment());
		stat.setDouble(4 , db.getIncome());
		stat.setDouble(5 , db.getExpense());
		stat.setDouble(6 , db.getDebt());
		stat.setDouble(7 , db.getCredit());
		stat.setBoolean(8 , db.getAdjustment());
		int n = stat.executeUpdate();
		
		dbUtil.close(conn);
		
	}
    
    public List<DepartmentalBudget> findByYM(String year , String month) throws Exception {
    	
    	Connection conn = dbUtil.getConnection();
		
		String sql = "select * from f_departmentalBudget where year=? and month=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, year);
		stat.setString(2, month);
		ResultSet result = stat.executeQuery();
		
		
        List<DepartmentalBudget> dbs = new ArrayList<DepartmentalBudget>();
		
		while (result.next()) {
			
			DepartmentalBudget db = new DepartmentalBudget();
			db.setYear(result.getString("year"));
			db.setMonth(result.getString("month"));
			db.setDepartment(result.getString("department"));
			db.setIncome(result.getDouble("income"));
			db.setExpense(result.getDouble("expense"));
			db.setDebt(result.getDouble("debt"));
			db.setCredit(result.getDouble("credit"));
			db.setAdjustment(result.getBoolean("adjustment"));
			dbs.add(db);
			
		}
		
		dbUtil.close(conn);
		return dbs;
    }
    
    public DepartmentalBudget findByYM(String year , String month , String department , boolean adjustment) throws Exception {
    	
    	Connection conn = dbUtil.getConnection();
		
		String sql = "select * from f_departmentalBudget where year=? and month=? and department=? and adjustment=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, year);
		stat.setString(2, month);
		stat.setString(3, department);
		stat.setBoolean(4, adjustment);
		ResultSet result = stat.executeQuery();
		
		DepartmentalBudget db = new DepartmentalBudget();
		
		if (result.next()) {
			
			db.setYear(result.getString("year"));
			db.setMonth(result.getString("month"));
			db.setDepartment(result.getString("department"));
			db.setIncome(result.getDouble("income"));
			db.setExpense(result.getDouble("expense"));
			db.setDebt(result.getDouble("debt"));
			db.setCredit(result.getDouble("credit"));
			db.setAdjustment(result.getBoolean("adjustment"));
			
		}
		
		dbUtil.close(conn);
		return db;
    }
    
    public void update(DepartmentalBudget db) throws Exception {
		
    	Connection conn = dbUtil.getConnection();
		
		String sql = "update f_departmentalBudget set year=?,month=?,department=?,income=?,expense=?,debt=?,credit=?;";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1 , db.getYear());
		stat.setString(2 , db.getMonth());
		stat.setString(3 , db.getDepartment());
		stat.setDouble(4 , db.getIncome());
		stat.setDouble(5 , db.getExpense());
		stat.setDouble(6 , db.getDebt());
		stat.setDouble(7 , db.getCredit());
		stat.setBoolean(8 , db.getAdjustment());
		int n = stat.executeUpdate();
		
		dbUtil.close(conn);
		
	}
    
    

}
