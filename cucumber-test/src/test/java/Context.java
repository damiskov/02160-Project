import board.Board;
import board.Game;
import environment_elements.ChainingPanel;
import environment_elements.Checkpoint;

import java.util.ArrayList;

import board.*;
import piece_basics.*;
import environment_elements.ConveyorBelt;
import environment_elements.Fire;
import environment_elements.Gear;
import environment_elements.HealthStation;
import environment_elements.Laser;
import environment_elements.OilSpill;
import environment_elements.Pit;
import environment_elements.RespawnPoint;
import environment_elements.ReversalPanel;
import environment_elements.Teleporter;
import environment_elements.Wall;
import piece_basics.Robot;
import cards.*;
import player.Player;

public class Context {
	Board board;
	Robot robot;
	Robot robot2; //needed for the chaining panel //also used in robot bumping
	ConveyorBelt conveyorBelt;
	Gear gear;
	HealthStation healthStation;
	Pit pit;
	Wall wall;
	Game game;
	
	

	RespawnPoint respawnPoint;
	RespawnPoint respawnPoint2;
	Laser laser;
	Teleporter sending;
	Teleporter receiving;
	OilSpill spill;
	Fire fire;
	ReversalPanel revpan;
	ChainingPanel chainpan;
	ChainingPanel chainpan2;
	Checkpoint checkpoint;
	
	Player player;
	Player player1;
	Player host;
	Button startButton;
	Piece piece;
	Card card;
	Difficulty d;
	
	Deck deck;
	Hand hand;
	Program program;
	ArrayList<Card> gram;

}
