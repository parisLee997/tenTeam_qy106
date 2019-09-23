package com.aaa.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDao {
//    private static final String URL = "jdbc:mysql://localhost:3306/userdb";//地址
//    private static final String USER = "root";//用户名
//    private static final String PWD = "root";//密码

    //成员变量：每个方法都可以直接使用
    protected Connection connection=null;
    protected PreparedStatement statement=null;
    protected ResultSet resultSet=null;
    private static DataSource dataSource=null;
    static {
        try {
            Context context=new InitialContext();
            dataSource= (DataSource) context.lookup("java:comp/env/jdbc/userdb");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取连接
     * @return
     */
    public Connection getConnection(){
//        try {
//            //加载驱动
//            Class.forName("com.mysql.jdbc.Driver");
//            connection=DriverManager.getConnection(URL,USER,PWD);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return connection;
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //方法内部无法确定的数据，统一使用参数
    public int executeUpdate(String sql,Object[] params){
        int result=-1;
        try {
            this.connection=getConnection();
            this.statement=connection.prepareStatement(sql);
            //参数的顺序要和占位符一致
            if(params!=null){
                for (int i = 0; i < params.length; i++) {
                    Object param = params[i];
                    this.statement.setObject(i+1,param);
                }
            }
            //执行命令
            result=this.statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll(null,this.statement,this.connection);
        }
        return result;
    }


    /**
     * 执行查询的方法
     * @param sql
     * @param params
     * @return
     */
    public List<Map> executeQuery(String sql,Object[] params){
        List<Map> mapList=new ArrayList<>();
        try {
            this.connection=getConnection();
            this.statement=connection.prepareStatement(sql);
            //参数的顺序要和占位符一致
            if(params!=null){
                for (int i = 0; i < params.length; i++) {
                    Object param = params[i];
                    this.statement.setObject(i+1,param);
                }
            }
            //执行命令
            resultSet=statement.executeQuery();
            //获取结果集的元数据对象：获取当前sql对应的结构：列数、类型、名称
            ResultSetMetaData metaData=resultSet.getMetaData();
//            获取当前查询的列的数量
            int colCount=metaData.getColumnCount();
            while(resultSet.next()){
                //依次获取每列的值存入到map中
                Map<String,Object> row=new HashMap<>();
                //metaData.getColumnName(1)：获取列名
                //metaData.getColumnLabel():获取别名
                //遍历每一列的数据
                for(int i=1;i<=colCount;i++){
                    row.put(metaData.getColumnLabel(i),resultSet.getObject(i));
                }
                //添加每行数据到集合中
                mapList.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll(resultSet,this.statement,this.connection);
        }
        return mapList;
    }



    /**
     * 释放资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public void closeAll(ResultSet resultSet,Statement statement,Connection connection){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
