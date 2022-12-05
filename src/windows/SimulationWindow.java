package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Restaurant.Driver;
import Restaurant.Restaurant;
import Restaurant.RestaurantStatus;
import Restaurant.RestaurantUtil;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Window to simulate a restaurant with input and output
 * @author Levi Olson
 * @version 1.0
 */
public class SimulationWindow extends JFrame {

	private JPanel contentPane;
	private Restaurant restaurant;
	
	private JLabel lblAssembled;
	private JLabel lblAssembling;
	private JLabel lblHighestWait;
	private JLabel lblInLine;
	private JLabel lblTotalServed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimulationWindow frame = new SimulationWindow(RestaurantUtil.defaultRestuarant());
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
	public SimulationWindow(Restaurant restaurant) {
		setTitle("Simulation");
		this.restaurant = restaurant;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		RestaurantStatus status = restaurant.getStatus();
		lblAssembled = new JLabel("assembled: " + status.getAssembled());
		lblAssembled.setBounds(10, 11, 416, 14);
		contentPane.add(lblAssembled);
		
		lblAssembling = new JLabel("assembling: " + status.getAssembling());
		lblAssembling.setBounds(10, 36, 416, 14);
		contentPane.add(lblAssembling);
		
		lblHighestWait = new JLabel("Highest wait: " + status.getHighestWait());
		lblHighestWait.setBounds(10, 61, 416, 14);
		contentPane.add(lblHighestWait);
		
		lblInLine = new JLabel("In line: " + status.getInline());
		lblInLine.setBounds(10, 86, 416, 14);
		contentPane.add(lblInLine);
		
		lblTotalServed = new JLabel("Total served: " + status.getTotalServed());
		lblTotalServed.setBounds(10, 111, 416, 14);
		contentPane.add(lblTotalServed);
		
		//tick button will cause the simulation to advance by 1 tick and then update the labels to display the up to date status of the restaurant
		JButton btnTick = new JButton("Tick");
		btnTick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restaurant.tick();
				updateLabels();
			}
		});
		btnTick.setBounds(10, 240, 89, 23);
		contentPane.add(btnTick);
		
		//exit button will close the program
		JButton btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(347, 240, 89, 23);
		contentPane.add(btnExit);
	}
	
	/**
	 * Updates all the labels to display the up to date status of the restaurant
	 */
	private void updateLabels() {
		RestaurantStatus status = restaurant.getStatus();
		lblAssembled.setText("assembled: " + status.getAssembled());
		lblAssembling.setText("assembling: " + status.getAssembling());
		lblHighestWait.setText("Highest wait: " + status.getHighestWait());
		lblInLine.setText("In line: " + status.getInline());
		lblTotalServed.setText("Total served: " + status.getTotalServed());
	}
}
