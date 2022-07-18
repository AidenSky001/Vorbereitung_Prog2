package demo009.model;

import demo009.misc.Util;

public class Niederlassung extends Standort {

	
	/**
	 * Warenart, die in der Produktion hergestellt wird
	 */
	private Warenart warenartProduktion;
	
	/**
	 * Anzahl der Arbeitenden, die in der Produktion arbeiten
	 */
	private int arbeitende;
	
	/**
	 * Gibt an, ob die Produktion ausgel�st wurde (true) oder nicht (false)
	 */
	private int lohn;
	//Setzt einen Lohn fest
	
	private boolean produktionAngefordert;
	
	/**
	 * Anzahl der Einheiten der Warenart, die nach der Produktion zur Abholung bereit stehen.
	 */
	private int produzierteMenge=0;
	
	/**
	 * interner Parameter, der angibt, wieviele Einheiten der Ware pro Arbeitender produziert werden k�nnen 
	 */
	private int faktorArbeiterZuMenge=10;
	
	/**
	 * Konstruktor
	 * @param ort 		Ort, in dem sich die Niederlassung befinden soll
	 * @param warenart	die Warenart, welche in der Niederlassung produziert werden soll
	 * @param arbeitende	die Anzahl der Arbeiter, die bei Beginn in dieser Niederlassung angestellt sind
	 */
	public Niederlassung(String ort, Warenart warenart, int arbeitende, int lohn) {
		super(ort);
		this.warenartProduktion=warenart;
		this.arbeitende=arbeitende;
		this.lohn=lohn;
	}
	// APL 5.2.1 hier wurde eine Methode eingefügt um die Anzahl der Arbeiter zu bekommen //
	public int getArbeitende() {
		return arbeitende;
	}

	public int getLohn() {
		return lohn;
	}
	
	/**
	 * Mit dieser Methode wird die Produktion der Warenart in der Niederlassung angefordert.
	 * Anschlie�end muss mit der Methode produzieren() die Produktion ausgel�st werden. 
	 */
	public void anfordern() {
		this.produktionAngefordert=true;
	}
	
	/**
	 * Diese Methode gibt zur�ck, ob die Produktion angefordert wurde. 
	 * @return true, falls die Produktion angefordert wurde; false, ansonsten
	 */
	public boolean wurdeAngefordert() {
		return this.produktionAngefordert;
	}
	
	/**
	 * Diese Methode l�st die Produktion aus. Es wird allerdings nur dann Ware produziert, wenn
	 * vorher auch mit der Methode anfordern() die Produktion ausgel�st wurde. Ansonsten
	 * wird nichts produziert.
	 * Die Menge der produzierten Ware ist von der Anzahl der vorhandenen Arbeiter abh�ngig. 
	 * Au�erdem unterliegt die Produktion einer zuf�lligen Schwankung.
	 */
	public void produzieren() {
		int zufaelligeSchwankungInProzent = (int)Math.round( Math.random() * 60.0)-30;
		if(this.produktionAngefordert) {
			this.produzierteMenge=this.arbeitende * this.faktorArbeiterZuMenge * (100-zufaelligeSchwankungInProzent)/100;
		} else {
			this.produzierteMenge=0;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int abholen() {
		int mengeAuslieferung = this.produzierteMenge;
		this.produzierteMenge=0;
		this.produktionAngefordert=false;
		return mengeAuslieferung;
	}
	
	/**
	 * Es k�nnen Arbeitende eingestellt werden.
	 * 
	 * @param anzahlEinzustellende Anzahl der neu einzustellenden Arbeitenden
	 */
	public void einstellen(int anzahlEinzustellende) {
		this.arbeitende=this.arbeitende+anzahlEinzustellende;
	}

	/**
	 * Es k�nnen Arbeitende entlassen werden.
	 * 
	 * @param anzahlEinzustellende Anzahl der neu einzustellenden Arbeitenden
	 */
	public void entlassen(int anzahlZuentlassender) {
		this.arbeitende=this.arbeitende-anzahlZuentlassender;
	}
	
	//Hier wird eingestellt welcher Lohn gezahlt wird
	public void zahlenplu(int neuerlohnplu) {
		this.lohn=this.lohn+neuerlohnplu;
	}
	
	public void zahlenmin(int neuerlohnmin) {
		this.lohn=this.lohn-neuerlohnmin;
	}

	/**
	 * In der Klasse ist die Warenart gespeichert. Methode gibt die Warenart vom Datentyp Warenart zur�ck.
	 * @return Warenart vom Datentyp Warenart
	 */
	public Warenart getWarenart() {
		return this.warenartProduktion;
	}
	
	/**
	 * In der Klasse ist die Warenart gespeichert. Methode gibt den passenden String der Warenart zur�ck.
	 * @return String der Warenart
	 */
	public String getWarenartString() {
		return Util.convertWarenartToString(this.warenartProduktion);
	}
	
}
