import java.util.Random;
import Tools.IO.IOTools;


public class Session {
	

	
	private int anzahlFalsch = 0;
	private Lektion falscheAntworten;


	public Session(){
	}
	
	

	
	public void Abfragen (Lektion lektion)
	{
		lektion = lektion.zufaelligeListe(lektion);
		Random rdm = new Random();
		int laenge = lektion.getVokabelListe().size();
		String eingabe = null;
		
		for(int i = 0; i <= laenge; i++)
		if(rdm.nextBoolean())
		{
			boolean antwort = true;
			System.out.println("lektion.vokabelListe.getWort()");
			eingabe = IOTools.readString("Bitte gib die Loesung ein: ");
			
			if(lektion.getVokabelListe().get(i).getWort() == eingabe)
			{
				System.out.println("Richtig!");
			}
			else
			{

				falscheAntworten.getVokabelListe().add(lektion.getVokabelListe().get(i));
				
			}
			
		

	}
	public Lektion falscheAntworten();
	{
		
	}
}
