import java.util.*;

public class SimulatedAnnealing {
    public double increment = 0;
    public double temperature = 500;
    public double coolingRate = 0.98;
    public SchedulingProblem problem;
    public randomGenerator generator;
    public Schedule solution;
    public int scheduledCourses = 0;

    public SimulatedAnnealing(SchedulingProblem problem, Schedule solution) {
        this.problem = problem;
        this.generator = new randomGenerator(problem, solution);
        this.solution = solution;
    }

    public double probability(double f1, double f2) {

        return Math.exp((f1 - f2) / this.temperature);
    }

    public void coolDown() {
        this.temperature = this.temperature * this.coolingRate;
    }

    public  Schedule getSolution(){
        double[] current=generator.generate();
        while(current[3]==-1){
            current=generator.generate();
        }
        this.increment=current[3]-this.increment;
        this.solution.schedule[(int)(current[0])][(int)(current[1])]=(int)current[2];
        while(this.temperature>1 && this.scheduledCourses<10){
            double[] next=generator.generate();
            double newIncrement=next[3]-current[3];
            if(next[0]==-1){
                coolDown();
            }
            else if(newIncrement>this.increment){

                current=next;
                this.solution.schedule[(int)current[0]][(int)current[1]]=(int)current[2];
                this.generator.schedule=this.solution;
                this.increment=newIncrement;
                this.scheduledCourses+=1;
            }else{

                Random random=new Random();
                double check=random.nextDouble()*1;
                if(probability(this.increment, newIncrement)>check){
                    current=next;
                    this.solution.schedule[(int)current[0]][(int)current[1]]=(int)current[2];
                    this.generator.schedule=this.solution;
                    this.increment=newIncrement;
                    this.scheduledCourses+=1;
                }

            }
            coolDown();
            
        }
        return this.solution;
    }

}
