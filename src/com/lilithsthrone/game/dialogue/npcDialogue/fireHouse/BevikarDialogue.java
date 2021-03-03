package com.lilithsthrone.game.dialogue.npcDialogue.fireHouse;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


import com.lilithsthrone.game.character.npc.NPC;
import com.lilithsthrone.game.dialogue.DialogueNode;
import com.lilithsthrone.game.dialogue.npcDialogue.fireHouse.BevikarDialogue;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.main.Main;

/**
 * cobbled together by Delvigore, with assistance from deboucher 
 */

public class BevikarDialogue {

	private static NPC getBevikar() {
		return Main.game.getActiveNPC();
	}
	
public static final DialogueNode ENCOUNTER = new DialogueNode("Bevikar", "", true) {
		
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("characters/dominion/fireHouse/Bevikar", "INTRO_GREET");
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if(index==1) {
				return new Response("Small talk", "Talk with this guy.", ENCOUNTER) {
					@Override
					public void effects() {
						Main.game.getTextStartStringBuilder().append(UtilText.parseFromXMLFile("characters/dominion/fireHouse/Bevikar", "SMALL_TALK"));
					}
				};
				
			} else if(index == 2) {
				return new Response("Leave", "Bid this guy goodbye", ENCOUNTER) {
				
				@Override
				public DialogueNode getNextDialogue() {
					return Main.game.getDefaultDialogue(false);
				}
				@Override
				public void effects() {
					Main.game.getTextStartStringBuilder().append(UtilText.parseFromXMLFile("characters/dominion/fireHouse/Bevikar", "DECLINE"));
					}
				};
			}
		else {
		return null;
		}
	}
	};

}