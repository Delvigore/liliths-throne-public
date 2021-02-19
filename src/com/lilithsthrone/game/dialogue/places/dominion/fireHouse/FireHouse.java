package com.lilithsthrone.game.dialogue.places.dominion.fireHouse;

import com.lilithsthrone.game.dialogue.DialogueNode;
import com.lilithsthrone.game.dialogue.places.dominion.DominionPlaces;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.PlaceType;

// thanks to Hunman(shark bait) and deboucher for the help with this

public class FireHouse {

	public static final DialogueNode OUTSIDE = new DialogueNode("Fire house", "-", false) {
		
		@Override
		public int getSecondsPassed() {
			return DominionPlaces.TRAVEL_TIME_STREET;
		}

		@Override
		public String getContent() {
			return "You are in front of a fire house";
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Enter", "Step through the entrance and enter the fire house.", PlaceType.FIREHOUSE_ENTRANCE.getDialogue(false)){
					@Override
					public void effects() {
						Main.game.getPlayer().setLocation(WorldType.DOMINION_FIREHOUSE, PlaceType.FIREHOUSE_ENTRANCE, false);
					}
				};

			} else {
				return null;
			}
		}
	};
	
	public static final DialogueNode FIREHOUSE_ENTRANCE = new DialogueNode("Entrance", "-", false) {

		@Override
		public int getSecondsPassed() {
			return 30;
		}

		@Override
		public String getContent() {
			return "You went through a door";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Exit", "Head out through the revolving glass doors back into Dominion.", OUTSIDE) {
					@Override
					public void effects() {
						Main.game.getPlayer().setLocation(WorldType.DOMINION, PlaceType.DOMINION_FIREHOUSE, false);
					}
				};
			}
			return null;
		}
	};

	public static final DialogueNode FIREHOUSE_FLOOR1 = new DialogueNode("Floor", "-", false) {

		@Override
		public int getSecondsPassed() {
			return 15;
		}

		@Override
		public String getContent() {
			return "You are in a fake firehouse";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			return null;
		}

	};
	
	public static final DialogueNode FIREHOUSE_STAGE_AREA = new DialogueNode("Floor", "-", false) {

		@Override
		public int getSecondsPassed() {
			return 15;
		}

		@Override
		public String getContent() {
			return "You are in a staging area";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			return null;
		}

	};
	
	public static final DialogueNode FIREHOUSE_SECRETARY = new DialogueNode("Floor", "-", true) {

		@Override
		public int getSecondsPassed() {
			return 15;
		}

		@Override
		public String getContent() {
			StringBuilder sb = new StringBuilder();
			
			sb.append(UtilText.parseFromXMLFile("places/dominion/fireHouse/generic", "ENTRANCE_SECRETARY_TALK"));
			
			return sb.toString();
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if(!Main.game.isFireDayShift()) {
				if(index==0) {
					return new Response("Step back",
							"As there's nobody here to talk to, there's nothing else to be done but step away from the desk.",
							FIREHOUSE_SECRETARY) {
						@Override
						public void effects() {
							Main.game.getPlayer().setLocation(WorldType.DOMINION_FIREHOUSE, PlaceType.FIREHOUSE_ENTRANCE, false);
						}
					};
					
				} 
				return null;
			}
			
			if(index==0) {
				return new Response("Step back",
						"Tell Alissa that you'll be back later and step away from her desk.",
						FIREHOUSE_ENTRANCE) {
					@Override
					public void effects() 
					{
						Main.game.getTextStartStringBuilder().append(UtilText.parseFromXMLFile("places/dominion/fireHouse/generic", "FIREHOUSE_SECRETARY_LEAVE"));
						Main.game.getPlayer().setLocation(WorldType.DOMINION_FIREHOUSE, PlaceType.FIREHOUSE_ENTRANCE, false);
					}
				};
			}
			return null;
		}
	};
	
	public static final DialogueNode FIREHOUSE_PLACEHOLDER = new DialogueNode("Floor", "-", false) {

		@Override
		public int getSecondsPassed() {
			return 15;
		}

		@Override
		public String getContent() {
			return "You are in a placeholder area";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			return null;
		}

	};
	
	public static final DialogueNode FIREHOUSE_STAIRS_UP = new DialogueNode("Stairs", "-", false) {

		@Override
		public int getSecondsPassed() {
			return 30;
		}

		@Override
		public String getContent() {
			return "Stairs to first floor";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Upstairs", "Go upstairs to the first floor.", FIREHOUSE_STAIRS_DOWN) {
					@Override
					public void effects() {
						Main.game.getPlayer().setLocation(WorldType.DOMINION_FIREHOUSE2, PlaceType.FIREHOUSE_STAIRS_DOWN, false);
					}
				};
			}
			return null;
		}
	};
	
	public static final DialogueNode FIREHOUSE_STAIRS_DOWN = new DialogueNode("Stairs", "-", false) {

		@Override
		public int getSecondsPassed() {
			return 30;
		}

		@Override
		public String getContent() {
			return "Stairs to ground floor";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Downstairs", "Go downstairs to the ground floor.", FIREHOUSE_STAIRS_UP) {
					@Override
					public void effects() {
						Main.game.getPlayer().setLocation(WorldType.DOMINION_FIREHOUSE, PlaceType.FIREHOUSE_STAIRS_UP, false);
					}
				};
			};
			return null;
		}
	};
	
}