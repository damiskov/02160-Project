
import environment_elements.Chaining_Panel;
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
import environment_elements.Reversal_Panel;
import environment_elements.Teleporter;
import environment_elements.Wall;
import piece_basics.Robot;

public class Context {
	Board board;
	Robot robot;
	Robot robot2; //needed for the chaining panel
	ConveyorBelt conveyorBelt;
	Gear gear;
	HealthStation healthStation;
	Pit pit;
	Wall wall;
	RespawnPoint respawnPoint;
	Laser laser;
	Teleporter sending;
	Teleporter receiving;
	OilSpill spill;
	Fire fire;
	Reversal_Panel revpan;
	Chaining_Panel chainpan;
	Player player;
	Player host;
	Button startButton;
	Game game;
	Piece piece;
}
