package interfacciaTesto;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

import agenzia.ListaTrasporti;

public class IlMain 
{

	public static void main(String[] args) throws Exception 
	{
		ListaTrasporti x = new ListaTrasporti(5);
		File unFile = new File("./files/input");
		File uscita = new File("./files/testOutput");
		
		try
		{
			x.parse(new Scanner(unFile));
		}
		catch(Exception e)
		{
			System.err.println("Qualcosa è andato storto!\n" + e.toString());
		}
		
		x.writeToBuffer(new PrintStream(uscita));
	}	

}
	