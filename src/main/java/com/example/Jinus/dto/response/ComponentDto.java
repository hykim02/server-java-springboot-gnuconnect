package com.example.Jinus.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComponentDto {
    private CarouselDto carousel;
    private TextCardDto textCard;

    public ComponentDto(CarouselDto carousel) {
        this.carousel = carousel;
    }

    public ComponentDto(TextCardDto textCard) {
        this.textCard = textCard;
    }
}
