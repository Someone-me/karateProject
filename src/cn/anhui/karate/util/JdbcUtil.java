package cn.anhui.karate.util;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtil {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	//事务专用链接
	private static ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();

	public static Connection getConnection() throws SQLException {
		Connection con = t1.get(); //将自己的线程判断是否存在conn
		if (con != null) return con;  //con已经创建
		System.out.println("wei"+con);
		return dataSource.getConnection();
	}

	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}

	/**
	 * 开启事务
	 * 1、保证链接是刚创建的con
	 */
	public static void beginTransaction() throws SQLException {
		Connection con = t1.get(); //将自己的线程判断是否存在conn
		if (con != null) throw new RuntimeException("已经开启事务不要重复开启");
		con = getConnection(); //给con赋值 事务开启
		con.setAutoCommit(false);
		t1.set(con);//将自己线程的con保存起来 用来下次调用
	}

	/**
	 * 提交事务
	 */
	public static void commitTransaction() throws SQLException {
		Connection con = t1.get(); //将自己的线程判断是否存在conn
		if (con == null) throw new RuntimeException("还没有开启事务，不能提交");
		con.commit();
		con.close();
		t1.remove();//从t1中移除con
	}

	/*
    回滚事务
     */
	public static void rollbackTransaction() throws SQLException {
		Connection con = t1.get(); //将自己的线程判断是否存在conn
		if (con == null) throw new RuntimeException("还没有开启事务，不能回滚");
		;
		con.rollback();
		con.close();
		t1.remove();
	}

	//releaseConnection
	public static void releaseConnection(Connection connection) throws SQLException {
		Connection con = t1.get(); //将自己的线程判断是否存在conn
		//判断当前事务专用链接（con）是否为空，为空则直接关闭连接的事务
		if (con == null) connection.close();
		//判断此链接是否是事务专用连接
		if (con != connection) connection.close();

	}
}
