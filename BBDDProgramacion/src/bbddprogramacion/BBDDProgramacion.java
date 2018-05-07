/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbddprogramacion;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Usuario 1 DAM
 */
public class BBDDProgramacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Departamento dep=new Departamento();
        Departamentos bddep =new Departamentos();
     /*DEPARTAMENTO*/   
        dep.setDept_no(70);
        dep.setDnombre("INFORMATICA");
        dep.setLoc("MADRID");
     /*CIERRO DEPARTAMENTO*/
     
     
        Empleado emp=new Empleado();
        Empleados bdemp =new Empleados();
     /*EMPLEADO*/
     emp.setEmp_no(70);/*numero */
     emp.setApellidos("Gonzalez");
     emp.setOficina("Inteligencia Central");
     emp.setDir(5);
     emp.setFecha_alt(Date.valueOf("25 marzo 1465"));
     emp.setSalario(20.35);
     emp.setComision(5.32);
     emp.setDept_no(12);
                                             
                                             
     /*CIERRO EMPLEADO*/
     /*Variables App Crud*/
     Scanner sc=new Scanner(System.in);
     boolean continuar=true;
     int eleccion,eleccionv2;
            /*variables departamento*/
                int no_dep;
            /**/
     /*Fin variables Crud*/
     try{
     while(continuar)
     {
         System.out.println("          BBDD Programacion Aplicacion CRUD          ");
         System.out.println("|***************************************************|");
       
         System.out.println("|------------------Eleccion Accion------------------|");
         System.out.println("|| 1.-    >> Listado de Departamentos     <<       ||");
         System.out.println("|| 2.-    >> Listado de Empleados         <<       ||");
         System.out.println("|| 3.-    >> Busqueda de Departamento     <<       ||");
         System.out.println("|| 4.-    >> Busqueda de Empleado         <<       ||");
         System.out.println("|---------------------------------------------------|");
         System.out.println("|| 5.-    >> Creacion de Empleado         <<       ||");
         System.out.println("|| 6.-    >> Creacion de Departamentos    <<       ||");
         System.out.println("|---------------------------------------------------|");
         System.out.println("|| 7.-    >> Borrado de Empleados         <<       ||");
         System.out.println("|| 8.-    >> Borrado de Departamentos     <<       ||");
         System.out.println("|***************************************************|");
         System.out.println("----->");eleccion=sc.nextInt(); 
         
       switch(eleccion)
       {
           case 1:/*Listado Departamentos*/
               
         System.out.println("|--------------------------------------------------|");     
         System.out.println("|| 1.-    >> Busqueda Personalizada      <<       ||");
         System.out.println("|| 2.-    >> Mostrar Todos               <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.println("---->");eleccionv2=sc.nextInt();
              if(eleccionv2==1)
              {
         System.out.println("---->Departamento a buscar: ");no_dep=sc.nextInt();
                bddep.Read(no_dep);

              }
              if(eleccionv2==2)
              {
         System.out.println("|| 1.-    >> Listado de Departamentos     <<       ||");  
              }
               break;
           case 2:
               break;
           case 3:
               break;
           case 4:
               break;
           case 5:
               break;
           case 6:
               break;
           case 7:
               break;
           case 8:
               break;
               
               
               
              
       }
         
         
     }
        
     /*INICIO TRY CATCH*/  
     /*
        try{
            bddep.Create(dep);
            bddep.Read(70);
            bddep.Update(70, dep);
            bddep.Delete(70);
            bddep.Close(); 
            
            bdemp.Create(emp);
            bdemp.Read(70);
            bdemp.Update(70,emp);
            bdemp.Delete(70);
            bdemp.Close();
                    
        }
      */  
     }
        catch(SQLException ex){
            System.out.println("Error al insertar: "+ex.getSQLState() + " "+ ex.getMessage());
        }   finally{
        try{
            bddep.Close();
           } catch(SQLException ex){
               System.out.println("Error al cerrar BBDD: "+ex.getSQLState()+ " "+ ex.getMessage());
           }        
    }
     /*FIN DEL TRY CATCH*/   
        
    }
    
}
    