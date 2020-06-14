package horace.velmont.springboot.demo51;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Event {
    Event(int id) {
        this.id = id;
    }

    private Integer id;
    private String title;
}
