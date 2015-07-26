package util;

import java.sql.*;

public class DBOper {
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	//�������ݿ�����
	/**
	 * @param server
	 * @param dbname
	 * @param user
	 * @param pwd
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConn(String server,String dbname,String user,String pwd) 
			throws InstantiationException, IllegalAccessException, 
			ClassNotFoundException, SQLException{
		
		String DRIVER="com.mysql.jdbc.Driver";
		String URL="jdbc:mysql://"+server+":3306/"+dbname+"?useUnicode=true&characterEncoding=utf-8&user="+user+
				"&password="+pwd;
		Class.forName(DRIVER).newInstance();
		conn=DriverManager.getConnection(URL);
		return conn;
	}
	
	//�ͷ���Դ
	public void closeAll(){
		if(rs!=null){
			try{
				rs.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		if(pstmt!=null){
			try{
				pstmt.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try{
				conn.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	//ִ�в�ѯ���
	public ResultSet executeQuery(String preparedSql,String[] param){
		try{
			pstmt=conn.prepareStatement(preparedSql);
			if(param!=null){
				for(int i=0;i<param.length;i++){
					//�Ѳ������뵽Ԥ�����sql�����
					pstmt.setString(i+1, param[i]);
				}
			}
			//ִ��sql���
			rs=pstmt.executeQuery();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
	//ִ�и������
	public int executeUpdate(String preparedSql,String[] param){
		int num=0;
		try{
			pstmt=conn.prepareStatement(preparedSql);
			if(param!=null){
				for(int i=0;i<param.length;i++){
					pstmt.setString(i+1, param[i]);
				}
			}
			num=pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return num;
	}
}
