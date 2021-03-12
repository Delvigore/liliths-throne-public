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
import com.lilithsthrone.game.character.body.valueEnums.LipSize;
import com.lilithsthrone.game.character.body.valueEnums.NippleSize;
import com.lilithsthrone.game.character.body.valueEnums.OrificeElasticity;
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
 * @author Delvigore, with much assistance from Innoxia, deboucher, AceXP, and WitheredGryphon 
 */

public class Sonja extends fireHouseNPC {
	
	public Sonja() {
		this(false);
	}
	
	public Sonja(boolean isImported) {
		super(isImported, new NameTriplet("Sonja"), "Shaw",
				"A person stationed at the firehouse"
						+ " She's super stronk.",
				26, Month.SEPTEMBER, 3,
				15,
				Gender.F_V_B_FEMALE,
				Subspecies.getSubspeciesFromId("innoxia_panther_subspecies_tiger"),
				RaceStage.GREATER,
				new CharacterInventory(10), WorldType.DOMINION_FIREHOUSE, PlaceType.FIREHOUSE_SECRETARY, true);
		
		if(!isImported) {
			this.setPlayerKnowsName(false);
			this.setGenericName("Tigress Firefighter");
		}
	}
	

	@Override
	public void setupPerks(boolean autoSelectPerks) {
		this.addSpecialPerk(Perk.SPECIAL_HEALTH_FANATIC);
		
		PerkManager.initialisePerks(this,
				Util.newArrayListOfValues(
						Perk.RUNNER_2,
						Perk.SEDUCTION_DEFENCE_BOOST,
						Perk.OBJECT_OF_DESIRE,
						Perk.ENCHANTMENT_STABILITY,
						Perk.COMBAT_REGENERATION),
				Util.newHashMapOfValues(
						new Value<>(PerkCategory.PHYSICAL, 0),
						new Value<>(PerkCategory.LUST, 0),
						new Value<>(PerkCategory.ARCANE, 0)));
	}
	
	@Override
	public void setStartingBody(boolean setPersona) {
		// Persona:
		if(setPersona) {
			this.setPersonalityTraits(
					PersonalityTrait.CONFIDENT,
					PersonalityTrait.KIND,
					PersonalityTrait.LEWD);
	
			this.setSexualOrientation(SexualOrientation.AMBIPHILIC);
			
			this.setHistory(Occupation.NPC_CONSTRUCTION_WORKER);

			this.addFetish(Fetish.FETISH_EXHIBITIONIST);
			this.addFetish(Fetish.FETISH_DOMINANT);
			this.addFetish(Fetish.FETISH_VOYEURIST);
			this.addFetish(Fetish.FETISH_VAGINAL_RECEIVING);
			this.setFetishDesire(Fetish.FETISH_CUM_ADDICT, FetishDesire.THREE_LIKE);
			this.setFetishDesire(Fetish.FETISH_ORAL_GIVING, FetishDesire.THREE_LIKE);
			this.setFetishDesire(Fetish.FETISH_ORAL_RECEIVING, FetishDesire.THREE_LIKE);
			this.setFetishDesire(Fetish.FETISH_PENIS_RECEIVING, FetishDesire.THREE_LIKE);
			this.setFetishDesire(Fetish.FETISH_MASTURBATION, FetishDesire.THREE_LIKE);
			this.setFetishDesire(Fetish.FETISH_BREASTS_SELF, FetishDesire.THREE_LIKE);			
			this.setFetishDesire(Fetish.FETISH_NON_CON_SUB, FetishDesire.ZERO_HATE);
			this.setFetishDesire(Fetish.FETISH_NON_CON_DOM, FetishDesire.ZERO_HATE);
			this.setFetishDesire(Fetish.FETISH_SADIST, FetishDesire.ZERO_HATE);
		}
		
		// Body:

		// Core:
		this.setHeight(190);
		this.setFemininity(85);
		this.setMuscle(60);
		this.setBodySize(60);
		this.setAttribute(Attribute.MAJOR_CORRUPTION, 65);
		
		// Coverings:
		this.setEyeCovering(new Covering(BodyCoveringType.getBodyCoveringTypeFromId("innoxia_panther_eye"), PresetColour.EYE_BROWN));
		this.setSkinCovering(new Covering(BodyCoveringType.getBodyCoveringTypeFromId("innoxia_panther_fur"), CoveringPattern.STRIPED, CoveringModifier.SHORT, PresetColour.COVERING_TAN, false, PresetColour.COVERING_BLACK, false), true);
		this.setSkinCovering(new Covering(BodyCoveringType.HUMAN, PresetColour.SKIN_LIGHT), true);

		this.setHairCovering(new Covering(BodyCoveringType.getBodyCoveringTypeFromId("innoxia_panther_hair"), PresetColour.COVERING_GINGER), true);
		this.setHairLength(HairLength.THREE_SHOULDER_LENGTH.getMedianValue());
		this.setHairStyle(HairStyle.WAVY);

		this.setHairCovering(new Covering(BodyCoveringType.getBodyCoveringTypeFromId("innoxia_panther_body_hair"), PresetColour.COVERING_BROWN_DARK), false);
		this.setHairCovering(new Covering(BodyCoveringType.BODY_HAIR_FELINE_FUR, PresetColour.COVERING_BROWN), false);
		this.setUnderarmHair(BodyHair.ZERO_NONE);
		this.setAssHair(BodyHair.ZERO_NONE);
		this.setPubicHair(BodyHair.ZERO_NONE);
		this.setFacialHair(BodyHair.ZERO_NONE);

		this.setHandNailPolish(new Covering(BodyCoveringType.MAKEUP_NAIL_POLISH_HANDS, PresetColour.COVERING_RED));
		this.setFootNailPolish(new Covering(BodyCoveringType.MAKEUP_NAIL_POLISH_FEET, PresetColour.COVERING_RED));
		this.setLipstick(new Covering(BodyCoveringType.MAKEUP_LIPSTICK, PresetColour.COVERING_RED));
		this.setEyeLiner(new Covering(BodyCoveringType.MAKEUP_EYE_LINER, PresetColour.COVERING_BLACK));
		this.setEyeShadow(new Covering(BodyCoveringType.MAKEUP_EYE_SHADOW, PresetColour.COVERING_RED));
		
		// Face:
		this.setFaceVirgin(false);
		this.setLipSize(LipSize.TWO_FULL);
		this.setFaceCapacity(Capacity.FIVE_ROOMY, true);
		// Throat settings and modifiers
		this.setTongueLength(TongueLength.ONE_LONG.getMedianValue());
		// Tongue modifiers
		
		// Chest:
		this.setBreastRows(1);
		this.setNippleVirgin(true);
		this.setBreastSize(CupSize.E.getMeasurement());
		this.setBreastShape(BreastShape.ROUND);
		this.setNippleSize(NippleSize.TWO_BIG.getValue());
		this.setAreolaeSize(AreolaeSize.TWO_BIG.getValue());
		// Nipple settings and modifiers
		
		// Ass:
		this.setAssVirgin(true);
		this.setAssBleached(false);
		this.setAssSize(AssSize.THREE_NORMAL);
		this.setHipSize(HipSize.THREE_GIRLY);
		this.setAssCapacity(Capacity.TWO_TIGHT, true);
		this.setAssWetness(Wetness.ZERO_DRY);
		this.setAssElasticity(OrificeElasticity.FOUR_LIMBER.getValue());
		this.setAssPlasticity(OrificePlasticity.THREE_RESILIENT.getValue());
		// Anus modifiers
		
		// Penis:
		// No penis
		
		// Vagina:
		this.setVaginaVirgin(false);
		this.setVaginaClitorisSize(ClitorisSize.ZERO_AVERAGE);
		this.setVaginaLabiaSize(LabiaSize.ZERO_TINY);
		this.setVaginaSquirter(true);
		this.setVaginaCapacity(Capacity.THREE_SLIGHTLY_LOOSE, true);
		this.setVaginaDepth(3);
		this.setVaginaWetness(Wetness.FOUR_SLIMY);
		this.setVaginaElasticity(OrificeElasticity.FOUR_LIMBER.getValue());
		this.setVaginaPlasticity(OrificePlasticity.THREE_RESILIENT.getValue());
	}
	
	@Override
	public void equipClothing(List<EquipClothingSetting> settings) {
		this.unequipAllClothingIntoVoid(true, true);
		this.clearNonEquippedInventory(false);
		this.unequipMainWeaponIntoVoid(0, false);
		this.unequipOffhandWeaponIntoVoid(0, false);
		
	//	this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing(ClothingType.CHEST_TUBE_TOP, PresetColour.CLOTHING_BLUE_DARK, false), true, this);
	//	this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing(ClothingType.GROIN_BOYSHORTS, PresetColour.CLOTHING_BLACK, false), true, this);
	//	this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("nerdlinger_street_joggers_joggers", PresetColour.CLOTHING_GREY, false), true, this);
	//	this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_sock_socks", PresetColour.CLOTHING_WHITE, false), true, this);
	//	this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_foot_low_top_skater_shoes", PresetColour.CLOTHING_BLACK, false), true, this);
				
		
		if(settings.contains(EquipClothingSetting.ADD_ACCESSORIES)) {
			this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing(ClothingType.WRIST_WOMENS_WATCH, PresetColour.CLOTHING_BLACK, false), true, this);
		}
		
	}
	
	public boolean isBusy() {
        return Main.game.isFireDayShift() && Main.game.getCurrentWeather()!=Weather.MAGIC_STORM;
    }
	
	@Override
	public void hourlyUpdate() {
		if(!Main.game.getCharactersPresent().contains(this)) {
			if(Main.game.isFireDayShift() && Main.game.getCurrentWeather()!=Weather.MAGIC_STORM) {
				if (this.getWorldLocation()!=WorldType.DOMINION_FIREHOUSE) {
					this.equipClothing(EquipClothingSetting.getAllClothingSettings());
					this.setLocation(WorldType.DOMINION_FIREHOUSE, PlaceType.FIREHOUSE_STAGE_AREA, true);
				}
			} else {
				if (this.getWorldLocation()!=WorldType.DOMINION_FIREHOUSE2) {
					this.equipClothing(EquipClothingSetting.getAllClothingSettings());
					this.setLocation(WorldType.DOMINION_FIREHOUSE2, PlaceType.FIREHOUSE_FLOOR2, false);
				}
			}
		}
	}
		
	@Override
	public SexPace getSexPaceSubPreference(GameCharacter character){
		return SexPace.SUB_EAGER;
	}

	@Override
	public SexPace getSexPaceDomPreference(){
		return SexPace.DOM_GENTLE;
	}
	
	@Override
	public void loadFromXML(Element parentElement, Document doc, CharacterImportSetting... settings) {
	    loadNPCVariablesFromXML(this, null, parentElement, doc, settings);
	}
	
}