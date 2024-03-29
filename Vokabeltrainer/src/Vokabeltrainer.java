import Tools.IO.*;

public class Vokabeltrainer {

	/**
	 * Hauptroutine f�r den Vokabeltrainer
	 * @author Jakob Gerzen
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("###########################################");
		System.out.println("#       V O K A B E L T R A I N E R       #");
		System.out.println("###########################################");
		
		int auswahl = 0;
		
		while( auswahl != 9 ){
			System.out.println("\nMEN�");
			System.out.println("\nBitte w�hle aus:");
			System.out.println("  (1) Vokabeln abfragen");
			System.out.println("  (2) Vokabeln eingeben");
			System.out.println("  (9) Beenden");
			
			auswahl = IOTools.readInteger();
			
			if(auswahl==1)
			{
					System.out.println();
					String pfad = IOTools.readString("\nBitte gib den Dateinamen ein: ");
					Input input = new Input();
					Session session = new Session();
					session.Abfragen(input.DateiEinlesen(pfad));
			}
			if(auswahl==2)
			{
				Output output = new Output();
				Lektion lektion = new Lektion();
				output.LektionAbspeichern(lektion.VokabelnEingeben());
			}
		}

		
	}

}
