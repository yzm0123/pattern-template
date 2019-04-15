package com.gupaoedu.vip.pattern.template.jdbc;

import com.gupaoedu.vip.pattern.template.jdbc.dao.MemberDao;

import javax.servlet.http.HttpServlet;
import java.util.AbstractList;
import java.util.List;

public class MemberDaoTest {

    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List list = memberDao.selectAll();

        System.out.println(list);

    }
}
