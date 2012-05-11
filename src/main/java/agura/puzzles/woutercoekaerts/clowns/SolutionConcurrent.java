package agura.puzzles.woutercoekaerts.clowns;

import java.util.ArrayList;
import java.util.List;

/**
 * Multithreaded solution
 *
 * @author Andrey Gura
 */
public class SolutionConcurrent {

    private static final int TARGET_CLOWNS_AMOUNT = 20;

    private static volatile int waitingThreadsCount = 0;

    public static void main(String args[]) throws InterruptedException {
        final Volkswagen vw = new Volkswagen();
        final List<Thread> threads = addClownsConcurrently(vw);

        //all threads have to acquire vw's lock before main thread
        while (waitingThreadsCount < TARGET_CLOWNS_AMOUNT) {}

        synchronized (vw) {
            vw.notifyAll();
        }

        joinAllThreads(threads);
        vw.done();
    }

    private static List<Thread> addClownsConcurrently(final Volkswagen vw) {
        final List<Thread> threads = new ArrayList<Thread>(TARGET_CLOWNS_AMOUNT);

        for (int i = 0; i < TARGET_CLOWNS_AMOUNT; i++) {

            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    vw.add(new ConcurrentClown(vw));
                }
            };

            final Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        return threads;
    }

    private static void joinAllThreads(final List<Thread> threads) throws InterruptedException {
        for (final Thread thread : threads) {
            thread.join();
        }
    }

    private static class ConcurrentClown extends Clown {
        private final Volkswagen vw;

        ConcurrentClown(final Volkswagen vw) {
            this.vw = vw;
        }

        @Override
        public int hashCode() {
            try {
                waitingThreadsCount++;
                while (waitingThreadsCount < TARGET_CLOWNS_AMOUNT) {
                    vw.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return super.hashCode();
        }
    }
}