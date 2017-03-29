package autoveicoli;

public class Autoveicolo 
{
	// Attribuiti 
	private	int			numeroKm		= 0;
	private	String		targa;
	
	// Costruttori
	public Autoveicolo(int numeroKm, String targa) 
	{
		this.numeroKm		= numeroKm;
		this.targa			= targa;
	}

	// Sets & gets
	public int getNumeroKm() 
	{
		return numeroKm;
	}

	public void setNumeroKm(final int numeroKm) 
	{
		this.numeroKm = numeroKm;
	}

	public String getTarga() 
	{
		return targa;
	}
	
}
