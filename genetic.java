import java.util.Random;

/**
 *
 * https://towardsdatascience.com/introduction-to-genetic-algorithms-including-example-code-e396e98d8bf3
 */

// Main class

public class genetic {
    Population population = new Population();
    Individual fittest;
    Individual secondFittest;
    int generationCount = 0;

    public static void main(String[] args) {

        Random rn = new Random();

        genetic run = new genetic();
        // Initialize population
        run.population.initializePopulation(population.length);

        // Calculate fitness of each individual population
        run.population.calculateFitness();

        // While population gets an individual with maximum fitness
        while (run.population.fittest < 5) {
            ++run.generationCount;

            // Do selection
            run.selection();

            // Do mutation under a random probability
            if (rn.nextInt() % 7 < 5) {
                run.mutation();
            }

            // Add fittest offspring to population
            run.addFittestOffspring();

            // Calculate new fitness value
            run.population.calculateFitness();
        }
        System.out.println("Fitness: " + run.population.getFittest().fitness);
    }

    // Selection
    void selection() {

        // Select the most fittest individual
        fittest = population.getFittest();

        // Select the second most fittest individual
        secondFittest = population.getSecondFittest();
    }

    // Mutation
    void mutation() {
        Random rn = new Random();

        // Select a random mutation point
        int mutationPoint = rn.nextInt(population.individuals[0].geneLength);

        // Flip values at the mutation point
        if (fittest.genes[mutationPoint] == 0) {
            fittest.genes[mutationPoint] = 1;
        } else {
            fittest.genes[mutationPoint] = 0;
        }

        mutationPoint = rn.nextInt(population.individuals[0].geneLength);

        if (secondFittest.genes[mutationPoint] == 0) {
            secondFittest.genes[mutationPoint] = 1;
        } else {
            secondFittest.genes[mutationPoint] = 0;
        }
    }

    // Get fittest offspring
    Individual getFittestOffspring() {
        if (fittest.fitness > secondFittest.fitness) {
            return fittest;
        }
        return secondFittest;
    }

    // Replace least fittest individual from most fittest offspring
    void addFittestOffspring() {

        // Update fitness values of offspring
        fittest.calcFitness();
        secondFittest.calcFitness();

        // Get index of least fit individual
        int leastFittestIndex = population.getLeastFittestIndex();

        // Replace least fittest individual from most fittest offspring
        population.individuals[leastFittestIndex] = getFittestOffspring();
    }

}

// Individual class for the main.java class and slot info
class Individual {

    int fitness = 0;
    int[] genes = new int[5];
    int geneLength = 5;

    public Individual() {
        Random rn = new Random();

        // Set genes randomly for each individual
        for (int i = 0; i < genes.length; i++) {
            genes[i] = Math.abs(rn.nextInt() % 2);
        }

        fitness = 0;
    }

    // Calculate fitness
    public void calcFitness() {

        fitness = 0;
        for (int i = 0; i < 5; i++) {
            if (genes[i] == 1) {
                ++fitness;
            }
        }
    }

}

// Population class
class Population {
    population.createRandomInstance(nBuildings, nRooms, nCourses);//initialize population
    int popSize = population.length;
    Individual[] individuals = new Individual[popSize];
    int fittest = 0;

    //Initialize population
    public void initializePopulation(int size) {
        for (int i = 0; i < individuals.length; i++) {
            individuals[i] = new Individual();
        }
    }

    // Get the fittest individual
    public Individual getFittest() {
        int maxFit = Integer.MIN_VALUE;
        int maxFitIndex = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (maxFit <= individuals[i].fitness) {
                maxFit = individuals[i].fitness;
                maxFitIndex = i;
            }
        }
        fittest = individuals[maxFitIndex].fitness;
        return individuals[maxFitIndex];
    }

    // Get the second most fittest individual
    public Individual getSecondFittest() {
        int maxFit1 = 0;
        int maxFit2 = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (individuals[i].fitness > individuals[maxFit1].fitness) {
                maxFit2 = maxFit1;
                maxFit1 = i;
            } else if (individuals[i].fitness > individuals[maxFit2].fitness) {
                maxFit2 = i;
            }
        }
        return individuals[maxFit2];
    }

    // Get index of least fittest individual
    public int getLeastFittestIndex() {
        int minFitVal = Integer.MAX_VALUE;
        int minFitIndex = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (minFitVal >= individuals[i].fitness) {
                minFitVal = individuals[i].fitness;
                minFitIndex = i;
            }
        }
        return minFitIndex;
    }

    // Calculate fitness of each individual
    public void calculateFitness() {

        for (int i = 0; i < individuals.length; i++) {
            individuals[i].calcFitness();
        }
        getFittest();
    }

}
