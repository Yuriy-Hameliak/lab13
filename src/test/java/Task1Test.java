

import org.junit.jupiter.api.Test;

import kb13.task1.FacebookUser;
import kb13.task1.FacebookUserAdapter;
import kb13.task1.MessageSender;
import kb13.task1.TwitterUser;
import kb13.task1.TwitterUserAdapter;
import kb13.task1.User;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    void facebookUserAdapterTest() {
        FacebookUser facebookUser = new FacebookUser("yurka@gmail.com", "Ukraine", "2024-12-09T12:34:56");

        FacebookUserAdapter adapter = new FacebookUserAdapter(facebookUser);

        assertEquals("yurka@gmail.com", adapter.getUserMail());
        assertEquals("Ukraine", adapter.getCountry());
        assertEquals("2024-12-09T12:34:56", adapter.getLastActiveTime());
    }

    @Test
    void twitterUserAdapterTest() {
        TwitterUser twitterUser = new TwitterUser("marichka@gmail.com", "Ukraine", "2024-12-09T12:34:56");

        TwitterUserAdapter adapter = new TwitterUserAdapter(twitterUser);

        assertEquals("marichka@gmail.com", adapter.getUserMail());
        assertEquals("Ukraine", adapter.getCountry());
        assertEquals("2024-12-09T12:34:56", adapter.getLastActiveTime());
    }

    @Test
    void messageSenderTest() {
        User user = new User("test@gmail.com", "USA", "2024-12-09T12:34:56");

        MessageSender sender = new MessageSender();

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        sender.send(user, "Hello");

        String expectedOutput = "Message send to User(userMail=test@gmail.com, country=USA, lastActiveTime=2024-12-09T12:34:56)\n" +
                                "Message :Hello\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
