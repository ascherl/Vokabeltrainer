
public class Vokabel {
	private String wort;
	private String uebersetzung;

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
