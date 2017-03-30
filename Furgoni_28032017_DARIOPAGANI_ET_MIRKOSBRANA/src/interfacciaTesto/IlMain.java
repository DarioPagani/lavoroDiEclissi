package interfacciaTesto;

import java.util.ArrayList;

import autoveicoli.Autoveicolo;
import autoveicoli.Camion;
import autoveicoli.Furgone;

public class IlMain 
{

	public static void main(String[] args) 
	{
		Furgone x = new Furgone("{numeroKm:5;targa:XX-000-YY;dataProduzione:23/12/2010;velocitaMedia:23.2;numeroPubblicita:5;}");

		System.out.println(x.toString());
	}	

}
	