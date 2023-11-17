package com.mycompany.controlstock.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Repositorio {
    private static Repositorio instancia;
    private Connection conexion;
    private Statement comando;
    private ResultSet resultado;
    
    private Repositorio(){
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectojava","root","admin");
            System.out.println("Coneccion BD exitosa");
            comando = conexion.createStatement();
        }catch(SQLException e){
            System.out.println("Error iniciando la coneccion, ERR: " + e.getErrorCode());
        }
    }
    //implemento patron de diseño singleton
    public static synchronized Repositorio getInstancia(){
        if(instancia == null){
            instancia = new Repositorio();
        }
        return instancia;
    }
    //Metodo para consultas select
    public ResultSet select(String sql){
        try{
            resultado = comando.executeQuery(sql);
            return resultado;
        }catch(SQLException e){            
            System.out.println("Error ejecutando la consulta, ERR: " + e.getErrorCode());
            return null;
        }
    }
    //Metodo para consultas update, create, drop, alter, etc.
    public void update(String sql){
        try{
            comando.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println("Error ejecutando el update, ERR: " + e.getErrorCode());
        }
    }
}
