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
	
	public String getName()
	{
		return this.name;
	}
	
	public String getSprache1()
	{
		return this.sprache1;
	}
	
	public String getSprache1()
	{
		return this.sprache2;
	}
	
	public ArrayList<Vokabel> getVokabelListe() {
		return this.vokabelListe;
	}
	
	public Lektion zufaelligeListe(Lektion original)
	{
		Lektion rdmLektion = new Lektion();
		
		rdmLektion.name = original.name;
		rdmLektion.sprache1 = original.sprache1;
		rdmLektion.sprache2 = original.sprache2;
		
		Random rdm = new Random();
		while(original.vokabelListe.size()>0)
		{
			int index = rdm.nextInt(original.vokabelListe.size());
			rdmLektion.vokabelListe.add(original.vokabelListe.get(index));
		}
		
		return rdmLektion;
	}
	
	public Lektion VokabelnEingeben()
	{
		Lektion neueLektion = new Lektion();

		neueLektion.sprache1 = IOTools.readString("Bitte gib die eine Sprache ein: ");
		neueLektion.sprache2 = IOTools.readString("Bitte gib die andere Sprache ein: ");
		System.out.println("\n\n");
		
		String wort1 = null;
		String wort2 = null;
		
		do{
			wort1 = IOTools.readString("Wort in der Sprache (\"STOP!\" zum Beenden)"+ neueLektion.sprache1);
			if(wort1!="STOP!") 
			{
				Vokabel vokabel = new Vokabel();
				wort2 = IOTools.readString("Wort in der Sprache "+neueLektion.sprache2);
				neueLektion.vokabelListe.add(vokabel.neueVokabel(wort1, wort2)); // ?!
			}
		}while(wort1!="STOP!");
		
		return neueLektion;
	}
	
}
