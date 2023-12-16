package com.nerv.hdbmanagement.properties.domain.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "hdb_property_information")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "blk_no", nullable = false)
    private String blockNumber;

    @NotNull
    @NotBlank
    private String street;

    @Column(name = "max_floor_lvl", nullable = false)
    private int maximumFloorLevel;

    @Column(name = "year_completed", nullable = false)
    private int yearCompleted;

    @NotBlank
    @Column(name = "residential", nullable = false)
    private String residentialPropertyTag;

    @NotBlank
    @Column(name = "commercial", nullable = false)
    private String commercialPropertyTag;

    @NotBlank
    @Column(name = "market_hawker", nullable = false)
    private String marketAndHawkerTag;

    @NotBlank
    @NotNull
    private String miscellaneous;

    @NotBlank
    @Column(name = "multistorey_carpark", nullable = false)
    private String multiStoreyCarParkTag;

    @NotBlank
    @Column(name = "precinct_pavilion", nullable = false)
    private String precinctPavilionTag;

    @NotBlank
    @Column(name = "bldg_contract_town", nullable = false)
    private String town;

    @Column(name = "total_dwelling_units", nullable = false)
    private int totalDwellingUnits;

    @PositiveOrZero
    @Column(name = "1room_sold", nullable = false)
    private int numberOneRoomSoldFlats;

    @PositiveOrZero
    @Column(name = "2room_sold", nullable = false)
    private int numberTwoRoomSoldFlats;

    @PositiveOrZero
    @Column(name = "3room_sold", nullable = false)
    private int numberThreeRoomSoldFlats;

    @PositiveOrZero
    @Column(name = "4room_sold", nullable = false)
    private int numberFourRoomSoldFlats;

    @PositiveOrZero
    @Column(name = "5room_sold", nullable = false)
    private int numberFiveRoomSoldFlats;

    @PositiveOrZero
    @Column(name = "exec_sold", nullable = false)
    private int numberExecutiveSoldFlats;

    @PositiveOrZero
    @Column(name = "multigen_sold", nullable = false)
    private int numberMultiGenerationSoldFlats;

    @PositiveOrZero
    @Column(name = "studio_aparment_sold", nullable = false)
    private int numberStudioApartmentSoldFlats;

    @PositiveOrZero
    @Column(name = "1room_rental", nullable = false)
    private int numberOneRoomRentalFlats;

    @PositiveOrZero
    @Column(name = "2room_rental", nullable = false)
    private int numberTwoRoomRentalFlats;

    @PositiveOrZero
    @Column(name = "3room_rental", nullable = false)
    private int numberThreeRoomRentalFlats;

    @PositiveOrZero
    @Column(name = "other_room_rental", nullable = false)
    private int numberOtherRoomRentalFlats;
}
