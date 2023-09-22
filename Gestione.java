package User;

import java.io.RandomAccessFile;
import java.io.IOException;

public class Gestione {
		private byte[] buffer;
	public void insertData(String data) {
		try (RandomAccessFile raf = new RandomAccessFile("dati.dat","rw")){
			//buffer = data.getBytes("UTF-8");
			//raf.write(buffer);
			raf.writeBytes(data); 
			raf.writeByte('\n');
		}catch(IOException e){
			e.printStackTrace();
		}	
	}
	public void extractData() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("dati.dat","r");
		buffer = new byte[(int)raf.length()];
		raf.read(buffer);
		String text = new String(buffer, "UTF-8");
		raf.close();
	}
	
	public static void main(String[] args) {
		User user = new User();
		Gestione gestione = new Gestione();
		user.addName("Mark");
		user.addName("Coriolis");
		user.addYOB("2013");
		
		user.addName("Mark");
		user.addName("Coriolis");
		user.addYOB("2013");
		
		gestione.insertData(user.getInfo());
		try {
			gestione.extractData();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//byteArray: [109, 97, 114, 107]
}
