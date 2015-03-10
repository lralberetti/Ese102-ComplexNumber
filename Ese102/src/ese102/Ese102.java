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
    /**
        double re = 0;
	double im =0;      
	double argument=0; 
	double modulus=0;
                
        ComplexNumber.setInitRectangular(45, 7);
        
        ComplexNumber n1 = new ComplexNumber();
        ComplexNumber n2 = new ComplexNumber();
        ComplexNumber ris = new ComplexNumber();
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
            
            n1.SetPolar(modulus,argument);
            System.out.println("PARTE REALE " + n1.getRe());
            System.out.println("PARTE IMMAGINARIA: " + n1.getIm()); 
           
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
            n1.SetRectangular(im, re);
            System.out.println("IL MODULO è: " + n1.getModulus());
            System.out.println("L'ANGOLO THETA è:" + n1.getArgument());
            }
        }
            valoreValido=false;
        */
        double re = 0;
	double im =0;      
	double argument=0; 
	double modulus=0;        
        ComplexNumber.setInitRectangular(45, 7);
        ComplexNumber n1 = new ComplexNumber();
        ComplexNumber n2 = new ComplexNumber();
        ComplexNumber ris = new ComplexNumber();
        boolean valoreValido=false;
        InputStreamReader input = new InputStreamReader (System.in);
        BufferedReader tastiera = new BufferedReader (input);
        String linea;
        int operazione=0;
            while(!valoreValido){
                 System.out.println("Che operazione vuoi svolgere?");
                 System.out.println("1-> Addizione 2-> Sottrazione 3-> Moltiplicazione 4-> Divisione 5->Coniugato");
                 linea=tastiera.readLine();        
                try{
                    operazione=Integer.valueOf(linea).intValue();
                    valoreValido=true;
                }
                catch(NumberFormatException e){
                    System.out.println("NON HAI INSERITO UN VALORE CORRETTO");
                }
            
            }
            if(operazione==1){
                valoreValido=false;
                while(!valoreValido){
                System.out.println("INSERISCI LA PARTE REALE CHE VUOI AGGIUNGERE ");
                linea=tastiera.readLine();
                try{
                    re=Double.valueOf(linea).doubleValue();
                    valoreValido=true;
                }
                catch(NumberFormatException e){
                    System.out.println("NON HAI INSERITO UN VALORE CORRETTO");
                }
            }
                
            valoreValido=false;
            while(!valoreValido){
                System.out.println("INSERISCI LA PARTE IMMAGINARA CHE VUOI AGGIUNGERE: ");
                linea=tastiera.readLine();
                try{
                    im=Double.valueOf(linea).doubleValue();
                    valoreValido=true;
                }
                catch(NumberFormatException e){
                    System.out.println("NON HAI INSERITO UN VALORE CORRETTO");
                }
            }
            n1.SetRectangular(im, re);
                valoreValido=false;
                while(!valoreValido){
                System.out.println("INSERISCI LA PARTE REALE DEL SECONDO ADDENDO: ");
                linea=tastiera.readLine();
                try{
                    re=Double.valueOf(linea).doubleValue();
                    valoreValido=true;
                }
                catch(NumberFormatException e){
                    System.out.println("NON HAI INSERITO UN VALORE CORRETTO");
                }
            }
                
            valoreValido=false;
            while(!valoreValido){
                System.out.println("INSERISCI LA PARTE IMMAGINARA DEL SECONDO ADDENDO: ");
                linea=tastiera.readLine();
                try{
                    im=Double.valueOf(linea).doubleValue();
                    valoreValido=true;
                }
                catch(NumberFormatException e){
                    System.out.println("NON HAI INSERITO UN VALORE CORRETTO");
                }
            }
            n2.SetRectangular(im, re);
            ris=ComplexNumber.add(n1, n2);
            System.out.println(ris.formatComplexNumber());    //il metodo vieni richiamato da un oggetto quindi viene messo prima n1-> oggetto . ->accedo al metodo
        }
            else if(operazione==2){
                    valoreValido=false;
                    while(!valoreValido){
                        System.out.println("INSERISCI LA PARTE LA REALE CHE VUOI SOTTRARRE: ");
                        linea=tastiera.readLine();
                        try{
                            re=Double.valueOf(linea).doubleValue();
                            valoreValido=true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("NON HAI INSERITO UN VALORE CORRETTO");
                        }
                    }
                    valoreValido=false;
                    while(!valoreValido)
                        System.out.println("INSERISCI LA PARTE IMMAGINARIA CHE VUOI SOTTRARRE: ");
                        linea=tastiera.readLine();
                        try{
                            im=Double.valueOf(linea).doubleValue();
                            valoreValido=true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("NON HAI INSERITO UN VALORE CORRETTO");
                        }
                        n2.SetRectangular(im, re);
                        ris=n1.sub(n2);
                        System.out.println(n1.formatComplexNumber()+"-"+n2.formatComplexNumber()+"="+ris.formatComplexNumber());
                    }
                    else if(operazione==3)
                    {
                    valoreValido=false;
                    while(!valoreValido){
                        System.out.println("INSERISCI IL MODULO: ");
                        linea=tastiera.readLine();
                        try{
                            modulus=Double.valueOf(linea).doubleValue();
                            valoreValido=true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("NON HAI INSERITO UN VALORE CORRETTO");
                        }
                    }
                    valoreValido=false;
                    while(!valoreValido){
                        System.out.println("INSERISCI L'ANGOLO THETA");
                        linea=tastiera.readLine();
                        try{
                            argument=Double.valueOf(linea).doubleValue();
                            valoreValido=true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("NON HAI INSERITO UN VALORE CORRETTO");
                        }
                    }
                    n2.SetPolar(modulus, argument);
                    ris=n1.multiply(n2);
                    System.out.println(n1.formatComplexNumber()+"*"+n2.formatComplexNumber()+"="+ris.formatComplexNumber());
                    }
                    else if(operazione==4){                    {
                    valoreValido=false;
                    while(!valoreValido){
                        System.out.println("INSERISCI IL MODULO: ");
                        linea=tastiera.readLine();
                        try{
                            modulus=Double.valueOf(linea).doubleValue();
                            valoreValido=true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("NON HAI INSERITO UN VALORE CORRETTO");
                        }
                    }
                    valoreValido=false;
                    while(!valoreValido){
                        System.out.println("INSERISCI L'ANGOLO THETA");
                        linea=tastiera.readLine();
                        try{
                            argument=Double.valueOf(linea).doubleValue();
                            valoreValido=true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("NON HAI INSERITO UN VALORE CORRETTO");
                        }
                    }
                    n2.SetPolar(modulus, argument);
                    ris=n1.divide(n2);
                    System.out.println(n1.formatComplexNumber()+"/"+n2.formatComplexNumber()+"="+ris.formatComplexNumber());
                    }
                 }
                 else
                 ris=n1.conjgate();
                 System.out.println(n1.formatComplexNumber());
           }   
}    

