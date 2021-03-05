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
import com.lilithsthrone.game.character.body.types.EyeType;
import com.lilithsthrone.game.character.body.types.PenisType;
import com.lilithsthrone.game.character.body.types.TailType;
import com.lilithsthrone.game.character.body.types.WingType;
import com.lilithsthrone.game.character.body.valueEnums.AreolaeSize;
import com.lilithsthrone.game.character.body.valueEnums.AssSize;
import com.lilithsthrone.game.character.body.valueEnums.BodyHair;
import com.lilithsthrone.game.character.body.valueEnums.BreastShape;
import com.lilithsthrone.game.character.body.valueEnums.Capacity;
import com.lilithsthrone.game.character.body.valueEnums.CoveringModifier;
import com.lilithsthrone.game.character.body.valueEnums.CoveringPattern;
import com.lilithsthrone.game.character.body.valueEnums.CupSize;
import com.lilithsthrone.game.character.body.valueEnums.FootStructure;
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
import com.lilithsthrone.game.character.npc.NPC;
import com.lilithsthrone.game.character.persona.NameTriplet;
import com.lilithsthrone.game.character.persona.Occupation;
import com.lilithsthrone.game.character.persona.PersonalityTrait;
import com.lilithsthrone.game.character.persona.SexualOrientation;
import com.lilithsthrone.game.character.race.RaceStage;
import com.lilithsthrone.game.character.race.Subspecies;
import com.lilithsthrone.game.combat.spells.Spell;
import com.lilithsthrone.game.combat.spells.SpellUpgrade;
import com.lilithsthrone.game.dialogue.DialogueNode;
import com.lilithsthrone.game.dialogue.places.dominion.fireHouse.BevikarDialogue;
import com.lilithsthrone.game.inventory.CharacterInventory;
import com.lilithsthrone.game.inventory.clothing.ClothingType;
import com.lilithsthrone.game.sex.SexPace;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.Util;
import com.lilithsthrone.utils.Util.Value;
import com.lilithsthrone.utils.colours.PresetColour;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.PlaceType;

/**
 * @author Delvigore, with much assistance from Innoxia, deboucher, and AceXP 
 */

public class Bevikar extends NPC{

	public Bevikar() {
		this(false);
	}
	
	public Bevikar(boolean isImported) {
		super(isImported, new NameTriplet("Bevikar"), "Webb",
				"[Bevikar.name] is a handsome fellow",
				31, Month.NOVEMBER, 15,
				20,
				Gender.M_P_MALE,
				Subspecies.getSubspeciesFromId("innoxia_panther_subspecies_lion"),
				RaceStage.GREATER,
				new CharacterInventory(10),
				WorldType.DOMINION_FIREHOUSE, PlaceType.FIREHOUSE_STAGE_AREA,
				true);
		
		if(!isImported) {
			this.setPlayerKnowsName(false);
			this.setGenericName("Firefighter Stud");
		}
	}
	
	
	@Override
	public void setupPerks(boolean autoSelectPerks) {
		this.addSpecialPerk(Perk.SPECIAL_SLUT);
		
		PerkManager.initialisePerks(this,
				Util.newArrayListOfValues(
						Perk.RUNNER_2,
						Perk.SEDUCTION_DEFENCE_BOOST,
						Perk.ARCANE_COMBATANT,
						Perk.OBSERVANT,
						Perk.ENCHANTMENT_STABILITY,
						Perk.COMBAT_REGENERATION,
						Perk.ARCANE_BOOST_MAJOR,
						Perk.PHYSIQUE_BOOST_MAJOR),					
				Util.newHashMapOfValues(
						new Value<>(PerkCategory.PHYSICAL, 2),
						new Value<>(PerkCategory.LUST, 2),
						new Value<>(PerkCategory.ARCANE, 0)));
	}
	
	@Override
	public void setStartingBody(boolean setPersona) {
		
		// Persona:
		if(setPersona) {
			this.setPersonalityTraits(
					PersonalityTrait.BRAVE,
					PersonalityTrait.SLOVENLY);
	
			this.setSexualOrientation(SexualOrientation.AMBIPHILIC);
			
			this.setHistory(Occupation.NPC_CONSTRUCTION_WORKER);

			this.addFetish(Fetish.FETISH_ANAL_GIVING);
			this.addFetish(Fetish.FETISH_ANAL_RECEIVING);
			this.addFetish(Fetish.FETISH_EXHIBITIONIST);
			this.addFetish(Fetish.FETISH_ORAL_GIVING);
			this.addFetish(Fetish.FETISH_ORAL_RECEIVING);
			this.addFetish(Fetish.FETISH_CUM_ADDICT);
			this.addFetish(Fetish.FETISH_CUM_STUD);
			this.addFetish(Fetish.FETISH_VOYEURIST);
			this.setFetishDesire(Fetish.FETISH_PENIS_GIVING, FetishDesire.THREE_LIKE);
			this.setFetishDesire(Fetish.FETISH_MASTURBATION, FetishDesire.THREE_LIKE);
			this.setFetishDesire(Fetish.FETISH_LEG_LOVER, FetishDesire.ONE_DISLIKE);
			this.setFetishDesire(Fetish.FETISH_MASOCHIST, FetishDesire.ONE_DISLIKE);
		}
		
		this.addSpell(Spell.CLOAK_OF_FLAMES);
		this.addSpell(Spell.SOOTHING_WATERS);
		this.addSpellUpgrade(SpellUpgrade.SOOTHING_WATERS_1);
		this.addSpellUpgrade(SpellUpgrade.SOOTHING_WATERS_2);
		this.addSpellUpgrade(SpellUpgrade.SOOTHING_WATERS_3);
		this.addSpell(Spell.RAIN_CLOUD);
		this.addSpell(Spell.ELEMENTAL_WATER);
		this.addSpell(Spell.VACUUM);
		this.addSpell(Spell.ARCANE_CLOUD);
		this.addSpell(Spell.ARCANE_AROUSAL);
		this.addSpell(Spell.TELEPATHIC_COMMUNICATION);
		this.addSpellUpgrade(SpellUpgrade.TELEPATHIC_COMMUNICATION_1);
		
		// Body:
		this.setFootStructure(FootStructure.DIGITIGRADE);
		this.setAgeAppearanceDifferenceToAppearAsAge(25);
		
		// Core:
		this.setHeight(185);
		this.setFemininity(10);
		this.setMuscle(50);
		this.setBodySize(70);
		this.setAttribute(Attribute.MAJOR_ARCANE, 27);
		this.setAttribute(Attribute.MAJOR_PHYSIQUE, 15);
		
		// Coverings:
		this.setSkinCovering(new Covering(BodyCoveringType.getBodyCoveringTypeFromId("innoxia_panther_fur"), CoveringPattern.SPOTTED, CoveringModifier.SHORT, PresetColour.COVERING_TAN, false, PresetColour.COVERING_BLACK, false), true);

		this.setHairCovering(new Covering(BodyCoveringType.HAIR_FELINE_FUR, PresetColour.COVERING_BROWN), true);
		this.setSkinCovering(new Covering(BodyCoveringType.HUMAN, PresetColour.SKIN_PURPLE_DARK), true);
		this.setHairLength(HairLength.TWO_SHORT);
		this.setHairStyle(HairStyle.NONE);
		
		this.setUnderarmHair(BodyHair.FOUR_NATURAL);
		this.setAssHair(BodyHair.THREE_TRIMMED);
		this.setPubicHair(BodyHair.THREE_TRIMMED);
		this.setFacialHair(BodyHair.ZERO_NONE);
		
		// Face:
		this.setFaceVirgin(false);
		this.setLipSize(LipSize.ONE_AVERAGE);
		this.setFaceCapacity(Capacity.FOUR_LOOSE, true);
		this.setTongueLength(TongueLength.THREE_EXTREMELY_LONG.getMedianValue());
		
		// Chest:
		this.setNippleVirgin(true);
		this.setBreastSize(CupSize.FLAT.getMeasurement());
		this.setBreastShape(BreastShape.POINTY);
		this.setNippleSize(NippleSize.ZERO_TINY);
		this.setAreolaeSize(AreolaeSize.ZERO_TINY);
		
		// Ass:
		this.setAssVirgin(false);
		this.setAssBleached(true);
		this.setAssSize(AssSize.TWO_SMALL);
		this.setHipSize(HipSize.TWO_NARROW);
		this.setAssCapacity(Capacity.FOUR_LOOSE, true);
		this.setAssDepth(3);
		this.setAssWetness(Wetness.FOUR_SLIMY);
		this.setAssElasticity(OrificeElasticity.SEVEN_ELASTIC.getValue());
		this.setAssPlasticity(OrificePlasticity.ZERO_RUBBERY.getValue());
		this.addAssOrificeModifier(OrificeModifier.MUSCLE_CONTROL);
		
		// Penis:
		this.setPenisVirgin(false);
		this.setPenisGirth(PenetrationGirth.THREE_AVERAGE);
		this.setPenisSize(17);
		this.setTesticleSize(TesticleSize.THREE_LARGE);
		
		// Demon Modifiers/overrides
		this.setSubspeciesOverride(Subspecies.HALF_DEMON);
		this.setEyeType(EyeType.DEMON_COMMON);
		this.setEyeCovering(new Covering(BodyCoveringType.EYE_DEMON_COMMON, CoveringPattern.EYE_IRISES_HETEROCHROMATIC, PresetColour.EYE_BROWN, false, PresetColour.EYE_RED, false));
		this.setSkinCovering(new Covering(BodyCoveringType.DEMON_COMMON, PresetColour.SKIN_RED_DARK), true);
		this.setHairCovering(new Covering(BodyCoveringType.BODY_HAIR_DEMON, PresetColour.COVERING_GINGER), false);
		this.setWingType(WingType.DEMON_COMMON);
		this.setWingSize(3);
		this.setPenisType(PenisType.DEMON_COMMON);
		this.setTailType(TailType.DEMON_COMMON);
	}
	
	@Override
	public void equipClothing(List<EquipClothingSetting> settings) {
		this.unequipAllClothingIntoVoid(true, true);
		this.clearNonEquippedInventory(false);
		this.unequipMainWeaponIntoVoid(0, false);
		this.unequipOffhandWeaponIntoVoid(0, false);
		
	//	this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing(ClothingType.TORSO_OVER_HOODIE, PresetColour.CLOTHING_BLACK, false), true, this);
	//	this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("nerdlinger_street_joggers_joggers", PresetColour.CLOTHING_GREY, false), true, this);
	//	this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_sock_socks", PresetColour.CLOTHING_WHITE, false), true, this);
	//	this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_foot_low_top_skater_shoes", PresetColour.CLOTHING_BLACK, false), true, this);
				
		
		if(settings.contains(EquipClothingSetting.ADD_ACCESSORIES)) {
			this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing(ClothingType.WRIST_MENS_WATCH, PresetColour.CLOTHING_BLACK, false), true, this);		}
	}
	
	@Override
	public boolean isUnique() {
		return true;
	}
			
	@Override
	public boolean isAbleToBeImpregnated() {
		return true;
	}
	
	@Override
	public void changeFurryLevel() {
	}
	
	@Override
	public DialogueNode getEncounterDialogue() {
		return BevikarDialogue.ENCOUNTER;
	}
	
	@Override
	public void turnUpdate() {
		if(!Main.game.getCharactersPresent().contains(this)) {
			if(Main.game.isFireDayShift()) {
				this.setLocation(WorldType.DOMINION_FIREHOUSE, PlaceType.FIREHOUSE_STAGE_AREA, false);
				
			} else {
				this.setLocation(WorldType.DOMINION_FIREHOUSE2, PlaceType.FIREHOUSE_FLOOR1, false);
			}
		}
	}
		
	@Override
	public SexPace getSexPaceSubPreference(GameCharacter character){
		return SexPace.SUB_EAGER;
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
