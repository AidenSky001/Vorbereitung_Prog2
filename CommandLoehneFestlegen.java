package demo009.menu.impl;

import java.util.List;
import java.util.Scanner;

import demo009.ApplicationContext;
import demo009.menu.Command;
import demo009.model.Niederlassung;

public class CommandLoehneFestlegen implements Command {

	@Override
	public String menuItemName() {
		return "Loehne festlegen";
	}

	@Override
	public void execute(ApplicationContext context) {
		// TODO Auto-generated method stub
		System.out.println("========== "+menuItemName());

		int Lohndazu =0;
		int Lohnweg =0;
		
		List<Niederlassung> listeNiederlassung = context.getNiederlassungen();
		for(int indexNdls=0; indexNdls<listeNiederlassung.size(); indexNdls++) {
			int mitarbeiterLohn = listeNiederlassung.get(indexNdls).getLohn();
			System.out.println("In " + listeNiederlassung.get(indexNdls).getOrt()+" wird jedem Arbeiter ein Mindestlohn in Höhe von " + listeNiederlassung.get(indexNdls).getLohn() + " Talern gezahlt.");
			System.out.println("Um wieviel Taler soll der Lohn erhoeht werden?");
			
			Scanner Lohnscanner = new Scanner(System.in);
			boolean scannerErfolg=false;
			while(!scannerErfolg) {
				try {
					System.out.print("Anzahl:");
					Lohndazu = Lohnscanner.nextInt();
					Lohnscanner.nextLine();
					
					listeNiederlassung.get(indexNdls).zahlenplu(Lohndazu);
					scannerErfolg=true;
				} catch (Exception e) {
					e.printStackTrace();
					scannerErfolg=false;
					Lohnscanner.nextLine();
				}
						}
				
		}
		for(int indexNdls=0; indexNdls<listeNiederlassung.size(); indexNdls++) {
			int mitarbeiterLohn = listeNiederlassung.get(indexNdls).getLohn();
			System.out.println("In " + listeNiederlassung.get(indexNdls).getOrt()+" wird jedem Arbeiter ein Lohn in Höhe von " + listeNiederlassung.get(indexNdls).getLohn() + " Talern gezahlt.");
			System.out.println("Um wieviel Taler soll der Lohn gesenkt werden?");
			
			Scanner Lohnscanner = new Scanner(System.in);
			boolean scannerErfolg=false;
			while(!scannerErfolg) {
				try {
					System.out.print("Anzahl:");
					Lohnweg = Lohnscanner.nextInt();
					Lohnscanner.nextLine();
					listeNiederlassung.get(indexNdls).zahlenmin(Lohnweg);
					if(listeNiederlassung.get(indexNdls).getLohn() <=0) {
						System.out.println("Niemand arbeitet freiwillig, ... außer Praktikanten.");
						listeNiederlassung.get(indexNdls).zahlenplu(Lohnweg);
						scannerErfolg=false;
					}
					scannerErfolg=true;
				} catch (Exception e) {
					e.printStackTrace();
					scannerErfolg=false;
					Lohnscanner.nextLine();
				}
						}
				
		}
		
		// Verlassen des Menus
					return;
	}
}
