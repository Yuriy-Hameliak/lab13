package kb13.task1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class TwitterUser {
    private String userMail;
    private String country;
    private String lastActiveTime;
}
