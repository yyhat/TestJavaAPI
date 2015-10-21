package TestExecutor;

import java.util.concurrent.ThreadPoolExecutor;

public class MyMonitorThread implements Runnable{

	private ThreadPoolExecutor executor;
	private float seconds;
	private boolean run = false;
	public MyMonitorThread(ThreadPoolExecutor exec, int delay)
	{
		executor = exec;
		seconds = delay;
		run = true;
	}
	
	public void shutdown()
	{
		run = false;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(run)
		{
			 System.out.println(
	                    String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
	                        this.executor.getPoolSize(),
	                        this.executor.getCorePoolSize(),
	                        this.executor.getActiveCount(),
	                        this.executor.getCompletedTaskCount(),
	                        this.executor.getTaskCount(),
	                        this.executor.isShutdown(),
	                        this.executor.isTerminated()));
	                try {
	                    Thread.sleep((long) (seconds*1000));
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
		}
	}
	

}
