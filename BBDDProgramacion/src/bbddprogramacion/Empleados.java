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
public class Empleados {/*clase empleados*/

 private ArrayList<Empleado> empleados;/*ArrayList de empleado, arrastra sus variables*/
 private Connection conexion;
 Statement sentencia=null;

    public Empleados() {/*constructor empleados*/
       
         try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }

         
       
    }
    public int Create(Empleado emp)throws SQLException {/*metodo para crear empleados*/
                   
         int filas;
        String sql = "INSERT INTO empleados VALUES ( ?, ?, ? , ? , ? , ? , ? , ? )";
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
    
    
    
     public String Update(int emp_no,Empleado emp) throws SQLException{/*metodo update del ejemplo inicial*/
         
        String sql="UPDATE empleados set loc= 'Madrid' where dep_no = 70";
        
        sentencia =conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs= sentencia.getResultSet();
      //  rs.close();/*añadir ( ?) cuando este el resto arreglado añadir lineas de codigo del primer ejemplo jdbc*/
             sentencia.close(); 
        
        return sql;
    }

    public Empleado Read(int emp_no) throws SQLException {/*metodo del ejemplo read(no se usa)*/
    Empleado emp=null;
    
        String sql="select * from empleados where emp_no = "+emp_no;     
    
        sentencia =conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs= sentencia.getResultSet();
        rs.close();
    
    return emp;
    }

    public void Delete(int dep_no) throws SQLException {/*metodo del ejemplo delete*/
        
         String sql="delete from departamentos where dept_no =70";     
    
        sentencia =conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs= sentencia.getResultSet();
     //   rs.close();
        
    }
    public void Close() throws SQLException{/*metodo cerrar la conexion*/
    conexion.close();}

    public void BorrarEmp(int no_emp) throws SQLException {/*metodo borrar empleado*/
        String sql="delete from empleados where emp_no="+no_emp;
        sentencia=conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs=sentencia.getResultSet();
        sentencia.close();
    }

    

    public ArrayList<Empleado> ReadTodos() throws SQLException {/*metodo para leer a todos los empleados*/
       Empleado emp=null;
      ArrayList<Empleado> bdemp=new ArrayList<>();
      String sql="Select * from empleados";
      sentencia=conexion.createStatement();
      sentencia.execute(sql);
      ResultSet rs=sentencia.getResultSet();
      while(rs.next())
      {
          emp=new Empleado(rs.getInt("emp_no"),rs.getString("apellido"),rs.getString("oficio"),rs.getInt("dir"),rs.getDate("fecha_alt"),rs.getDouble("salario"),rs.getDouble("comision"),rs.getInt("dept_no"));
          bdemp.add(emp);
      }
      rs.close();
      sentencia.close();
      return bdemp;
    }
    
   public Empleado BusquedaEmpleado(String apellidos_emp)throws SQLException{
       /*metodo buscar empleados por su apellido*/
       Empleado emp=null;
       String sql="Select * from empleados where apellido ='"+apellidos_emp+"'";
       
        sentencia=conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs=sentencia.getResultSet();
        
        while(rs.next())
        {
          emp=new Empleado(rs.getInt("emp_no"),rs.getString("Apellido"),rs.getString("oficio"),rs.getInt("dir"),rs.getDate("fecha_alt"),
            rs.getDouble("salario"),rs.getDouble("comision"),rs.getInt("dept_no"));
        }
        rs.close();
        sentencia.close();
        
        return emp;
   }
    public Empleado ReadEmp(int no_emp) throws SQLException {/*metodo para buscar empleados por su numero de empleado*/
        
        /*Departamento dep=null;
        String sql="select * from departamentos where dept_no="+no_dep;
        sentencia=conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs=sentencia.getResultSet();
        while(rs.next())
        {
            dep=new Departamento(rs.getInt("dept_no"),rs.getString("dnombre"),rs.getString("loc"));
        }
        sentencia.close();
        return dep;
        */
        Empleado emp=null;
    
        String sql="Select *from empleados where emp_no= "+no_emp;
        sentencia=conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs=sentencia.getResultSet();
        while(rs.next())
        {
            emp=new Empleado(rs.getInt("emp_no"),rs.getString("Apellido"),rs.getString("oficio"),rs.getInt("dir"),rs.getDate("fecha_alt"),
            rs.getDouble("salario"),rs.getDouble("comision"),rs.getInt("dept_no"));
        }
        rs.close();
        sentencia.close();
        
        return emp;
       
    }
    /*fin metodos*/
}