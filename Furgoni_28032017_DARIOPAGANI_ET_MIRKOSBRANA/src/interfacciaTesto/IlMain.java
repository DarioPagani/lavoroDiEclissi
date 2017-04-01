package interfacciaTesto;

import java.util.InputMismatchException;
import java.util.Scanner;

import agenzia.ListaTrasporti;

public class IlMain 
{

	public static void main(String[] args) throws Exception 
	{
		// Variabili
		ListaTrasporti		autorimessa = null;
		Scanner				cin			= new Scanner(System.in);
		int					tmp0		= -1;
		
		System.out.print("Inserire capacità della rimessa: ");
		do
		{
			tmp0 = cin.nextInt(); cin.nextLine();
		}
		while(tmp0 <= 0);
		
		// Creo l'autorimessa
		autorimessa = new ListaTrasporti(tmp0);
		
		while(tmp0 != 0)
		{
			try
			{
				System.out.print(
						"1. Aggiungere un veicolo da console\n" + 
						"2. Cancellare un veicolo da console\n" +
						"3. Visualizza un veicolo su console\n" + 
						"4. Stampa il parco veicoli su un documento\n" +
						"5. Carica il parco veicolo da un documento\n" +
						"6. Visualliza i chilometri ancora da percorrere da tutti i veicoli\n" + 
						"7. Decrementa i chilometri ancora da percorrere ancora da un veicolo\n" +
						"8. Verifica se un veicolo può ancora circolare\n" +
						"0. Esci...\n: "
						);
				tmp0 = cin.nextInt(); cin.nextLine();
				switch(tmp0)
				{
				case 0:
					System.out.println("Uscita!");
					break;
				default:
					System.out.flush();
					System.err.print("\nQuesta opzione non è valida ovvero non ancora implementata!\n");
					System.err.flush();
					System.out.flush();
					break;
				}
			}
			catch(InputMismatchException error)
			{
				System.out.flush();
				System.err.print("\nGIÀMMAI! Un valore errato è stato inserito nella console! Ripristino del flussi...\n");
				System.err.flush();
				System.out.flush();
				cin.nextLine();
			}
			catch(Exception error)
			{
				System.err.println("Qualcosa è andato storto:\n" + error.toString() + "\nUscita...");
				System.exit(-1);
			}
		}
		
		
		// Chiudo
		cin.close();
	}	

}
	