package User;
import java.io.IOException;
import java.util.Calendar;
public class User {
	private final static int DIM_MAX_NAME = 20;
	private final static int DIM_RECORD = 2 *(DIM_MAX_NAME+Character.BYTES)+Integer.BYTES;
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
			buffer.append(String.valueOf(YOB));
			for(int i=0;i<(DIM_MAX_NAME-YOB.length());i++)
				buffer.append('\0');
		}else return false;
		return true;
	}
	public String getInfo() {
		return buffer.toString();
		//return buffer.substring(DIM_MAX_NAME);
	}
}
