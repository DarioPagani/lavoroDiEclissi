package autoveicoli;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Autoveicolo 
{
	// Attribuiti 
	private	int					numeroKm		= 0;
	private	String				targa;
	private	GregorianCalendar	dataProduzione;
	
	// Costruttori
	public Autoveicolo(int numeroKm, String targa, GregorianCalendar dataProduzione) 
	{
		this.numeroKm		= numeroKm;
		this.targa			= targa;
		this.dataProduzione	= dataProduzione;
	}
	
	public Autoveicolo(final String parse)
	{
		// Variabili
		String tmp = "";
		
		int numeroKmPOS = parse.lastIndexOf("numeroKm:") + 9;
		
		if(numeroKmPOS - 9 == -1)
		{
			System.err.println("Non è stato trovato \"numeroKm\"!\nUscita...");
			System.exit(-2);
		}
		
		for(int i = numeroKmPOS , l = parse.length(); i < l && parse.charAt(i) != ';'; i++)
		{
			tmp = tmp.concat(String.valueOf(parse.charAt(i)));
		}
		this.numeroKm = (new Integer(tmp)).intValue();
		
		int targaPOS = parse.lastIndexOf("targa:") + 6;
		tmp = "";
		
		for(int i = targaPOS, l = parse.length(); i < l && parse.charAt(i) != ';'; i++)
		{
			tmp = tmp.concat(String.valueOf(parse.charAt(i)));
		}
		this.targa = tmp.toString();
		tmp = "";
		
		// Ricerca data di produzione
		int dataProduzioneKmPOS = parse.lastIndexOf("dataProduzione:") + ("dataProduzione:").length();
		
		for(int i = dataProduzioneKmPOS, l = parse.length(); i < l && parse.charAt(i) != ';'; i++)
		{
			tmp = tmp.concat(String.valueOf(parse.charAt(i)));
		}
		
		this.dataProduzione = new GregorianCalendar();
		try {
			this.dataProduzione.setTime((new SimpleDateFormat("dd/MM/yyyy")).parse(tmp));
		} catch (ParseException e) {
			System.err.println("Qualcosa è andato storto:\n" + e.toString());
			System.exit(-3);
		}
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
		
		return "numeroKm:" + this.numeroKm + ";\ntarga:" + this.targa + ";\ndataProduzione:" + 
		(new SimpleDateFormat("dd/MM/yyyy").format(this.dataProduzione.getTime())) + ";\n";
	}
	
	/*** I metodo ***/
	
	public void decrementaKm(int numeroDaDecrementare){
		
		this.numeroKm -= numeroDaDecrementare;
		
		if (this.numeroKm < 0 ){
			
			this.numeroKm = 0;
			
		}
		
	}
	
	
	
}
