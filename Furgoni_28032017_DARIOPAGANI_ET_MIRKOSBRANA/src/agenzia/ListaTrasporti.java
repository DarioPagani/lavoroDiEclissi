package agenzia;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;


import autoveicoli.Autoveicolo;
import autoveicoli.Camion;
import autoveicoli.Furgone;

public class ListaTrasporti 
{
	private	ArrayList<Autoveicolo>			memoria		= null;
	
	public ListaTrasporti(final int dimensioneParcoVeicoli) throws Exception
	{
		if(dimensioneParcoVeicoli <= 0)
			throw new Exception("Minimun 1 vehicles!");
		
		this.memoria = new ArrayList<Autoveicolo>(dimensioneParcoVeicoli);
	}
	
	public void parse(final Scanner cin) throws Exception
	{
		String tmp = "";
		
		tmp = cin.nextLine();
		while(!tmp.contains("STOP") && cin.hasNextLine())
		{
			tmp = tmp.concat(cin.nextLine());
		}
		//tmp = tmp.substring(tmp.indexOf("STOP"));
		this.parse(tmp);
	}
	
	public void parse(final String toParse) throws Exception
	{
		// Variabili
		int i = 0;
		int l = toParse.length();
		String className = "";
		String tmp = "";
		
		while(i < l)
		{
			className = "";
			tmp = "";
			// Ricerca token
			for(;i < l && toParse.charAt(i) != '{' && toParse.charAt(i) != '\n'; i++)
			{
				className = className.concat(String.valueOf(toParse.charAt(i)));
			}
			
			// Prendo la classe
			for(; i < l && toParse.charAt(i-1) != '}'; i++)
			{
				tmp = tmp.concat(String.valueOf(toParse.charAt(i)));
			}
			
			if(className.equals(Camion.class.getSimpleName()))
				this.aggiungiMezzo(new Camion(tmp));
			else if (className.equals(Furgone.class.getSimpleName()))
				this.aggiungiMezzo(new Furgone(tmp));
			else if (className.equals("STOP"))
				;
			else
				throw new Exception("Someone has insert a mismatch name: \"" + className + "\"!");
		}
	}
	
	public String toString()
	{
		String output = "";
		
		for(int i = 0, l = this.memoria.size(); i < l; i++, output = output.concat("\n"))
		{
			output = output.concat(this.memoria.get(i).getClass().getSimpleName() + '\n');
			output = output.concat(this.memoria.get(i).toString());
		}
		output = output.concat("STOP");
		return output;
	}
	
	public void writeToBuffer(final PrintStream cout)
	{
		cout.print(this.toString());
	}
	
	// Metodi veri
	public void aggiungiMezzo(final Autoveicolo toAdd) throws Exception
	{
		boolean esiste = false;
		for(int i = 0, l = this.memoria.size(); i < l && (!esiste); i++)
			if(this.memoria.get(i).getTarga().equals(toAdd.getTarga()))
				esiste = true;
		
		if(esiste)
			throw new Exception("Another vheichle has the same number plate!\n");
		
		this.memoria.add(toAdd);
	}
	
	public void aggiungiMezzo(final Camion toAdd) throws Exception
	{
		this.aggiungiMezzo((Autoveicolo)(toAdd));
	}
	
	public void aggiungiMezzo(final Furgone toAdd) throws Exception
	{
		this.aggiungiMezzo((Autoveicolo)(toAdd));
	}
	
	public void rimuoviMezzo(final String targaDaEliminare)
	{
		Predicate<Autoveicolo> filter = i-> i.getTarga().equals(targaDaEliminare);
		this.memoria.removeIf(filter);
	}
	
	public long totaleChilometri()
	{
		long totale = 0;
		for(int i = 0, l = this.memoria.size();i < l; i++)
			totale+= this.memoria.get(i).getNumeroKm();
		
		return totale;
	}
	
	public boolean circolazioneAmessa(final String targa, final int anniMassimi) throws Exception
	{
		Autoveicolo index = null;
		boolean trovato = false;
		for(int i = 0, l = this.memoria.size(); i < l && !trovato; i++)
			if(this.memoria.get(i).getTarga().equals(targa))
			{
				trovato = true;
				index = this.memoria.get(i);
			}
		if(!trovato)
			throw new Exception("Non found that number plate!\n");
		
		if(index.getDataProduzione().getTimeInMillis() + ((long)anniMassimi * 31556952000l) > (System.currentTimeMillis()))
			return false;
		else if(index.getNumeroKm() <= 0)
			return false;
		else
			return true;
	}
}
