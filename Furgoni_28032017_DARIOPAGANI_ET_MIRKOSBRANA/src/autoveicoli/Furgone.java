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

	public float getVelocitaMedia() {
		return velocitaMedia;
	}

	public void setVelocitaMedia(float velocitaMedia) {
		this.velocitaMedia = velocitaMedia;
	}

	public int getNumeroPubblicita() {
		return numeroPubblicita;
	}

	public void setNumeroPubblicita(int numeroPubblicita) {
		this.numeroPubblicita = numeroPubblicita;
	}
	
}
