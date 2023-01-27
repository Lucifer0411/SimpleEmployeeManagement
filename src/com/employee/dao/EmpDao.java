/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.dao;

/**
 *
 * @author LENOVO
 */
import com.employee.pojo.EmpPojo;
import com.employee.utils.DbConnection;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class EmpDao {
    public static boolean addEmp(EmpPojo emp) throws SQLException{//no instance variable thats why method is static 
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into employees values(?,?,?)");
        ps.setInt(1,emp.getEmpNO());
        ps.setString(2,emp.getEmpName());
        ps.setDouble(3,emp.getEmpSal());
        int ans=ps.executeUpdate();
        return ans==1;
    }
    public static EmpPojo findEmpByEmpNo(int empid)  throws SQLException{
       Connection conn=DbConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("select * from employees where empno=?");
       ps.setInt(1,empid);
       ps.executeQuery();
       ResultSet rs=ps.executeQuery();
       EmpPojo emp=null;
       if(rs.next()==true){
            emp=new EmpPojo();
           emp.setEmpNO(rs.getInt(1));
           emp.setEmpName(rs.getString(2));
           emp.setEmpSal(rs.getDouble(3));
       }
           return emp;
    }
    public static List<EmpPojo> getAllEmployees() throws SQLException{
             Connection conn=DbConnection.getConnection();
       Statement st=conn.createStatement();
       ResultSet rs=st.executeQuery("Select * from employees");
       List<EmpPojo> empList=new ArrayList<>();
       while(rs.next()){
           EmpPojo emp=new EmpPojo();
               emp=new EmpPojo();
           emp.setEmpNO(rs.getInt(1));
           emp.setEmpName(rs.getString(2));
           emp.setEmpSal(rs.getDouble(3));
           empList.add(emp);
       }
       return empList;
    }
        public static boolean updateEmployee(int empid,double empSal) throws SQLException{
             Connection conn=DbConnection.getConnection();
             PreparedStatement ps=conn.prepareStatement("update employees set empsal=? where empno=?");
             EmpPojo emp=new EmpPojo();
             ps.setDouble(1,empSal);
             ps.setInt(2,empid);
             int a=ps.executeUpdate();
            return a==1;
    }
        public static boolean deleteEmployee(int empid) throws SQLException{
            Connection conn=DbConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("delete from employees where empno=?");
            ps.setInt(1,empid);
            int a=ps.executeUpdate();
            return a==1;
        }
    
}
