package kb13.task1;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        AuthMethod authMethod = AuthMethod.FACEBOOK;
        User user = new User();
        switch (authMethod) {
            case FACEBOOK:
                FacebookUserAdapter facebookUserAdapter = new FacebookUserAdapter(new FacebookUser("yurka@gmail.com", "Ukraine", LocalDateTime.now().toString()));
                facebookUserAdapter.toString();
                break;
                
            case TWITTER:
                TwitterUserAdapter twitterUserAdapter = new TwitterUserAdapter(new TwitterUser("marichka@gmail.com", "Ukraine", LocalDateTime.now().toString()));
                twitterUserAdapter.toString();
                break;
            default:
                System.out.println("Unknown");
        }
        MessageSender messageSender = new MessageSender();
        messageSender.send(user, "Hello");
    }
}
