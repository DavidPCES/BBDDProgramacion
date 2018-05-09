/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbddprogramacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario 1 DAM
 */
public class Empleados {

 private ArrayList<Empleado> empleados;
 private Connection conexion;
 Statement sentencia=null;

    public Empleados() {
       
         try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }

         
       
    }
    public int Create(Empleado emp)throws SQLException {
                   
         int filas;
        String sql = "INSERT INTO departamentos VALUES ( ?, ?, ? , ? , ? , ? , ? , ? )";
        PreparedStatement sentencia;
        
        sentencia=conexion.prepareStatement(sql);
        
         sentencia.setInt(1, emp.getEmp_no());
        sentencia.setString(2, emp.getApellidos());
        sentencia.setString(3, emp.getOficina());
        sentencia.setInt(4, emp.getDir());
        sentencia.setDate(5, (Date) emp.getFecha_alt());
        sentencia.setDouble(6, emp.getSalario());
        sentencia.setDouble(7, emp.getComision());
        sentencia.setInt(8, emp.getDept_no());
        filas = sentencia.executeUpdate();
        return filas;
       }
    
    
    
     public String Update(int emp_no,Empleado emp) throws SQLException{
         
        String sql="UPDATE empleados set loc= 'Madrid' where appellido = 70";
        
        sentencia =conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs= sentencia.getResultSet();
      //  rs.close();/*añadir ( ?) cuando este el resto arreglado añadir lineas de codigo del primer ejemplo jdbc*/
             sentencia.close(); 
        
        return sql;
    }

    public Departamento Read(int emp_no) throws SQLException {
    Departamento dep=null;
    
        String sql="select apellido from empleados where emp_no = "+emp_no;     
    
        sentencia =conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs= sentencia.getResultSet();
        rs.close();
    
    return dep;
    }

    public void Delete(int dep_no) throws SQLException {
        
         String sql="delete from departamentos where dept_no =70";     
    
        sentencia =conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs= sentencia.getResultSet();
     //   rs.close();
        
    }
    public void Close() throws SQLException{
    conexion.close();}

    public void BorrarEmp(int no_emp) throws SQLException {
        String sql="delete from empleados where emp_no"+no_emp;
        sentencia=conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs=sentencia.getResultSet();
        sentencia.close();
    }

    public Empleado ReadEmp(String apellidos_emp) throws SQLException {
    Empleado emp=null;
    
        String sql="select * from empleados where apellidos = "+apellidos_emp;     
    
        sentencia =conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs= sentencia.getResultSet();
        rs.close();
    
    return emp;
    }

}
