package com.nerv.hdbmanagement.properties.interfaces.rest.resources;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PropertyResource {
    private Long id;
    private String blockNumber;
    private String street;
    private int maximumFloorLevel;
    private int yearCompleted;
    private String residentialPropertyTag;
    private String commercialPropertyTag;
    private String marketAndHawkerTag;
    private String miscellaneous;
    private String multiStoreyCarParkTag;
    private String precinctPavilionTag;
    private String town;
    private int totalDwellingUnits;
    private int numberOneRoomSoldFlats;
    private int numberTwoRoomSoldFlats;
    private int numberThreeRoomSoldFlats;
    private int numberFourRoomSoldFlats;
    private int numberFiveRoomSoldFlats;
    private int numberExecutiveSoldFlats;
    private int numberMultiGenerationSoldFlats;
    private int numberStudioApartmentSoldFlats;
    private int numberOneRoomRentalFlats;
    private int numberTwoRoomRentalFlats;
    private int numberThreeRoomRentalFlats;
    private int numberOtherRoomRentalFlats;
}
