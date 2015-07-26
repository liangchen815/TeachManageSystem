package lab;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBOper;

public class L_labhardmsgDao extends DBOper {
	public List<L_labhardmsg> getAll() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {
		List<L_labhardmsg> hardware = new ArrayList<L_labhardmsg>();
		String sql = "select * from l_labhardmsg";
		ResultSet rst = this.executeQuery(sql, null);
		while (rst.next()) {
			L_labhardmsg e = new L_labhardmsg();
			e.setCpu(rst.getString("cpu"));
			e.setXianka(rst.getString("xianka"));
			e.setXianshiqi(rst.getString("xianshiqi"));
			e.setNeicun(rst.getString("neicun"));
			e.setLabNo(rst.getString("labNo"));
			e.setYingpan(rst.getString("yingpan"));
			hardware.add(e);
		}
		this.closeAll();
		return hardware;
	}

	public int delete(String labNo) throws Exception {
		int i = 0;
		String sql = "delete l_labhardmsg "
				+ "delete from l_labhardmsg where labNo = ?";
		String[] de = new String[] { labNo };
		i = this.executeUpdate(sql, de);
		this.closeAll();
		return i;
	}

	public int add(L_labhardmsg e) throws Exception {
		int i = 0;
		String sql = "insert into "
				+ "l_labhardmsg(cpu,xianka,xianshiqi,neicun,labNo,yingpan) "
				+ "values(?,?,?,?,?,?)";
		String[] pa = new String[] { e.getCpu(), e.getXianka(),
				e.getXianshiqi(), e.getNeicun(), e.getLabNo(), e.getYingpan() };
		i = this.executeUpdate(sql, pa);
		this.closeAll();
		return i;
	}

	public L_labhardmsg findByLabNo(String labNo) throws Exception {
		String sql = "select* from l_labhardmsg where labNo = ?";
		String[] pa = new String[] { labNo };
		ResultSet rst = this.executeQuery(sql, pa);
		L_labhardmsg e = null;
		if (rst.next()) {
			e = new L_labhardmsg();
			e.setCpu(rst.getString("cpu"));
			e.setXianka(rst.getString("xianka"));
			e.setXianshiqi(rst.getString("xianshiqi"));
			e.setNeicun(rst.getString("neicun"));
			e.setLabNo(rst.getString("labNo"));
			e.setYingpan(rst.getString("yingpan"));
		}
		this.closeAll();
		return e;
	}

	public int update(L_labhardmsg e) throws Exception {
		int i = 0;
		String sql = "update l_labhardmsg "
				+ "set cpu=?,xianka=?,xianshiqi=?,neicun=?,labNo=?,yingpan=?"
				+ "where labNo=?";
		String[] pa = new String[] { e.getCpu(), e.getXianka(),
				e.getXianshiqi(), e.getNeicun(), e.getLabNo(), e.getYingpan() };
		i = this.executeUpdate(sql, pa);
		this.closeAll();
		return i;
	}
}
