import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static final long MAX = 1000000000;

    static class TaskThead extends Thread {
        private int x;
        private long s, e;
        public long sum = 0;
        public TaskThead(long s, long e, int x) {
            this.s = s;
            this.e = e;
            this.x = x;
        }

        @Override
        public void run() {
            for (long i = s; i < MAX && i <= e; i++) {
                if (String.valueOf(i).contains(String.valueOf(x))) {
                    sum += i;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int x;
        long ans = 0;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        long startTime = System.currentTimeMillis(); //开始时间
        List<TaskThead> taskTheadList = new ArrayList<>();
        for (long i = 1; i < MAX; i += MAX/10 + 1) {
            taskTheadList.add(new TaskThead(i, i + MAX/10, x));
        }
        for (int i = 0; i < taskTheadList.size(); i++) {
            taskTheadList.get(i).start();
        }
        for (int i = 0; i < taskTheadList.size(); i++) {
            taskTheadList.get(i).join();
        }
        for (int i = 0; i < taskTheadList.size(); i++) {
            ans += taskTheadList.get(i).sum;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time:" + (endTime - startTime));
        System.out.println(ans);
    }

}