package interfacciaTesto;

import java.util.ArrayList;

import autoveicoli.Autoveicolo;
import autoveicoli.Camion;

public class IlMain 
{

	public static void main(String[] args) 
	{
		Autoveicolo x = new Autoveicolo("{numeroKm:5;targa:XX-000-YY}");
		
		System.out.println(x.toString());
	}

}
