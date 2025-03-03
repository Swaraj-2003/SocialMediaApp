package basemodelclasses;
import java.util.*;
public class Post {
		private User user;
		private String Content;
		private List<String> comments;
		
	public Post(User user,String Content)
	{
		this.user=user;
		this.Content=Content;
		this.comments=new ArrayList<>();
	}
	
	public void addComment(String Comment)
	{
		comments.add(Comment);
	}
	
	@Override
	public String toString()
	{
		return "📝 " + user.getUserName() + ": " + Content + "\n  💬 Comments: " + comments;
	}

	
}
