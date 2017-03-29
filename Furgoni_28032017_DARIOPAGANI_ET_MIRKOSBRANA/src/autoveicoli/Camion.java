package autoveicoli;

import java.util.ArrayList;

public class Camion extends Autoveicolo 
{
	// Attribuiti
	private	boolean				isFrigo;
	private	long				capacitaCarico		= 0;
	private	ArrayList<String>	cittaRaggiungibili	= null;
	
	public Camion(int numeroKm, String targa, long capacitaCarico, ArrayList<String> cittaRaggiungibili,boolean isFrigo) 
	{
		super(numeroKm, targa);
		this.capacitaCarico = capacitaCarico;
		this.cittaRaggiungibili = cittaRaggiungibili;
		this.isFrigo = isFrigo;
	}
	
	public String toString()
	{
		return "{\n" + super.toString(true) + "isFrigo:" + this.isFrigo + ";\ncapacitàCarico:" 
				+ this.capacitaCarico + ";\ncittaRaggiungibili:" + cittaRaggiungibili.toString() + ";\n}";
	}
}
