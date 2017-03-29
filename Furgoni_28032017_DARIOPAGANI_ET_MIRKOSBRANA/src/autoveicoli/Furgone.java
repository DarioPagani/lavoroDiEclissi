package autoveicoli;

public class Furgone extends Autoveicolo 
{
	private		float				velocitaMedia;
	private		int					numeroPubblicita;
	
	public Furgone(int numeroKm, String targa, float velocitaMedia, int numeroPubblicita) 
	{
		super(numeroKm, targa);
		this.velocitaMedia = velocitaMedia;
		this.numeroPubblicita = numeroPubblicita;
	}
}
