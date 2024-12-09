package kb13.task1;

public class FacebookUserAdapter implements IUser {
    private FacebookUser facebookUser;

    public FacebookUserAdapter(FacebookUser facebookUser) {
        this.facebookUser = facebookUser;
    }

    @Override
    public String getUserMail() {
        return facebookUser.getEmail();
    }

    @Override
    public String getCountry() {
        return facebookUser.getUsercountry();
    }

    @Override
    public String getLastActiveTime() {
        return facebookUser.getUserActiveTime();
    }
    public String toString() {
        return "Email" +
                facebookUser.getEmail() + facebookUser.getUsercountry() + facebookUser.getUserActiveTime()
                ;
    }

}
