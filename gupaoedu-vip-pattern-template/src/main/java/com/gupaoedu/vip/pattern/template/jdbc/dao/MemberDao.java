package com.gupaoedu.vip.pattern.template.jdbc.dao;

import com.gupaoedu.vip.pattern.template.jdbc.JdbcTemplate;
import com.gupaoedu.vip.pattern.template.jdbc.Member;
import com.gupaoedu.vip.pattern.template.jdbc.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class MemberDao extends JdbcTemplate {
    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll(){
        String sql = "Select * from t_member";
        return super.excuteQuery(sql, new RowMapper<Object>() {

            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws Exception {
                Member m = new Member();
                m.setUseName(rs.getString("useName"));
                m.setPassword(rs.getString("password"));
                m.setNickName(rs.getString("nickName"));
                m.setAddress(rs.getString("address"));
                m.setAge(rs.getInt("age"));
                return m;
            }
        },null);

    }


}
