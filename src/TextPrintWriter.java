import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @des: test PrintWriter
 * @author anting.hu
 * @date: 2015-10-15
 * @reference: http://www.tuicool.com/articles/jE7FVn
 *
 */
public class TextPrintWriter {

	public static void main(String[] args) {
		try {
			int a = 1/0;
			
		} catch (Exception e) {
			// TODO: handle exception
			String msg = GetExceptionMsg(e);
			System.out.println("-----------exception begin -----------------");
			System.out.println(msg);
			System.out.println("--------------exception end---------------");
			
		}
	}
	
	public static String GetExceptionMsg(Exception e)
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String msg = sw.toString();
		pw.close();
		return msg;
	}
}
