package interfacciaTesto;

import java.io.File;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import agenzia.ListaTrasporti;
import autoveicoli.Autoveicolo;
import autoveicoli.Camion;
import autoveicoli.Furgone;

public class IlMain 
{
	public static String aggiungi(final Scanner cin) throws Exception
	{
		// Variabili
		String output = "";
		String tmp0, tmp1;
		
		// Inzio input
		System.out.println("Digitare nome classe veicolo (Camion ovvero Furgone): ");
		tmp0 = cin.nextLine();
		
		if((!tmp0.equals(Furgone.class.getSimpleName())) && (!tmp0.equals(Camion.class.getSimpleName())))
		{
			System.err.println("Non era una cosa giusta!\n");
			return null;
		}
		output = output.concat(tmp0 + "\n{");
		
		System.out.println("Inserire targa:");
		output = output.concat("targa:" + cin.nextLine() + ';');
		
		System.out.println("Inserire numero Km da percorre: ");
		output = output.concat("numeroKm:" + cin.nextLine() + ";");

		System.out.println("Inserire data produzione nel formato dd/MM/yyyy :");
		output = output.concat("dataProduzione:" + cin.nextLine() + ";");
		
		if(tmp0.equals("Furgone"))
		{
			System.out.println("Inserire numero di pubblicità applicabili: ");
			output = output.concat("numeroPubblicita:" + cin.nextLine() + ';');
			
			System.out.println("Inserire velocità media del veicolo: ");
			tmp1 = cin.nextLine();
			tmp1 = tmp1.replace(',', '.');
			output = output.concat("velocitaMedia:" + tmp1 + ";");
		}
		else
		{
			System.out.println("È un camion frigorifero [true ovvero false]: ");
			output = output.concat("isFrigo:" + cin.nextLine() + ";");
			
			System.out.println("Inserire la capacità di carico in chilogrammi: ");
			output = output.concat("capacitaCarico:" + cin.nextLine() + ';');
			
			System.out.println("Inserire le città raggiungibili separate da ', '(virgola + spazio): ");
			tmp1 = cin.nextLine();
			output = output.concat("cittaRaggiungibili:[" + tmp1 + "];");
		}
		
		output = output.concat("}");
		
		System.out.println(output);
		return output;
	}
	
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
				String path;
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
				case 1:
					path = aggiungi(cin);
					if(path != null)
						autorimessa.aggiungiMezzo(path);
					break;
				case 2:
					System.out.println("Inserire targa veicolo: ");
					path = cin.nextLine();
					autorimessa.rimuoviMezzo(path);
					break;
				case 3:
					System.out.println("Inserire targa veicolo: ");
					path = cin.nextLine();
					Autoveicolo tmp1 = autorimessa.ottieni(path);
					System.out.println(tmp1 == null ? "Non esiste tale targa!" : tmp1.toString());
					break;
				case 4:
					System.out.print("Inserire percoroso documento (Lasciare vuoto per scrivere su ./files/output): ");
					path = cin.nextLine();
					autorimessa.writeToBuffer(new PrintStream(new File(path.equals("") ? "./files/output" : path)));
					if(path.equals(""))
						cin.reset();
					break;
				case 5:
					System.out.print("Inserire percoroso documento (inserire 'OK' per scrivere su ./files/input): ");
					path = cin.nextLine();
					autorimessa.parse(new Scanner(new File(path.equals("") ? "./files/input" : path)));
					if(path.equals(""))
						cin.reset();
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
	