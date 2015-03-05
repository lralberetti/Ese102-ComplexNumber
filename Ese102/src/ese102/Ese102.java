/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese102;
import complexnumber.*;
import java.io.*;

/**
 *
 * @author user
 */
public class Ese102 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        double re = 0;
	double im =0;      
	double argument=0; 
	double modulus=0;
        ComplexNumber cn = new ComplexNumber();
        boolean valoreValido=false;
        InputStreamReader input = new InputStreamReader (System.in);
        BufferedReader tastiera = new BufferedReader (input);
        String linea;
        int coordinata=0;
        while(!valoreValido){
            System.out.println("QUALE COORDINATE VUOI INSERIRE?");
            System.out.println("DIGITA 1 PER LE COORDINATE POLARI ALTRIMENTI 2 PER LE COORDINATE RETTANGOLARI:");
            linea=tastiera.readLine();
         try{
                coordinata=Integer.valueOf(linea).intValue();
                valoreValido=true;
            }
            catch(Exception e){
                System.out.println("NON HAI INSERITO UN VALORE CORRETTO");
            }
        }
        if(coordinata==1){
            valoreValido=false;
            while(!valoreValido){
                System.out.println("INSERISCI IL MODULO (MAGGIORE O UGUALE A ZERO): ");
                linea=tastiera.readLine();
                try{
                    modulus=Double.valueOf(linea).doubleValue();
                    valoreValido=true;
                    
                }
                catch(NumberFormatException e){
                    System.out.println("NON HAI INSERITO UN VALORE CORRETTO");
                }
                catch(IllegalArgumentException e){
                    System.out.println("MODULO NON DEVE ESSERE MINORE DI 0");           
                }
            }
            valoreValido=false;
            while(!valoreValido){ 
                System.out.println("INSERISCI L'ARGOMENTO:");
                linea=tastiera.readLine();
              
                try{
                    argument=Double.valueOf(linea).doubleValue();
                    valoreValido=true;
                }
                catch(NumberFormatException e){
                    System.out.println("NON HAI INSERITO UN VALORE CORRETTO");
                }
            }
            cn.SetPolar(modulus,argument);
            System.out.println("PARTE REALE " + cn.getRe());
            System.out.println("PARTE IMMAGINARIA: " + cn.getIm()); 
           
        }
        else{
            valoreValido=false;
            while(!valoreValido)
            {
                System.out.print("INSERISCI LA PARTE IMMAGINARIA: ");
                linea=tastiera.readLine();
                    try{
                        im=Double.valueOf(linea).doubleValue();
                        valoreValido=true;
                        }
                    catch(NumberFormatException e){
                        System.out.println("NON HAI INSERITO UN VALORE CORRETTO");
                    }
            }
            valoreValido=false;
            while(!valoreValido){
                System.out.print("INSERISCI LA PARTE REALE: ");
                linea=tastiera.readLine();
                    try{
                        re=Double.valueOf(linea).doubleValue();
                        valoreValido=true;
                        }
                    catch(NumberFormatException e){
                        System.out.println("NON HAI INSERITO UN VALORE CORRETTO");
                    }  
                    cn.SetRectangular(im, re);
            System.out.println("IL MODULO è: " + cn.getModulus());
            System.out.println("L'ANGOLO THETA è:" + cn.getArgument());
            }
        } 
    }
    
}
