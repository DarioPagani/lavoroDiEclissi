package autoveicoli;

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
	
	public Autoveicolo(final String parse) throws Exception
	{
		// Variabili
		String tmp = "";
		
		int numeroKmPOS = parse.lastIndexOf("numeroKm:");
		
		if(numeroKmPOS == -1)
			throw new Exception("Not found token \"numeroKm:\" in string");
		else
			numeroKmPOS+=9;
		
		for(int i = numeroKmPOS , l = parse.length(); i < l && parse.charAt(i) != ';'; i++)
		{
			tmp = tmp.concat(String.valueOf(parse.charAt(i)));
		}
		this.numeroKm = (new Integer(tmp)).intValue();
		
		int targaPOS = parse.lastIndexOf("targa:");
		if(targaPOS == -1)
			throw new Exception("Not found token \"targa:\" in string");
		else
			targaPOS+=("targa:").length();
		tmp = "";
		
		for(int i = targaPOS, l = parse.length(); i < l && parse.charAt(i) != ';'; i++)
		{
			tmp = tmp.concat(String.valueOf(parse.charAt(i)));
		}
		this.targa = tmp.toString();
		tmp = "";
		
		// Ricerca data di produzione
		int dataProduzioneKmPOS = parse.lastIndexOf("dataProduzione:");
		if(dataProduzioneKmPOS == -1)
			throw new Exception("Not found token \"dataProduzione:\" in string");
		else
			dataProduzioneKmPOS+=+ ("dataProduzione:").length();
		
		for(int i = dataProduzioneKmPOS, l = parse.length(); i < l && parse.charAt(i) != ';'; i++)
		{
			tmp = tmp.concat(String.valueOf(parse.charAt(i)));
		}
		
		this.dataProduzione = new GregorianCalendar();		
		this.dataProduzione.setTime((new SimpleDateFormat("dd/MM/yyyy")).parse(tmp));
	}

	// Sets & gets
	public GregorianCalendar getDataProduzione()
	{
		return this.dataProduzione;
	}
	
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
