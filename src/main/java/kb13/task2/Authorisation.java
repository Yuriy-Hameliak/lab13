package kb13.task2;

public class Authorisation extends Авторизація{
    private Авторизація auth;
    public Authorisation(Авторизація auth){
        this.auth=auth;
    }
    public Authorisation(){
        this.auth= new Авторизація();
    }
    public boolean authorise(DB db){
        return auth.авторизуватися(db.getDb());
    }
}
