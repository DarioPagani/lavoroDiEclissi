package autoveicoli;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Camion extends Autoveicolo 
{
	// Attribuiti
	private	boolean				isFrigo;
	private	long				capacitaCarico		= 0;
	private	ArrayList<String>	cittaRaggiungibili	= null;
	private int 				permessi = 0;
	
	public Camion(int numeroKm, String targa, long capacitaCarico, GregorianCalendar dataProduzione, ArrayList<String> cittaRaggiungibili,boolean isFrigo) 
	{
		super(numeroKm, targa, dataProduzione);
		
		this.capacitaCarico = capacitaCarico;
		this.cittaRaggiungibili = cittaRaggiungibili;
		this.isFrigo = isFrigo;
	}
	
	public String toString()
	{
		return "{\n" + super.toString(true) + "isFrigo:" + this.isFrigo + ";\ncapacitàCarico:" 
				+ this.capacitaCarico + ";\ncittaRaggiungibili:" + cittaRaggiungibili.toString() + ";\n}";
	}
	
	//METODI
	
	public void rimuoviCitta(String cittaRimovibile){
		
		this.cittaRaggiungibili.remove(cittaRimovibile);
		
	}
	
	public void aggiungiCitta(String cittaAggiungibile){
		
		//controllo, se la città è gia presente allora non agigungo niente.
		if (!this.cittaRaggiungibili.contains(cittaAggiungibile)){
			this.cittaRaggiungibili.add(cittaAggiungibile);
		}
	}
	
	public void decrementaKm(int numeroDaDecrementare)
	{
		if (this.isFrigo){
			
			numeroDaDecrementare += numeroDaDecrementare/10;
			
		}
		super.decrementaKm(numeroDaDecrementare);
		
	}
}
