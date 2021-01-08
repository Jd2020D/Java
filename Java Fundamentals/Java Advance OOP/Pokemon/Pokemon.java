public class Pokemon{
    private static int count=0;
    private String name="";
    private double health=100;
    private String type="";
    Pokemon(){
        count+=1;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setHealth(double health){
        this.health=health;
    }
    public void setType(String type){
        this.type=type;
    }
    Pokemon(String name,double health,String type){
        this.setHealth(health);
        this.setName(name);
        this.setType(type);
        count+=1;
    }
    public String getName(){
        return this.name;
    }
    public double getHealth(){
        return this.health;
    }
    public String getType(){
        return this.type;
    }
    public void attackPokemon(Pokemon pokemon){
        pokemon.setHealth(pokemon.getHealth()-10);
        // or pokemon.health-=10; 
    }
    public static int getPokemonsNumber(){
        return count;
    }

}