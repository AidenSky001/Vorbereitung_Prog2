package demo009.menu.impl;

import java.util.Scanner;

import demo009.ApplicationContext;
import demo009.menu.Command;


public class CommandFuhrwerkVerkaufen implements Command {

	@Override
	public String menuItemName() {
		return "Fuhrwerk verkaufen:";
	}

	@Override
	public void execute(ApplicationContext context) {
		Scanner myScanner = new Scanner(System.in);
        int scannerErg=-1;
        while(scannerErg < 0) {
            System.out.println("Wie viele Fuhrwerke sollen verkauft werden?");
            System.out.println("aktuelle Anzahl der Fuhrwerke:"+context.getFuhrpark().getAnzahlFuhrwerke()+")");
            System.out.println("Preis pro Fuhrwerk: "+context.getFuhrpark().getPreisFuhrwerk()+")");
            scannerErg=myScanner.nextInt();
            if (scannerErg > 0) {
                if(scannerErg>context.getFuhrpark().getAnzahlFuhrwerke()) {
                    System.out.println("Nicht genug Fuhrwerke vorhanden!");
                    break;
                }
                //Fuhrwerk Anzahl
                context.getFuhrpark().setAnzahlFuhrwerke(context.getFuhrpark().getAnzahlFuhrwerke() - scannerErg);
                context.guthabenPlus(scannerErg*context.getFuhrpark().getPreisFuhrwerk());
                System.out.println("Es wurden "+scannerErg+ "Fuhrwerke für " + scannerErg*context.getFuhrpark().getPreisFuhrwerk()+" Taler verkauft!");
            }
            else System.out.println("Diese Eingabe ist nicht gültig.");
        }
    }
}