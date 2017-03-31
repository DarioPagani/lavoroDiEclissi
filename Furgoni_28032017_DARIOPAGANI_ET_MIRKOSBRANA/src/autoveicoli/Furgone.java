package autoveicoli;

import java.util.GregorianCalendar;

public class Furgone extends Autoveicolo
{
	private	float	velocitaMedia;
	private	int		numeroPubblicita;

	public Furgone(int numeroKm, String targa, GregorianCalendar dataProduzione, float velocitaMedia, int numeroPubblicita)
	{
		super(numeroKm, targa, dataProduzione);
		this.velocitaMedia = velocitaMedia;
		this.numeroPubblicita = numeroPubblicita;
	}

	public Furgone(String parse) throws Exception
	{
		super(parse);
		String tmp = "";

		//
		int velocitaPOS = parse.lastIndexOf("velocitaMedia:") + ("velocitaMedia:").length();
		for (int i = velocitaPOS, l = parse.length(); i < l && parse.charAt(i) != ';'; i++)
		{
			tmp = tmp.concat(String.valueOf(parse.charAt(i)));
		}
		this.velocitaMedia = Float.valueOf(tmp);
		tmp = "";

		//
		int pubPOS = parse.lastIndexOf("numeroPubblicita:") + ("numeroPubblicita:").length();

		for (int i = pubPOS, l = parse.length(); i < l && parse.charAt(i) != ';'; i++)
		{
			tmp = tmp.concat(String.valueOf(parse.charAt(i)));
		}
		this.numeroPubblicita = Integer.valueOf(tmp);
	}

	public float getVelocitaMedia()
	{
		return velocitaMedia;
	}

	public void setVelocitaMedia(float velocitaMedia)
	{
		this.velocitaMedia = velocitaMedia;
	}

	public int getNumeroPubblicita()
	{
		return numeroPubblicita;
	}

	public void setNumeroPubblicita(int numeroPubblicita)
	{
		this.numeroPubblicita = numeroPubblicita;
	}

	public String toString()
	{
		return "{\n" + super.toString(true) + "velocitaMedia:" + this.velocitaMedia + ";\nnumeroPubblicita:" + this.numeroPubblicita + ";\n}";
	}

}
