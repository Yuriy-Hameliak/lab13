package kb13.task2;

import lombok.Data;

@Data
public class DB {
    private БазаДаних db;
    public DB(){
        this.db= new БазаДаних();
    }
    public String getUserData(){
        return db.отриматиДаніКористувача();
    }
    public String getStaticData(){
        return db.отриматиСтатистичніДані();
    }
}
