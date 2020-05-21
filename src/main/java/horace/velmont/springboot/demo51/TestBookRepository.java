package horace.velmont.springboot.demo51;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("!prod")
public class TestBookRepository implements BookRepository {
}
