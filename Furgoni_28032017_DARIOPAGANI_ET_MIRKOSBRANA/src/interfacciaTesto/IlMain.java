package interfacciaTesto;

import java.util.ArrayList;

import autoveicoli.Camion;

public class IlMain 
{

	public static void main(String[] args) 
	{
		Camion x = new Camion(20, "XX-500-32", 400, new ArrayList<String>(), true);
		
		System.out.println(x.toString());
	}

}
