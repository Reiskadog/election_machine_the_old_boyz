package data;

public class ListedData {
	private int id;
	private String data;
	private String fName;
	private String lName;

	
	public ListedData(String id, String data) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.data=data;
	}
	
	public ListedData(String id, String fName, String lName) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.fName=fName;
		this.lName=lName;
	}

	

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public ListedData() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

}
