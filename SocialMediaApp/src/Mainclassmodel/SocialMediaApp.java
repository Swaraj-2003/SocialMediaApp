package Mainclassmodel;
import basemodelclasses.*;
import java.util.*;
public class SocialMediaApp {
	private static List<User> users = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
public static void main(String []args)
	{
	 System.out.println("🌍 Welcome to Console Social Media!");
	 User currentUser = loginUser();

     while (true) {
         System.out.println("\n📜 Menu:");
         System.out.println("1️⃣ Create Post");
         System.out.println("2️⃣ View Feed");
         System.out.println("3️⃣ Comment on a Post");
         System.out.println("4️⃣ Send Message");
         System.out.println("5️⃣ View Inbox");
         System.out.println("6️⃣ Exit");
         System.out.print("➡️ Choose an option: ");
         
         int choice = scanner.nextInt();
         scanner.nextLine(); // Consume newline

         switch (choice) {
             case 1:
                 createPost(currentUser);
                 break;
             case 2:
                 viewFeed();
                 break;
             case 3:
                 commentOnPost();
                 break;
             case 4:
                 sendMessage();
                 break;
             case 5:
                 currentUser.DisplayMessage();
                 break;
             case 6:
                 System.out.println("👋 Exiting... Thank you!");
                 return;
             default:
                 System.out.println("❌ Invalid choice! Try again.");
         }
     }
 }
private static User loginUser() {
	System.out.print("👤 Enter your username: ");
    String username = scanner.nextLine();

    
    User existingUser = findUser(username);
    if (existingUser != null) {
        System.out.print("🔒 Enter your password: ");
        String password = scanner.nextLine();

     
        if (existingUser.checkPassword(password)) {
            System.out.println("✅ Login successful!");
            return existingUser;
        }
        else {
            System.out.println("❌ Incorrect password! Try again.");
            return loginUser(); // 
        }
    }

   
    System.out.print("🆕 Create a password: ");
    String newPassword = scanner.nextLine();

    User newUser = new User(username, newPassword);
    users.add(newUser);
    System.out.println("✅ Account created successfully!");
    return newUser;
}

private static User findUser(String username) {
    for (User user : users) {
        if (user.getUserName().equals(username)) {
            return user; 
        }
    }
    return null; 
	}

private static void sendMessage() {
    System.out.print("📩 Enter recipient username: ");
    String recipientUsername = scanner.nextLine();

    User recipient = findUser(recipientUsername);

    if (recipient == null) {
        System.out.println("❌ User not found!");
        return;
    }

    System.out.print("📝 Enter message: ");
    String message = scanner.nextLine();

    recipient.ReceiveMessage("📨 Message from " + recipientUsername + ": " + message);
    System.out.println("✅ Message sent!");
}

private static void commentOnPost() {
    System.out.print("👤 Enter username of the post owner: ");
    String username = scanner.nextLine();

    User user = findUser(username);
    if (user == null) {
        System.out.println("❌ User not found!");
        return;
    }

    List<Post> posts = user.posts();
    if (posts.isEmpty()) {
        System.out.println("❌ No posts found!");
        return;
    }

    for (int i = 0; i < posts.size(); i++) {
        System.out.println((i + 1) + ". " + posts.get(i));
    }

    System.out.print("📌 Choose a post number: ");
    int postIndex = scanner.nextInt() - 1;
    scanner.nextLine(); // Consume newline

    if (postIndex < 0 || postIndex >= posts.size()) {
        System.out.println("❌ Invalid choice!");
        return;
    }

    System.out.print("💬 Enter your comment: ");
    String comment = scanner.nextLine();
    posts.get(postIndex).addComment(comment);
    System.out.println("✅ Comment added!");
}

private static void viewFeed() {
    System.out.println("\n🌟 Social Media Feed:");
    for (User user : users) {
        for (Post post : user.posts()) {
            System.out.println(post);
        }
    }
}

private static void createPost(User user) {
    System.out.print("📝 Enter post content: ");
    String content = scanner.nextLine();
    user.createPost(content);
}


}
	

