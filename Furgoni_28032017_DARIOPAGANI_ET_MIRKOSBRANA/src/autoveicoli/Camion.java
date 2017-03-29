package autoveicoli;

import java.util.ArrayList;

public class Camion extends Autoveicolo 
{
	// Attribuiti
	private	long				capacitaCarico		= 0;
	private	ArrayList<String>	cittaRaggiungibili	= null;
	private	boolean				isFrigo;
	
	public Camion(int numeroKm, String targa, long capacitaCarico, ArrayList<String> cittaRaggiungibili,boolean isFrigo) 
	{
		super(numeroKm, targa);
		this.capacitaCarico = capacitaCarico;
		this.cittaRaggiungibili = cittaRaggiungibili;
		this.isFrigo = isFrigo;
	}
	
	
}
