import org.junit.jupiter.api.Test;

import kb13.task2.Authorisation;
import kb13.task2.DB;
import kb13.task2.ReportBuilder;
import kb13.task2.Авторизація;
import kb13.task2.БазаДаних;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void базаДанихTest() {
        БазаДаних db = new БазаДаних();
        assertEquals("hello", db.отриматиДаніКористувача());
        assertEquals("hello2", db.отриматиСтатистичніДані());
    }

    @Test
    void авторизаціяTest() {
        БазаДаних db = new БазаДаних();
        Авторизація auth = new Авторизація();
        assertTrue(auth.авторизуватися(db));
    }

    @Test
    void authorisationTest() {
        БазаДаних базаДаних = new БазаДаних();
        DB db = new DB();
        Authorisation auth = new Authorisation();
        assertTrue(auth.authorise(db));
    }

    @Test
    void dbTest() {
        DB db = new DB();
        assertEquals("hello", db.getUserData());
        assertEquals("hello2", db.getStaticData());
    }

    @Test
    void reportBuilderTest() {
        DB db = new DB();
        ReportBuilder reportBuilder = new ReportBuilder(db);
        assertNotNull(reportBuilder);
    }
}
