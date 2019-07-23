package me.jjeda.restwhiteship.events;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
@RequestMapping(value="/api/events",produces = MediaTypes.HAL_JSON_UTF8_VALUE)
@AllArgsConstructor
public class EventController {

    private final EventRepository eventRepository;

    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity createEvent(@RequestBody EventDto eventDto) {
        /*Event event = Event.builder()
                .name(eventDto.getName())
                ...
                .build();*/
        Event event = modelMapper.map(eventDto, Event.class);

        Event newEvent = this.eventRepository.save(event);
        URI createdUri = linkTo(EventController.class).slash(newEvent.getId()).toUri();
        //why NULL ? 모킹 한거아닌가? 입력값 제한하기 10:00
        //모킹할 때 세이브를 호출할때 세이브할 때 리턴하도록
        //save에 전달한 객체는 새로만든 객체자나 ㅎㅎ
        //그러니 적용이 안되지
        return ResponseEntity.created(createdUri).body(event);
    }
}
