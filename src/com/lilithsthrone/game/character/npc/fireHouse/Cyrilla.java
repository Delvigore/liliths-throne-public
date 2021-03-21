package com.lilithsthrone.game.character.npc.fireHouse;

import java.time.Month;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.lilithsthrone.game.character.CharacterImportSetting;
import com.lilithsthrone.game.character.EquipClothingSetting;
import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.attributes.Attribute;
import com.lilithsthrone.game.character.body.coverings.BodyCoveringType;
import com.lilithsthrone.game.character.body.coverings.Covering;
import com.lilithsthrone.game.character.body.types.BreastType;
import com.lilithsthrone.game.character.body.types.EarType;
import com.lilithsthrone.game.character.body.types.FaceType;
import com.lilithsthrone.game.character.body.types.LegType;
import com.lilithsthrone.game.character.body.valueEnums.AreolaeSize;
import com.lilithsthrone.game.character.body.valueEnums.AssSize;
import com.lilithsthrone.game.character.body.valueEnums.BodyHair;
import com.lilithsthrone.game.character.body.valueEnums.BreastShape;
import com.lilithsthrone.game.character.body.valueEnums.Capacity;
import com.lilithsthrone.game.character.body.valueEnums.ClitorisSize;
import com.lilithsthrone.game.character.body.valueEnums.CoveringModifier;
import com.lilithsthrone.game.character.body.valueEnums.CoveringPattern;
import com.lilithsthrone.game.character.body.valueEnums.CupSize;
import com.lilithsthrone.game.character.body.valueEnums.HairLength;
import com.lilithsthrone.game.character.body.valueEnums.HairStyle;
import com.lilithsthrone.game.character.body.valueEnums.HipSize;
import com.lilithsthrone.game.character.body.valueEnums.LabiaSize;
import com.lilithsthrone.game.character.body.valueEnums.LegConfiguration;
import com.lilithsthrone.game.character.body.valueEnums.LipSize;
import com.lilithsthrone.game.character.body.valueEnums.NippleSize;
import com.lilithsthrone.game.character.body.valueEnums.OrificeDepth;
import com.lilithsthrone.game.character.body.valueEnums.OrificeElasticity;
import com.lilithsthrone.game.character.body.valueEnums.OrificeModifier;
import com.lilithsthrone.game.character.body.valueEnums.OrificePlasticity;
import com.lilithsthrone.game.character.body.valueEnums.TongueLength;
import com.lilithsthrone.game.character.body.valueEnums.Wetness;
import com.lilithsthrone.game.character.effects.Perk;
import com.lilithsthrone.game.character.effects.PerkCategory;
import com.lilithsthrone.game.character.effects.PerkManager;
import com.lilithsthrone.game.character.fetishes.Fetish;
import com.lilithsthrone.game.character.fetishes.FetishDesire;
import com.lilithsthrone.game.character.gender.Gender;
import com.lilithsthrone.game.character.persona.NameTriplet;
import com.lilithsthrone.game.character.persona.Occupation;
import com.lilithsthrone.game.character.persona.PersonalityTrait;
import com.lilithsthrone.game.character.persona.SexualOrientation;
import com.lilithsthrone.game.character.race.RaceStage;
import com.lilithsthrone.game.character.race.Subspecies;
import com.lilithsthrone.game.inventory.CharacterInventory;
import com.lilithsthrone.game.inventory.clothing.ClothingType;
import com.lilithsthrone.game.sex.SexPace;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.Util;
import com.lilithsthrone.utils.Util.Value;
import com.lilithsthrone.utils.colours.PresetColour;
import com.lilithsthrone.world.Weather;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.PlaceType;

/**
 * @author Delvigore, with much assistance from Innoxia, deboucher, and AceXP
 */

public class Cyrilla extends fireHouseNPC{
	
	public Cyrilla() {
		this(false);
	}
	
	public Cyrilla(boolean isImported) {
		super(isImported, new NameTriplet("Cyrilla"), "Gordon",
				"",
				19, Month.OCTOBER, 15,
				15,
				Gender.F_V_B_FEMALE, Subspecies.HORSE_MORPH,
				RaceStage.PARTIAL,
				new CharacterInventory(10), WorldType.DOMINION_FIREHOUSE, PlaceType.FIREHOUSE_BARRACKS, true);
		
		if(!isImported) {
			this.setPlayerKnowsName(false);
			this.setGenericName("Firefighter Centauress");
		}
	}

	@Override
	public void setupPerks(boolean autoSelectPerks) {
		PerkManager.initialisePerks(this,
				Util.newArrayListOfValues(Perk.BARREN),
				Util.newHashMapOfValues(
						new Value<>(PerkCategory.PHYSICAL, 1),
						new Value<>(PerkCategory.LUST, 3)));
	}
	
	@Override
	public void setStartingBody(boolean setPersona) {
		// Persona:
		if(setPersona) {
			this.setPersonalityTraits(
					PersonalityTrait.CONFIDENT);
			
			this.setSexualOrientation(SexualOrientation.AMBIPHILIC);
			
			this.setHistory(Occupation.NPC_CONSTRUCTION_WORKER);
			
			this.addFetish(Fetish.FETISH_DOMINANT);
			this.addFetish(Fetish.FETISH_ORAL_GIVING);
			this.addFetish(Fetish.FETISH_ANAL_RECEIVING);

			this.setFetishDesire(Fetish.FETISH_MASOCHIST, FetishDesire.ZERO_HATE);
			this.setFetishDesire(Fetish.FETISH_CUM_ADDICT, FetishDesire.THREE_LIKE);
			this.setFetishDesire(Fetish.FETISH_PURE_VIRGIN, FetishDesire.ZERO_HATE);
			this.setFetishDesire(Fetish.FETISH_PREGNANCY, FetishDesire.ZERO_HATE);
			this.setFetishDesire(Fetish.FETISH_PENIS_RECEIVING, FetishDesire.THREE_LIKE);
			this.setFetishDesire(Fetish.FETISH_VAGINAL_RECEIVING, FetishDesire.THREE_LIKE);
			}
		
		// Body:
		this.setLegConfiguration(LegType.HORSE_MORPH, LegConfiguration.QUADRUPEDAL, true);
		this.setBreastCrotchType(BreastType.NONE);
			
		// Core:
		this.setHeight(154);
		this.setFemininity(85);
		this.setMuscle(70);
		this.setBodySize(50);
		this.setAttribute(Attribute.MAJOR_CORRUPTION, 50);
		
		// Coverings:
		this.setEyeCovering(new Covering(BodyCoveringType.EYE_HORSE_MORPH, PresetColour.EYE_BROWN));
		this.setSkinCovering(new Covering(BodyCoveringType.HORSE_HAIR, CoveringPattern.MARKED, CoveringModifier.SHORT, PresetColour.COVERING_BROWN, false, PresetColour.COVERING_WHITE, false), true);
		this.setSkinCovering(new Covering(BodyCoveringType.HUMAN, PresetColour.SKIN_PALE), true);

		this.setHairCovering(new Covering(BodyCoveringType.HAIR_HORSE_HAIR, PresetColour.COVERING_BROWN_DARK), true);
		this.setHairLength(HairLength.TWO_SHORT);
		this.setHairStyle(HairStyle.LOOSE);

		this.setHairCovering(new Covering(BodyCoveringType.BODY_HAIR_HUMAN, PresetColour.COVERING_BLACK), false);
		this.setHairCovering(new Covering(BodyCoveringType.BODY_HAIR_HORSE_HAIR, PresetColour.COVERING_BLACK), false);
		this.setUnderarmHair(BodyHair.FOUR_NATURAL);
		this.setAssHair(BodyHair.FOUR_NATURAL);
		this.setPubicHair(BodyHair.THREE_TRIMMED);
		this.setFacialHair(BodyHair.ZERO_NONE);
		
		// Face:
		this.setFaceType(FaceType.HUMAN);
		this.setEarType(EarType.HORSE_MORPH);
		this.setFaceVirgin(false);
		this.setLipSize(LipSize.TWO_FULL);
		this.setFaceCapacity(Capacity.FIVE_ROOMY, true);
		this.setTongueLength(TongueLength.ZERO_NORMAL.getMedianValue());
		
		// Chest:
		this.setNippleVirgin(true);
		this.setBreastSize(CupSize.B.getMeasurement());
		this.setBreastShape(BreastShape.PERKY);
		this.setNippleSize(NippleSize.TWO_BIG);
		this.setAreolaeSize(AreolaeSize.TWO_BIG);
		
		this.setNippleCapacity(Capacity.ONE_EXTREMELY_TIGHT.getMedianValue(), true);
		
		// Crotch-boobs:
		this.setBreastCrotchType(BreastType.NONE);
		
		// Ass:
		this.setAssVirgin(false);
		this.setAssBleached(false);
		this.setAssSize(AssSize.FOUR_LARGE);
		this.setHipSize(HipSize.FOUR_WOMANLY);
		this.setAssCapacity(Capacity.THREE_SLIGHTLY_LOOSE, true);
		this.setAssWetness(Wetness.THREE_WET);
		this.setAssDepth(OrificeDepth.FOUR_DEEP.getValue());
		this.setAssPlasticity(0);
		this.setAssElasticity(OrificeElasticity.SEVEN_ELASTIC.getValue());
		this.addAssOrificeModifier(OrificeModifier.MUSCLE_CONTROL);
		
		// Penis:
		// No penis
		
		// Vagina:
		this.setVaginaVirgin(false);
		this.setVaginaClitorisSize(ClitorisSize.ZERO_AVERAGE);
		this.setVaginaLabiaSize(LabiaSize.TWO_AVERAGE);
		this.setVaginaSquirter(true);
		this.setVaginaCapacity(Capacity.THREE_SLIGHTLY_LOOSE, true);
		this.setVaginaWetness(Wetness.FIVE_SLOPPY);
		this.setVaginaDepth(OrificeDepth.FOUR_DEEP.getValue());
		this.setVaginaPlasticity(OrificePlasticity.ZERO_RUBBERY.getValue());
		this.setVaginaElasticity(OrificeElasticity.SEVEN_ELASTIC.getValue());
	}

	@Override
	public void equipClothing(List<EquipClothingSetting> settings) {
		this.unequipAllClothingIntoVoid(true, true);
		this.clearNonEquippedInventory(false);
		this.unequipMainWeaponIntoVoid(0, false);
		this.unequipOffhandWeaponIntoVoid(0, false);
		
	//	this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing(ClothingType.CHEST_TUBE_TOP, PresetColour.CLOTHING_BLUE_DARK, false), true, this);
		
		if(settings.contains(EquipClothingSetting.ADD_ACCESSORIES)) {
			this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing(ClothingType.WRIST_WOMENS_WATCH, PresetColour.CLOTHING_BLACK, false), true, this);		}
	}
		
	public boolean isBusy() {
        return Main.game.isFireDayShift() && Main.game.getCurrentWeather()!=Weather.MAGIC_STORM;
    }

	@Override
	public void hourlyUpdate() {
		if(!Main.game.getCharactersPresent().contains(this)) {
			if(Main.game.isFireDayShift() && Main.game.getCurrentWeather()!=Weather.MAGIC_STORM) {
				this.setLocation(WorldType.DOMINION_FIREHOUSE, PlaceType.FIREHOUSE_STAGE_AREA, false);				
			} else {
				if(Main.game.getCurrentWeather()!=Weather.MAGIC_STORM)
				this.setLocation(WorldType.DOMINION_FIREHOUSE2, PlaceType.FIREHOUSE_FLOOR2, false);
			} 
			if(Main.game.getCurrentWeather() == Weather.MAGIC_STORM) {
				this.setLocation(WorldType.DOMINION_FIREHOUSE, PlaceType.FIREHOUSE_BARRACKS, true);
			}
		}
	}
			
		@Override
		public SexPace getSexPaceSubPreference(GameCharacter character){
			return SexPace.SUB_NORMAL;
		}

		@Override
		public SexPace getSexPaceDomPreference(){
			return SexPace.DOM_NORMAL;
		}
		
		@Override
		public void loadFromXML(Element parentElement, Document doc, CharacterImportSetting... settings) {
		    loadNPCVariablesFromXML(this, null, parentElement, doc, settings);
		}
		
}