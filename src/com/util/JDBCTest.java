package com.util;
import javax.sql.DataSource;
import org.junit.Test;
import com.mchange.v2.c3p0.ComboPooledDataSource;
public class JDBCTest {
	
	//C3P0测试(自己写的代码)
	@Test
	public void testC3P0Demo1() throws Exception{
		DataSource dataSource=new ComboPooledDataSource("c3p0");
		System.out.println(dataSource.getConnection());
	}

	
	/**
	 * 1. 创建 c3p0-config.xml 文件, 
	 * 参考帮助文档中 Appendix B: Configuation Files 的内容
	 * 2. 创建 ComboPooledDataSource 实例；
	 * DataSource dataSource = 
	 *			new ComboPooledDataSource("c3p0");  
	 * 3. 从 DataSource 实例中获取数据库连接. 
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
