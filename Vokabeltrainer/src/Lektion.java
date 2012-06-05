import java.util.ArrayList;
import java.util.Random;

import Tools.IO.IOTools;

/**
 * Lektion für ein Vokabelprogramm
 * @author Rudi Ascherl
 */
public class Lektion {
	private String name;
	private String sprache1;
	private String sprache2;
	private ArrayList<Vokabel> vokabelListe;
	
	/**
	 * Erzeugt leere Lektion.
	 */
	public Lektion()
	{
	}
	
	/**
	 * 
	 * @param name Name der Lektion
	 * @param sprache1 Die erste Sprache der Vokabeln
	 * @param sprache2 Die andere Sprache der Vokabeln
	 */
	public Lektion(String name, String sprache1, String sprache2)
	{
		this.name = name;
		this.sprache1 = sprache1;
		this.sprache2 = sprache2;
		this.vokabelListe = new ArrayList<Vokabel>();
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
	
	/**
	 * Mischt die Lektion, indem mit einem zufälligen Integer von der Länge der Liste eine Vokabel gezogen wird und der an die vokabelListe einer neue Lektion angehängt wird.
	 * @param original Die Lektion, die gemischt werden soll.
	 * @return Die durchgemischte Lektion.
	 */
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
	
	/**
	 * Methode zur Eingabe einer neuen Lektion und neuer Vokabeln.
	 * @return Die eben eingegebene Lektion.
	 */
	public Lektion VokabelnEingeben()
	{

		String name = IOTools.readString("Bitte gib die einen Namen für die Lektion ein: ");
		String sprache1 = IOTools.readString("Bitte gib die eine Sprache ein: ");
		String sprache2 = IOTools.readString("Bitte gib die andere Sprache ein: ");
		Lektion neueLektion = new Lektion(name, sprache1, sprache2);
		System.out.println("");
		
		String wort1 = null;
		String wort2 = null;
		
		do{
			wort1 = IOTools.readString("\nWort in der Sprache "+ neueLektion.sprache1 + " (\"STOP\" zum Beenden) ");
			if (!wort1.equals("STOP"))
			{
				wort2 = IOTools.readString("Wort in der Sprache "+neueLektion.sprache2+ " ");
				Vokabel vokabel = new Vokabel(wort1, wort2);
				neueLektion.vokabelListe.add(vokabel);
			}
		}while(!wort1.equals("STOP"));
		System.out.println();
		return neueLektion;
	}

	/**
	 * Fügt die Vokabel vokabel ans Ende der vokabelListe ein.
	 * @param vokabel einzufügende Vokabel
	 */
	public void addVokabel(Vokabel vokabel) {
		this.vokabelListe.add(vokabel);
	}
	
}
