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
     * Inizializza i campi di classe initRe ed initIm nonchè il formato di rappresentazione RETTANGOLARE
     * @param re
     * @param im 
     */
    static public void setInitRectangular(double re, double im) {
        initRe = re;
        initIm = im;
        initFormat= StringFormat.RECTANGULAR;
    }
    /**
     * Inizializzo i campi di classe initRe, initIm nonchè il formato di rappresentazione Polare
     * Se inserito modulo < 0 creo e lancio un eccezione.
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
        initFormat= StringFormat.POLAR;
        }
    /**
     * somma i valori degli oggetti ricevuti come paramento in una instanza(oggetto)
     * @param operand1
     * @param operand2
     * @return una instanza con il risultato
     */
        static public ComplexNumber add(ComplexNumber operand1, ComplexNumber operand2) {
        ComplexNumber ris = new ComplexNumber();
        ris.setRectangular(operand1.getRe()+operand2.getRe(), operand1.getIm() + operand2.getIm());
        return ris;
        }
    
    
    /**
     *sottrae il valore del secondo oggetto al primo, ricevuti come parametro in una instanza (oggetto)
     * @param operand1
     * @param operand2
     * @return una instanza con il risultato
     */
    
    static public ComplexNumber sub(ComplexNumber operand1, ComplexNumber operand2){
        ComplexNumber ris= new ComplexNumber();
        ris.setRectangular(operand1.getRe()-operand2.getRe(),operand1.getIm() - operand2.getIm());
        return ris;
    }
    
    /**
     * divide il valore del primo oggetto ottenuto come parametro per il secondo per il modulo, mentre la differenza per gli argomenti 
     * @param operand1
     * @param operand2
     * @return una instanza con il risultato
     */
    static public ComplexNumber divide(ComplexNumber operand1, ComplexNumber operand2){
        ComplexNumber ris= new ComplexNumber();
        ris.setPolar(operand1.getModulus()/operand2.getModulus(), operand1.getArgument()-operand2.getArgument());
        return ris;
    }
    /**
     * moltiplica il valore del primo oggetto ottenuto come parametro per il secondo, mentre si fa la somma per gli argomenti
     * @param operand1
     * @param operand2
     * @return una instanza con il risultato
     */
  static public ComplexNumber multiply(ComplexNumber operand1,ComplexNumber operand2){
        ComplexNumber ris = new ComplexNumber();
        ris.setPolar(operand1.getModulus()*operand2.getModulus(),operand1.getArgument()+operand2.getArgument());
        return ris;
    }
    
  
  /**
    * im cambiato di segno
    * @param operand
    * @return una instanza con il risultato
    */
 
     static public ComplexNumber conjgate(ComplexNumber operand){
     ComplexNumber ris= new ComplexNumber();
     double re=operand.getRe();
     double im=operand.getIm()*-1;
     ris.setRectangular(im, re);
     return ris;    
  }

    /**
     * definisco i due possibili valori che una variabile di tipo StringFormat può assumere
     */
    static public enum  StringFormat{
        RECTANGULAR,
        POLAR
    }
    /**
     * Ridefinizione del metodo toString poichè esso è gia implementato nella 
     * classe Object in questo metodo lo specializzo aggiungendo questa funzione.
     * 
     * @return 
     */
    @Override public String toString(){
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
     * restituisce vero se l'oggetto invocante della classe ComplexNumber e
     * quello passato come argomento,della medesima classe,sono uguali
     * @param o
     * @return 
     */
    @Override 
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
     * Costruttore che inizializza i campi dell'oggetto a initRe, initIm ed initFormat
     * @param operand1
     * @param operand2
     * @return 
     */
    public ComplexNumber() {
        this.re = initRe;
        this.im = initIm;
        this.format= initFormat;
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
    
    public void setStringFormat(StringFormat format) {
		this.format = format;
	}
    
    /**
     * RITORNA IL VETTORE DI MODULO CALCOLATO
     *@return    
    */
    public double getModulus(){
        return sqrt((this.re*this.re)+(this.im*this.im));
    }
    
    /**
     * toDegrees transformo gli angoli in gradi.
     * Il valore di ritorno è in gradi sessehesimali.
     * @return 
     */
    
    public double getArgument(){
        double argument = 0;
		if(re == 0 || im == 0)
		{
                    argument = 0;
			if(im > 0)
				argument = 90;
			else if(im < 0)
				argument = 270;
		}
		else
		{
			argument = Math.toDegrees(Math.atan(this.im/this.re));
			if (re < 0 && im > 0 || re < 0 && im < 0)
				argument =argument + 180;
			else if (re > 0 && im < 0)
				argument =argument + 360;
		}
		return argument;
    }

    /**
    * IN IMPUT RICEVO LE COORDINATE RETTANGOLARI O CARTESIANE
    * QUINDI LE SETTO UGUALI ALL'INPUT
    */

    public void setRectangular(double im, double re){
        this.im=im;
        this.re=re;
    }
    
    /**
     *  SOHCAHTOA
     *  (RE=ADIACENT)--> CAH --> COS(THETA)*HYP
     *  (IM=OPP)--> SOH --> IM= SEN(THETA)*HYP 
     *  Setto quindi le coordinatre polari a seconda di quanto ricevuto in input
     */    
    public void setPolar(double modulus, double argument){
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
     * @param operand
     * @return un instanza con il risultato
     */
    public ComplexNumber add(ComplexNumber operand){
        ComplexNumber somma=new ComplexNumber();
        double re=this.re+operand.getRe();
        double im=this.im+operand.getIm();
        somma.setRectangular(im, re);        //con il . si accede sia al campo sia ai metodi.
        return somma;
    }
    /**
     * Ritorna un complex number che è la sottrazione della parte reale e immaginaria dei due numeri complessi
     * @param operand
     * @return un instanza con il risultato
     */
    public ComplexNumber sub(ComplexNumber operand){
        ComplexNumber sottrazione=new ComplexNumber();
        double re=this.re-operand.getRe();
        double im=this.im-operand.getIm();
        sottrazione.setRectangular(im, re);
        return sottrazione;
    }
    /**
     * ritorna un complex number che è la moltiplicazione di mudulo 
     * e la somma dei due argomenti dei numeri complessi
     * @param operand
     * @return un instanza con il risultato
     */
    public ComplexNumber multiply(ComplexNumber operand){
        ComplexNumber moltiplicazione=new ComplexNumber();
        double modulus= this.getModulus()*operand.getModulus();
        double argument= this.getArgument()+operand.getArgument();
        moltiplicazione.setPolar(modulus, argument);
        return moltiplicazione;
    }
    /**
     * ritorna un complex number che è la divisione di modulo 
     * e la differenza dei due argomenti dei numeri complessi
     * @param operand
     * @return un instanza con il risultato
     */
    public ComplexNumber divide(ComplexNumber operand){
        ComplexNumber divisione=new ComplexNumber();
        double mudulus=this.getModulus()/operand.getModulus();
        double argument=this.getArgument()-operand.getArgument();
        divisione.setPolar(mudulus, argument);
        return divisione;
    }
  
    /**
    * creo un instanza per il coniugato.
    * @return una nuova instanza con il coniugato.
    */    
    public ComplexNumber getConjugate(){
        ComplexNumber coniugato=new ComplexNumber();
        double re=this.getRe();
        double im=this.getIm()*-1;
        coniugato.setRectangular(im, re);
        return coniugato;
    }
}
/**
 * SONO STATE UTILIZZATE LE 4 FUNZIONI GETTER (getRe, getIm, getModulus, getArgument), E SOLO DUE
 * FUNZIONI SETTER (SetPolar, SetRectangular) PERCHè PER CALCOLARE IM E RE HO BISOGNO DEL MODULO E L'ARGOMENTO, poichè i parametri devono NECESSARIAMENTE lavorare in coppia.
 * PER CALCOLARE MODULO E ARGOMENTO SI SONO UTILIZZATE LE RELAZIONI CON IM E RE.
*/