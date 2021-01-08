public class Project{
    private String name="";
    private String description="";
    private double initialCost=0;
    public Project() {}
    public Project(String name) {
        this.name=name;
    }
    public Project(String name, String description,double initialCost) {
        this.name=name;
        this.description=description;
        this.initialCost=initialCost;
    }
    public String elevatorPitch(){
        return this.name+" ("+String.valueOf(initialCost)+")"+": "+this.description;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setInitialCost(double initialCost){
        this.initialCost=initialCost;
    }
    public double getInitialCost(){
        return this.initialCost;
    }
    




}