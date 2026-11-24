/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package burgershop;

/**
 *
 * @author omira
 */
public class BurgerShop {

    public static final int BURGERPRICE =500;
    //Prepaing=0
    //deliverded=1
    //canceled=2
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MainUI().setVisible(true);
        // TODO code application logic here
    }
    
    /**
     *
     * @return
     */
    public static int getBurgerPrice(){
        return BURGERPRICE;
    }
}
