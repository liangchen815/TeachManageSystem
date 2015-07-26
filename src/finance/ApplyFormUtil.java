package finance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.*;

public class ApplyFormUtil {
	public static void submit(ApplyForm form) {
		try {
			String sql = "insert into parttime_job_apply_form values(null,?,?,?,?,?,?,?,?,?,?)";
			Connection conn = dbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, form.getName());
			ps.setString(2, form.getGender());
			ps.setString(3, form.getNation());
			ps.setString(4, form.getBirthday());
			ps.setString(5, form.getNumber());
			ps.setString(6, form.getPhoneNumber());
			ps.setString(7, form.getEmail());
			ps.setString(8, form.getDescription());
			ps.setString(9, form.getApplyType());
			ps.setString(10, form.getWorkTime());
			ps.executeUpdate();
			ps.close();
			dbUtil.close(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
