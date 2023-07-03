package Game;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;


public class Main {
	private JFrame frame;
	private JPanel panel;
	private JLabel label, label2 ;
	private JSeparator line1, line2,line3, line4;
	private JButton button1,button2,button3,button4,button5,button6,button7,button8,button9, reset;
	private int x = 1;
	private String player1 = "X", player2 = "O";
	private final Font DEFAULT = new Font("ARIAL BLACK", Font.BOLD, 48);
	private ImageIcon icon;
	
	private void initGui() {
		initElements();
		configureFrame();
		configurePanel();
		addElements();
		configElements();
		actionButton(button1);
		actionButton(button2);
		actionButton(button3);
		actionButton(button4);
		actionButton(button5);
		actionButton(button6);
		actionButton(button7);
		actionButton(button8);
		actionButton(button9);
	
	}
	
	private void initElements() {
		frame = new JFrame("Tic-Tac-Toe");
		panel = new JPanel();
		label = new JLabel();
		label2 = new JLabel();
		line1 = new JSeparator();
		line2 = new JSeparator();
		line3 = new JSeparator();
		line4 = new JSeparator();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		button6 = new JButton();
		button7 = new JButton();
		button8 = new JButton();
		button9 = new JButton();
		reset = new JButton();
		icon = new ImageIcon("C:/Users/ti2/Desktop/Tic-Tac-Toe V2/Icons/X icon.png");
	}
	
	private void configureFrame(){
		frame.setSize(600,420);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(null);	
		frame.setIconImage(icon.getImage());
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
	}
	
	private void configurePanel() {
		panel.setBounds(10,10,400,350);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	private void addElements() {
		frame.add(panel);
		frame.add(label);
		frame.add(label2);
		frame.add(reset);
		
		panel.add(line1);
		panel.add(line2);
		panel.add(line3);
		panel.add(line4);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
	}
	
	private void configElements() {
		label.setBounds(435, 170, 140, 210);
		label.setText(player2);
		label.setFont(new Font("Calibri", Font.BOLD, 200));
		label.setForeground(Color.BLACK);

		
		label2.setBounds(450, 90, 100, 50);
		label2.setText("PLAYER:");
		label2.setFont(new Font("Calibri", Font.BOLD, 28));
		
		line1.setBounds(0,117,400,1);
		line2.setBounds(0,233,400,1);
		
		line3.setBounds(133,0,1,350);
		line3.setOrientation(SwingConstants.VERTICAL);
		line4.setBounds(266,0,1,350);
		line4.setOrientation(SwingConstants.VERTICAL);
		
		button1.setBounds(15, 10, 100, 100);
		button2.setBounds(150, 10, 100, 100);
		button3.setBounds(285, 10, 100, 100);
		button4.setBounds(15, 125, 100, 100);
		button5.setBounds(150, 125, 100, 100);
		button6.setBounds(285, 125, 100, 100);
		button7.setBounds(15, 240, 100, 100);
		button8.setBounds(150, 240, 100, 100);
		button9.setBounds(285, 240, 100, 100);
		
		button1.setFont(DEFAULT);
		button2.setFont(DEFAULT);
		button3.setFont(DEFAULT);
		button4.setFont(DEFAULT);
		button5.setFont(DEFAULT);
		button6.setFont(DEFAULT);
		button7.setFont(DEFAULT);
		button8.setFont(DEFAULT);
		button9.setFont(DEFAULT);
		
		button1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button9.setBorder(BorderFactory.createLineBorder(Color.BLACK));;
		
		textButtons();
		reset.setBounds(450, 10, 100, 40);
		reset.setText("Restart");	
		reset.setBackground(Color.WHITE);
		reset.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
	}
	
	private void actionButton(JButton button) {
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textButtons();
				statusButtons(true);
				label.setText(player2);
				x = 1;	
			}	
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(x%2 == 0 ) {
					label.setText(player2);
					button.setText(player1);
					regras(player1);
				}
				else if(x % 2 != 0 ) {
					label.setText(player1);
					button.setText(player2);
					regras(player2);
				}
				button.setEnabled(false);
				x ++;
			}
		});
	}
	
	public void regras(String player) {
		if(button1.getText().equals(player) && button2.getText().equals(player) && button3.getText().equals(player) ||
				button4.getText().equals(player) && button5.getText().equals(player) && button6.getText().equals(player) ||
				button7.getText().equals(player) && button8.getText().equals(player) && button9.getText().equals(player)){
			JOptionPane.showMessageDialog(null,player + " WIN!!","WIN", JOptionPane.INFORMATION_MESSAGE);
			statusButtons(false);
		}
		else if(button1.getText().equals(player) && button5.getText().equals(player) && button9.getText().equals(player) ||
				button3.getText().equals(player) && button5.getText().equals(player) && button7.getText().equals(player) ) {
			JOptionPane.showMessageDialog(null,player + " WIN!!","WIN", JOptionPane.INFORMATION_MESSAGE);
			statusButtons(false);
		}
		else if(button1.getText().equals(player) && button4.getText().equals(player) && button7.getText().equals(player) ||
				button2.getText().equals(player) && button5.getText().equals(player) && button8.getText().equals(player) ||
				button3.getText().equals(player) && button6.getText().equals(player) && button9.getText().equals(player)) {
			JOptionPane.showMessageDialog(null,player + " WIN!!","WIN", JOptionPane.INFORMATION_MESSAGE);
			statusButtons(false);
		}
		else if(button1.getText()!= "" && button2.getText()!= "" && button3.getText()!= "" &&
				button4.getText()!= "" && button5.getText()!= "" && button5.getText()!= "" &&
				button7.getText()!= "" && button8.getText()!= "" && button9.getText()!= "") {
			JOptionPane.showMessageDialog(null,"TIC-TAC-TOE","TIC-TAC-TOE", JOptionPane.INFORMATION_MESSAGE);
			statusButtons(false);
		}
	}
	
	private void textButtons() {
		button1.setText("");
		button2.setText("");
		button3.setText("");
		button4.setText("");
		button5.setText("");
		button6.setText("");
		button7.setText("");
		button8.setText("");
		button9.setText("");
	}
	
	public void statusButtons(boolean status) {
		button1.setEnabled(status);
		button2.setEnabled(status);
		button3.setEnabled(status);
		button4.setEnabled(status);
		button5.setEnabled(status);
		button6.setEnabled(status);
		button7.setEnabled(status);
		button8.setEnabled(status);
		button9.setEnabled(status);
	}
	public static void main(String [] args) {
		Main gui = new Main();
		gui.initGui();
	}

}
