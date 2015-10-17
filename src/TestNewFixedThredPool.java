import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author anting.hu
 * @des: test InterruptedException
 * @date:	2015-10-17
 * @reference: http://www.itzhai.com/the-executorservice-common-method-newfixedthreadpool-of-create-fixed-size-thread-pool.html
 */
public class TestNewFixedThredPool {
	
	public static void main(String[] args) throws InterruptedException
	{
		ExecutorService service = Executors.newFixedThreadPool(3, new ThreadFactory() {
			
			/* (non-Javadoc)
			 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
			 */
			@Override
			public Thread newThread(Runnable r) {
				// TODO Auto-generated method stub
				Thread t = new Thread(r);
				t.setPriority(Thread.NORM_PRIORITY -1);
				t.setName("Test");
				return t;
			}
		});
		
		for(int i=0; i< 10; i++)
		{
			service.submit(new SubTask("Thread_" + i));
		}
		service.shutdown();
		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		System.out.println("All thread complete");
	}
}

class SubTask implements Runnable
{
	String taskName="";
	public SubTask(String name)
	{
		taskName = name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("SubTask: " + taskName);
	}
	
}
