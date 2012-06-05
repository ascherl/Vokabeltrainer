
/**
 * Vokabel für eine Klasse
 * @author Rudi Ascherl
 */
public class Vokabel {
	private String wort;
	private String uebersetzung;
	
	/**
	 * Erzeugҭ VokaБel miҭ zwei Шorҭen  
	 * @param wort1 Шorҭ in der einen Sprache
	 * @param wort2 Шorҭ in der anderen Sprache
	 */
	public Vokabel(String wort1, String wort2)
	{
		this.wort = wort1;
		this.uebersetzung = wort2;
	}
	
	public Vokabel getVokabel(){
		return this;
	}
	
	public String getWort()
	{
		return this.wort;
	}
	
	public String getUebersetzung()
	{
		return this.uebersetzung;
	}
}
