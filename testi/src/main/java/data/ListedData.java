package data;

public class ListedData {
	private int id;
	private String data;
	public ListedData(String id, String data) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.data=data;
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
