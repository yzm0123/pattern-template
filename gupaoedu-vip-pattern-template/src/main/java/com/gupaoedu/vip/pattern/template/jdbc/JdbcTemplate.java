package com.gupaoedu.vip.pattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> excuteQuery(String sql, RowMapper<?> rowMapper,Object[] values){

        try {
            //1、获取连接
            Connection con = this.getconnection();

            //2、创建语句集
            PreparedStatement preparedStatement = this.createPrepareStatement(con,sql);

            //3、执行语句集
            ResultSet rs = execute(sql,preparedStatement,values);


            //4、处理结果集
            List<?> list  = this.parseResultSet(rs,rowMapper);

            //5、关闭结果集
            this.closeResultSet(rs);
            
            //6、关闭语句集
            this.closePrepareStatement(preparedStatement);
            
            //7、关闭连接
            this.closeConnection(con);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void closeConnection(Connection con) throws SQLException {
        con.close();
    }

    protected void closePrepareStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
    }

    protected void closeResultSet(ResultSet rs) throws SQLException {
        rs.close();
    }

    protected List<?> parseResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> list  = new ArrayList<Object>();
        int rownum = 1;
        while (rs.next()){
            list.add(rowMapper.mapRow(rs,rownum++));
        }
        return list;
    }

    private ResultSet execute(String sql,PreparedStatement preparedStatement, Object[] values) throws Exception {
        for(int i = 0;i<values.length;i++){
            preparedStatement.setObject(i,values[i]);
        }

        return preparedStatement.executeQuery(sql);
    }

    private PreparedStatement createPrepareStatement(Connection con, String sql) throws SQLException {
        return con.prepareStatement(sql);
    }


    private Connection getconnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
