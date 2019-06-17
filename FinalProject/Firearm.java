import java.util.ArrayList;
import javafx.scene.image.Image;

public class Firearm {
	//attributes of a Firearm
	public Image image;
	public String brand;
	public String model;
	public String serialNum;
	public String caliber;
	public ArrayList<String> attachments;
	public double estValue;
	public String notes;
	
	//zero arg constructor
	public Firearm() {
		image = null;
		brand = null;
		model = null;
		serialNum = null;
		caliber = null;
		attachments = new ArrayList<String>();
		estValue = 0;
		notes = "";
	}
	
	//constructor
	public Firearm(Image image, String brand, String model, String serialNum, String caliber,
			ArrayList<String> attachments, double estValue, String notes) {

		this.image = image;
		this.brand = brand;
		this.model = model;
		this.serialNum = serialNum;
		this.caliber = caliber;
		this.attachments = attachments;
		this.estValue = estValue;
		this.notes = notes;
	}
	
	//getters
	public Image getImage() {
		return image;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public String getCaliber() {
		return caliber;
	}
	public ArrayList<String> getAttachments() {
		return attachments;
	}
	public double getEstValue() {
		return estValue;
	}
	public String getNotes() {
		return notes;
	}
	
	//setters
	public void setImage(Image image) {
		this.image = image;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public void setCaliber(String caliber) {
		this.caliber = caliber;
	}
	public void setAttachments(ArrayList<String> attachments) {
		this.attachments = attachments;
	}
	public void setEstValue(double estValue) {
		this.estValue = estValue;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
