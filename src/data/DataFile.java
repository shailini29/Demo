package data;

import utilities.Xls_Reader;

public class DataFile {
	
	Xls_Reader d = new Xls_Reader("C:\\testing\\ShailiTest.xlsx");
	
	// Login
	public String correctEmail = d.getCellData("Data1", "CorrectEmail", 2);
	public String wrongEmail = d.getCellData("Data1", "WrongEmail", 2);
	public String wrongPassword = d.getCellData("Data1", "Password", 2);
	public String expEmailError = d.getCellData("Data1", "EmailError", 2);
	public String expPasswordError = d.getCellData("Data1", "PasswordError", 2);
	
	// Home
	
	// Footer
	
	// addtoCart
	
	// logout

}
