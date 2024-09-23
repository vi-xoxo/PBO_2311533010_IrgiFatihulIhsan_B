package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UserRepo;
import model.User;
import table.TableUser;

import java.util.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class UserFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JButton btnCancel;
	private JTable tableUser;
	
	/**
	 * Launch the application.
	 */
	public void reset() {
		txtName.setText("");
		txtUsername.setText("");
		txtPassword.setText("");
		
	}
	
	UserRepo usr = new UserRepo();
	List<User> ls;
	public String id;
	
	
	public void loadTable() {
		ls = usr.show();
		TableUser tu = new TableUser(ls);
		tableUser.setModel(tu);
		tableUser.getTableHeader().setVisible(true);
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		UserFrame frame = new UserFrame();
		frame.setVisible(true);
		frame.loadTable();
	}
	
	
	
	
	/**
	 * Create the frame.
	 */
	public UserFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 809);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(30, 38, 128, 31);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(30, 88, 128, 31);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 140, 128, 31);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblPassword);
		
		txtName = new JTextField();
		txtName.setBounds(124, 43, 544, 34);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(124, 93, 544, 34);
		txtUsername.setColumns(10);
		contentPane.add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(124, 145, 544, 34);
		txtPassword.setColumns(10);
		contentPane.add(txtPassword);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user =  new User();
				user.setNama(txtName.getText());
				user.setUsername(txtUsername.getText());
				user.setPassword(txtPassword.getText());
				usr.save(user);
				reset();
				
			}
		});
		btnSave.setBounds(30, 220, 105, 31);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSave.setBackground(new Color(128, 255, 0));
		btnSave.setForeground(new Color(0, 0, 0));
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.setNama(txtName.getText());
				user.setUsername(txtUsername.getText());
				user.setPassword(txtPassword.getText());
				user.setId(id);
				usr.update(user);
				reset();
				loadTable();
			}
		});
		btnUpdate.setBounds(150, 220, 105, 31);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBackground(new Color(0, 64, 128));
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id != null) {
					usr.delete(id);
					reset();
					loadTable();
				}else {
					JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan di hapus");
				}
			}
		});
		btnDelete.setBounds(448, 220, 105, 31);
		btnDelete.setBackground(new Color(128, 64, 64));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnDelete);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(563, 220, 105, 31);
		btnCancel.setBackground(new Color(255, 255, 0));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 262, 636, 481);
		contentPane.add(scrollPane);
		
		tableUser = new JTable();
		scrollPane.setViewportView(tableUser);
		tableUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = tableUser.getValueAt(tableUser.getSelectedRow(),0).toString();
				txtName.setText(tableUser.getValueAt(tableUser.getSelectedRow(),1).toString());
				txtUsername.setText(tableUser.getValueAt(tableUser.getSelectedRow(),2).toString());
				txtPassword.setText(tableUser.getValueAt(tableUser.getSelectedRow(),3).toString());
			}
		});
	}
}
