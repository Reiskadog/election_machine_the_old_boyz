package data;

public class ListedData {
	private int id;
	private String data;
	private String fName;
	private String lName;

	/**
	 *	A constructor with 2 values.
	 * 
	 *	@param id Id of the question.
	 *	@param data Data in the question.
	 */
	public ListedData(String id, String data) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.data=data;
	}
	
	/**
	 *	A constructor with 3 values.
	 * 
	 *	@param id Index of list
	 *	@param fName First name of electee
	 *	@param lName Last name of electee
	 */
	public ListedData(String id, String fName, String lName) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.fName=fName;
		this.lName=lName;
	}

	/**
	 *	An empty constructor.
	 */
	public ListedData() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *	Gets the first name of electee.
	 * 
	 *	@return Returns fName.
	 */
	public String getfName() {
		return fName;
	}

	/**
	 *	Sets the first name of electee.
	 * 
	 *	@param fName Sets fName.
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 *	Return last name of electee.
	 * 
	 *	@return Returns last name.
	 */
	public String getlName() {
		return lName;
	}

	/**
	 *	Sets the electees last name.
	 * 
	 *	@param lName Sets last name.
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	/**
	 *	Return the id of an entity.
	 * 
	 *	@return getId Returns entity id.
	 */
	public int getId() {
		return id;
	}
	/**
	 *	Sets id of an entity.
	 * 
	 *	@param id Sets entity id.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 *	Sets entity id.
	 * 
	 *	@param id Sets string version of id.
	 */
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	/**
	 *	Returns questions data.
	 * 
	 *	@return Returns string version of data.
	 */
	public String getData() {
		return data;
	}
	/**
	 *	Sets the question data.
	 * 
	 *	@param data Sets string version of data.
	 */
	public void setData(String data) {
		this.data = data;
	}

}
