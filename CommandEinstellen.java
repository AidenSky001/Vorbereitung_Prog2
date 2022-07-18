package demo009.menu.impl;

import java.util.Scanner;
import java.util.List;

import demo009.ApplicationContext;
import demo009.menu.Command;
import demo009.model.Niederlassung;


public class CommandEinstellen implements Command {

	@Override
	public String menuItemName() {
		return "Arbeiter einstellen | entlassen ";
	}

	@Override
	public void execute(ApplicationContext context) {
		// TODO Auto-generated method stub
		
		int mitarbeiterdazu = 0;
		int mitarbeiterweg = 0;
		System.out.println("========== "+menuItemName());
		
		 
		 List<Niederlassung> listeNiederlassung = context.getNiederlassungen();
		 	
		 
			for(int indexNdls=0; indexNdls<listeNiederlassung.size(); indexNdls++) {
				int mitarbeiterMenge = listeNiederlassung.get(indexNdls).getArbeitende();
				System.out.println("In " + listeNiederlassung.get(indexNdls).getOrt()+" sind " + listeNiederlassung.get(indexNdls).getArbeitende() + " Mitarbeiter eingestellt.");
				System.out.println("Wie viele Mitarbeiter sollen eingestellt werden?");
				
				Scanner mitarscanner = new Scanner(System.in);
				boolean scannerErfolg=false;
				while(!scannerErfolg) {
					try {
						System.out.print("Anzahl:");
						mitarbeiterdazu = mitarscanner.nextInt();
						scannerErfolg=true;
						mitarscanner.nextLine();
						listeNiederlassung.get(indexNdls).einstellen(mitarbeiterdazu);
					} catch (Exception e) {
						e.printStackTrace();
						scannerErfolg=false;
						mitarscanner.nextLine();
					}
							}
					
			}
			
			//Entlassen der Arbeiter
			for(int indexNdls=0; indexNdls<listeNiederlassung.size(); indexNdls++) {
				int mitarbeiterMenge = listeNiederlassung.get(indexNdls).getArbeitende();
				System.out.println("In " + listeNiederlassung.get(indexNdls).getOrt()+" sind " + listeNiederlassung.get(indexNdls).getArbeitende() + " Mitarbeiter eingestellt.");
				System.out.println("Wie viele Mitarbeiter sollen entlassen werden?");
				
				Scanner Mitscanner = new Scanner(System.in);
				boolean scannerErfolg=false;
				while(!scannerErfolg) {
					try {
						System.out.print("Anzahl:");
						mitarbeiterweg = Mitscanner.nextInt();
						scannerErfolg=true;
						Mitscanner.nextLine();
						if(mitarbeiterweg>mitarbeiterMenge)
						{
							System.out.println("Nicht zulässig! Es koennen maximal " + mitarbeiterMenge +" treue Mitarbeiter entlassen werden.");
							scannerErfolg=false;
						}
						listeNiederlassung.get(indexNdls).entlassen(mitarbeiterweg);
						if(mitarbeiterweg >0) {
							System.out.println("Die waren eh nur am faulenzen.");	
						}
					} catch (Exception e) {
						e.printStackTrace();
						scannerErfolg=false;
						Mitscanner.nextLine();
					}
							}
					
			}
			// Verlassen des Menus
			return;
	}
}