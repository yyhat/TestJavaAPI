package TestExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestNewFixedThreadPool2 {

	public static void main(String[] args) throws InterruptedException {
		TestRejectedExecutionHandler handler = new TestRejectedExecutionHandler();
		ThreadFactory factory = Executors.defaultThreadFactory();
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, 
				new ArrayBlockingQueue<Runnable>(2), factory,handler);
		
		MyMonitorThread monitor = new MyMonitorThread(threadPool, 3);
		Thread monitorThread = new Thread(monitor);
		monitorThread.start();
		
		for(int i=0; i< 10; i++)
		{
			MyMonitorThread thread = new MyMonitorThread(threadPool, 3);
			threadPool.execute(thread);
		}
		
		Thread.sleep(30000);
        //shut down the pool
		threadPool.shutdown();
        //shut down the monitor thread
        Thread.sleep(5000);
        monitor.shutdown();
	}
}
