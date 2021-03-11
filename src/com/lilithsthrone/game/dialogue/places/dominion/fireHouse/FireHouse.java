package com.lilithsthrone.game.dialogue.places.dominion.fireHouse;

import com.lilithsthrone.game.dialogue.DialogueNode;
import com.lilithsthrone.game.dialogue.places.dominion.DominionPlaces;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.PlaceType;

import java.util.ArrayList;
import java.util.List;

import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.npc.fireHouse.Bevikar;
import com.lilithsthrone.game.character.npc.fireHouse.Sameera;
import com.lilithsthrone.game.character.npc.fireHouse.Priya;

// thanks to Hunman(shark bait), deboucher, and AceXP for the help with this

public class FireHouse {

	public static final DialogueNode OUTSIDE = new DialogueNode("Fire House", "-", false) {
		
		@Override
		public int getSecondsPassed() {
			return DominionPlaces.TRAVEL_TIME_STREET;
		}

		@Override
		public String getContent() {
			StringBuilder sb = new StringBuilder();
			
			sb.append(UtilText.parseFromXMLFile("places/dominion/fireHouse/generic", "OUTSIDE"));
			
			return sb.toString();
		}
		
		@Override
		public Response getResponse(int responseTab, int index) {
			if (index == 1) {
				return new Response("Enter", "Step through the smaller door and enter the fire house.", PlaceType.FIREHOUSE_ENTRANCE.getDialogue(false)){
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
			 return GenericFHResponse(responseTab, index);
	    }
	    @Override
		public String getResponseTabTitle(int index) {
			return getGenericResponseTabTitle(index);
		}
	};
	
	public static final DialogueNode FIREHOUSE_FLOOR2 = new DialogueNode("Floor", "-", false) {

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
		  return GenericFHResponse(responseTab, index);
	    }
		@Override
		public String getResponseTabTitle(int index) {
			return getGenericResponseTabTitle(index);
		}
	};	
		
	public static final DialogueNode FIREHOUSE_STAGE_AREA = new DialogueNode("Staging Area", "-", false) {

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
		  return GenericFHResponse(responseTab, index);
	    }
		@Override
		public String getResponseTabTitle(int index) {
			return getGenericResponseTabTitle(index);
		}
		
	};
	
	public static final DialogueNode FIREHOUSE_SECRETARY = new DialogueNode("Secretary", "-", true) {

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
							"Tell Alissa that you'll be back later and step away from her desk.",
							FIREHOUSE_ENTRANCE) {
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
						"As there's nobody here to talk to, there's nothing else to be done but step away from the desk.",
						FIREHOUSE_ENTRANCE) {
					@Override
					public void effects() 
					{
						Main.game.getPlayer().setLocation(WorldType.DOMINION_FIREHOUSE, PlaceType.FIREHOUSE_ENTRANCE, false);
					}
				};
			}
			return null;
		}
	};
	
	public static final DialogueNode FIREHOUSE_WAITING = new DialogueNode("Waiting Area", "-", false) {

		@Override
		public int getSecondsPassed() {
			return 15;
		}

		@Override
		public String getContent() {
			return "You are in a waiting area";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			return GenericFHResponse(responseTab, index);
		}
		@Override
		public String getResponseTabTitle(int index) {
			return getGenericResponseTabTitle(index);
		}

	};
	
	public static final DialogueNode FIREHOUSE_DOOR = new DialogueNode("Waiting Area", "-", false) {

		@Override
		public int getSecondsPassed() {
			return 15;
		}

		@Override
		public String getContent() {
			return "You are in a door area";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			return null;
		}

	};
	
	public static final DialogueNode FIREHOUSE_OFFICE = new DialogueNode("Office", "-", false) {

		@Override
		public int getSecondsPassed() {
			return 15;
		}

		@Override
		public String getContent() {
			return UtilText.parseFromXMLFile("places/dominion/fireHouse/generic", "FIRE_OFFICE");
		}

		@Override
	    public Response getResponse(int responseTab, int index) {
		  return GenericFHResponse(responseTab, index);
	    }
		@Override
		public String getResponseTabTitle(int index) {
			return getGenericResponseTabTitle(index);
		}

	};
	
	public static final DialogueNode FIREHOUSE_BRIEFING = new DialogueNode("Briefing Room", "-", false) {

		@Override
		public int getSecondsPassed() {
			return 15;
		}

		@Override
		public String getContent() {
			return "You are in a fake briefing room";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			return GenericFHResponse(responseTab, index);
		}
		@Override
		public String getResponseTabTitle(int index) {
			return getGenericResponseTabTitle(index);
		}

	};
	
	public static final DialogueNode FIREHOUSE_BARRACKS = new DialogueNode("Barracks", "-", false) {

		@Override
		public int getSecondsPassed() {
			return 15;
		}

		@Override
		public String getContent() {
			return "You are in a fake barracks room";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			return GenericFHResponse(responseTab, index);
		}
		@Override
		public String getResponseTabTitle(int index) {
			return getGenericResponseTabTitle(index);
		}

	};
	
	public static final DialogueNode FIREHOUSE_LOUNGE = new DialogueNode("Lounge", "-", false) {

		@Override
		public int getSecondsPassed() {
			return 15;
		}

		@Override
		public String getContent() {
			return "You are in a fake lounge";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			return GenericFHResponse(responseTab, index);
		}
		@Override
		public String getResponseTabTitle(int index) {
			return getGenericResponseTabTitle(index);
		}

	};
	
	public static final DialogueNode FIREHOUSE_KITCHEN = new DialogueNode("Kitchen", "-", false) {

		@Override
		public int getSecondsPassed() {
			return 15;
		}

		@Override
		public String getContent() {
			return "You are in a fake kitchen";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			return GenericFHResponse(responseTab, index);
		}
		@Override
		public String getResponseTabTitle(int index) {
			return getGenericResponseTabTitle(index);
		}

	};
	
	public static final DialogueNode FIREHOUSE_SHOWERS_GROUND = new DialogueNode("Showers", "-", false) {

		@Override
		public int getSecondsPassed() {
			return 15;
		}

		@Override
		public String getContent() {
			return "You are in a fake shower room";
		}

		@Override
		public Response getResponse(int responseTab, int index) {
			return GenericFHResponse(responseTab, index);
		}
		@Override
		public String getResponseTabTitle(int index) {
			return getGenericResponseTabTitle(index);
		}

	};
	
	public static final DialogueNode FIREHOUSE_SAMEERA_ROOM = new DialogueNode("Sameera's Room", "-", false) {

		@Override
		public int getSecondsPassed() {
			return 30;
		}

		@Override
		public String getContent() {
			return "This is Sameera's room";
		}

		@Override
        public Response getResponse(int responseTab, int index) {
			return GenericFHResponse(responseTab, index);

        }
		@Override
		public String getResponseTabTitle(int index) {
			return getGenericResponseTabTitle(index);
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

	public static Response GenericFHResponse(int responseTab, int index) {
        Bevikar bevikar = Main.game.isStarted()?(Bevikar) Main.game.getNpc(Bevikar.class):null;
        Sameera sameera = Main.game.isStarted()?(Sameera) Main.game.getNpc(Sameera.class):null;
        Priya   priya   = Main.game.isStarted()?(Priya)   Main.game.getNpc(Priya.class):null;

        for (int i = 0; i < Main.game.getCharactersPresent().size(); i++) {
            if (index == 1 && i == responseTab) {
                if(Main.game.getCharactersPresent().get(i).equals(bevikar)) {
                    if (bevikar.isBusy()) {
                        return new Response(bevikar.getName(), "Talk to this guy.", BevikarDialogue.BUSY);
                    } else {
                        return new Response(bevikar.getName(), "Greet this guy.", BevikarDialogue.GREET);
                    }
                }

                if(Main.game.getCharactersPresent().get(i).equals(sameera)) {
                    if (sameera.isBusy()) {
                        return new Response(sameera.getName(), "Talk to this lady.", SameeraDialogue.BUSY);
                    } else {
                        return new Response(sameera.getName(), "Greet this lady.", SameeraDialogue.GREET);
                    }
                }

                if(Main.game.getCharactersPresent().get(i).equals(priya)) {
                    if (priya.isBusy()) {
                        return new Response(priya.getName(), "Talk to this girl.", PriyaDialogue.BUSY);
                    } else {
                        return new Response(priya.getName(), "Greet this girl.", PriyaDialogue.GREET);
                    }
                }
            }
        }
        return null;
    }
	
	public static String getGenericResponseTabTitle(int index) {
        for (int i = 0; i < Main.game.getCharactersPresent().size(); i++) {
            if (index == i) {
                return Main.game.getCharactersPresent().get(i).getName();
            }
        }
        return null;
    }
	
	public static List<GameCharacter> getFHGroup() {
		  List<GameCharacter> FHGroup = new ArrayList<>(Main.game.getCharactersPresent());
		  FHGroup.removeIf(npc -> Main.game.getPlayer().getParty().contains(npc));
		  return FHGroup;
		    }
	
}