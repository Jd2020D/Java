public abstract class AbstractPokemon implements PokemonInterface {
    AbstractPokemon(){}
    @Override
    public String pokemonInfo(Pokemon pokemon) {
        return "Name: "+ pokemon.getName()+" Type: "+pokemon.getType()+" Health: "+pokemon.getHealth();
    }

    @Override
    public Pokemon createPokemon(String name, int health, String type) {
        Pokemon pokemon = new Pokemon(name,health,type); 
        return pokemon;
    }
    // we implement these methods here "in abstract class" in case we make many class childs like pokedex that extends from the abstract one


}
