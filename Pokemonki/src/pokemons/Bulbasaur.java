package pokemons;

import modelinio.PokemonGrass;

public class Bulbasaur extends PokemonGrass {

	public Bulbasaur(int AP, int DP, int maxHP) {
		super(AP, DP, maxHP);
		super.attackName = "Dzikie pnacze";
		super.name = "Bulbasaur";		
	}
	
	public Bulbasaur(int AP, int DP, int maxHP, String name){
		this(AP, DP, maxHP);
		super.name = name;
	}
}
