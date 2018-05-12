/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbddprogramacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public class Departamentos {/*clase departamentos*/

    private Connection conexion;
    private ArrayList<Departamento> departamentos;/*coge variables departamento*/
    
    Statement sentencia=null;

    public Departamentos() {/*constructor*/

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    


    public int Create(Departamento dep) throws SQLException {/*metodo creacion departamento*/
        int filas;
        String sql = "INSERT INTO departamentos VALUES ( ?, ?, ? )";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, dep.getDept_no());
        sentencia.setString(2, dep.getDnombre());
        sentencia.setString(3, dep.getLoc());
        filas = sentencia.executeUpdate();
        return filas;
    }

    public String Update(int dep_no, Departamento dep) throws SQLException{/*metodo de update del ejemplo inicial*/
        String sql="UPDATE departamentos set loc= 'Madrid' where dept_no = 70";
        
        sentencia =conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs= sentencia.getResultSet();
        sentencia.close(); 
        
        return sql;
    }

    public Departamento Read(int dept_no) throws SQLException {/*metodo para mostrar del ejemplo inicial adaptado al codigo, no se usa*/
    Departamento dep=null;
    
        String sql="select * from departamentos where dept_no = "+dept_no;     
    
        sentencia =conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs= sentencia.getResultSet();
        rs.close();
    
    return dep;
    }

    public void Delete(int dep_no) throws SQLException {/*metodo de eliminar del ejemplo inicial */
        
         String sql="delete from departamentos where dept_no =70";     
    
        sentencia =conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs= sentencia.getResultSet();
     //   rs.close();
        
    }
    public void Close() throws SQLException{/*cerrar bbdd*/
    conexion.close();}

    public Departamento ReadNum(int no_dep) throws SQLException {/**metodo para mostrar por pantalla departamento segun numero*/
        Departamento dep=null;
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
        
    }
    
    public ArrayList<Departamento>ReadTodos() throws SQLException/*metodo para mostrar listado de todos los departamentos*/
    {
      Departamento dep=null;
      ArrayList<Departamento> deps=new ArrayList<>();
      String sql="Select * from departamentos";
      sentencia=conexion.createStatement();
      sentencia.execute(sql);
      ResultSet rs=sentencia.getResultSet();
      while(rs.next())
      {
          dep=new Departamento(rs.getInt("dept_no"),rs.getString("dnombre"),rs.getString("loc"));
          deps.add(dep);
      }
      rs.close();
      sentencia.close();
      return deps;
    }

    public void BorrarDep(int no_dep) throws SQLException {/*metodo para borrar departamentos*/
        
        String sql="Delete from departamentos where dept_no="+no_dep;
        sentencia=conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs=sentencia.getResultSet();
        sentencia.close();
        
        
    }

    public Departamento ReadDepNombre(String dnombre) throws SQLException {/*metodo para buscar departamentos por nombre*/
         Departamento dep=new Departamento();
    
        String sql="select * from departamentos where dnombre = '"+dnombre+"'";     
    
        sentencia =conexion.createStatement();
        sentencia.execute(sql);
        ResultSet rs= sentencia.getResultSet();
       
        
        while(rs.next())
        {
          dep=new Departamento(rs.getInt("dept_no"),rs.getString("dnombre"),rs.getString("loc"));
        }
        rs.close();
        sentencia.close();
        
        return dep;
    
   
    }

}