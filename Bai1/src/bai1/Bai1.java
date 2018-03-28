/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author MyPC
 */
public class Bai1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        SpriteMapManipulator.join("E:\\Imgs", "E:\\ImgsOut\\out.png", 2);
        }
        catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }
    
}
