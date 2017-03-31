package autoveicoli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class Camion extends Autoveicolo 
{
	// Attribuiti
	private	boolean				isFrigo;
	private	long				capacitaCarico		= 0;
	private	ArrayList<String>	cittaRaggiungibili	= null;
	
	public Camion(int numeroKm, String targa, long capacitaCarico, GregorianCalendar dataProduzione, ArrayList<String> cittaRaggiungibili,boolean isFrigo) 
	{
		super(numeroKm, targa, dataProduzione);
		
		this.capacitaCarico = capacitaCarico;
		this.cittaRaggiungibili = cittaRaggiungibili;
		this.isFrigo = isFrigo;
	}
	
	public Camion(final String parse)
	{
		super(parse);
		int isFrigoPOS = parse.lastIndexOf("isFrigo:") + ("isFrigo:").length();
		String tmp = "";
		
		for(int i = isFrigoPOS, l = parse.length(); i < l && parse.charAt(i) != ';'; i++)
		{
			tmp = tmp.concat(String.valueOf(parse.charAt(i)));
		}
		this.isFrigo = Boolean.parseBoolean(tmp);
		
		int capacitaCaricoPOS = parse.lastIndexOf("capacitaCarico:") + ("capacitaCarico:").length();
		tmp = "";
		
		for(int i = capacitaCaricoPOS, l = parse.length(); i < l && parse.charAt(i) != ';'; i++)
		{
			tmp = tmp.concat(String.valueOf(parse.charAt(i)));
		}
		
		this.capacitaCarico = (new Long(tmp)).intValue();
		
		// Conversione della stringa in ArrayLista
		int arrayPos = parse.lastIndexOf("cittaRaggiungibili:") + ("cittaRaggiungibili:").length();
		tmp = "";
		
		if(parse.charAt(arrayPos) != '[')
		{
			System.err.println("Qualcosa è andato storto!");
			System.exit(-4);
		}
		
		for(int i = arrayPos + 1, l = parse.length(); i < l && parse.charAt(i) != ']'; i++)
		{
			if(parse.charAt(i) == ';')
			{
				System.err.println("Qualcosa è andato storto!");
				System.exit(-4);
			}
			tmp = tmp.concat(String.valueOf(parse.charAt(i)));
		}
		this.cittaRaggiungibili = new ArrayList<String>(Arrays.asList(tmp.split(", ")));
	}
	
	public String toString()
	{
		return "{\n" + super.toString(true) + "isFrigo:" + this.isFrigo + ";\ncapacitaCarico:" 
				+ this.capacitaCarico + ";\ncittaRaggiungibili:" + this.cittaRaggiungibili.toString() + ";\n}";
	}
	
	//METODI
	
	public void rimuoviCitta(String cittaRimovibile)
	{	
		this.cittaRaggiungibili.remove(cittaRimovibile);	
	}
	
	public void aggiungiCitta(String cittaAggiungibile)
	{	
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
