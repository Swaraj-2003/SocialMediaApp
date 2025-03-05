package basemodelclasses;

public class baseaccount {
private String UserName;
private String Password;

public baseaccount(String UserName,String Password)
	{
	this.UserName=UserName;
	this.Password=Password;
	}


public String getUserName()
	{
	return UserName;
	}

public boolean checkpassword(String Inputpass)
	{
	return Password.equals(Inputpass);	
	}

}
