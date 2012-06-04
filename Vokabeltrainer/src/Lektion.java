import java.util.ArrayList;
import java.util.Random;

import Tools.IO.IOTools;


public class Lektion {
	private String name;
	private String sprache1;
	private String sprache2;
	private ArrayList<Vokabel> vokabelListe;
	
	public Lektion()
	{
	}
	
	public Lektion(String name, String sprache1, String sprache2)
	{
		this.name = name;
		this.sprache1 = sprache1;
		this.sprache2 = sprache2;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getSprache1()
	{
		return this.sprache1;
	}
	
	public String getSprache2()
	{
		return this.sprache2;
	}
	
	public ArrayList<Vokabel> getVokabelListe() {
		return this.vokabelListe;
	}
	
	public Lektion zufaelligeListe(Lektion original)
	{
		Lektion rdmLektion = new Lektion(original.name, original.sprache1, original.sprache2);
		
		Random rdm = new Random();
		while(original.vokabelListe.size()>0)
		{
			int index = rdm.nextInt(original.vokabelListe.size());
			rdmLektion.vokabelListe.add(original.vokabelListe.get(index));
			original.vokabelListe.remove(index);
		}
		
		return rdmLektion;
	}
	
	public Lektion VokabelnEingeben()
	{

		String name = IOTools.readString("Bitte gib die einen Namen für die Lektion ein: ");
		String sprache1 = IOTools.readString("Bitte gib die eine Sprache ein: ");
		String sprache2 = IOTools.readString("Bitte gib die andere Sprache ein: ");
		Lektion neueLektion = new Lektion(name, sprache1, sprache2);
		System.out.println("\n\n");
		
		String wort1 = null;
		String wort2 = null;
		
		do{
			wort1 = IOTools.readString("Wort in der Sprache "+ neueLektion.sprache1 + " (\"Return\" zum Beenden) ");
			System.out.println(wort1);

				System.out.println("YEA!");
				Vokabel vokabel = null;
				wort2 = IOTools.readString("Wort in der Sprache "+neueLektion.sprache2+ " ");
				neueLektion.vokabelListe.add(vokabel.neueVokabel(wort1, wort2)); // ?!

		}while(wort1.equals(null));
		
		return neueLektion;
	}

	public void addVokabel(Vokabel vokabel) {
		this.vokabelListe.add(vokabel);
	}
	
}
