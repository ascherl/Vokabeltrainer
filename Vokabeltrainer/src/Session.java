import java.util.Random;
import Tools.IO.IOTools;

/**
 * Klasse für eine Lernsitzung in einem Vokabelprogramm.
 * @author Jakob Gerzen
 */
public class Session {
	
	private int anzahlFalsch;
	private Lektion falscheAntworten;


	public Session(){
		this.anzahlFalsch = 0;
		this.falscheAntworten = null;
	}
	
	

	/**
	 * Fragt eine Lektion Vokabeln ab, speichert dabei alle falschen Antworten und gibt sie in eine Datei "Lektion0.voc"
	 * @param lektion 
	 */
	public void Abfragen (Lektion lektion)
	{
		lektion = lektion.zufaelligeListe(lektion);
		Random rdm = new Random();
		int laenge = lektion.getVokabelListe().size();
		String eingabe = null;
		falscheAntworten = new Lektion("Lektion0",lektion.getSprache1(),lektion.getSprache2());
		
		for(int i = 0; i < laenge; i++)
		{
			System.out.println();
			if(rdm.nextBoolean())
			{
				System.out.println( lektion.getVokabelListe().get(i).getWort() );
				eingabe = IOTools.readString("Bitte gib die Loesung ein: ");
				
				if(lektion.getVokabelListe().get(i).getUebersetzung().equals(eingabe))
				{
					System.out.println("Richtig!");
				}
				else
				{
					anzahlFalsch++;
					falscheAntworten.addVokabel(lektion.getVokabelListe().get(i));
				}
			}
			else
			{
				System.out.println( lektion.getVokabelListe().get(i).getUebersetzung() );
				eingabe = IOTools.readString("Bitte gib die Loesung ein: ");
			
				if(lektion.getVokabelListe().get(i).getWort().equals(eingabe))
				{
					System.out.println("Richtig!");
				}
				else
				{
					anzahlFalsch++;
					falscheAntworten.addVokabel(lektion.getVokabelListe().get(i));
				}
			}
		}
		Output output = new Output();
		output.LektionAbspeichern(falscheAntworten);
		System.out.println("\nFERTIG!\n");
		if(anzahlFalsch>0) System.out.println("Du hast " + anzahlFalsch + " von " + lektion.getVokabelListe().size() + " Vokabeln falsch beantwortet. Diese Vokabeln wurden zur erneuten Abfrage in \"Lektion0.voc\" abgespeichert!");
		else System.out.println("Du hast alle Fragen richtig beantwortet.");
	}
	
}
