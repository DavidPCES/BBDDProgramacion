/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbddprogramacion;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
     /*Creacion DEPARTAMENTO*/   
       /*
        dep.setDept_no(70);
        dep.setDnombre("INFORMATICA");
        dep.setLoc("MADRID");
       */ 
     /*CIERRO DEPARTAMENTO*/
     
     
        Empleado emp=new Empleado();
        Empleados bdemp =new Empleados();
     /*EMPLEADO*/
        /*
        emp.setEmp_no(70);//numero de empleado
        emp.setApellidos("Gonzalez");
        emp.setOficina("Inteligencia Central");
        emp.setDir(5);
        emp.setFecha_alt(Date.valueOf("25 marzo 1465"));
        emp.setSalario(20.35);
        emp.setComision(5.32);
        emp.setDept_no(12);
        */                                            
     /*CIERRO EMPLEADO*/
     
     
     /*Variables App Crud*/
     Scanner sc=new Scanner(System.in);
     boolean continuar=true;
     int eleccion,eleccionv2;
            /*variables departamento*/
                int no_dep;
                String loc; 
                String dnombre;
            /*fin variables departamento*/
            /*variables empleado*/
                int no_emp;
                String apellidos_emp,oficina_emp;
                int dir_emp;
                String fecha_emp;
                Date fecha_empdate;
                double salario_emp;
                double comision_emp;
                int deptno_emp;
            /*fin variables empleado*/
     /*Fin variables Crud*/
     try{
     while(continuar)
     {
         System.out.println("          BBDD Programacion Aplicacion CRUD          ");
         System.out.println("|***************************************************|");
       
         System.out.println("|------------------Eleccion Accion------------------|");
         System.out.println("|| 1.-    >> Listado de Departamentos     <<       ||");//
         System.out.println("|| 2.-    >> Listado de Empleados         <<       ||");
         System.out.println("|| 3.-    >> Busqueda de Departamento     <<       ||");
         System.out.println("|| 4.-    >> Busqueda de Empleado         <<       ||");//
         System.out.println("|---------------------------------------------------|");
         System.out.println("|| 5.-    >> Creacion de Empleado         <<       ||");
         System.out.println("|| 6.-    >> Creacion de Departamentos    <<       ||");//
         System.out.println("|---------------------------------------------------|");
         System.out.println("|| 7.-    >> Borrado de Empleados         <<       ||");//
         System.out.println("|| 8.-    >> Borrado de Departamentos     <<       ||");//
         System.out.println("|| 0.-    >> Salir                        <<       ||");//
         System.out.println("|***************************************************|");
         System.out.print("----->");eleccion=sc.nextInt(); 
         
       switch(eleccion)
       {
           case 1:/*Listado Departamentos*/
               
         System.out.println("|--------------------------------------------------|");     
         System.out.println("|| 1.-    >> Busqueda Personalizada      <<       ||");
         System.out.println("|| 2.-    >> Mostrar Todos               <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.print("---->");eleccionv2=sc.nextInt();
              if(eleccionv2==1)
              {
                  
         System.out.println("---->Departamento a buscar: ");no_dep=sc.nextInt();
               dep=bddep.ReadNum(no_dep);/*Metodo para imprimir valores de los datos introducidos*/
               /*imprimir datos del departamento*/
         System.out.println("|--------------------------------------------------|");
         System.out.printf("|%-10s %-20s |%-15s |%n","Dpto_no","Nom.Dep","Ciudad");
         System.out.println("|--------------------------------------------------|");
                  
         System.out.printf("|%10d |%-20s |%-15s |%n", dep.getDept_no(),dep.getDnombre(),dep.getLoc());
         System.out.printf("+--------------------------------------------------+ %n");
               
              }
              if(eleccionv2==2)
              {
         System.out.print("---->Mostrando todos los departamentos: ");
                ArrayList<Departamento>departamentoAL=new ArrayList<>();
                departamentoAL=bddep.ReadTodos();
         System.out.println("");
              }
               break;
               
               
           case 2:
         System.out.println("|--------------------------------------------------|");     
         System.out.println("|| 1.-    >> Busqueda Personalizada      <<       ||");
         System.out.println("|| 2.-    >> Mostrar Todos               <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.print("---->");eleccionv2=sc.nextInt();
              if(eleccionv2==1)
              {
                  
         System.out.println("---->Empleado a buscar: ");no_dep=sc.nextInt();
               dep=bddep.ReadNum(no_dep);/*Metodo para imprimir valores de los datos introducidos*/
               /*imprimir datos del departamento*/
         System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------|");
         System.out.printf("|%-10s %-20s |%-15s |%-10s |%-10s |%-10s |%-10s |%-10s |%n","Emp_no","Apellidos","Oficina","Dir","Fecha_alt","Salario","Comision","Dept_no","|");
         System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------|");
                  
         System.out.printf("|%10d |%-20s |%-15s |%-10d |%-10d |%-10d |%-10d |%-10d |%n", emp.getEmp_no(),emp.getApellidos(),emp.getOficina(),emp.getDir(),emp.getFecha_alt(),emp.getSalario(),emp.getComision(),emp.getDept_no());
         System.out.printf("+------------------------------------------------------+ %n");
               
              }
              if(eleccionv2==2)
              {
         System.out.print("---->Mostrando todos los departamentos: ");
                ArrayList<Departamento>departamentoAL=new ArrayList<>();
                departamentoAL=bddep.ReadTodos();
         System.out.println("");
              }
               
               break;
           case 3:
               
               break;
           case 4:
    //   System.out.println("|--------------------------------------------------|");
   //    System.out.println("|| 2.-    >> Mostrar Todos               <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.println("||        >> Busqueda Empleado por nombre<<       ||");
         System.out.println("|--------------------------------------------------|");                
         System.out.println("---->"); apellidos_emp=sc.nextLine();
         emp=bdemp.ReadEmp(apellidos_emp);
               
               break;
           case 5:
    //   System.out.println("|--------------------------------------------------|");
   //    System.out.println("|| 2.-    >> Mostrar Todos               <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.println("||        >> Creacion de Departamentos   <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.println("---->Dept_no");no_dep=sc.nextInt(); 
         System.out.println("---->Dnombre");dnombre=sc.nextLine();
         System.out.println("---->Loc");loc=sc.nextLine();
         bddep.Create(dep);
               
               break;
           case 6:
    //   System.out.println("|--------------------------------------------------|");
   //    System.out.println("|| 2.-    >> Mostrar Todos               <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.println("||        >> Creacion de Empleados       <<       ||");
         System.out.println("|--------------------------------------------------|"); 
         System.out.println("---->Emp_no");no_emp=sc.nextInt(); 
         System.out.println("---->Apellidos");/*String*/apellidos_emp=sc.nextLine();
         System.out.println("---->Oficina");/*String*/oficina_emp=sc.nextLine();
         System.out.println("---->Dir");/*int*/dir_emp=sc.nextInt();
         System.out.println("---->Fecha_alt");fecha_emp=sc.nextLine();
                                              fecha_empdate=Date.valueOf(fecha_emp);
         System.out.println("---->Salario");salario_emp=sc.nextDouble();
         System.out.println("---->Comision");comision_emp=sc.nextDouble();
         System.out.println("---->Dept_no");deptno_emp=sc.nextInt();
         bdemp.Create(emp);
               break;
           case 7:
    //   System.out.println("|--------------------------------------------------|");
   //    System.out.println("|| 2.-    >> Mostrar Todos               <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.println("||        >> Eliminar Empleados          <<       ||");
         System.out.println("|--------------------------------------------------|"); 
         System.out.println("---->Eleccion de empleado a eliminar: ");no_emp=sc.nextInt();
            bdemp.BorrarEmp(no_emp);
               
               break;
           case 8:
   //    System.out.println("|--------------------------------------------------|");
   //    System.out.println("|| 2.-    >> Mostrar Todos               <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.println("||        >> Eliminar Departamentos      <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.println("---->Eleccion de departamento a eliminar: ");no_dep=sc.nextInt();
            bddep.BorrarDep(no_dep);/*Metodo para eliminar valores de los datos introducidos*/

         
               
               break;
           case 0:
               continuar=false;
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
    