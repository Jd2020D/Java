public class Test{
    public static void main(String[] args){
        Pokedex dex1= new Pokedex();
        Pokemon p1=dex1.createPokemon("pokemon1", 100, "type1");
        Pokemon p2=dex1.createPokemon("pokemon2", 100, "type2");
        System.out.println(p1.getName()+" "+String.valueOf(p1.getHealth()));
        System.out.println(p2.getName()+" "+String.valueOf(p2.getHealth()));
        p1.attackPokemon(p2);
        System.out.println("affter attack");
        System.out.println(p1.getName()+" "+String.valueOf(p1.getHealth()));
        System.out.println(p2.getName()+" "+String.valueOf(p2.getHealth()));
        System.out.println("Pokemons' names");
        dex1.listPokemon();
    }
}