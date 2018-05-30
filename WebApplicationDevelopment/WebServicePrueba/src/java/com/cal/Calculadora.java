/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cal;

import javax.jws.WebService;

/**
 *
 * @author danielguevara
 */
@WebService
public class Calculadora {
    public Calculadora(){}
    
    public float Suma(float a, float b){
        return a+b;
    }
    
    public float Resta(float a, float b){
        return a-b;
    }
    
    public float Division(float a, float b){
        return a/b;
    }
    
    public float Multiplicacion(float a, float b){
        return a*b;
    }
    
}
