package environment_elements;

import board.IBoard;
import piece_basics.EnvironmentElement;
import piece_basics.IRegisterActor;
import piece_basics.Robot;

public class ReversalPanel extends EnvironmentElement implements IRegisterActor{

	@Override
	public void performRegisterAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getActorClassID() {
		return "reversal_panel";
	}

}
