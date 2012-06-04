import java.util.Random;
import Tools.IO.IOTools;


public class Session {
	
	private int anzahlFalsch;
	private Lektion falscheAntworten;


	public Session(){
		this.anzahlFalsch = 0;
		this.falscheAntworten = null;
	}
	
	

	
	public void Abfragen (Lektion lektion)
	{
		lektion = lektion.zufaelligeListe(lektion);
		Random rdm = new Random();
		int laenge = lektion.getVokabelListe().size();
		String eingabe = null;
		falscheAntworten = new Lektion("Lektion0",lektion.getSprache1(),lektion.getSprache2());
		
		for(int i = 0; i < laenge; i++)
		{
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
	}
	
}
