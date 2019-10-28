package mail;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JList;

public class MailUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MailUI frame = new MailUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MailUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(93, 94, 306, 23);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(96, 139, 306, 136);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(308, 61, 91, 23);
		contentPane.add(textArea_2);
		
		JButton button = new JButton("发送");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url;
				String payload;
				MailProxy proxy = new MailProxy();
				try {
					url=textArea.getText();
					payload=textArea_1.getText();
					proxy.sendEmail(url, payload);
					textArea_2.setText("Y");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(26, 305, 76, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("批量发送");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url;
				String[] urls=null;
				String payload;
				MailProxy proxy = new MailProxy();
				try {
					url=textArea.getText();
					urls = url.split("/");
					payload=textArea_1.getText();
					proxy.sendEmailBatch(urls, payload);
					textArea_2.setText("Y");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		button_1.setBounds(133, 305, 97, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("验证邮箱地址");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url;
				MailProxy proxy = new MailProxy();
				try {
					url=textArea.getText();
					if(proxy.validateEmailAddress(url)==true) {
					textArea_2.setText("Y");
					}
					else {
						textArea_2.setText("N");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(260, 305, 139, 23);
		contentPane.add(button_2);
		
		JLabel label = new JLabel("\u6536\u4EF6\u4EBA\u90AE\u7BB1\uFF1A");
		label.setBounds(26, 97, 80, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u9009\u62E9\u63A5\u53E3\uFF1A");
		label_1.setBounds(26, 54, 81, 37);
		contentPane.add(label_1);
		
		
		JLabel label_2 = new JLabel("\u90AE\u4EF6\u5185\u5BB9\uFF1A");
		label_2.setBounds(26, 127, 76, 37);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u8FD4\u56DE\u503C\uFF1A");
		label_3.setBounds(251, 65, 58, 15);
		contentPane.add(label_3);
		
		JCheckBox chckbxSoap = new JCheckBox("Soap");
		chckbxSoap.setBounds(164, 63, 51, 18);
		contentPane.add(chckbxSoap);
		
		JCheckBox chckbxRest = new JCheckBox("Rest");
		chckbxRest.setBounds(93, 54, 57, 37);
		contentPane.add(chckbxRest);
	}
}
