package com.study.task;

import com.study.storage.NatLogSaveThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class LogStart implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(LogStart.class);

    @Override
    public void run(String... args) throws Exception {
        runThreads("NatLogPool", 5, NatLogSaveThread.class);
    }

    private void runThreads(final String poolName, int threadNum, Class<? extends Runnable> c) {
        ExecutorService pool = Executors.newFixedThreadPool(threadNum, new ThreadFactory() {
            private AtomicInteger atomicInteger = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                int index = atomicInteger.incrementAndGet();
                Thread t = new Thread(r, poolName + "-" + index);
                return t;
            }
        });
        for (int i = 1; i <= threadNum; i++) {
            try {
                pool.execute(c.newInstance());
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }
}
