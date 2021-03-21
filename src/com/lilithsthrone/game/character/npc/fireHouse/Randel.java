package com.lilithsthrone.game.character.npc.fireHouse;

import java.time.Month;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.lilithsthrone.game.character.CharacterImportSetting;
import com.lilithsthrone.game.character.body.coverings.BodyCoveringType;
import com.lilithsthrone.game.character.body.coverings.Covering;
import com.lilithsthrone.game.character.body.valueEnums.AreolaeSize;
import com.lilithsthrone.game.character.body.valueEnums.AssSize;
import com.lilithsthrone.game.character.body.valueEnums.BodyHair;
import com.lilithsthrone.game.character.body.valueEnums.BreastShape;
import com.lilithsthrone.game.character.body.valueEnums.Capacity;
import com.lilithsthrone.game.character.body.valueEnums.CupSize;
import com.lilithsthrone.game.character.body.valueEnums.FluidModifier;
import com.lilithsthrone.game.character.body.valueEnums.HairLength;
import com.lilithsthrone.game.character.body.valueEnums.HairStyle;
import com.lilithsthrone.game.character.body.valueEnums.HipSize;
import com.lilithsthrone.game.character.body.valueEnums.LipSize;
import com.lilithsthrone.game.character.body.valueEnums.NippleSize;
import com.lilithsthrone.game.character.body.valueEnums.OrificeElasticity;
import com.lilithsthrone.game.character.body.valueEnums.OrificeModifier;
import com.lilithsthrone.game.character.body.valueEnums.OrificePlasticity;
import com.lilithsthrone.game.character.body.valueEnums.PenetrationGirth;
import com.lilithsthrone.game.character.body.valueEnums.TesticleSize;
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
import com.lilithsthrone.game.character.persona.SexualOrientation;
import com.lilithsthrone.game.character.race.RaceStage;
import com.lilithsthrone.game.character.race.Subspecies;
import com.lilithsthrone.game.inventory.CharacterInventory;
import com.lilithsthrone.utils.Util;
import com.lilithsthrone.utils.Util.Value;
import com.lilithsthrone.utils.colours.PresetColour;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.PlaceType;

public class Randel extends fireHouseNPC{
	
	public Randel() {
		this(false);
	}

	public Randel(boolean isImported) {
		super(isImported, new NameTriplet("Randel"), "Williamson",
				"Description goes here",
				23, Month.FEBRUARY, 17,
				14,
				Gender.M_P_MALE,
				Subspecies.RAT_MORPH, RaceStage.GREATER,
				new CharacterInventory(50),
				WorldType.DOMINION_FIREHOUSE, PlaceType.FIREHOUSE_STAGE_AREA, true);
		
		if(!isImported) {
			this.setPlayerKnowsName(false);
			this.setGenericName("Fire house janitor");
		}
	}
	
	@Override
	public void setupPerks(boolean autoSelectPerks) {
		this.addSpecialPerk(Perk.SPECIAL_SLUT);
				
		PerkManager.initialisePerks(this,
				Util.newArrayListOfValues(
						Perk.RUNNER_2,
						Perk.SEDUCTION_DEFENCE_BOOST),					
				Util.newHashMapOfValues(
						new Value<>(PerkCategory.PHYSICAL, 2),
						new Value<>(PerkCategory.LUST, 2),
						new Value<>(PerkCategory.ARCANE, 0)));
	}
	
	@Override
	public void setStartingBody(boolean setPersona) {
		
		// Persona:
		if(setPersona) {
			
			this.setSexualOrientation(SexualOrientation.AMBIPHILIC);
			
			this.setHistory(Occupation.NPC_CONSTRUCTION_WORKER);

			this.addFetish(Fetish.FETISH_MASTURBATION);
			this.addFetish(Fetish.FETISH_EXHIBITIONIST);
			this.addFetish(Fetish.FETISH_ORAL_RECEIVING);
			this.addFetish(Fetish.FETISH_CUM_ADDICT);
			this.addFetish(Fetish.FETISH_CUM_STUD);
			this.addFetish(Fetish.FETISH_VOYEURIST);
			this.addFetish(Fetish.FETISH_PENIS_GIVING);
			this.addFetish(Fetish.FETISH_TRANSFORMATION_GIVING);
			this.setFetishDesire(Fetish.FETISH_LEG_LOVER, FetishDesire.ONE_DISLIKE);
		}
	
		// Body:
		// Core:
		this.setHeight(162);
		this.setFemininity(20);
		this.setMuscle(40);
		this.setBodySize(60);
				
		// Coverings:
		this.setSkinCovering(new Covering(BodyCoveringType.EYE_RAT, PresetColour.EYE_BROWN), true);
		this.setSkinCovering(new Covering(BodyCoveringType.RAT_FUR, PresetColour.COVERING_BROWN_DARK), true);
		this.setSkinCovering(new Covering(BodyCoveringType.RAT_SKIN, PresetColour.SKIN_PINK_PALE), true);
		this.setSkinCovering(new Covering(BodyCoveringType.HUMAN, PresetColour.SKIN_DARK), true);
		this.setSkinCovering(new Covering(BodyCoveringType.PENIS, PresetColour.SKIN_DARK), false);
		this.setHairCovering(new Covering(BodyCoveringType.HAIR_RAT_FUR, PresetColour.COVERING_BROWN_DARK), false);
		this.setHairLength(HairLength.TWO_SHORT);
		this.setHairStyle(HairStyle.STRAIGHT);

		this.setHairCovering(new Covering(BodyCoveringType.BODY_HAIR_RAT_FUR, PresetColour.COVERING_BROWN_DARK), false);
		this.setUnderarmHair(BodyHair.ZERO_NONE);
		this.setAssHair(BodyHair.ZERO_NONE);
		this.setPubicHair(BodyHair.ZERO_NONE);
		this.setFacialHair(BodyHair.ZERO_NONE);

		// Face:
		this.setFaceVirgin(false);
		this.setLipSize(LipSize.ONE_AVERAGE);
		this.setFaceCapacity(Capacity.FOUR_LOOSE, true);
		this.setTongueLength(TongueLength.ONE_LONG.getMedianValue());
				
		// Chest:
		this.setNippleVirgin(true);
		this.setBreastSize(CupSize.FLAT.getMeasurement());
		this.setBreastShape(BreastShape.POINTY);
		this.setNippleSize(NippleSize.ZERO_TINY);
		this.setAreolaeSize(AreolaeSize.ZERO_TINY);
				
		// Ass:
		this.setAssVirgin(false);
		this.setAssBleached(false);
		this.setAssSize(AssSize.THREE_NORMAL);
		this.setHipSize(HipSize.TWO_NARROW);
		this.setAssCapacity(Capacity.THREE_SLIGHTLY_LOOSE, true);
		this.setAssWetness(Wetness.THREE_WET);
		this.setAssElasticity(OrificeElasticity.SEVEN_ELASTIC.getValue());
		this.setAssPlasticity(OrificePlasticity.ZERO_RUBBERY.getValue());
		this.addAssOrificeModifier(OrificeModifier.MUSCLE_CONTROL);
		// Anus modifiers
				
		// Penis:
		this.setPenisVirgin(false);
		this.setPenisSize(38);
		this.setPenisGirth(PenetrationGirth.SEVEN_FAT);
		this.setTesticleSize(TesticleSize.FOUR_HUGE);
		this.setPenisCumStorage(350);
		this.fillCumToMaxStorage();
		this.addCumModifier(FluidModifier.MUSKY);
				
		// Vagina:
		// No vagina
			
		// Feet:
		// Foot shape
		}

	@Override
	public void loadFromXML(Element parentElement, Document doc, CharacterImportSetting... settings) {
		// TODO Auto-generated method stub		
	}
		
}