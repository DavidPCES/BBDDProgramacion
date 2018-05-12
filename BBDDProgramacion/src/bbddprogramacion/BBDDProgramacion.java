/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbddprogramacion;

import java.sql.Date;
import java.sql.SQLException;
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
     {/*
        1.1 funciona
        1.2 funciona
        2.1 liada 
        2.2 funciona
        3 en blanco
        4 error sql 
        5 departamento nulo
        6 departamento nulo
         
      */
         
         System.out.println("\n\n");
         System.out.println("          BBDD Programacion Aplicacion CRUD          ");
         System.out.println("|***************************************************|");
       
         System.out.println("|------------------Eleccion Accion------------------|");
         System.out.println("|| 1.-    >> Listado de Departamentos     <<       ||");//funciona
         System.out.println("|| 2.-    >> Listado de Empleados         <<       ||");// funciona
         System.out.println("|| 3.-    >> Busqueda de Departamento     <<       ||");//     /*departamento por nombre buscar*/
         System.out.println("|| 4.-    >> Busqueda de Empleado         <<       ||");//     /*buscar empleado por nombre*/
         System.out.println("|---------------------------------------------------|");
         System.out.println("|| 5.-    >> Creacion de Departamentos    <<       ||");//funciona
         System.out.println("|| 6.-    >> Creacion de Empleado         <<       ||");//funciona
         System.out.println("|---------------------------------------------------|");
         System.out.println("|| 7.-    >> Borrado de Empleados         <<       ||");//funciona
         System.out.println("|| 8.-    >> Borrado de Departamentos     <<       ||");//funciona
         System.out.println("|| 0.-    >> Salir                        <<       ||");//
         System.out.println("|***************************************************|");
         System.out.print("-----> ");eleccion=sc.nextInt(); 
         
       switch(eleccion)
       {
           case 1:/*Listado Departamentos*/
               
         System.out.println("|--------------------------------------------------|");     
         System.out.println("|| 1.-    >> Busqueda Personalizada      <<       ||");
         System.out.println("|| 2.-    >> Mostrar Todos               <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.print("----> ");eleccionv2=sc.nextInt();
              if(eleccionv2==1)
              {
                  
         System.out.println("----> Departamento a buscar: ");no_dep=sc.nextInt();
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
         System.out.print("---->Mostrando todos los departamentos: \n");
                ArrayList<Departamento>departamentoAL=new ArrayList<>();
                departamentoAL=bddep.ReadTodos();
         System.out.println("|-------------------------------------------------|");
         System.out.printf("|%-10s %-20s |%-15s |%n","Dpto_no","Nom.Dep","Ciudad");
         System.out.println("|-------------------------------------------------|");
            for (int i=0;i<departamentoAL.size();i++)
            {
                System.out.printf("|%-10s %-20s |%-15s |%n", departamentoAL.get(i).getDept_no(),departamentoAL.get(i).getDnombre(),departamentoAL.get(i).getLoc());
            }
         System.out.println("|-------------------------------------------------|");   
              }
              
               break;
               
               
           case 2:
         System.out.println("|--------------------------------------------------|");     
         System.out.println("|| 1.-    >> Busqueda Personalizada      <<       ||");
         System.out.println("|| 2.-    >> Mostrar Todos               <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.print("----> ");eleccionv2=sc.nextInt();
              if(eleccionv2==1)
              {
         /*         
         System.out.print("---->Apellido del empleado a buscar: ");apellidos_emp=sc.next();
             emp=bdemp.ReadEmp(apellidos_emp);/*Metodo para imprimir valores de los datos introducidos*/
               /*imprimir datos del departamento
         System.out.println("\n|-------------------------------------------------------------------------------------------------------------|");
         System.out.printf("|%-10s %-20s |%-15s |%-10s |%-10s |%-10s |%-10s |%-10s |%n","Emp_no","Apellidos","Oficina","Dir","Fecha_alt","Salario","Comision","Dept_no","|");
         System.out.println("|-------------------------------------------------------------------------------------------------------------|");
                  
         System.out.printf("|%10s %-20s %-15s %-10s %-10s %-10s %-10s %-10s        |%n", emp.getEmp_no(),emp.getApellidos(),emp.getOficina(),emp.getDir(),emp.getFecha_alt(),emp.getSalario(),emp.getComision(),emp.getDept_no());
         System.out.printf("+------------------------------------------------------+ %n");
       */      
                  
         System.out.print("---->Numero del Empleado: ");no_emp=sc.nextInt();
         emp=bdemp.ReadEmp(no_emp);
         System.out.println("\n|-------------------------------------------------------------------------------------------------------------|");
         System.out.printf("|%10s %-20s %-15s %-10s %-15s %-10s %-10s %-10s  |%n","Emp_no","Apellidos","Oficina","Dir","Fecha_alt","Salario","Comision","Dept_no");
         System.out.println("|-------------------------------------------------------------------------------------------------------------|");
                  
         System.out.printf("|%10s %-20s %-15s %-10s %-10s %-10s %-10s %-10s       |%n", emp.getEmp_no(),emp.getApellidos(),emp.getOficina(),emp.getDir(),emp.getFecha_alt(),emp.getSalario(),emp.getComision(),emp.getDept_no());
         System.out.printf("+-------------------------------------------------------------------------------------------------------------+ %n");
         
         
                  
              }
              if(eleccionv2==2)
              {
         System.out.print("----> Mostrando todos los departamentos: \n");
                ArrayList<Empleado>empleadoAL=new ArrayList<>();
                empleadoAL=bdemp.ReadTodos();
 /*      System.out.println("|-------------------------------------------------|");
         System.out.printf("|%-10s %-20s |%-15s |%n","Dpto_no","Nom.Dep","Ciudad");
         System.out.println("|-------------------------------------------------|");
            for (int i=0;i<departamentoAL.size();i++)
            {
                System.out.printf("|%-10s %-20s |%-15s |%n", departamentoAL.get(i).getDept_no(),departamentoAL.get(i).getDnombre(),departamentoAL.get(i).getLoc());
            }
         System.out.println("|-------------------------------------------------|");  */
         System.out.println("|-------------------------------------------------------------------------------------------------------------|");
         System.out.printf("|%-10s %-20s %-15s %-10s %-10s %-10s %-10s %-10s %n","Emp_no","Apellidos","Oficio","Dir","Fecha_alt","Salario","Comision","Dept_no","               |");
         System.out.println("|-------------------------------------------------------------------------------------------------------------|");

         for(int i=0;i<empleadoAL.size();i++)
         {
             System.out.printf("|%-10s %-20s %-15s %-10s %-10s %-10s %-10s %-10s %n",
                     empleadoAL.get(i).getEmp_no(),empleadoAL.get(i).getApellidos(),empleadoAL.get(i).getOficina(),empleadoAL.get(i).getDir(),empleadoAL.get(i).getFecha_alt(),empleadoAL.get(i).getSalario(),empleadoAL.get(i).getComision(),empleadoAL.get(i).getDept_no()+
             "               |");
         }
         System.out.println("|-------------------------------------------------------------------------------------------------------------|");

              }
               
               break;
           case 3:/*Busqueda departamento por nombre*/
    //   System.out.println("|--------------------------------------------------|");
   //    System.out.println("|| 2.-    >> Mostrar Todos               <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.println("||        >> Busqueda Departamento       <<       ||");
         System.out.println("|--------------------------------------------------|"); 
         System.out.print("----> "); dnombre=sc.next();
        dep=bddep.ReadDepNombre(dnombre);
         
         
         System.out.println("|--------------------------------------------------|");
         System.out.printf("|%-10s %-20s %-15s  |%n","Dpto_no","Nom.Dep","Ciudad");
         System.out.println("|--------------------------------------------------|");
                  
         System.out.printf("|%-10s %-20s %-15s   |%n", dep.getDept_no(),dep.getDnombre(),dep.getLoc());
         System.out.printf("+--------------------------------------------------+ %n");
         
               break;
           case 4:/*busqueda empleado por nombre*/
    //   System.out.println("|--------------------------------------------------|");
   //    System.out.println("|| 2.-    >> Mostrar Todos               <<       ||");
         System.out.println("|--------------------------------------------------|");
/*Cambios desde aqui*/System.out.println("||        >> Busqueda Empleado por nombre<<       ||");
         System.out.println("|--------------------------------------------------|");                
         System.out.printf("----> Apellido del Empleado: "); apellidos_emp=sc.next();
         emp=bdemp.BusquedaEmpleado(apellidos_emp);
         System.out.println("\n|-------------------------------------------------------------------------------------------------------------|");  
         System.out.printf("|%-10s %-20s %-15s %-10s %-10s %-10s %-10s %-10s       |%n","Emp_no","Apellidos","Oficio","Dir","Fecha_alt","Salario","Comision","Dept_no");
         System.out.println("|-------------------------------------------------------------------------------------------------------------|");  
         System.out.printf("|%10s %-20s %-15s %-10s %-10s %-10s %-10s %-10s       |%n", emp.getEmp_no(),emp.getApellidos(),emp.getOficina(),emp.getDir(),emp.getFecha_alt(),emp.getSalario(),emp.getComision(),emp.getDept_no());
         System.out.printf("+-------------------------------------------------------------------------------------------------------------+ %n");
 

         
               break;
           case 5:
    //   System.out.println("|--------------------------------------------------|");
   //    System.out.println("|| 2.-    >> Mostrar Todos               <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.println("||        >> Creacion de Departamentos   <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.print("----> Dept_no: ");no_dep=sc.nextInt();
         dep.setDept_no(no_dep);      
         System.out.print("----> Dnombre: ");dnombre=sc.next();
         dep.setDnombre(dnombre);
         System.out.print("----> Loc: ");loc=sc.next();
         dep.setLoc(loc);
         bddep.Create(dep);
               
               break;
           case 6:
    //   System.out.println("|--------------------------------------------------|");
   //    System.out.println("|| 2.-    >> Mostrar Todos               <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.println("||        >> Creacion de Empleados       <<       ||");
         System.out.println("|--------------------------------------------------|"); 
         System.out.print("----> Emp_no: ");no_emp=sc.nextInt(); 
         emp.setEmp_no(no_emp);
         System.out.print("----> Apellidos: ");/*String*/apellidos_emp=sc.next();
         emp.setApellidos(apellidos_emp);
         System.out.print("----> Oficina: ");/*String*/oficina_emp=sc.next();
         emp.setOficina(oficina_emp);
         System.out.print("---->Dir: ");/*int*/dir_emp=sc.nextInt();
         emp.setDir(dir_emp);
         System.out.print("----> Fecha_alt segun el formato (yyyy-mm-dd): ");fecha_emp=sc.next();
                                              fecha_empdate=Date.valueOf(fecha_emp);
                                              emp.setFecha_alt(fecha_empdate);
         System.out.print("----> Salario: ");salario_emp=sc.nextDouble();
         emp.setSalario(salario_emp);
         System.out.print("----> Comision: ");comision_emp=sc.nextDouble();
         emp.setComision(comision_emp);
         System.out.print("----> Dept_no: ");deptno_emp=sc.nextInt();
         emp.setDept_no(deptno_emp);
         bdemp.Create(emp);
               break;
           case 7:
    //   System.out.println("|--------------------------------------------------|");
   //    System.out.println("|| 2.-    >> Mostrar Todos               <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.println("||        >> Eliminar Empleados          <<       ||");
         System.out.println("|--------------------------------------------------|"); 
         System.out.print("----> Eleccion de empleado a eliminar: ");no_emp=sc.nextInt();
            bdemp.BorrarEmp(no_emp);
               
               break;
           case 8:
   //    System.out.println("|--------------------------------------------------|");
   //    System.out.println("|| 2.-    >> Mostrar Todos               <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.println("||        >> Eliminar Departamentos      <<       ||");
         System.out.println("|--------------------------------------------------|");
         System.out.println("----> Eleccion de departamento a eliminar: ");no_dep=sc.nextInt();
            bddep.BorrarDep(no_dep);/*Metodo para eliminar valores de los datos introducidos*/

         
               
               break;
           case 0:
               continuar=false;
               break;
            
               
               
               
              
       }/* (mic drop)
            switch out
        */
         
         
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