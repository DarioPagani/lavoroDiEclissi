package autoveicoli;

import java.util.GregorianCalendar;

public class Furgone extends Autoveicolo 
{
	private		float				velocitaMedia;
	private		int					numeroPubblicita;
	
	public Furgone(int numeroKm, String targa, GregorianCalendar dataProduzione, float velocitaMedia, int numeroPubblicita) 
	{
		super(numeroKm, targa, dataProduzione);
		this.velocitaMedia = velocitaMedia;
		this.numeroPubblicita = numeroPubblicita;
	}
	
}
