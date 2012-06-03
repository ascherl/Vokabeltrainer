
public class Vokabel {
	private String wort;
	private String uebersetzung;
	public Vokabel()
	{
		this.wort = null;
		this.uebersetzung = null;
	}
	
	public Vokabel neueVokabel(String wort1, String wort2)
	{
		this.wort = wort1;
		this.uebersetzung = wort2;
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
