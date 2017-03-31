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
		File unFile = new File("./files/testOutput");
		File uscita = new File("./files/testOutput");
		
		x.parse(new Scanner(unFile));
		x.writeToBuffer(new PrintStream(uscita));
	}	

}
	