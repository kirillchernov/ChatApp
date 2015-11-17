import java.awt.Color; 
import java.awt.EventQueue; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JScrollPane; 
import javax.swing.JTextArea; 
import javax.swing.JTextField; 

public class FrameCLie { 

JFrame frame; 
JTextField textField; 
JTextArea txtrText; 
static ClientThread listenServer; 

/** 
* Launch the application. 
*/ 
public static void main(String[] args) { 
listenServer = new ClientThread(); 
Thread serverListen = new Thread(listenServer); 
serverListen.start(); 


EventQueue.invokeLater(new Runnable() { 
public void run() { 
try { 
FrameCLie window = new FrameCLie(); 
window.frame.setVisible(true); 
} catch (Exception e) { 
e.printStackTrace(); 
} 
} 
}); 
} 

/** 
* Create the application. 
*/ 
public FrameCLie() { 
initialize(); 
} 

/** 
* Initialize the contents of the frame. 
*/ 
private void initialize() { 
frame = new JFrame(); 
frame.setBounds(100, 100, 610, 470); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
frame.getContentPane().setLayout(null); 

textField = new JTextField(); 
textField.setBackground(Color.PINK); 
textField.setBounds(10, 385, 413, 35); 
frame.getContentPane().add(textField); 
textField.setColumns(10); 

JButton Send = new JButton("SEND"); 
Send.addActionListener(new ActionListener() { 
public void actionPerformed(ActionEvent arg0) { 
} 
}); 
Send.setBounds(457, 385, 128, 35); 
frame.getContentPane().add(Send); 

txtrText = new JTextArea(); 
txtrText.setWrapStyleWord(true); 
txtrText.setLineWrap(true); 
txtrText.setBackground(Color.LIGHT_GRAY); 
txtrText.setBounds(10, 15, 413, 362); 
txtrText.setWrapStyleWord(true); 
frame.getContentPane().add(txtrText); 

JTextArea txtrConnections = new JTextArea(); 
txtrConnections.setBackground(Color.GRAY); 
txtrConnections.setBounds(457, 15, 127, 300); 
frame.getContentPane().add(txtrConnections); 

JButton btnConnect = new JButton("Connect"); 
btnConnect.setBounds(457, 360, 127, 23); 
frame.getContentPane().add(btnConnect); 

JButton btnDisconnect = new JButton("Disconnect"); 
btnDisconnect.setBounds(457, 326, 127, 23); 
frame.getContentPane().add(btnDisconnect); 

Send.addActionListener(new ActionListener() { 
public void actionPerformed(ActionEvent e) { 
Client.message = Client.Login+": "+textField.getText(); 
Client.writer.println(Client.message); 
Client.writer.flush(); 
} 
}); 

} 
}