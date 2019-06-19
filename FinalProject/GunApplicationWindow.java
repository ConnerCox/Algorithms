/*
 * Author: Conner Cox
 * Date: June 19, 2019
 * 
 * Description: This application allows a user to add the information and image of a firearm, 
 * and then it stores and sorts it. This allows for easy record keeping of firearms.
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JList;

public class GunApplicationWindow {

	private JFrame frame;
	private JTextField tfBrand;
	private JTextField tfModel;
	private JTextField tfSerialNum;
	private JTextField tfEstValue;
	private JTextField tfCaliber;
	private JTextField tfAttachments;
	private JTabbedPane tabbedPane;
	private JPanel inputPanel;
	private JLabel lblTop;
	private JButton btnEnterGun;
	private JButton btnUploadImage;
	private JLabel lblImageSelected;
	private JLabel lblStatus;
	private JPanel searchPanel;
	private JButton btnBrand;
	private JButton btnRecent;
	private JButton btnCaliber;
	private JButton btnValue;
	private JLabel lblNotes;
	private JTextField tfNotes;
	private JList searchList;

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
		//TODO: all things that need to persist
		BufferedImage image = null;

		

		
		//initialize gun collection
		
		//Entire collection (also recent collection)
		ArrayList<Firearm> gunCollection = new ArrayList<Firearm>();
		//A different list for each sortable collection
		ArrayList<Firearm> gunSortedModel = new ArrayList<Firearm>(gunCollection);
		ArrayList<Firearm> gunSortedBrand = new ArrayList<Firearm>(gunCollection);
		ArrayList<Firearm> gunSortedCaliber = new ArrayList<Firearm>(gunCollection);
		ArrayList<Firearm> gunSortedSerial = new ArrayList<Firearm>(gunCollection);
		ArrayList<Firearm> gunSortedValue = new ArrayList<Firearm>(gunCollection);
		gunSortedModel.sort(new FirearmComparatorByModel());
		gunSortedBrand.sort(new FirearmComparatorByBrand());
		gunSortedCaliber.sort(new FirearmComparatorByCaliber());
		gunSortedSerial.sort(new FirearmComparatorBySerial());
		gunSortedValue.sort(new FirearmComparatorByValue());

		
		//Frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{40, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		//Tabbed Pane for all selection panes
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		frame.getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		//Search Panel Scroll Pane (Display Guns here)
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 63, 417, 313);
		searchPanel.add(scrollPane);
		
		//Input panel tab
		inputPanel = new JPanel();
		tabbedPane.addTab("Input Guns", null, inputPanel, null);
		inputPanel.setLayout(null);
		//Labels for input panel
		lblTop = new JLabel("Enter info about the gun you with to add.");
		lblTop.setBounds(85, 10, 259, 16);
		inputPanel.add(lblTop);
		
		JLabel lblBrand = new JLabel("Enter brand: ");
		lblBrand.setBounds(115, 41, 80, 16);
		inputPanel.add(lblBrand);
		
		JLabel lblModel = new JLabel("Enter model: ");
		lblModel.setBounds(112, 72, 83, 16);
		inputPanel.add(lblModel);

		JLabel lblSerialNum = new JLabel("Serial number: ");
		lblSerialNum.setBounds(101, 103, 94, 16);
		inputPanel.add(lblSerialNum);

		JLabel lblCaliber = new JLabel("Enter the caliber: ");
		lblCaliber.setBounds(85, 134, 110, 16);
		inputPanel.add(lblCaliber);

		JLabel lblEstValue = new JLabel("Estimated value: ");
		lblEstValue.setBounds(88, 162, 107, 16);
		inputPanel.add(lblEstValue);
				
		JTextArea lblAttachments = new JTextArea("Enter attachments\n(seperated by a comma):");
		lblAttachments.setBounds(42, 193, 153, 32);
		lblAttachments.setBackground(UIManager.getColor("Button.background"));
		lblAttachments.setEditable(false);
		inputPanel.add(lblAttachments);
		
		lblNotes = new JLabel("Notes:");
		lblNotes.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNotes.setBounds(88, 237, 107, 16);
		inputPanel.add(lblNotes);
		
		lblImageSelected = new JLabel("no image selected");
		lblImageSelected.setBounds(215, 274, 200, 16);
		inputPanel.add(lblImageSelected);

		lblStatus = new JLabel("Awaiting input...");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(10, 334, 145, 13);
		lblStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		inputPanel.add(lblStatus);
		
		//Input panel text Fields
		tfBrand = new JTextField();
		tfBrand.setBounds(215, 38, 200, 26);
		inputPanel.add(tfBrand);
		tfBrand.setColumns(10);

		tfModel = new JTextField();
		tfModel.setBounds(215, 69, 200, 26);
		inputPanel.add(tfModel);
		tfModel.setColumns(10);

		tfSerialNum = new JTextField();
		tfSerialNum.setBounds(215, 100, 200, 26);
		inputPanel.add(tfSerialNum);
		tfSerialNum.setColumns(10);

		tfCaliber = new JTextField();
		tfCaliber.setBounds(215, 131, 200, 26);
		inputPanel.add(tfCaliber);
		tfCaliber.setColumns(10);

		tfEstValue = new JTextField();
		tfEstValue.setBounds(215, 165, 200, 26);
		inputPanel.add(tfEstValue);
		tfEstValue.setColumns(10);

		tfAttachments = new JTextField();
		tfAttachments.setBounds(215, 199, 200, 26);
		inputPanel.add(tfAttachments);
		tfAttachments.setColumns(10);
		
		tfNotes = new JTextField();
		tfNotes.setColumns(10);
		tfNotes.setBounds(215, 236, 200, 26);
		inputPanel.add(tfNotes);
		
		//Input Pane Buttons
		btnUploadImage = new JButton("Upload Image");
		btnUploadImage.setBounds(67, 269, 130, 29);
		inputPanel.add(btnUploadImage);
		btnUploadImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//TODO: choose image file
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPG & PNG Images", "jpg", "png", "jpeg");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(chooser);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					File imageFile = chooser.getSelectedFile();
					//try to make the selected file into a BufferedImage
					try {
						lblImageSelected.setText(imageFile.getName());
						BufferedImage img = ImageIO.read(imageFile);
					} catch (IOException e2) {
						lblImageSelected.setText("Failed to read image");
					}
				}
			}
		});
		
		btnEnterGun = new JButton("     Enter Gun     ");
		btnEnterGun.setBounds(10, 347, 145, 29);
		btnEnterGun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					//TODO: Enter Gun
					//if there is something written in brand and value slots  
					//(value has to have something in it) record and store new firearm
					if(!tfBrand.getText().equals("") && !tfEstValue.getText().equals("")) {						
						//Take everything from the fields
						String brand = tfBrand.getText().trim();
						String model = tfModel.getText().trim();
						String serialNum = tfSerialNum.getText().trim();
						String caliber = tfCaliber.getText().trim();
						String[] att = tfAttachments.getText().split(",");
						ArrayList<String> attachments = new ArrayList<String> (Arrays.asList(att));
						attachments.forEach(each -> each.trim());
						String toParse = tfEstValue.getText().replace('$', ' ').trim();
						double estValue = Double.parseDouble(toParse);
						String notes = tfNotes.getText().trim();
						
						//add gun to records
						Firearm gunToAdd = new Firearm(image, brand, model, serialNum, caliber, attachments, estValue, notes);
						gunCollection.add(gunToAdd);
						
						//clear text fields
						tfBrand.setText("");
						tfModel.setText("");
						tfSerialNum.setText("");
						tfCaliber.setText("");
						tfEstValue.setText("");

						
						//Update the user that the gun was added successfully
						new Thread(()-> {
							try {
								lblStatus.setText("Added Successfully!");
								System.out.println("Made it here!");
								Thread.sleep(4000);
								lblStatus.setText("Awaiting input...");
							} catch (InterruptedException e1) {
								//Catch nothing, Thread.sleep shouldn't throw
								e1.printStackTrace();
							}
							
						}).start();
						
					}
					//else update the user that they need to fill in the fields
					else {
						new Thread(()-> {
							try {
								lblStatus.setText("Please fill in all the fields");
								Thread.sleep(4000);
								lblStatus.setText("Awaiting input...");
							} catch (InterruptedException e1) {
								//Catch nothing, Thread.sleep shouldn't throw
								e1.printStackTrace();
							}
						}).start();
					}
				} catch (Exception e2) {
					//This catches when new gun couldn't be created.
					e2.printStackTrace();
				}
			}
		});
		inputPanel.add(btnEnterGun);
		
		
		//Search Panel tab
		searchPanel = new JPanel();
		tabbedPane.addTab("Search Guns", null, searchPanel, null);
		searchPanel.setLayout(null);
		
		
		JLabel lblSearchBy = new JLabel("Sort by…");
		lblSearchBy.setBounds(184, 6, 57, 16);
		searchPanel.add(lblSearchBy);
		
		//Search Panel Buttons
		btnBrand = new JButton("Brand");
		btnBrand.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: Add appropriate list to scroll pane
				searchList = new JList();
				scrollPane.setViewportView(searchList);

			}
		});
		btnBrand.setBounds(125, 34, 75, 29);
		searchPanel.add(btnBrand);
		
		btnRecent = new JButton("Recent");
		btnRecent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: Add appropriate list to scroll pane
			}
		});
		btnRecent.setBounds(25, 34, 75, 29);
		searchPanel.add(btnRecent);
		
		btnCaliber = new JButton("Caliber");
		btnCaliber.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: Add appropriate list to scroll pane
			}
		});
		btnCaliber.setBounds(225, 34, 75, 29);
		searchPanel.add(btnCaliber);
		
		btnValue = new JButton("Value");
		btnValue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: Add appropriate list to scroll pane
			}
		});
		btnValue.setBounds(325, 34, 75, 29);
		searchPanel.add(btnValue);
		
		JButton btnModel = new JButton("Model");
		btnModel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: Add appropriate list to scroll pane
			}
		});
		btnModel.setBounds(75, 1, 75, 29);
		searchPanel.add(btnModel);
		
		JButton btnSerialNumber = new JButton("Serial #");
		btnSerialNumber.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: Add appropriate list to scroll pane
			}
		});
		btnSerialNumber.setBounds(275, 1, 75, 29);
		searchPanel.add(btnSerialNumber);
		
		//Maybe Ill delete this
		JPanel deletionPanel = new JPanel();
		tabbedPane.addTab("Delete a Gun", null, deletionPanel, null);
	}
}
