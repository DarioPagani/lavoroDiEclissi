package agenzia;

import autoveicoli.Autoveicolo;

public class PlateAreEquals extends Exception
{
	private static final long serialVersionUID = 1L;
	private Autoveicolo a = null;
	private Autoveicolo b = null;
	
	public Autoveicolo getA()
	{
		return a;
	}

	public Autoveicolo getB()
	{
		return b;
	}

	public PlateAreEquals(Autoveicolo a, Autoveicolo b)
	{
		super("Due veicoli hanno la stessa targa ma differenti propietà!");
		this.a = a;
		this.b = b;
	}
}
