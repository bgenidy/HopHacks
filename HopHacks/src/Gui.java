import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.Component;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.SystemColor;
import java.io.File;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;


public class Gui {

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
					Gui window = new Gui();
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
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(new Color(255, 228, 181));
		frame.setBackground(new Color(255, 218, 185));
		frame.setBounds(100, 100, 924, 552);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panel_main = new JPanel();
		panel_main.setBackground(new Color(205, 92, 92));
		frame.getContentPane().add(panel_main, "name_67805013103729");
		panel_main.setLayout(null);
		panel_main.setVisible(true);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 245, 238), new Color(255, 239, 213)));
		fileChooser.setForeground(new Color(250, 235, 215));
		fileChooser.setBackground(new Color(250, 235, 215));
		fileChooser.setBounds(48, 90, 611, 397);
		panel_main.add(fileChooser);
		
		JTextArea txtrchooseAFile = new JTextArea();
		txtrchooseAFile.setBackground(new Color(255, 222, 173));
		txtrchooseAFile.setTabSize(10);
		txtrchooseAFile.setBorder(new CompoundBorder(new LineBorder(new Color(255, 235, 205), 2, true), new LineBorder(new Color(255, 228, 181), 3, true)));
		txtrchooseAFile.setLineWrap(true);
		txtrchooseAFile.setFont(new Font("SansSerif", Font.BOLD, 23));
		txtrchooseAFile.setText("Choose a file, then select the process you want to run.");
		txtrchooseAFile.setBounds(139, 22, 621, 49);
		panel_main.add(txtrchooseAFile);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 92, 92));
		frame.getContentPane().add(panel, "name_67730042797845");
		panel.setLayout(null);
		panel.setVisible(false);
		
		JTextArea textresult = new JTextArea();
		textresult.setBackground(new Color(255, 245, 238));
		textresult.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 239, 213), new Color(255, 222, 173)), new LineBorder(new Color(255, 248, 220), 4, true)));
		textresult.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textresult.setBounds(40, 99, 828, 305);
		panel.add(textresult);
		
		JTextArea resulttitle = new JTextArea();
		resulttitle.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 248, 220), new Color(255, 222, 173)), new LineBorder(new Color(255, 239, 213))));
		resulttitle.setAlignmentX(Component.RIGHT_ALIGNMENT);
		resulttitle.setBackground(new Color(255, 222, 173));
		resulttitle.setFont(new Font("SansSerif", Font.BOLD, 36));
		resulttitle.setText("Results");
		resulttitle.setBounds(389, 32, 139, 56);
		panel.add(resulttitle);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(255, 222, 173));
		btnBack.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel_main.setVisible(true);
			}
		});
		btnBack.setBounds(402, 440, 101, 35);
		panel.add(btnBack);
		
		
		JButton FileScan = new JButton("File Scan");
		FileScan.setBackground(new Color(255, 222, 173));
		FileScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String m = parseString(FileCheck.rawAnalysis(fileChooser.getSelectedFile().getAbsolutePath(),0));
				textresult.setText(m);
				panel.add(textresult);
				panel_main.setVisible(false);
				panel.setVisible(true);
			}
		});
		FileScan.setBounds(705, 176, 142, 49);
		panel_main.add(FileScan);
		
		JButton SongScan = new JButton("Song Scan");
		SongScan.setBackground(new Color(255, 222, 173));
		SongScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String m = parseString(FileCheck.rawAnalysis(fileChooser.getSelectedFile().getAbsolutePath(),1));
				textresult.setText(m);
				panel.add(textresult);
				panel_main.setVisible(false);
				panel.setVisible(true);
			}
		});
		SongScan.setBounds(705, 266, 142, 49);
		panel_main.add(SongScan);
		
		JButton both = new JButton("File AND Scan");
		both.setBackground(new Color(255, 222, 173));
		both.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String m = parseString(FileCheck.rawAnalysis(fileChooser.getSelectedFile().getAbsolutePath(),2));
				textresult.setText(m);
				panel.add(textresult);
				panel_main.setVisible(false);
				panel.setVisible(true);
			}
		});
		both.setBounds(705, 354, 142, 49);
		panel_main.add(both);
	}
	
	private String parseString(String []s) {
		String x = "";
		for (int i = 0; i < s.length; i++) {
			x = x + "\n" + s[i];
		}
		return x;
	}
	 
}
