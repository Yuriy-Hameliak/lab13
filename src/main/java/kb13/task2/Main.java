package kb13.task2;

public class Main {
    public static void main(String[] args) {
        Authorisation auth = new Authorisation();
        DB db = new DB();
        if (auth.authorise(db)) {
            ReportBuilder br = new ReportBuilder(db);
            System.out.println(br);
        }
    }
}