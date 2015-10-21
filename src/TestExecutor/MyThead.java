package TestExecutor;

public class MyThead implements Runnable
{
	private String command;
	
	public MyThead(String threadName)
	{
		command = threadName;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " start. command=" + command);
		ProcessCommand();
		System.out.println(Thread.currentThread().getName() + " end");
	}
	
	
	void ProcessCommand()
	{
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return command;
	}
}
