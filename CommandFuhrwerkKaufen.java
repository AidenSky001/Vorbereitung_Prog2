package demo009.menu.impl;

import demo009.ApplicationContext;
import demo009.menu.Command;

import java.util.Scanner;

public class CommandFuhrwerkKaufen implements Command {
    @Override
    public String menuItemName() {
        return "Fuhrwerk kaufen";
    }
    @Override
    public void execute(ApplicationContext context) {
        Scanner myScanner = new Scanner(System.in);
        int scannerEr=-1;
        while(scannerEr < 0) {
        	System.out.println("Dein Guthaben beträgt: "+context.getGuthaben()+" Taler");
            System.out.println("Wie viele neue Fuhrwerke sollen gekauft werden?:");
            System.out.println("(Preis pro Fuhrwerk: "+context.getFuhrpark().getPreisFuhrwerk()+")");
            scannerEr=myScanner.nextInt();
                if (scannerEr > 0) {
                    if (scannerEr*context.getFuhrpark().getPreisFuhrwerk() > context.getGuthaben()) {
                        System.out.println("Es sind nicht genug Taler in der Schatzkammer.");
                        break;
                    }
                    else
                    context.getFuhrpark().setAnzahlFuhrwerke(context.getFuhrpark().getAnzahlFuhrwerke() + scannerEr);
                    context.guthabenMinus(scannerEr*context.getFuhrpark().getPreisFuhrwerk());
                    System.out.println("Es wurden "+scannerEr+" Fuhrwerke für "+scannerEr*context.getFuhrpark().getPreisFuhrwerk()+" Taler gekauft!");
                }
                else System.out.println("Die Eingabe war ungültig");
        }
    }
}

