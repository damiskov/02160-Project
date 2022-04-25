package property_changes;

public class GameWinEvent implements IPropertyChangeEvent {

	private final int winningPlayerNum;

	public GameWinEvent(int winningPlayerNum) {
		this.winningPlayerNum = winningPlayerNum;
	}

	public int getWinningPlayerNum() {
		return winningPlayerNum;
	}
	
}
