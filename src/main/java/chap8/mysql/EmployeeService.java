package chap8.mysql;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class EmployeeService {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        // 加载mysql.properties文件
        InputStream input = EmployeeService.class.getClassLoader().getResourceAsStream("mysql.properties");
        properties.load(input);
        // 获取properties中对应的值
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driver);
        // 获取数据库连接
        Connection connection = DriverManager.getConnection(url, user, password);
        // 需要执行的sql语句
        String insertSql = "insert into employee_name(id, first_name, last_name) values(?,?,?)";
        String selectSql = "select * from employee_name where id = ?";
        PreparedStatement insertStatement = connection.prepareCall(insertSql);
        PreparedStatement selectStatement = connection.prepareCall(selectSql);

        try {
            // 插入（001， Li, Zion）
            insertStatement.setString(1,"001");
            insertStatement.setString(2,"Li");
            insertStatement.setString(3,"Zion");
            insertStatement.executeUpdate();  // 执行并更新

            // 查询 id = 001
            selectStatement.setString(1, "001");
            ResultSet rs = selectStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("id") + " " +
                        rs.getString("first_name") + " " +
                        rs.getString("last_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            selectStatement.close();
            insertStatement.close();
            connection.close();
        }
    }





}
