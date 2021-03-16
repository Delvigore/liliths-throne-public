package com.lilithsthrone.game.dialogue.npcDialogue.fireHouse;

import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.npc.fireHouse.Bruno;
import com.lilithsthrone.game.dialogue.DialogueNode;
import com.lilithsthrone.game.dialogue.places.dominion.fireHouse.FireHouse;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.dialogue.responses.ResponseSex;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.game.sex.managers.universal.SMGeneric;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.Util;

/**
 * cobbled together by Delvigore, put in a working state with the help and assistance from deboucher and AceXP
 */

public class BrunoDialogue {
	
	public static final DialogueNode GREET = new DialogueNode("Bruno", "", true) {
		
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("characters/dominion/fireHouse/Bruno", "INTRO_GREET");
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			Main.game.getNpc(Bruno.class).setPlayerKnowsName(true);
			if(index==1) {
				return new Response("Small talk", "Talk with this guy.", SMALL_TALK) {
					@Override
					public void effects() {
						Main.game.getTextStartStringBuilder().append(UtilText.parseFromXMLFile("characters/dominion/fireHouse/Bruno", "SMALL_TALK"));
					}
				};
			} else if(index==2) {
					return new ResponseSex("Dom Sex", "Dominantly have sex with Bruno.",
							true, true,
							new SMGeneric(
									Util.newArrayListOfValues(Main.game.getPlayer()),
									Util.newArrayListOfValues(Main.game.getNpc(Bruno.class)),
									null,
									FireHouse.getFHGroup()) {
								@Override
								public boolean isSelfTransformDisabled(GameCharacter character) {
									return character.equals(Main.game.getNpc(Bruno.class));
								}
							},
							END_SEX,
							UtilText.parseFromXMLFile("characters/dominion/fireHouse/Bruno", "DOM_SEX"));
					
				} else if(index==3) {
					return new ResponseSex("Sub Sex", "Let Bruno take charge and be dominantly fucked by him.",
							true, true,
							new SMGeneric(
									Util.newArrayListOfValues(Main.game.getNpc(Bruno.class)),
									Util.newArrayListOfValues(Main.game.getPlayer()),
									FireHouse.getFHGroup(),
									null) {
								@Override
								public boolean isSelfTransformDisabled(GameCharacter character) {
									return character.equals(Main.game.getNpc(Bruno.class));
								}
							},
							END_SEX,
							UtilText.parseFromXMLFile("characters/dominion/fireHouse/Bruno", "SUB_SEX"));
			} else if(index == 4) {
				return new Response("Leave", "Bid this guy goodbye", GREET) {
				
				@Override
				public DialogueNode getNextDialogue() {
					return Main.game.getDefaultDialogue(false);
				}
				@Override
				public void effects() {
					Main.game.getTextStartStringBuilder().append(UtilText.parseFromXMLFile("characters/dominion/fireHouse/Bruno", "DECLINE"));
					}
				};
			}
		else {
		return null;
		}
	}
	};

	public static final DialogueNode SMALL_TALK = new DialogueNode("Bruno", "", true) {
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if(index==1) {
				return new Response("Small talk", "Talk with this guy.", SMALL_TALK) {
					@Override
					public void effects() {
						Main.game.getTextStartStringBuilder().append(UtilText.parseFromXMLFile("characters/dominion/fireHouse/Bruno", "SMALL_TALK"));
					}
				};
			} else if(index==2) {
					return new ResponseSex("Dom Sex", "Dominantly have sex with Bruno.",
							true, true,
							new SMGeneric(
									Util.newArrayListOfValues(Main.game.getPlayer()),
									Util.newArrayListOfValues(Main.game.getNpc(Bruno.class)),
									null,
									FireHouse.getFHGroup()) {
								@Override
								public boolean isSelfTransformDisabled(GameCharacter character) {
									return character.equals(Main.game.getNpc(Bruno.class));
								}
							},
							END_SEX,
							UtilText.parseFromXMLFile("characters/dominion/fireHouse/Bruno", "DOM_SEX"));
					
				} else if(index==3) {
					return new ResponseSex("Sub Sex", "Let Bruno take charge and be dominantly fucked by him.",
							true, true,
							new SMGeneric(
									Util.newArrayListOfValues(Main.game.getNpc(Bruno.class)),
									Util.newArrayListOfValues(Main.game.getPlayer()),
									FireHouse.getFHGroup(),
									null) {
								@Override
								public boolean isSelfTransformDisabled(GameCharacter character) {
									return character.equals(Main.game.getNpc(Bruno.class));
								}
							},
							END_SEX,
							UtilText.parseFromXMLFile("characters/dominion/fireHouse/Bruno", "SUB_SEX"));
			} else if(index == 4) {
				return new Response("Leave", "Bid this guy goodbye", GREET) {
				
				@Override
				public DialogueNode getNextDialogue() {
					return Main.game.getDefaultDialogue(false);
				}
				@Override
				public void effects() {
					Main.game.getTextStartStringBuilder().append(UtilText.parseFromXMLFile("characters/dominion/fireHouse/Bruno", "DECLINE"));
					}
				};
			}
		else {
		return null;
		}
	}
		@Override
		public String getContent() {
			//Auto-generated method stub
			return "";
		}
	};
	
	public static final DialogueNode END_SEX = new DialogueNode("", "", true) {
		
		@Override
		public int getSecondsPassed() {
			return 5*60;
		}
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("characters/dominion/fireHouse/Bruno", "END_SEX");
		}
		@Override
		public Response getResponse(int responseTab, int index) {
			if(index==1) {
				return new Response("Leave", "Step out into the corridor and continue on your way...", FireHouse.FIREHOUSE_FLOOR1) {
					@Override
					public DialogueNode getNextDialogue() {
						return Main.game.getDefaultDialogue(false);
					}
				};
			}
			return null;
		}
	};
	
public static final DialogueNode BUSY = new DialogueNode("", "", true) {
				
		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("characters/dominion/fireHouse/Bruno", "BUSY");
		}
		@Override
		public Response getResponse(int responseTab, int index) {
			if(index==1) {
				return new Response("Leave", "Step out into the corridor and continue on your way...", FireHouse.FIREHOUSE_FLOOR1) {
					@Override
					public DialogueNode getNextDialogue() {
						return Main.game.getDefaultDialogue(false);
					}
				};
			}
			return null;
		}
	};
	
}