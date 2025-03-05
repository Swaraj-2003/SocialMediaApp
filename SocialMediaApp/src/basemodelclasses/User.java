package basemodelclasses;
import java.util.*;

public class User extends baseaccount {
private List<Post>posts;
private List<String>message;

public User(String UserName,String Password)
    {
	super(UserName,Password);
	this.posts=new ArrayList<>();
	this.message=new ArrayList<>();
	
	}

public void createPost(String content) {
    posts.add(new Post(this, content));
    System.out.println("✅ Post created successfully!");
}

public void ReceiveMessage(String Message)
{
	message.add(Message);
}

public void DisplayMessage()
{
	System.out.println("\n📩 Inbox Messages:");
	for(String msg:message)
	{
		System.out.println(msg);
	}
}

public List<Post>posts()
{
	return posts;
}

}
