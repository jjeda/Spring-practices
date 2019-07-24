package me.jjeda.restwhiteship.events;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder @NoArgsConstructor @AllArgsConstructor
@Data
public class EventDto {
//DTO 를 따로 두는 이유!?
//중복 코드가 발생하는데도 불궇고
//바로 입력값 제한해버리기
    @NotEmpty
    private String name;
    @NotEmpty
    private String desciption;
    @NotNull
    private LocalDateTime beginEnrollmentDateTime;
    @NotNull
    private LocalDateTime closeEnrollmentDateTime;
    @NotNull
    private LocalDateTime beginEventDateTime;
    @NotNull
    private LocalDateTime endEventDateTime;
    @NotNull
    private String location;
    @Min(0)
    private int basePrice;
    @Min(0)
    private int maxPrice;
    @Min(0)
    private int limitOfEnrollment;
}
