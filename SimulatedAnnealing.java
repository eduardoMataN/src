public class SimulatedAnnealing {
    public static double probability (double f1, double f2, double temperature){
        if(f1>f2){
            return f1;
        }
        return Math.exp((f1-f2)/temperature);
    }
    public static int distance(int x1, int y1, int x2, int y2){
        return ((x2-x1)+(y2-y1));
    }
}
