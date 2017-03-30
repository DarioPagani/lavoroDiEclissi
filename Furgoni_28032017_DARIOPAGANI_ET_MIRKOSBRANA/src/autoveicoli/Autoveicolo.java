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
		// Variabili
		String tmp = "";
		
		// Rimuovo TUTTE le tabulazioni
		parse.replace("\t", "");
		
		int numeroKmPOS = parse.lastIndexOf("numeroKm:") + 8;
		
		if(numeroKmPOS - 8 == -1)
		{
			System.err.println("Non è stato trovato \"numeroKm\"!\nUscita...");
			System.exit(-2);
		}
		
		for(int i = numeroKmPOS + 1, l = parse.length(); i < l && parse.charAt(i) != ';'; i++)
		{
			tmp = tmp.concat(String.valueOf(parse.charAt(i)));
		}
		this.numeroKm = (new Integer(tmp)).intValue();
		
		int targaPOS = parse.lastIndexOf("targa:") + 5;
		tmp = "";
		
		for(int i = targaPOS, l = parse.length(); i < l && parse.charAt(i) != ';'; i++)
		{
			tmp = tmp.concat(String.valueOf(parse.charAt(i)));
		}
		this.targa = tmp.toString();
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
