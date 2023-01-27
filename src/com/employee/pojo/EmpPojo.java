/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.pojo;

import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class EmpPojo  implements Comparable{

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.empNO;
        hash = 97 * hash + Objects.hashCode(this.empName);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.empSal) ^ (Double.doubleToLongBits(this.empSal) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmpPojo other = (EmpPojo) obj;
        if (this.empNO != other.empNO) {
            return false;
        }
        if (Double.doubleToLongBits(this.empSal) != Double.doubleToLongBits(other.empSal)) {
            return false;
        }
        if (!Objects.equals(this.empName, other.empName)) {
            return false;
        }
        return true;
    }
    @Override
    public int compareTo(Object t){
        EmpPojo e=(EmpPojo)t;
        if(this.empNO>e.empNO){
            return 1;
        }else if(this.empNO<e.empNO){
            return -1;
        }else{
            return this.empName.compareTo(e.empName);
        }
    }

    @Override
    public String toString() {
        return "\t"+empNO +"\t\t"+empName + "\t\t"+ empSal;
    }
    
    public  EmpPojo(){
        
    }
    public EmpPojo(int empNO, String empName, double empSal) {
        this.empNO = empNO;
        this.empName = empName;
        this.empSal = empSal;
    }
       private int empNO;
    private String empName;
    private double empSal;

    public int getEmpNO() {
        return empNO;
    }

    public void setEmpNO(int empNO) {
        this.empNO = empNO;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }
 
    
}
