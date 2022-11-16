import java.util.Random;

public class genetic {
    public SchedulingProblem problem;
    public randomGenerator generator;
    public Schedule solution;
    public int scheduledCourses = 0;

    double[] current = generator.generate();

    public genetic(SchedulingProblem problem, Schedule solution) {
        this.problem = problem;
        this.generator = new randomGenerator(problem, solution);
        this.solution = solution;
    }

    public void main(String[] args) {

        Random rn = new Random();
        // Initialize population
        double[] current=generator.generate();

        // Evaluate each individual population=generated solution
        double evaluated= eval(current);

        // While population gets best solution
        while (int i>0) {
            ++i;

            // Do selection
            System.out.println(evaluated);

            // Do mutation under a random probability
            if (rn.nextInt() % 7 < 5) {
                double mutated=mutation(current);
            }

            // Add best offspring to population
            double temp = addOffspring(mutated);

            // Calculate new evaluation
            double[] best = eval(temp);
        }
        System.out.println("Best choice: " + best);
    }

    public double eval(double[] current2) {
        // which returns back the best solution
        return;

    }

    // Mutation
    void mutation() {
        Random rn = new Random();

        // Select a random mutation point
        int point = rn.nextInt(current[0].length);

        // Flip values at the mutation point
        if (current[point] == 0) {
            current[point] = 1;
        } else {
            current[point] = 0;
        }
    }

    public double addOffspring(double mutated) {
        // adds new offspring into population
        return current.append.mutated;
    }
}
