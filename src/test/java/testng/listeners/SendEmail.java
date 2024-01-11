package testng.listeners;

public class SendEmail implements Notification {

	@Override
	public void send() {
		System.out.println("Email sent");
	}

}
