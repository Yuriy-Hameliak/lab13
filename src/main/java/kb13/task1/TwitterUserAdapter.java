package kb13.task1;

public class TwitterUserAdapter implements IUser {
    private TwitterUser twitterUser;

    public TwitterUserAdapter(TwitterUser twitterUser) {
        this.twitterUser = twitterUser;
    }

    @Override
    public String getUserMail() {
        return twitterUser.getUserMail();
    }

    @Override
    public String getCountry() {
        return twitterUser.getCountry();
    }

    @Override
    public String getLastActiveTime() {
        return twitterUser.getLastActiveTime();
    }
    public String toString() {
        return twitterUser.toString();
    }

}
