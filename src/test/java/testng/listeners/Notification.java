package testng.listeners;

public interface Notification {
	
	default void send(){
		System.out.println("Message sent");
	}

}
