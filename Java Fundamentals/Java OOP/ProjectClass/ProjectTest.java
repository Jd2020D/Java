public class ProjectTest{
    public static void main(String[] args){
        Project p1=new Project();
        Project p2=new Project("Project2");
        Project p3=new Project("Project3","desc. . . . ",10);
        p1.setName("p1name");
        p1.setDescription("p1description");
        p1.setInitialCost(2.5);
        p2.setDescription("p2description");
        p2.setInitialCost(10.5);
        System.out.println(p1.elevatorPitch());
        System.out.println(p2.elevatorPitch());
        System.out.println(p3.elevatorPitch());
        System.out.println("==========");
        Portfolio myPortfolio=new Portfolio();
        myPortfolio.addProject(p1);
        myPortfolio.addProject(p2);
        myPortfolio.addProject(p3);
        System.out.println(myPortfolio.getPortfolioCost());
        myPortfolio.showPotrfolio();
    }
}