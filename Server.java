import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.text.html.HTMLDocument.Iterator;

public class Server {

	public static Socket sock = null;
	private static ArrayList streams;

	public static void main(String[] args) {
		go();
	}

	private static void go() {
		try {
			ServerSocket ss = new ServerSocket(28411);
			while (true) {
				Socket sock = ss.accept();
				System.out.println("Got user!");
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				streams.add(writer);

			}
		} catch (Exception e) {

		}

		
	}

	private void tellAll(String msg){
		int x = msg.indexOf(':');
		String login = msg.substring(0, x);
		java.util.Iterator<PrintWriter> it = streams.iterator();
		while(it.hasNext()){
			try{
				PrintWriter writer = it.next();
				writer.println(msg);
				writer.flush();
			}catch(Exception ex){
				
			}
		}
	}
}
