import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static final long MAX = 1000000000;
    public static int x;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long ans = 0;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        long startTime = System.currentTimeMillis();

        List<TaskThread> list = new ArrayList<>();
        long i;
        for (i = 1; i < MAX; i += 300000001) {
            list.add(new TaskThread(i, i + 300000000));
        }

        List<FutureTask> futureTaskList = new ArrayList<>();
        for (TaskThread t : list) {
            futureTaskList.add(new FutureTask(t));
        }
        List<Thread> threadList = new ArrayList<>();
        for (FutureTask futureTask : futureTaskList) {
            threadList.add(new Thread(futureTask));
        }

        for (int j = 0; j < threadList.size(); j++) {
            Thread thread = threadList.get(j);
            FutureTask futureTask = futureTaskList.get(j);
            thread.start();
            Object sum = futureTask.get();
            ans += (long)sum;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time:" + (endTime - startTime));
        System.out.println(ans);
    }

    static class TaskThread implements Callable {
        private long s, e;

        public TaskThread(long s, long e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public Object call() {
            long ans = 0;
            for (long i = s; i <= e && i < MAX; i++) {
                if (String.valueOf(i).contains(String.valueOf(x))) {
                    ans += i;
                }
            }
            return ans;
        }
    }



}