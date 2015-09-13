import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JFileChooser;
import javax.swing.border.CompoundBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JLayeredPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;


public class hhv3 {

	private JFrame frame;
	private final JFileChooser fileChooser = new JFileChooser();
	private File upload;
	private String path = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hhv3 window = new hhv3();
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
	public hhv3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 153));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton filescan = new JButton("File Scan");
		filescan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open(FileCheck.rawAnalysis(path,0));
			}
		});
		filescan.setBackground(new Color(255, 255, 153));
		filescan.setBounds(73, 175, 89, 23);
		frame.getContentPane().add(filescan);
		
		JButton songscan = new JButton("Song Scan");
		songscan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open(FileCheck.rawAnalysis(path,1));
			}
		});
		songscan.setBounds(168, 175, 89, 23);
		frame.getContentPane().add(songscan);
		
		JButton both = new JButton("File & Song");
		both.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open(FileCheck.rawAnalysis(path,2));
			}
		});
		both.setBounds(263, 175, 89, 23);
		frame.getContentPane().add(both);
		fileChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upload = fileChooser.getSelectedFile();
				path = upload.getAbsolutePath();
			}
		});
		
		fileChooser.setBackground(new Color(255, 255, 153));
		fileChooser.setBounds(73, 132, 279, 32);
		frame.getContentPane().add(fileChooser);
		
		JTextArea choosefile = new JTextArea();
		choosefile.setForeground(new Color(102, 51, 0));
		choosefile.setBackground(new Color(255, 255, 153));
		choosefile.setFont(new Font("SansSerif", Font.BOLD, 15));
		choosefile.setLineWrap(true);
		choosefile.setText("Choose a file, then select the process you want to run");
		choosefile.setBounds(20, 75, 387, 32);
		frame.getContentPane().add(choosefile);
	}
	
	private void open(String []x) {
		String s = "";
		for(int i = 0; i < x.length;i++) {
			s = s + "\n" + x[i];
		}
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 153));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea choosefile = new JTextArea(s);
		choosefile.setForeground(new Color(102, 51, 0));
		choosefile.setBackground(new Color(255, 255, 153));
		choosefile.setFont(new Font("SansSerif", Font.BOLD, 15));
		choosefile.setLineWrap(true);
		choosefile.setText("Choose a file, then select the process you want to run");
		choosefile.setBounds(20, 75, 387, 32);
		frame.getContentPane().add(choosefile);
	}
}
