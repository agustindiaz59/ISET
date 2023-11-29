package com.mycompany.controlstock;

import com.mycompany.controlstock.graficos.Principal;
import java.awt.EventQueue;

public class ControlStock {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }
}
