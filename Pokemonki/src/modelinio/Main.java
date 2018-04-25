package modelinio;

import exceptions.BadPotionException;
import exceptions.DeadPokemonException;
import pokemons.Bulbasaur;
import pokemons.Charmander;

public class Main {

	public static void main(String[]args) throws BadPotionException, DeadPokemonException{
		Bulbasaur b1 = new Bulbasaur(60,20,100,"Bulba");
		Charmander c1 = new Charmander(50,15,100);
		b1.attack(c1);
		c1.attack(b1);
		b1.heal(40);
		c1.attack(b1);
		b1.attack(c1);
		c1.heal(40);
		b1.attack(c1);
		c1.attack(b1);		
	}
}
