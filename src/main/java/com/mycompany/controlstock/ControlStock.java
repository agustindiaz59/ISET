/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.controlstock;

import com.mycompany.controlstock.graficos.Principal;
import java.awt.EventQueue;

/**
 *
 * @author matia
 */
public class ControlStock {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }
}
