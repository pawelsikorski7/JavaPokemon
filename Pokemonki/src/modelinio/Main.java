package modelinio;

import java.util.Scanner;

import exceptions.BadPotionException;
import exceptions.DeadPokemonException;
import pokemons.Bulbasaur;
import pokemons.Charmander;
import pokemons.Squirtle;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[]args) throws BadPotionException, DeadPokemonException{
		Pokemon pok1 = new Bulbasaur(60,20,100);
		Pokemon pok2 = new Charmander(50,15,100);
		int k = 0;
		while (pok1.getCurrentHP() > 0 && pok2.getCurrentHP() > 0){
			if (k == 0){
				System.out.println("Wybierz 2 pokemony spośród dostępnych");
				pok1 = pokemonChoice(pok1);
				pok2 = pokemonChoice(pok2);
				System.out.println("Rozpoczynamy walkę! Wybierz akcje: \"attack\" lub \"heal\"");
			}
			else if (k > 0){
				if(k > 1) nextRoundInfo();
				roundTask(pok1,pok2);
				roundTask(pok2,pok1);
			}				
			k++;
		}
		return;
	}
	public static void nextRoundInfo(){
		System.out.println();
		System.out.println("ROZPOCZYNA SIĘ NASTĘPNA RUNDA");
		System.out.println();
	}
	
	public static void roundTask(Pokemon p1, Pokemon p2) throws DeadPokemonException, BadPotionException{
		String s = sc.nextLine();
		if (s.equals("attack")){
			p1.attack(p2);
		}
		else if (s.equals("heal")){
			p1.heal(40);
		}
		else{
			System.out.println("Niepoprawna komenda- wybierz spośród: \"attack\" i \"heal\"");
			roundTask(p1,p2);
		}
	}
	
		static Pokemon pokemonChoice(Pokemon p){
			String typeOnly = sc.nextLine();			
			if (typeOnly.toLowerCase().contains("charmander")){
				if(typeOnly.toLowerCase().contains(" ")){
					p = new Charmander(50,15,100, checkName(typeOnly));
				}
				else{
					p = new Charmander(50,15,100);
				}				
			}
			else if (typeOnly.toLowerCase().contains("bulbasaur")){
				if(typeOnly.toLowerCase().contains(" ")){
					p = new Bulbasaur(60,20,100, checkName(typeOnly));
				}
				else{
					p = new Bulbasaur(60,20,100);
				}	
			}
			else if (typeOnly.toLowerCase().contains("squirtle")){
				if(typeOnly.toLowerCase().contains(" ")){
					p = new Squirtle(50,15,100, checkName(typeOnly));
				}
				else{
					p = new Squirtle(50,15,100);
				}	
			}
			else {
				System.out.println("Niepoprawny pokemon- wybierz spośród: Bulbasaur, Charmander, Squirtle");
				pokemonChoice(p);
			}
			return p;
		}
		
		public static String checkName(String scInput){
			StringBuilder sb = new StringBuilder(scInput);
			int iterator = 0;
			for(int i = 0; i < sb.length(); i++){
				if(sb.charAt(i) == 32){
					iterator = i;
					break;
				}
			}
			String Name = sb.substring(iterator + 1, sb.length());
			return Name;
		}
}
