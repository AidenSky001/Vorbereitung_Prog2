package demo009.util;

import java.util.List;

import demo009.ApplicationContext;
import demo009.model.Niederlassung;
import demo009.model.Lager;
import demo009.model.Warenart;


public class DisplayService
{

		public static void anzeigenNiederlassungen (ApplicationContext context)
		{
			
			System.out.println("========== Niederlassung");
			
			System.out.println("Ort"+"\t\t"+"Warenart"+"\t"+"Status Anforderung"+"\t"+"gesendete Fuhrwerke"+"\t\t"+"Arbeiter");

			List<Niederlassung> listeNiederlassung = context.getNiederlassungen();
			
			for(int indexNdls=0; indexNdls<listeNiederlassung.size(); indexNdls++) {
				String status = listeNiederlassung.get(indexNdls).wurdeAngefordert()==true?"angefordert":"nicht angefordert";
				int gepFuhrwerke = listeNiederlassung.get(indexNdls).wurdeAngefordert()==true?context.getGeplanteFuhrwerke().get(listeNiederlassung.get(indexNdls)):0;
				
				System.out.println(listeNiederlassung.get(indexNdls).getOrt()+"\t\t"+listeNiederlassung.get(indexNdls).getWarenartString()+"\t\t"+status+"\t\t"+gepFuhrwerke+"\t\t\t"+listeNiederlassung.get(indexNdls).getArbeitende());
			}
			
		}
		public static void anzeigenLager (ApplicationContext context)
		{
			
			System.out.println("========== Lagerbestand");
			
			
			Lager Lager = context.getLager();
			
			for (Warenart ware : Warenart.values())
			{
				int anzahl = Lager.getBestand(ware);
				if (anzahl >0)
				{
					System.out.println(Lager.getEingelagerteWaren()+": " + anzahl);
				}
			
			}
		}
		
		public static void anzeigenGuthaben (ApplicationContext context)
		{
			System.out.println("========== Guthaben");
			
			int anzeigeGeld = context.getGuthaben();
			System.out.println("Guthaben in Taler: " + anzeigeGeld);
		}
		
}
