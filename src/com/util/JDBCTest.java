package com.util;
import javax.sql.DataSource;
import org.junit.Test;
import com.mchange.v2.c3p0.ComboPooledDataSource;
public class JDBCTest {
	
	//C3P0����(�Լ�д�Ĵ���)
	@Test
	public void testC3P0Demo1() throws Exception{
		DataSource dataSource=new ComboPooledDataSource("c3p0");
		System.out.println(dataSource.getConnection());
	}

	
	/**
	 * 1. ���� c3p0-config.xml �ļ�, 
	 * �ο������ĵ��� Appendix B: Configuation Files ������
	 * 2. ���� ComboPooledDataSource ʵ����
	 * DataSource dataSource = 
	 *			new ComboPooledDataSource("c3p0");  
	 * 3. �� DataSource ʵ���л�ȡ���ݿ�����. 
	 */
	@Test
	public void testC3poWithConfigFile() throws Exception{
		DataSource dataSource = 
				new ComboPooledDataSource("c3p0");  
		System.out.println(dataSource.getConnection()); 
		ComboPooledDataSource comboPooledDataSource = 
				(ComboPooledDataSource) dataSource;
		System.out.println(comboPooledDataSource.getMaxStatements()); 
	}

}
