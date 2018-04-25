package modelinio;

public enum PokemonType {
	FIRE("Fire"),
	WATER("Water"),
	GRASS("Grass");
	
	private String typeName;
	
	private PokemonType(String name){
		this.typeName = name;
	}
	
	public String toString(){
		return this.typeName;
	}
	
	public String getTypeName(){
		return toString();
	}
}
