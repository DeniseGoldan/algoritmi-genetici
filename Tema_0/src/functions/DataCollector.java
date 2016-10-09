package functions;

/**
 * Created by Denise Goldan on 10/9/2016.
 */
public class DataCollector {
    private long minTime = Long.MAX_VALUE;
    private long medTime = 0;
    private long maxTime = Long.MIN_VALUE;
    private double worstSolution = Double.MIN_VALUE;
    private double medSolution = 0.0;
    private double bestSolution = Double.MAX_VALUE;
    private HeuristicInvoker heuristicInvoker;

    public static void main(String[] args){
        Ackley ackleyFunction = new Ackley();
        DataCollector ackleyCollector = new DataCollector();
        ackleyCollector.collectDataForFunction(ackleyFunction,4,40);
        ackleyCollector.printData();

        System.out.flush();

        DeJong deJongFunction = new DeJong();
        DataCollector deJongCollector = new DataCollector();
        deJongCollector.collectDataForFunction(deJongFunction,5,40);
        deJongCollector.printData();

        System.out.flush();

        Schwefel schwefelFunction = new Schwefel();
        DataCollector schwefelCollector = new DataCollector();
        schwefelCollector.collectDataForFunction(schwefelFunction,6,40);
        schwefelCollector.printData();

        System.out.flush();

        SixHumpCamelBack sixHumpFunction = new SixHumpCamelBack();
        DataCollector sixCollector = new DataCollector();
        sixCollector.collectDataForFunction(sixHumpFunction,2,40);
        sixCollector.printData();

    }

    private void collectDataForFunction(Function function, int desiredNumberOfVariables, int desiredNumberOfTries){
        heuristicInvoker = new HeuristicInvoker();
        for (int i = 0; i< 10; i++){
            long startTime = System.currentTimeMillis();
            heuristicInvoker.applyHeuristic(function, desiredNumberOfVariables, desiredNumberOfTries);
            long executionTime = System.currentTimeMillis() - startTime;
            medSolution+=heuristicInvoker.getMinimumFinder().getBestSolution();
            collectTimeData(executionTime);
            collectSolutionData(heuristicInvoker.getMinimumFinder().getBestSolution());
        }
        medSolution/=10;
    }

    private static boolean isBetterSolution(double currentSolution, double referenceSolution) {
        return currentSolution < referenceSolution;
    }

    private static boolean hasBiggerValue(double currentSolution, double referenceSolution) {
        return currentSolution > referenceSolution;
    }

    private static boolean isShorter(double currentTime, double referenceTime) {
        return currentTime < referenceTime;
    }

    private static boolean isLonger(double currentTime, double referenceTime) {
        return currentTime > referenceTime;
    }

    void collectTimeData(long executionTime) {
        if (isLonger(minTime, executionTime)) {
            minTime = executionTime;
        }
        if (isShorter(maxTime, executionTime)) {
            maxTime = executionTime;
        }
    }

    void collectSolutionData(double currentSolution){
        if (hasBiggerValue(currentSolution, worstSolution)) {
            worstSolution = currentSolution;
        }
        if (isBetterSolution(currentSolution, bestSolution)) {
            bestSolution = currentSolution;
        }
    }

    public long getMinTime() {
        return minTime;
    }

    public long getMaxTime() {
        return maxTime;
    }

    public double getWorstSolution() {
        return worstSolution;
    }

    public double getBestSolution() {
        return bestSolution;
    }

    public long getMedTime() {
        return medTime;
    }

    public double getMedSolution() {
        return medSolution;
    }

    void printData() {
        System.out.println(heuristicInvoker.getMinimumFinder().getTargetedFunctionName());
        System.out.println();
        System.out.println("Best time in ms: " + getMinTime());
        System.out.println("Average in ms: " + getMedTime());
        System.out.println("Worst time in ms: " + getMaxTime());
        System.out.println("Best Solution " + getBestSolution());
        System.out.println("Average Solution: " + getMedSolution());
        System.out.println("Worst Solution " + getWorstSolution());
        System.out.println();
    }
}
