public class ClientThread implements Runnable {

	FrameCLie c = new FrameCLie();

	public void run() {
		String msg;
		try {
			while ((msg = Client.reader.readLine()) != null) {
				c.txtrText.append(msg + "\n");
			}
		} catch (Exception ex) {
			
		}

	}

}