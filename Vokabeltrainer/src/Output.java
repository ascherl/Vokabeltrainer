import java.io.*;

/**
 * Speichert eine Lektion im aktuellen Verzeichnis als ${name}.voc ab.
 * @author Jakob Gerzen
 */
public class Output {
	public void LektionAbspeichern(Lektion eingabe)
	{
		Writer fw = null;
		try
		{
			fw = new FileWriter( eingabe.getName() + ".voc" );
			fw.write( eingabe.getName() + System.getProperty("line.separator") );
			fw.write( eingabe.getSprache1() + System.getProperty("line.separator") );
			fw.write( eingabe.getSprache2 () + System.getProperty("line.separator") );

			while(eingabe.getVokabelListe().size()>0)
			{
				fw.write( eingabe.getVokabelListe().get(0).getWort() + System.getProperty("line.separator") );
				fw.write( eingabe.getVokabelListe().get(0).getUebersetzung() + System.getProperty("line.separator") );
				eingabe.getVokabelListe().remove(0);
			}
		}
		catch ( IOException e )
		{
			System.err.println("Fehler beim Erstellen der Datei!");
		}
		finally
		{
			if (fw != null)
				try { fw.close(); } catch ( IOException e ) { e.printStackTrace(); }
		}
	}
}
