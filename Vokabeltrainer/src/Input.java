import java.io.*;


public class Input {
	
	public Lektion DateiEinlesen(String pfad)
	{
		Lektion lektion = null;
		Reader fr = null;
		try {
			fr = new FileReader(pfad);
			BufferedReader br = new BufferedReader(fr);
			String zeile1;
			String zeile2;
			
			String name = br.readLine();
			String sprache1 = br.readLine();
			String sprache2 = br.readLine();
		
			lektion = new Lektion(name, sprache1, sprache2);
	
			while((zeile1 = br.readLine()) != null && (zeile2 = br.readLine()) != null)
			{
				Vokabel vokabel = new Vokabel(zeile1,zeile2);
				lektion.addVokabel(vokabel);
			}
		}
		catch ( IOException e ) {
				  System.err.println( "Fehler beim Lesen der Datei!" );
		}
		finally {
			  try { fr.close(); } catch ( Exception e ) { e.printStackTrace(); }
		}
		return lektion;

	}
}
