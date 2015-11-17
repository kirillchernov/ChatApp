import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.PrintWriter; 
import java.net.Socket; 
import java.net.UnknownHostException; 

import javax.swing.JOptionPane; 

public class Client { 
static BufferedReader reader;//receive 
static PrintWriter writer;//send 
static String Login; 
static String message; 



public static void setConnection() { 
try { 
Socket sock = new Socket("127.0.0.1", 8080); 
InputStreamReader is = new InputStreamReader(sock.getInputStream()); 
reader = new BufferedReader(is); 
writer = new PrintWriter(sock.getOutputStream()); 
Login = JOptionPane.showInputDialog("write login"); 
} catch (UnknownHostException e) { 
e.printStackTrace(); 
} catch (IOException e) { 

e.printStackTrace(); 
} 
} 
public static void refresh(){ 
writer.print(""); 
} 




}