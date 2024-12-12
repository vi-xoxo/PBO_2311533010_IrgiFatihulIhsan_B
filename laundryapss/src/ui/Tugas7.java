package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tugas7 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMasukkan;
	private JTextField textarray;
	JLabel lbldata;
	private int[] dataArray;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tugas7 frame = new Tugas7();
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
	public Tugas7() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textMasukkan = new JTextField();
		textMasukkan.setBounds(36, 46, 187, 35);
		contentPane.add(textMasukkan);
		textMasukkan.setColumns(10);
		
		JLabel lblMasukkanData = new JLabel("Masukkan Data");
		lblMasukkanData.setBounds(36, 27, 126, 14);
		contentPane.add(lblMasukkanData);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputText = textMasukkan.getText();
				String[] inputSplit = inputText.split(",");
				dataArray = new int[inputSplit.length];

				try {
					for (int i = 0; i < inputSplit.length; i++) {
						dataArray[i] = Integer.parseInt(inputSplit[i].trim());
					}
					lbldata.setText("= " + inputText);
				} catch (NumberFormatException ex) {
					lbldata.setText("Error: Masukkan hanya angka yang valid!");
				}
			}
		});
		btnSimpan.setBounds(235, 52, 89, 23);
		contentPane.add(btnSimpan);
		
		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setBounds(46, 92, 126, 14);
		contentPane.add(lblNewLabel);
		
		lbldata = new JLabel("");
		lbldata.setBounds(46, 117, 390, 35);
		contentPane.add(lbldata);
		
		JLabel lblCekArrayKe = new JLabel("cek array ke-");
		lblCekArrayKe.setBounds(36, 173, 126, 14);
		contentPane.add(lblCekArrayKe);
		
		textarray = new JTextField();
		textarray.setColumns(10);
		textarray.setBounds(36, 192, 187, 35);
		contentPane.add(textarray);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textMasukkan == null) {
					lbldata.setText("Error: Data belum dimasukkan!");
					return;
				}

				try {
					int index = Integer.parseInt(textarray.getText().trim());
					int value = dataArray[index - 0];
					lbldata.setText("Hasil: Elemen ke-" + index + " adalah " + value);
				} catch (ArrayIndexOutOfBoundsException ex) {
					lbldata.setText("Error: Indeks di luar batas array!");
				} catch (NumberFormatException ex) {
					lbldata.setText("Error: Masukkan indeks yang valid!");
				}
			}
		});
		btnCheck.setBounds(235, 198, 89, 23);
		contentPane.add(btnCheck);
	}
}