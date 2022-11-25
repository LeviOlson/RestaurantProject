package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import Restaurant.Restaurant;
import Restaurant.RestaurantUtil;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField tfBurgerBatch;
	private JTextField tfBurgerCook;
	private JTextField tfDrinkBatch;
	private JTextField tfDrinkCook;
	private JTextField tfFryCook;
	private JTextField tfFryBatch;
	private JTextField tfMinOrders;
	private JTextField tfMaxOrders;
	private JTextField tfOrderFreq;
	private JTextField tfOrderTakeTime;
	private JTextField tfDeliverTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 409);
		contentPane = new JPanel();
		contentPane.setToolTipText("Exit");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbBurgBatch = new JLabel("Buger batch size");
		lbBurgBatch.setBounds(0, 5, 131, 25);
		contentPane.add(lbBurgBatch);
		
		JLabel label = new JLabel("");
		label.setBounds(136, 5, 116, 25);
		contentPane.add(label);
		
		tfBurgerBatch = new JTextField();
		tfBurgerBatch.setBounds(257, 5, 121, 25);
		contentPane.add(tfBurgerBatch);
		tfBurgerBatch.setColumns(10);
		
		JLabel lblBurgCook = new JLabel("Burger cook time");
		lblBurgCook.setBounds(0, 35, 131, 25);
		contentPane.add(lblBurgCook);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(136, 35, 116, 25);
		contentPane.add(label_1);
		
		tfBurgerCook = new JTextField();
		tfBurgerCook.setBounds(257, 35, 121, 25);
		tfBurgerCook.setColumns(10);
		contentPane.add(tfBurgerCook);
		
		JLabel lblDrinkBatch = new JLabel("Drink batch size");
		lblDrinkBatch.setBounds(0, 65, 131, 25);
		contentPane.add(lblDrinkBatch);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(136, 65, 116, 25);
		contentPane.add(label_2);
		
		tfDrinkBatch = new JTextField();
		tfDrinkBatch.setBounds(257, 65, 121, 25);
		tfDrinkBatch.setColumns(10);
		contentPane.add(tfDrinkBatch);
		
		JLabel lblDrinkPrepTime = new JLabel("Drink prep time");
		lblDrinkPrepTime.setBounds(0, 95, 131, 25);
		contentPane.add(lblDrinkPrepTime);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(136, 95, 116, 25);
		contentPane.add(label_3);
		
		tfDrinkCook = new JTextField();
		tfDrinkCook.setBounds(257, 95, 121, 25);
		tfDrinkCook.setColumns(10);
		contentPane.add(tfDrinkCook);
		
		JLabel lblFryCookTime = new JLabel("Fry cook time");
		lblFryCookTime.setBounds(0, 125, 131, 25);
		contentPane.add(lblFryCookTime);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(136, 125, 116, 25);
		contentPane.add(label_4);
		
		tfFryCook = new JTextField();
		tfFryCook.setBounds(257, 125, 121, 25);
		tfFryCook.setColumns(10);
		contentPane.add(tfFryCook);
		
		JLabel lblFryBatchSize = new JLabel("Fry batch size");
		lblFryBatchSize.setBounds(0, 155, 131, 25);
		contentPane.add(lblFryBatchSize);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(136, 155, 116, 25);
		contentPane.add(label_5);
		
		tfFryBatch = new JTextField();
		tfFryBatch.setBounds(257, 155, 121, 25);
		tfFryBatch.setColumns(10);
		contentPane.add(tfFryBatch);
		
		JLabel lblMinOrderSpawn = new JLabel("Minimum order spawn");
		lblMinOrderSpawn.setBounds(0, 185, 131, 25);
		contentPane.add(lblMinOrderSpawn);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(136, 185, 116, 25);
		contentPane.add(label_6);
		
		tfMinOrders = new JTextField();
		tfMinOrders.setBounds(257, 185, 121, 25);
		tfMinOrders.setColumns(10);
		contentPane.add(tfMinOrders);
		
		JLabel lblMaxOrderSpawn = new JLabel("Maximum order spawn size");
		lblMaxOrderSpawn.setBounds(0, 215, 164, 25);
		contentPane.add(lblMaxOrderSpawn);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(136, 215, 116, 25);
		contentPane.add(label_7);
		
		tfMaxOrders = new JTextField();
		tfMaxOrders.setBounds(257, 215, 121, 25);
		tfMaxOrders.setColumns(10);
		contentPane.add(tfMaxOrders);
		
		JLabel lblOrderFreq = new JLabel("Order spawn frequency");
		lblOrderFreq.setBounds(0, 245, 164, 25);
		contentPane.add(lblOrderFreq);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(136, 245, 116, 25);
		contentPane.add(label_8);
		
		tfOrderFreq = new JTextField();
		tfOrderFreq.setBounds(257, 245, 121, 25);
		tfOrderFreq.setColumns(10);
		contentPane.add(tfOrderFreq);
		
		JLabel lblTakingTime = new JLabel("Order taking time");
		lblTakingTime.setBounds(0, 275, 131, 25);
		contentPane.add(lblTakingTime);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(136, 275, 116, 25);
		contentPane.add(label_9);
		
		tfOrderTakeTime = new JTextField();
		tfOrderTakeTime.setBounds(257, 275, 121, 25);
		tfOrderTakeTime.setColumns(10);
		contentPane.add(tfOrderTakeTime);
		
		JLabel lblDeliverTime = new JLabel("Order Delivery Time");
		lblDeliverTime.setBounds(0, 305, 131, 25);
		contentPane.add(lblDeliverTime);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(136, 305, 116, 25);
		contentPane.add(label_10);
		
		tfDeliverTime = new JTextField();
		tfDeliverTime.setBounds(257, 305, 121, 25);
		tfDeliverTime.setColumns(10);
		contentPane.add(tfDeliverTime);
		
		JButton btnGoCustom = new JButton("Use custom");
		btnGoCustom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
				SimulationWindow simWindow = new SimulationWindow(new Restaurant((Integer.valueOf(tfBurgerCook.getText())), Integer.valueOf(tfFryCook.getText()), Integer.valueOf(tfDrinkCook.getText()), Integer.valueOf(tfOrderTakeTime.getText()),
						Integer.valueOf(tfDeliverTime.getText()), Integer.valueOf(tfBurgerBatch.getText()), Integer.valueOf(tfFryBatch.getText()), Integer.valueOf(tfDrinkBatch.getText()), Integer.valueOf(tfOrderFreq.getText()), 
						Integer.valueOf(tfMinOrders.getText()), Integer.valueOf(tfMaxOrders.getText())));
				simWindow.setVisible(true);
				}
				catch (Exception ex) {
					
				}
			}
		});
		btnGoCustom.setBounds(0, 335, 131, 30);
		contentPane.add(btnGoCustom);
		
		JButton btnExit = new JButton("exit");
		btnExit.setBounds(257, 335, 121, 30);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnGoDefault = new JButton("Use default");
		btnGoDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimulationWindow simWindow = new SimulationWindow(RestaurantUtil.defaultRestuarant());
				simWindow.setVisible(true);
			}
		});
		btnGoDefault.setBounds(136, 335, 116, 30);
		contentPane.add(btnGoDefault);
		contentPane.add(btnExit);
	}
}
