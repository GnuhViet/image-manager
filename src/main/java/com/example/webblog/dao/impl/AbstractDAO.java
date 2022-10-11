package com.example.webblog.dao.impl;

import com.example.webblog.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<T> {
    public static String URL = "jdbc:mysql://localhost:3306/webblog";
    public static String USER = "root";
    public static String PASSWORD = "";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    protected  <T> List<T> read(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> result = new ArrayList<>();
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pre = con.prepareStatement(sql);
            setParameter(pre, parameters);
            rs = pre.executeQuery();
            while (rs.next()) {
                result.add(rowMapper.mapRow(rs));
            }
            return result;
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (con != null)
                    con.close();
                if (pre != null)
                    pre.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected String update(String sql, Object... parameters) {
        Connection con = null;
        PreparedStatement pre = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            pre = con.prepareStatement(sql);
            setParameter(pre, parameters);
            pre.executeUpdate();
            con.commit();
            return "success";
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return "fail";
        } finally {
            try {
                if (con != null)
                    con.close();
                if (pre != null)
                    pre.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void setParameter(PreparedStatement pre, Object... parameters) throws SQLException {
        for (int i = 0; i < parameters.length; i++) {
            Object parameter = parameters[i];
            int index = i + 1;
            if (parameter instanceof Long) {
                pre.setLong(index, (Long) parameter);
            } else if (parameter instanceof String) {
                pre.setString(index, (String) parameter);
            } else if (parameter instanceof Integer) {
                pre.setInt(index, (Integer) parameter);
            } else if (parameter instanceof Timestamp) {
                pre.setTimestamp(index, (Timestamp) parameter);
            }
        }
    }
}
