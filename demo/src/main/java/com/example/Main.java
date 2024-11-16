package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.Entidad.Empleado;


 public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        
        //Crear un empleado
        crearEmpleado("Juan", 30);   
    
    
    
		    em.close();
        emf.close();
    }
    
    //Método para crear un nuevo empleado
    public static void crearEmpleado(String nombre, int edad) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setEdad(edad);

        em.persist(empleado);

        em.getTransaction().commit();
        em.close();
    }
}   