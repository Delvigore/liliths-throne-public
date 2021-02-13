package com.lilithsthrone.game.dialogue.places.dominion.fireHouse;

import com.lilithsthrone.game.dialogue.DialogueNode;
import com.lilithsthrone.game.dialogue.places.dominion.DominionPlaces;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.PlaceType;

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
	
}