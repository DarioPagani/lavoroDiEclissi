package autoveicoli;

public class ParseException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public ParseException(final String token)
	{
		super("Mancava il token \"" + token + "\"");
	}
}
