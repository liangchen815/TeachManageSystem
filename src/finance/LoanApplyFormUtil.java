package finance;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.*;

public class LoanApplyFormUtil {
	public static void submit(LoanApplyForm form) {
		try {
			String sql = "insert into f_loan values(null,?,?,?,?,?,?,?,?,?,?)";
			Connection conn = dbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, form.getName());
			ps.setString(2, form.getGender());
			ps.setString(3, form.getBirthday());
			ps.setString(4, form.getBirthday());
			ps.setString(5, form.getSno());
			ps.setString(6, form.getPhoneNumber());
			ps.setString(7, form.getDescription());
			ps.setString(8, form.getL_type());
			ps.setInt  (9,form.getAmout());
			ps.executeUpdate();
			ps.close();
			dbUtil.close(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

