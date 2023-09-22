package User;
import java.io.IOException;
import java.util.Calendar;
public class User {
	// maximum length for name.
	private final static int DIM_MAX_NAME = 20;
	// maximum size of the record composed of two strings and an integer.
	private final static int DIM_RECORD = 2 *(DIM_MAX_NAME+Character.BYTES)+Integer.BYTES;
	// set of two strings and an integer, maximum length "DIM_RECORD"
	private StringBuilder buffer = new StringBuilder();
	public boolean addName(String name) {
		if(name.length() <= DIM_RECORD) {
			buffer.append(name);
			for(int i=0;i<(DIM_MAX_NAME-name.length());i++)
				buffer.append('\0');
		}else return false; 
		return true;
	}
	public boolean addYOB(String YOB) {
		if(Integer.valueOf(YOB) <= Calendar.getInstance().get(Calendar.YEAR)) {
			buffer.append(YOB);
			for(int i=0;i<(DIM_MAX_NAME-YOB.length());i++)
				buffer.append('\0');
		}else return false;
		return true;
	}
	public String getInfo() {
		return buffer.toString();
	}
}
