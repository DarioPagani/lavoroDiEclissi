package agenzia;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import autoveicoli.Autoveicolo;

public class ListaTrasporti 
{
	private	ArrayList<Autoveicolo>			memoria		= null;
	
	public ListaTrasporti(final int dimensioneParcoVeicoli) throws Exception
	{
		if(dimensioneParcoVeicoli <= 0)
			throw new Exception("Minimun 1 vehicles!");
		
		this.memoria = new ArrayList<Autoveicolo>(dimensioneParcoVeicoli);
	}
	
	public void parse(final Scanner cin)
	{
		;
	}
	
	public void parse(final String toParse)
	{
		;
	}
}
