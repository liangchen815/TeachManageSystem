package util;

import java.sql.*;

public class DBOper {
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	//生成数据库连接
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
	
	//释放资源
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
	
	//执行查询语句
	public ResultSet executeQuery(String preparedSql,String[] param){
		try{
			pstmt=conn.prepareStatement(preparedSql);
			if(param!=null){
				for(int i=0;i<param.length;i++){
					//把参数输入到预编译的sql语句中
					pstmt.setString(i+1, param[i]);
				}
			}
			//执行sql语句
			rs=pstmt.executeQuery();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
	//执行更新语句
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
