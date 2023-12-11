/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200;

/**
 *
 * @author 91790
 */
public class Control {
    
     UserAuthorization userAuth= new UserAuthorization();
     
     public void frameOpen(){
                userAuth.setVisible(true);
     }
                
     public void frameCloser(){
                userAuth.dispose();
                }
}
