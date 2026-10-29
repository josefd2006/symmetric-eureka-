package cs250.hw2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;
public class Memory{

    String ogSize;
    String ogExperiments;
    String ogSeed;
    long size;
    long experiments;
    long seed;
    public Memory(String[] args){
        ogSize = args[0];
        ogExperiments = args[1];
        ogSeed = args[2];
        size = Long.parseLong(ogSize);
        experiments = Long.parseLong(ogExperiments);
        seed = Long.parseLong(ogSeed);
    }

    public float averageHelper(ArrayList<Long> times){
        long total = 0;
        for(long time : times){
            total += time;
        }
        return (float) total / times.size();
    }

    public long subTask1_1(){
    ArrayList<Long> times = new ArrayList<>();
    long startTime = System.nanoTime();
    long runningTotal = 0;
    for (long i = 1; i <= size; i++) {
        if(i % 2 == 0){
            runningTotal = runningTotal - i;
        }
        else{
            runningTotal = runningTotal + i;
        }
    }
    long endTime = System.nanoTime();
    times.add(endTime - startTime);
    float averageTime = averageHelper(times);
    System.out.println("Regular: " + ((averageTime)/1000000000.0) + " seconds"); 
    return runningTotal;
    }

    volatile long j;
    public long subTask1_2(){
    ArrayList<Long> times = new ArrayList<>();
    long startTime = System.nanoTime();
    long badRunningTotal = 0;
    for (j = 1; j <= size; j++) {
        if(j % 2 == 0) {
            badRunningTotal = badRunningTotal - j;
        } 
        else{
            badRunningTotal = badRunningTotal + j;
            
        }
    }
    long endTime = System.nanoTime();
    times.add(endTime - startTime);
    float averageTime = averageHelper(times);
    System.out.println("Volatile: " + ((averageTime)/1000000000.0) + " seconds");
    return badRunningTotal;
    }

    public void task1(){
    long avgRegularSum = subTask1_1();
    long avgVolatileSum = subTask1_2();
    System.out.println("Avg regular sum: " + avgRegularSum);
    System.out.println("Avg volatile sum: " + avgVolatileSum);
    }

    public long subTask2_1(){
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random(seed);
        for (long i = 0; i < size; i++) {
            list.add(rand.nextInt());
        } 
        long totalAccessed = 0;
        ArrayList<Long> firstTimes = new ArrayList<>();
        for(int i = 0; i < experiments + 1; i++) {
            for(int j = 0; j <= (list.size() * 0.1); j++) {
                long firststartTime = System.nanoTime();
                list.get(j);
                long firstendTime = System.nanoTime();
                totalAccessed += list.get(j);
                firstTimes.add(firstendTime - firststartTime);
            }
        }
    System.out.println("Avg time to access known element: " + averageHelper(firstTimes) + " nanoseconds");
    return totalAccessed;
    }

    public long subTask2_2(){
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random(seed);
        for (long i = 0; i < size; i++) {
            list.add(rand.nextInt());
        } 
        long totalAccessed = 0;
        ArrayList<Long> secondTimes = new ArrayList<>();
        for(int i = 0; i < experiments + 1; i++) {
            totalAccessed = 0;
            ArrayList<Integer> subList = new ArrayList<>(list.subList((int)(list.size() * 0.9), list.size()));
            int randomIndex = (int)(Math.random() * subList.size());
            long secondstartTime = System.nanoTime();
            subList.get(randomIndex);
            long secondendTime = System.nanoTime();
            totalAccessed += subList.get(randomIndex);
            secondTimes.add(secondendTime - secondstartTime);
        }
    System.out.println("Avg time to access random element: " + averageHelper(secondTimes) + " nanoseconds");
    return totalAccessed;
    }

    public void task2(){
        long sum1 = subTask2_1();
        long sum2 = subTask2_2();
        System.out.println("Sum: " + (sum1 + sum2));
    }

    
    

    public void task3(){
        TreeSet<Integer> set = new TreeSet<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (long i = 0; i < size; i++) {
            set.add((int)i);
            list.add((int)i);
        }
        ArrayList<Long> setTimes = new ArrayList<>();
        ArrayList<Long> listTimes = new ArrayList<>();
        for(int i = 0; i < experiments + 1; i++) {
            int num = (int)(Math.random() * size);
            long startTime = System.nanoTime();
            set.contains(num);
            long endTime = System.nanoTime();
            setTimes.add(endTime - startTime);
            long startTime2 = System.nanoTime();
            list.contains(num);
            long endTime2 = System.nanoTime();
            listTimes.add(endTime2 - startTime2);
        }
        System.out.println("Avg time to find in set: " + averageHelper(setTimes) + " nanoseconds");
        System.out.println("Avg time to find in list: " + averageHelper(listTimes) + " nanoseconds");

    }


    

    public static void main(String[] args) {
        Memory memory = new Memory(args);
        System.out.println("Task 1");
        memory.task1();
        System.out.println("Task 2");
        memory.task2();
        System.out.println("Task 3");
        memory.task3();
    }
}