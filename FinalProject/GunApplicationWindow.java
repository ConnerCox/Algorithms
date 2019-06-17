import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GunApplicationWindow {

	private JFrame frame;
	private JTextField tfBrand;
	private JTextField tfModel;
	private JTextField tfSerialNum;
	private JTextField tfAttachments;
	private JTextField tfCaliber;
	private JTextField tfEstValue;
	private JTabbedPane tabbedPane;
	private JPanel inputPanel;
	private JScrollPane scrollableSearchPanel;
	private JLabel lblTop;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GunApplicationWindow window = new GunApplicationWindow();
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
	public GunApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{40, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		frame.getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		inputPanel = new JPanel();
		tabbedPane.addTab("Input Guns", null, inputPanel, null);
		GridBagLayout gbl_inputPanel = new GridBagLayout();
		gbl_inputPanel.columnWidths = new int[]{207, 0, 0};
		gbl_inputPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_inputPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_inputPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		inputPanel.setLayout(gbl_inputPanel);
		
		lblTop = new JLabel("Enter info about the gun you with to add.");
		GridBagConstraints gbc_lblTop = new GridBagConstraints();
		gbc_lblTop.gridwidth = 2;
		gbc_lblTop.insets = new Insets(10, 0, 10, 0);
		gbc_lblTop.gridx = 0;
		gbc_lblTop.gridy = 0;
		inputPanel.add(lblTop, gbc_lblTop);
		
		JLabel lblBrand = new JLabel("Enter brand: ");
		GridBagConstraints gbc_lblBrand = new GridBagConstraints();
		gbc_lblBrand.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrand.gridx = 0;
		gbc_lblBrand.gridy = 1;
		inputPanel.add(lblBrand, gbc_lblBrand);
		
		tfBrand = new JTextField();
		GridBagConstraints gbc_tfBrand = new GridBagConstraints();
		gbc_tfBrand.insets = new Insets(0, 0, 5, 0);
		gbc_tfBrand.gridx = 1;
		gbc_tfBrand.gridy = 1;
		inputPanel.add(tfBrand, gbc_tfBrand);
		tfBrand.setColumns(10);
		
		JLabel lblModel = new JLabel("Enter model: ");
		GridBagConstraints gbc_lblModel = new GridBagConstraints();
		gbc_lblModel.insets = new Insets(0, 0, 5, 5);
		gbc_lblModel.gridx = 0;
		gbc_lblModel.gridy = 2;
		inputPanel.add(lblModel, gbc_lblModel);
		
		tfModel = new JTextField();
		GridBagConstraints gbc_tfModel = new GridBagConstraints();
		gbc_tfModel.insets = new Insets(0, 0, 5, 0);
		gbc_tfModel.gridx = 1;
		gbc_tfModel.gridy = 2;
		inputPanel.add(tfModel, gbc_tfModel);
		tfModel.setColumns(10);
		
		JLabel lblSerialNum = new JLabel("Serial number: ");
		GridBagConstraints gbc_lblSerialNum = new GridBagConstraints();
		gbc_lblSerialNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblSerialNum.gridx = 0;
		gbc_lblSerialNum.gridy = 3;
		inputPanel.add(lblSerialNum, gbc_lblSerialNum);
		
		tfSerialNum = new JTextField();
		GridBagConstraints gbc_tfSerialNum = new GridBagConstraints();
		gbc_tfSerialNum.insets = new Insets(0, 0, 5, 0);
		gbc_tfSerialNum.gridx = 1;
		gbc_tfSerialNum.gridy = 3;
		inputPanel.add(tfSerialNum, gbc_tfSerialNum);
		tfSerialNum.setColumns(10);
		
		JLabel lblCaliber = new JLabel("Enter the caliber: ");
		GridBagConstraints gbc_lblCaliber = new GridBagConstraints();
		gbc_lblCaliber.insets = new Insets(0, 0, 5, 5);
		gbc_lblCaliber.gridx = 0;
		gbc_lblCaliber.gridy = 4;
		inputPanel.add(lblCaliber, gbc_lblCaliber);
		
		tfCaliber = new JTextField();
		GridBagConstraints gbc_tfCaliber = new GridBagConstraints();
		gbc_tfCaliber.insets = new Insets(0, 0, 5, 0);
		gbc_tfCaliber.gridx = 1;
		gbc_tfCaliber.gridy = 4;
		inputPanel.add(tfCaliber, gbc_tfCaliber);
		tfCaliber.setColumns(10);
		
		JTextArea lblAttachments = new JTextArea("Enter attachments\n(seperated by a comma):");
		lblAttachments.setBackground(UIManager.getColor("Button.background"));
		lblAttachments.setEditable(false);
//		lblAttachments.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAttachments = new GridBagConstraints();
		gbc_lblAttachments.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttachments.gridx = 0;
		gbc_lblAttachments.gridy = 5;
		inputPanel.add(lblAttachments, gbc_lblAttachments);
		
		tfAttachments = new JTextField();
		GridBagConstraints gbc_tfAttachments = new GridBagConstraints();
		gbc_tfAttachments.insets = new Insets(0, 0, 5, 0);
		gbc_tfAttachments.gridx = 1;
		gbc_tfAttachments.gridy = 5;
		inputPanel.add(tfAttachments, gbc_tfAttachments);
		tfAttachments.setColumns(10);
		
		JLabel lblEstValue = new JLabel("Estimated value: ");
		GridBagConstraints gbc_lblEstValue = new GridBagConstraints();
		gbc_lblEstValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstValue.gridx = 0;
		gbc_lblEstValue.gridy = 6;
		inputPanel.add(lblEstValue, gbc_lblEstValue);
		
		tfEstValue = new JTextField();
		GridBagConstraints gbc_tfEstValue = new GridBagConstraints();
		gbc_tfEstValue.insets = new Insets(0, 0, 5, 0);
		gbc_tfEstValue.gridx = 1;
		gbc_tfEstValue.gridy = 6;
		inputPanel.add(tfEstValue, gbc_tfEstValue);
		tfEstValue.setColumns(10);
		
		btnNewButton = new JButton("Enter Gun");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Mouse was clicked");
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 7;
		inputPanel.add(btnNewButton, gbc_btnNewButton);
		
		scrollableSearchPanel = new JScrollPane();
		tabbedPane.addTab("Search Guns", null, scrollableSearchPanel, null);
	}

}
