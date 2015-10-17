import java.lang.Thread.UncaughtExceptionHandler;

/*
 * @des:	test UncaughtExceptionHandler
 * @date: 2015-10-17
 * @reference: http://www.cnblogs.com/freeliver54/archive/2011/10/17/2215423.html
 */
public class TestUncaughtExceptionHandler {
	public static void main(String[] args) throws InterruptedException
	{
	
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int a = 1/0;
			}
		});
		t.setUncaughtExceptionHandler(new ThreadException());
		t.start();
	}
}

class TestThread extends Thread
{
	@Override
	public void run()
	{
		int a = 1/0;
	}
}

class ThreadException implements UncaughtExceptionHandler
{

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		System.out.println("---------" + e.getCause());
	}
	
}
