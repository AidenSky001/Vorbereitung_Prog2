package demo009.menu.impl;

import demo009.ApplicationContext;
import demo009.menu.Command;
import demo009.misc.Util;
import demo009.model.Niederlassung;
import demo009.model.Warenart;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CommandSpeichern implements Command {
    @Override
    public String menuItemName() {
        return "Simulationsstand speichern";
    }

    @Override
    public void execute(ApplicationContext Context) {
        File Spielstand = new File("demo009/Speicherstand");
        if (Spielstand.exists()) {
            System.out.println("Simulationsstand wurde gespeichert");
        } else { Spielstand.mkdirs();
            System.out.println("Simulationsstand wurde gespeichert"); }
        File Fuhrwerk = new File("demo009/Speicherstand/fuhrwerk.txt");
        File Guthaben = new File("demo009/Speicherstand/guthaben.txt");
        File Lager = new File("demo009/Speicherstand/lager.txt");
        File Niederlassungen = new File("demo009/Speicherstand/niederlassungen.txt");
        try {
            FileWriter Writer = new FileWriter("demo009/Speicherstand/Fuhrwerk.txt");
            Writer.write(Context.getFuhrpark().getAnzahlFuhrwerke()+";"+Context.getFuhrpark().getPreisFuhrwerk());
            Writer.close();
            Writer = new FileWriter("demo009/Speicherstand/guthaben.txt");
            Writer.write(""+Context.getGuthaben());
            Writer.close();
            Writer = new FileWriter("demo009/Speicherstand/lager.txt");
            Writer.write(Context.getLager().getOrt());
            for (Warenart warenart : Context.getLager().getEingelagerteWaren()) {
                Writer.write("\n"+Util.convertWarenartToString(warenart)+";"+Context.getLager().getBestand(warenart));
            }
            Writer.close();
            Writer = new FileWriter("demo009/Speicherstand/niederlassungen.txt");
            for (Niederlassung niederlassung : Context.getNiederlassungen()) {
                Writer.write(niederlassung.getOrt() + ";" + niederlassung.getWarenartString() + ";"+ niederlassung.getArbeitende()+ ";"+niederlassung.getLohn());
            }
            Writer.close();
        } catch (IOException e) {
            System.out.println("Dateien konnten nicht gespeichert werden");
        }


    }
}