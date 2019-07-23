package me.jjeda.restwhiteship.events;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of ="id")
//객체관의 연관관계가 있을 때 스택오브플로우가 발생할 수 있음
//따라서 아이디의 값만가지고 해시코드를 만든다
//lombok @은 메타애너태이션으로 줄일 수 없다.
@Entity
public class Event {

    @Id @GeneratedValue
    private Integer id;

    private String name;
    private String desciption;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location;
    private int basePrice;
    private int maxPrice;
    private int limitOfEnrollment;
    private boolean offline;
    private boolean free;

    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;
}