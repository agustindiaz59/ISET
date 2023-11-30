package com.mycompany.controlstock.modelo;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Producto {
    private String codigo;
    private String descripcion;
    private int stock;
    private double precioPorUnidad;
    private String rubro;
    private List<String> rubrosValidos = new ArrayList<>();

    public Producto(String codigo, String descripcion, int stock, double precioPorUnidad, String rubro) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precioPorUnidad = precioPorUnidad;
        this.rubro = rubro;
        iniciarRubros();
    }
    public Producto() {
        iniciarRubros();
    }
    private void iniciarRubros(){
        rubrosValidos.add("Todos");
        rubrosValidos.add("Alimenticio");
        rubrosValidos.add("Bebidas");
        rubrosValidos.add("Tecnologia");
        rubrosValidos.add("Electrodomesticos");
        rubrosValidos.add("Miscelaneos");
    }
    
    public boolean esValido(){
        return (codigo != null && descripcion != null && stock != -1 && precioPorUnidad != -1 && rubrosValidos.stream().anyMatch(e-> e.equals(rubro)));
    }
    public String toString(){
        return "'" + codigo + "'" +", '"+ descripcion + "', " + stock + ", " + precioPorUnidad + "," + "'" + rubro + "'";
    }
}
