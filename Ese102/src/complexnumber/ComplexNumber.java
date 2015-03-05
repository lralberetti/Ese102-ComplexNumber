/*
LE RELAZIONI CHE LEGANO IL TUTTO SONO:
RE(MODULO, ARGOMENTO)= Cos THETA * HYP (modulo)
IM=(MODULO, ARGOMENTO)= Sen THETA * HYP (modulo)
MODULO(RE,IM)= SQRT RE*RE + IM*IM
THETA(RE,IM)=A TAN IM/RE
 */
package complexnumber;
import static java.lang.Math.*;

/**
 *
 * @author user
 */
public class ComplexNumber {
    private double re;
    private double im;
    
    public String formatComplexNumber()
    {
        return (this.re + "+(" + this.im + ")i");
    }


    /**
     * @return the re
     */
    public double getRe() {
        return re;
    }

    /**
     * @return the im
     */
    public double getIm() {
        return im;
    }
    
    /**
     * RITORNA IL VETTORE DI MODULO CALCOLATO
     *@return    
    */
    public double getModulus(){
        return sqrt((this.re*this.re)+(this.im*this.im));
    }
    
    /**
     * RITORNA L'ANGOLO THETA.
     * @return 
     */
    
    public double getArgument(){
        
        //Chiedere le altre relazioni, in questo modo è sbagliato.
        double r;
        if(im==0 && re==0)
            r=0;
        else
            r= (atan(this.im/this.re)*180)/Math.PI;       
            return r;
            
    }
   
    /**
    * IN IMPUT RICEVO LE COORDINATE RETTANGOLARI O CARTESIANE
    * QUINDI LE SETTO UGUALI ALL'INPUT
    */

    public void SetRectangular(double im, double re){
        this.im=im;
        this.re=re;
    }
    
    /**
     *  SOHCAHTOA
     *  (RE=ADIACENT)--> CAH --> COS(THETA)*HYP
     *  (IM=OPP)--> SOH --> IM= SEN(THETA)*HYP 
     */    
    public void SetPolar(double modulus, double argument){
        if(modulus >= 0)
        {
        	this.re = Math.cos(argument*Math.PI/180)*modulus;
	        if(argument == 180)
	        	this.im = 0;
	        else
	        	this.im = Math.sin(argument*Math.PI/180)*modulus;
        }
        else
        	throw new IllegalArgumentException("INSERISCI UN VALORE MAGGIORE DI 0");
    }   
}
/**
 * SONO STATE UTILIZZATE LE 4 FUNZIONI GETTER (getRe, getIm, getModulus, getArgument), E SOLO DUE
 * FUNZIONI SETTER (SetPolar, SetRectangular) PERCHè PER CALCOLARE IM E RE HO BISOGNO DEL MODULO E L'ARGOMENTO.
 * PER CALCOLARE MODULO E ARGOMENTO SI SONO UTILIZZATE LE RELAZIONI CON IM E RE.
*/