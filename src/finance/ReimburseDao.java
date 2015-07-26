package finance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import finance.*;
import util.DBOper;

public class ReimburseDao extends DBOper
{
	public List<Application> getApplications() throws Exception
	{
		List<Application>  applications= new ArrayList<Application>();
		Connection conn=this.getConn("localhost","ustbteach" ,"root", "wuzhengliang");
		Statement stat=conn.createStatement();
		ResultSet rst=stat.executeQuery("select * from f_application");
	/*	String sql = "select * from f_application";
		ResultSet rst = this.executeQuery(sql, null);*/
		while (rst.next()) {
			Application a=new Application();
			a.setApplicationNo(rst.getString("ApplicationNo"));
			a.setDate(rst.getString("Date"));
			a.setTno(rst.getString("Tno"));
			a.setTransaction(rst.getString("Transaction"));
			a.setCost(rst.getDouble("Cost"));
			a.setComment(rst.getString("Comment"));
			a.setOfficeSupplies(rst.getDouble("OfficeSupplies"));
			a.setMaterialExpense(rst.getDouble("MaterialExpense"));
			a.setEquipmentExpense(rst.getDouble("InformationExpense"));
			a.setTravellingExpense(rst.getDouble("TravellingExpense"));
			a.setEntertainmentExpense(rst.getDouble("EntertainmentExpense"));
			a.setPostExpense(rst.getDouble("PostExpense"));
			a.setPrintingExpense(rst.getDouble("PrintingExpense"));
			a.setPageExpense(rst.getDouble("PageExpense"));
			a.setCommunicationExpense(rst.getDouble("CommunicationExpense"));
			a.setConferenceExpense(rst.getDouble("ConferenceExpense"));
			a.setTrainingExpense(rst.getDouble("TrainingExpense"));
			a.setPorkingExpense(rst.getDouble("PorkingExpense"));
			a.setFuelExpense(rst.getDouble("FuelExpense"));
			a.setUpkeepExpense(rst.getDouble("UpkeepExpense"));
			a.setNumber(rst.getInt("Number"));
			a.setExamine(rst.getString("Examine"));
			applications.add(a);
			
		}
		this.closeAll();
		return applications;
		
	}
	public void save(Application a) throws Exception
	{
		Connection conn=this.getConn("localhost","ustbteach" ,"root", "wuzhengliang");
		PreparedStatement prep=conn.prepareStatement("insert into f_application(Date,Tno,Transaction,Cost,Comment,OfficeSupplies,MaterialExpense," +
				"EquipmentExpense,InformationExpense,TravellingExpense,EntertainmentExpense,PostExpense,PrintingExpense,PageExpense,CommunicationExpense,ConferenceExpense,TrainingExpense," +
				"PorkingExpense,FuelExpense,UpkeepExpense,Number,Examine,ExpenseAccount) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		prep.setString(1, a.getDate());
		prep.setString(2, a.getTno());
		prep.setString(3, a.getTransaction());
		prep.setDouble(4, a.getCost());
		prep.setString(5, a.getComment());
		prep.setDouble(6, a.getOfficeSupplies());
		prep.setDouble(7, a.getMaterialExpense());
		prep.setDouble(8, a.getEquipmentExpense());
		prep.setDouble(9, a.getInformationExpense());
		prep.setDouble(10, a.getTravellingExpense());
		prep.setDouble(11, a.getEntertainmentExpense());
		prep.setDouble(12, a.getPostExpense());
		prep.setDouble(13, a.getPrintingExpense());
		prep.setDouble(14, a.getPageExpense());
		prep.setDouble(15, a.getCommunicationExpense());
		prep.setDouble(16, a.getConferenceExpense());
		prep.setDouble(17, a.getTrainingExpense());
		prep.setDouble(18, a.getPorkingExpense());
		prep.setDouble(19, a.getFuelExpense());
		prep.setDouble(20, a.getUpkeepExpense());
		prep.setInt(21,a.getNumber());
		prep.setString(22, a.getExamine());
		prep.setString(23, a.getExpenseAccount());
		prep.executeUpdate();
		this.closeAll();
	}
	public Application findByNo(String no) throws Exception
	{
		Connection conn=this.getConn("localhost","ustbteach" ,"root", "wuzhengliang");
		PreparedStatement prep=conn.prepareStatement("select * from f_application where ApplicationNo=?");
		prep.setString(1,no);
		ResultSet rst=prep.executeQuery();
		Application a=null;
		while(rst.next())
		{
			a=new Application();
			a.setApplicationNo(no);
			a.setDate(rst.getString("Date"));
			a.setTno(rst.getString("Tno"));
			a.setExpenseAccount(rst.getString("ExpenseAccount"));
			a.setTransaction(rst.getString("Transaction"));
			a.setCost(Double.parseDouble(rst.getString("Cost")));
			a.setComment(rst.getString("Comment"));
			a.setOfficeSupplies(rst.getDouble("OfficeSupplies"));
			a.setMaterialExpense(rst.getDouble("MaterialExpense"));
			a.setEquipmentExpense(rst.getDouble("InformationExpense"));
			a.setTravellingExpense(rst.getDouble("TravellingExpense"));
			a.setEntertainmentExpense(rst.getDouble("EntertainmentExpense"));
			a.setPostExpense(rst.getDouble("PostExpense"));
			a.setPrintingExpense(rst.getDouble("PrintingExpense"));
			a.setPageExpense(rst.getDouble("PageExpense"));
			a.setCommunicationExpense(rst.getDouble("CommunicationExpense"));
			a.setConferenceExpense(rst.getDouble("ConferenceExpense"));
			a.setTrainingExpense(rst.getDouble("TrainingExpense"));
			a.setPorkingExpense(rst.getDouble("PorkingExpense"));
			a.setFuelExpense(rst.getDouble("FuelExpense"));
			a.setUpkeepExpense(rst.getDouble("UpkeepExpense"));
			a.setNumber(rst.getInt("Number"));
		}
		this.closeAll();
		return a;
	}
	public Approval findByAppNo(String no) throws Exception
	{
		Connection conn=this.getConn("localhost","ustbteach" ,"root", "wuzhengliang");
		PreparedStatement prep=conn.prepareStatement("select * from f_approval where ApplicationNo=?");
		prep.setString(1,no);
		ResultSet rst=prep.executeQuery();
		Approval a=null;
		while(rst.next())
		{
			a=new Approval();
			a.setApplicationNo(no);
			a.setApprovalNo(rst.getString("approvalNo"));
			a.setApprover(rst.getString("approver"));
			a.setComment(rst.getString("Comment"));
			a.setDate(rst.getString("Date"));
		}
		this.closeAll();
		return a;
	}
	public void update(Application a) throws Exception
	{
		Connection conn=this.getConn("localhost","ustbteach" ,"root", "wuzhengliang");
		PreparedStatement prep=conn.prepareStatement("update f_application set Cost=?,Comment=? ,OfficeSupplies=?,MaterialExpense=?," +
				"EquipmentExpense=?,InformationExpense=?,TravellingExpense=?,EntertainmentExpense=?,PostExpense=?,PrintingExpense=?,PageExpense=?,CommunicationExpense=?,ConferenceExpense=?,TrainingExpense=?," +
				"PorkingExpense=?,FuelExpense=?,UpkeepExpense=?,Number=?,Examine=?,ExpenseAccount=? where ApplicationNo=?");
		prep.setDouble(1, a.getCost());
		prep.setString(2, a.getComment());
		prep.setDouble(3, a.getOfficeSupplies());
		prep.setDouble(4, a.getMaterialExpense());
		prep.setDouble(5, a.getEquipmentExpense());
		prep.setDouble(6, a.getInformationExpense());
		prep.setDouble(7, a.getTravellingExpense());
		prep.setDouble(8, a.getEntertainmentExpense());
		prep.setDouble(9, a.getPostExpense());
		prep.setDouble(10, a.getPrintingExpense());
		prep.setDouble(11, a.getPageExpense());
		prep.setDouble(12, a.getCommunicationExpense());
		prep.setDouble(13, a.getConferenceExpense());
		prep.setDouble(14, a.getTrainingExpense());
		prep.setDouble(15, a.getPorkingExpense());
		prep.setDouble(16, a.getFuelExpense());
		prep.setDouble(17, a.getUpkeepExpense());
		prep.setInt(18,a.getNumber());
		prep.setString(19, a.getExamine());
		prep.setString(20, a.getExpenseAccount());
		prep.setString(21, a.getApplicationNo());
		prep.executeUpdate();
		this.closeAll();
	}
	public List<Approval> getApprovals() throws Exception
	{
		List<Approval>  approvals= new ArrayList<Approval>();
		Connection conn=this.getConn("localhost","ustbteach" ,"root", "wuzhengliang");
		Statement stat=conn.createStatement();
		ResultSet rst=stat.executeQuery("select * from f_approval");
		while (rst.next()) {
			Approval a=new Approval();
			a.setApplicationNo(rst.getString("ApplicationNo"));
			a.setApprovalNo(rst.getString("ApprovalNo"));
			a.setDate(rst.getString("Date"));
			a.setApprover(rst.getString("Approver"));
			a.setComment(rst.getString("Comment"));
			approvals.add(a);
			
		}
		this.closeAll();
		return approvals;
		
	}
	public String MaxNo() throws Exception
	{
		Connection conn=this.getConn("localhost","ustbteach" ,"root", "wuzhengliang");
		Statement stat=conn.createStatement();
		ResultSet rst=stat.executeQuery("select max(ApplicationNo) as max from f_application;");
		String number ="";
		while(rst.next())
		{
			number=rst.getString("max");
		}
		Integer a=Integer.parseInt(number)+1;
		String b=a+"";
		return b;
	}
	public String Max() throws Exception
	{
		Connection conn=this.getConn("localhost","ustbteach" ,"root", "wuzhengliang");
		Statement stat=conn.createStatement();
		ResultSet rst=stat.executeQuery("select max(ApprovalNo) as max from f_approval;");
		String number ="";
		while(rst.next())
		{
			number=rst.getString("max");
		}
		Integer a=Integer.parseInt(number)+1;
		String b=a+"";
		return b;
	}
	public void save(Approval a) throws Exception
	{
		Connection conn=this.getConn("localhost","ustbteach" ,"root", "wuzhengliang");
		PreparedStatement prep=conn.prepareStatement("insert into f_approval(ApplicationNo,Date,Approver,Comment) values(?,?,?,?)");
		prep.setString(1,a.getApplicationNo());
		prep.setString(2, a.getDate());
		prep.setString(3, a.getApprover());
		prep.setString(4, a.getComment());
		prep.executeUpdate();
		this.closeAll();
	}
}
