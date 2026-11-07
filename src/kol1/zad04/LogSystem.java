package kol1.zad04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LogSystem<T extends ILog> {
//TODO add instance variable(s)
ArrayList<T> logsList;

//TODO constructor


    public LogSystem(ArrayList<T> logsList) {
        this.logsList = logsList;
    }

    void printResults() {

        //TODO define concrete log processors with lambda expressions
        LogProcessor<T,T> firstLogProcessor = (logs) -> {
            return logs.stream().filter(l -> l.getType().equals("INFO")).collect(Collectors.toCollection(ArrayList::new));
        };

        LogProcessor<T,T> secondLogProcessor = (logs -> {
            return logs.stream().filter(l -> l.getMessage().length()<100).collect(Collectors.toCollection(ArrayList::new));
        });

        LogProcessor<T,T> thirdLogProcessor = (logs) -> {
            return logs.stream().sorted(Comparator.comparing(l -> l.getTimestamp())).collect(Collectors.toCollection(ArrayList::new));
        };

                                System.out.println("RESULTS FROM THE FIRST LOG PROCESSOR");
        firstLogProcessor.processLogs(logsList).forEach(l -> System.out.println(l.toString()));

        System.out.println("RESULTS FROM THE SECOND LOG PROCESSOR");
        secondLogProcessor.processLogs(logsList).forEach(l -> System.out.println(l.toString()));

        System.out.println("RESULTS FROM THE THIRD LOG PROCESSOR");
        thirdLogProcessor.processLogs(logsList).forEach(l -> System.out.println(l.toString()));
    }
}
