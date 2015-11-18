import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread implements Runnable {
	FrameCLie c = new FrameCLie();
	BufferedReader reader;

	ServerThread(Socket sock) {
		InputStreamReader is;
		try {
			is = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(is);
		} catch (Exception e) {

		}

	}

	@Override
	public void run() {
		String msg;
		try {
			while ((msg = reader.readLine()) != null) {
				System.out.println(msg);
			}
		} catch (Exception ex) {

		}
	}
}
