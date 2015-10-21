package TestExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestNewFixedThreadPool {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		for(int i=0; i< 5; i++)
		{
			Runnable thread = new MyThead("" + i);
			threadPool.execute(thread);
		}
		
		threadPool.shutdown();
		while(!threadPool.isTerminated())
		{
			
		}
		System.out.println("finish all thread");
	}
}
