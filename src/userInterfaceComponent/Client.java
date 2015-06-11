package userInterfaceComponent;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame{
	private PrintWriter writer;				// create a text to show the message
	Socket clientSocket;
	private JTextField writeField = new JTextField();
	private JTextArea printField = new JTextArea();
	JButton finishButton;
	JButton connectionButton;
	Container container;
	
	public Client(String title){
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = this.getContentPane();
		JPanel entity = new JPanel();
		entity.setPreferredSize(new Dimension(250,200));
		entity.setLayout(new BoxLayout(entity, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(200,120));
		scrollPane.setViewportView(printField);
		entity.add(scrollPane);
		JPanel bot = new JPanel();
		bot.setLayout(new FlowLayout());
		writeField.setPreferredSize(new Dimension(200,60));
		bot.add(writeField);
		finishButton = new JButton("Pass");
		finishButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					String content = writeField.getText();
					writer.println(content);
					printField.append(content+'\n');
					printField.setSelectionEnd(printField.getText().length());
					writeField.setText("");
				}catch(NullPointerException a){
					System.out.println("haven't connect to the server, you can't do that");
				}
			}
		});
		bot.add(finishButton);
		entity.add(bot);
		
		connectionButton = new JButton("connect");
		connectionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				connect();
			}
		});
		entity.add(connectionButton);
		container.add(entity);
		
		this.setVisible(true);
	}
	
	private void connect(){
		printField.append("Try to coneect");
		try{
			clientSocket = new Socket("127.0.0.1",8998);
			writer = new PrintWriter(clientSocket.getOutputStream(),true);
			printField.append("finish connecting");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
