import java.util.ArrayList;
public class Portfolio {
    private ArrayList<Project> projects=new ArrayList<Project>();
    Portfolio(){}
    public void addProject(Project project){
        this.projects.add(project);
    }
    public ArrayList<Project> getProjects(){
        return this.projects;
    }
    public double getPortfolioCost(){
        double cost=0;
        for (int i = 0; i < this.projects.size(); i++) {
            cost+=this.projects.get(i).getInitialCost();
        }
        return cost;
    }
    public void showPotrfolio(){
        for (int i = 0; i < this.projects.size(); i++) {
            System.out.println(this.projects.get(i).elevatorPitch());
        }

    }
}
