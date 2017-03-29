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
	
	// TODO da Finire
	public Autoveicolo(final String parse)
	{
		// Rimuovo TUTTE le tabulazioni
		int numeroKmPOS = parse.lastIndexOf("numeroKm:");
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
	
	public String toString()
	{
		return "{\n" + this.toString(true) + "}";
	}
	
	protected String toString(boolean noBrackets)
	{
		if(!noBrackets)
			return this.toString();
		
		return "numeroKm:" + this.numeroKm + ";\ntarga:" + this.targa + ";\n";
	}
}
