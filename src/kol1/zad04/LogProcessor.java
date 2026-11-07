package kol1.zad04;

import java.util.ArrayList;

public interface LogProcessor<T,R> {
    ArrayList<R> processLogs(ArrayList<T> logs);
}
