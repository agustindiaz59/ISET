package com.mycompany.controlstock.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@Data@NoArgsConstructor
public class Producto {
    private String codigo;
    private String descripcion;
    private int stock = -1;
    private double precioPorUnidad = -1;
    public boolean esValido(){
        return (codigo != null && descripcion != null && stock != -1 && precioPorUnidad != -1);
    }
    public String toString(){
        return "'" + codigo + "'" +", '"+ descripcion + "', " + stock + ", " + precioPorUnidad;
    };
}
