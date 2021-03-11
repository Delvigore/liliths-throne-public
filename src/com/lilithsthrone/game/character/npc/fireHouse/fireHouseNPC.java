package com.lilithsthrone.game.character.npc.fireHouse;

import com.lilithsthrone.game.character.EquipClothingSetting;
import com.lilithsthrone.game.character.gender.Gender;
import com.lilithsthrone.game.character.npc.NPC;
import com.lilithsthrone.game.character.npc.NPCGenerationFlag;
import com.lilithsthrone.game.character.persona.NameTriplet;
import com.lilithsthrone.game.character.race.AbstractSubspecies;
import com.lilithsthrone.game.character.race.RaceStage;
import com.lilithsthrone.game.dialogue.DialogueNode;
import com.lilithsthrone.game.inventory.CharacterInventory;
import com.lilithsthrone.game.inventory.clothing.ClothingType;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.colours.PresetColour;
import com.lilithsthrone.world.AbstractWorldType;
import com.lilithsthrone.world.places.AbstractPlaceType;

import java.time.Month;
import java.util.List;

/**
 * @author AceXP 
 */

public abstract class fireHouseNPC extends NPC {
    protected fireHouseNPC(boolean isImported, NameTriplet nameTriplet, String surname, String description, int age, Month birthMonth, int birthDay, int level, Gender startingGender, AbstractSubspecies startingSubspecies, RaceStage stage, CharacterInventory inventory, AbstractWorldType worldLocation, AbstractPlaceType startingPlace, boolean addedToContacts, NPCGenerationFlag... generationFlags) {
        super(isImported, nameTriplet, surname, description, age, birthMonth, birthDay, level, startingGender, startingSubspecies, stage, inventory, worldLocation, startingPlace, addedToContacts, generationFlags);
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
        return null;
    }

    @Override
    public void resetDefaultMoves() {
        this.clearEquippedMoves();
        equipMove("strike");
        equipMove("offhand-strike");
        equipMove("twin-strike");
        equipMove("block");
        this.equipAllSpellMoves();
    }

    @Override
    public void equipClothing(List<EquipClothingSetting> settings) {
        this.unequipAllClothingIntoVoid(true, true);
        this.clearNonEquippedInventory(false);
        this.unequipMainWeaponIntoVoid(0, false);
        this.unequipOffhandWeaponIntoVoid(0, false);

        if (this.isFeminine()) {
            this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing(ClothingType.GROIN_BOYSHORTS, PresetColour.CLOTHING_BLACK, false), true, this);
            this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing(ClothingType.CHEST_SPORTS_BRA, PresetColour.CLOTHING_BLACK, false), true, this);
            this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_sock_trainer_socks", PresetColour.CLOTHING_BLACK, false), true, this);
        } else {
            this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing(ClothingType.GROIN_BOXERS, PresetColour.CLOTHING_BLACK, false), true, this);
            this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_sock_socks", PresetColour.CLOTHING_BLACK, false), true, this);
        }
        this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_leg_cargo_trousers", PresetColour.CLOTHING_BLACK, false), true, this);
        this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("dsg_eep_ptrlequipset_lsldshirt", PresetColour.CLOTHING_RED, PresetColour.CLOTHING_BLACK, PresetColour.CLOTHING_BRASS, false), true, this);
        this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_foot_work_boots", PresetColour.CLOTHING_BLACK, false), true, this);

        if(settings.contains(EquipClothingSetting.ADD_ACCESSORIES)) {
            if (this.isFeminine()) {
                this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing(ClothingType.WRIST_WOMENS_WATCH, PresetColour.CLOTHING_BLACK, false), true, this);
            } else {
                this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing(ClothingType.WRIST_MENS_WATCH, PresetColour.CLOTHING_BLACK, false), true, this);
            }
        }
    }

    public boolean isBusy() {return true;}
}

