package robotclass;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;

public class RobotGUI {

	private JFrame frame;
	private DefaultListModel<Robot> listModel;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RobotGUI window = new RobotGUI();
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
	public RobotGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Robot GUI");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JList list = new JList();
		list.setBounds(182, 30, 217, 182);
		frame.getContentPane().add(list);
		
		
		JButton btnCreateRobot = new JButton("Create Robot");
		btnCreateRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = list.getSelectedIndex();
				String name = getValue("Enter a name for the Robot", "Robot Name");
				int[] coordinates = new int[2];
				coordinates[0] = (int)Double.parseDouble(getValue("Enter a starting X-coordinate", "X-coord"));
				coordinates[1] = (int)Double.parseDouble(getValue("Enter a starting Y-coordinate", "Y-coord"));
				int speed = (int)Double.parseDouble(getValue("Enter a speed", "Speed"));
				String direction = getValue("Enter a starting Direction (N S E W)", "Direction");
				char cDirection = direction.charAt(0);
				Robot r = new Robot(name, coordinates, speed, cDirection);
				listModel.add(listModel.size(), r);
			}
		});
		btnCreateRobot.setBounds(30, 30, 102, 23);
		frame.getContentPane().add(btnCreateRobot);
		
		
		JButton btnMoveRobot = new JButton("Move Robot");
		btnMoveRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selected = list.getSelectedIndex();
				listModel.get(selected).move();
			}
		});
		btnMoveRobot.setBounds(30, 84, 102, 23);
		frame.getContentPane().add(btnMoveRobot);
		
		
		JButton btnRotateRobot = new JButton("Rotate Robot");
		btnRotateRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = list.getSelectedIndex();
				String direction = getValue("Enter a direction to rotate 90 degrees (left right, N to unstick)", "Turn");
				listModel.get(selected).rotate(direction);
				if (direction == "N")
					listModel.get(selected).setDirection('N');
			}
		});
		btnRotateRobot.setBounds(30, 138, 102, 23);
		frame.getContentPane().add(btnRotateRobot);
		
		
		JButton btnComputeDistance = new JButton("Compute Distance");
		btnComputeDistance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComputeDistance.setBounds(30, 189, 102, 23);
		frame.getContentPane().add(btnComputeDistance);
	}
	
	private String getValue(String prompt, String title) {
		String s = (String)JOptionPane.showInputDialog(
				frame,
				prompt,
				title, JOptionPane.PLAIN_MESSAGE,
				null,
				null,
				"");
		return s;
	}
}
