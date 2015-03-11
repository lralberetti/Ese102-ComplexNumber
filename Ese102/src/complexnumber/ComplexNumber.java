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
    static private double initRe;
    static private double initIm;
    static private StringFormat initFormat;
    
    private double re;
    private double im;
    private StringFormat format;
    
    /**
     * 
     * @param re
     * @param im 
     */
    static public void setInitRectangular(double re, double im) {
        initRe = re;
        initIm = im;
    }
    /**
     * 
     * @param modulus
     * @param argument 
     */
    
    static public void setInitPolar(double modulus, double argument) {
        if(modulus < 0)
        {
            throw new IllegalArgumentException("Modulus must be greater or equal to 0");
        }
        initRe = modulus * Math.cos(argument);
        initIm = modulus * Math.sin(argument);
    }
    /**
     * Caratteristica dell'oggetto ComplexNumber, assegnadogli sia le coordinate polari e rettangolari
     */
    static public enum  StringFormat{
        RECTANGULAR,
        POLAR
    }
    
    public String ToString(){
        return toString(this.format);
	}
    /**
     * 
     * @param format
     * @return 
     */
    public String toString(StringFormat format) {
        String r = new String();
        switch(format) {
		case RECTANGULAR:
			r = this.re + "+(" + this.im + ")i";
			break;
		case POLAR:
			r = this.getModulus() + "*exp(i*" + this.getArgument() +")";
			break;
		default:
			throw new UnsupportedOperationException();
		}
		return r;
    }
    
    /**
     * 
     * @param o
     * @return 
     */
    public boolean equals(Object o) {
		boolean r = false;
		if(o instanceof ComplexNumber) {
			ComplexNumber p = (ComplexNumber)o;
			if(this.re == p.getRe() && this.im == p.getIm()) {
				r = true;
			}
		}
		return r;
	}
    /**
     * 
     * @param operand1
     * @param operand2
     * @return 
     */
    
    static public ComplexNumber add(ComplexNumber operand1, ComplexNumber operand2) {
        ComplexNumber ris = new ComplexNumber();
        ris.SetRectangular(operand1.getRe()+operand2.getRe(), operand1.getIm() + operand2.getIm());
        return ris;
    }
    
    
    /**
     * 
     * @param operand1
     * @param operand2
     * @return 
     */
    
    static public ComplexNumber sub(ComplexNumber operand1, ComplexNumber operand2){
        ComplexNumber ris= new ComplexNumber();
        ris.SetRectangular(operand1.getRe()-operand2.getRe(),operand1.getIm() - operand2.getIm());
        return ris;
    }
    /**
     * 
     * @param operand1
     * @param operand2
     * @return 
     */
    static public ComplexNumber divide(ComplexNumber operand1, ComplexNumber operand2){
        ComplexNumber ris= new ComplexNumber();
        ris.SetPolar(operand1.getModulus()/operand2.getModulus(), operand1.getArgument()-operand2.getArgument());
        return ris;
    }
    /**
     * 
     * @param operand1
     * @param operand2
     * @return 
     */
  static public ComplexNumber multiply(ComplexNumber operand1,ComplexNumber operand2){
        ComplexNumber ris = new ComplexNumber();
        ris.SetPolar(operand1.getModulus()*operand2.getModulus(),operand1.getArgument()+operand2.getArgument());
        return ris;
    }
  /**
   * 
   * @param operand
   * @return 
   */
  
  static public ComplexNumber conjgate(ComplexNumber operand){
      ComplexNumber ris= new ComplexNumber();
      double re=operand.getRe();
      double im=operand.getIm()*-1;
      ris.SetRectangular(im, re);
      return ris;    
  }
    public ComplexNumber() {
        this.re = initRe;
        this.im = initIm;
    }
    
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
    /**
     * Ritorna un complex number che è l'addizione della parte reale e immaginaria dei due numeri complessi
     * @param addendo
     * @return 
     */
    public ComplexNumber add(ComplexNumber operand){
        ComplexNumber somma=new ComplexNumber();
        double re=this.re+operand.getRe();
        double im=this.im+operand.getIm();
        somma.SetRectangular(im, re);        //con il . si accede sia al campo sia ai metodi.
        return somma;
    }
    /**
     * Ritorna un complex number che è la sottrazione della parte reale e immaginaria dei due numeri complessi
     * @param operand
     * @return 
     */
    public ComplexNumber sub(ComplexNumber operand){
        ComplexNumber sottrazione=new ComplexNumber();
        double re=this.re-operand.getRe();
        double im=this.im-operand.getIm();
        sottrazione.SetRectangular(im, re);
        return sottrazione;
    }
    /**
     * ritorna un complex number che è la moltiplicazione di mudulo e argomento dei due numeri complessi
     * @param operand
     * @return 
     */
    public ComplexNumber multiply(ComplexNumber operand){
        ComplexNumber moltiplicazione=new ComplexNumber();
        double modulus= this.getModulus()*operand.getModulus();
        double argument= this.getArgument()*operand.getArgument();
        moltiplicazione.SetPolar(modulus, argument);
        return moltiplicazione;
    }
    /**
     * ritorna un complex number che è la divisione di modulo e argomento dei due numeri complessi
     * @param operand
     * @return 
     */
    public ComplexNumber divide(ComplexNumber operand){
        ComplexNumber divisione=new ComplexNumber();
        double mudulus=this.getModulus()/operand.getModulus();
        double argument=this.getArgument()-operand.getArgument();
        divisione.SetPolar(mudulus, argument);
        return divisione;
    }
    /**
     * im cambiato di segno
     * @param operand
     * @return 
     */
    public ComplexNumber conjgate(){
        ComplexNumber coniugato=new ComplexNumber();
        double re=this.getRe();
        double im=this.getIm()*-1;
        coniugato.SetRectangular(im, re);
        return coniugato;
    }
}
/**
 * SONO STATE UTILIZZATE LE 4 FUNZIONI GETTER (getRe, getIm, getModulus, getArgument), E SOLO DUE
 * FUNZIONI SETTER (SetPolar, SetRectangular) PERCHè PER CALCOLARE IM E RE HO BISOGNO DEL MODULO E L'ARGOMENTO.
 * PER CALCOLARE MODULO E ARGOMENTO SI SONO UTILIZZATE LE RELAZIONI CON IM E RE.
*/