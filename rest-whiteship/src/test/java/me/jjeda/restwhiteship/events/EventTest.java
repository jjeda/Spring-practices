package me.jjeda.restwhiteship.events;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {

    @Test
    public void builder() {
        Event event = Event.builder()
                .name("")
                .desciption("")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() {
        Event event = new Event();
        String name = "Event";
        String spring = "Spring";

        event.setName(name);
        event.setDesciption(spring);

        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDesciption()).isEqualTo(spring);
    }
}