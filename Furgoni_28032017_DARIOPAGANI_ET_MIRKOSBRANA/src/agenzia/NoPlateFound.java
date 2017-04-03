package agenzia;

public class NoPlateFound extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoPlateFound()
	{
		super("Targa non trovata!\n");
	}
}
