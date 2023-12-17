package com.nerv.hdbmanagement.properties.interfaces.rest.resources;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePropertyResource {

    @NotBlank
    @NotNull
    private String blockNumber;

    @NotNull
    @NotBlank
    private String street;

    @NotBlank
    @NotNull
    private int maximumFloorLevel;

    @NotBlank
    @NotNull
    private int yearCompleted;

    @NotBlank
    @NotNull
    private String residentialPropertyTag;

    @NotBlank
    @NotNull
    private String commercialPropertyTag;

    @NotBlank
    @NotNull
    private String marketAndHawkerTag;

    @NotBlank
    @NotNull
    private String miscellaneous;

    @NotBlank
    @NotNull
    private String multiStoreyCarParkTag;

    @NotBlank
    @NotNull
    private String precinctPavilionTag;

    @NotBlank
    @NotNull
    private String town;

    @PositiveOrZero
    @NotNull
    private int numberOneRoomSoldFlats;

    @PositiveOrZero
    @NotNull
    private int numberTwoRoomSoldFlats;

    @PositiveOrZero
    @NotNull
    private int numberThreeRoomSoldFlats;

    @PositiveOrZero
    @NotNull
    private int numberFourRoomSoldFlats;

    @PositiveOrZero
    @NotNull
    private int numberFiveRoomSoldFlats;

    @PositiveOrZero
    @NotNull
    private int numberExecutiveSoldFlats;

    @PositiveOrZero
    @NotNull
    private int numberMultiGenerationSoldFlats;

    @PositiveOrZero
    @NotNull
    private int numberStudioApartmentSoldFlats;

    @PositiveOrZero
    @NotNull
    private int numberOneRoomRentalFlats;

    @PositiveOrZero
    @NotNull
    private int numberTwoRoomRentalFlats;

    @PositiveOrZero
    @NotNull
    private int numberThreeRoomRentalFlats;

    @PositiveOrZero
    @NotNull
    private int numberOtherRoomRentalFlats;
}
