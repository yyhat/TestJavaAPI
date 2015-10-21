package TestExecutor;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class TestRejectedExecutionHandler  implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable arg0, ThreadPoolExecutor arg1) {
		// TODO Auto-generated method stub
		System.out.println(arg0.toString() + " is rejected");
	}
	

}
