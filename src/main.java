/**
 * Copyright (C), 2015-2020, XXX有限公司
 * <p>
 * FileName: main
 * <p>
 * Author:   taozi
 * <p>
 * Date:     2020/8/14 16:53
 * <p>
 * Description: main
 * <p>
 * History:
 *
 * <author>          <time>          <version>          <desc>
 * <p>
 * 作者姓名           修改时间           版本号              描述
 */


/**
 * 〈一句话功能简述〉<br> 
 * 〈main〉
 *
 * @author taozi

 * @create 2020/8/14

 * @since 1.0.0

 */

import java.sql.*;
public class main {
    public static void main(String[] args) {
        Connection con;
        String driver="com.mysql.jdbc.Driver";
        //我的数据库是test
        String url="jdbc:mysql://localhost:3306/test";
        String user="root";
        String password="root";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            Statement statement = con.createStatement();
            String sql = "select * from goods;";
            //我的表格叫goods
            ResultSet resultSet = statement.executeQuery(sql);
            String name;
            int price;
            while (resultSet.next()) {
                name = resultSet.getString("name");
                System.out.println("商品：" + name);
                price = resultSet.getInt("price");
                System.out.println("价格：" + price);
            }
            resultSet.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }
    }
}

