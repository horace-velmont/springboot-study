package horace.velmont.springboot.demo51;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

class abc<T> {
    public void test() {}
}

public class EventConverter {

    @Component
    public static class StringToEventConverter implements Converter<String, Event> {
        @Override
        public Event convert(String s) {
            abc<Integer> a = new abc<>();

            return new Event(Integer.parseInt(s));
        }
    }

    @Component
    public static class EventToStringConverter implements Converter<Event, String> {
        @Override
        public String convert(Event event) {
            return event.getId().toString();
        }
    }
}
