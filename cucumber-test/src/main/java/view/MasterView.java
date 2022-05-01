package view;

import controller.MasterController;
import property_changes.ActivationPhaseEndEvent;
import property_changes.GameWinEvent;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import animations.Animation;
import animations.HealthChangeAnimation;

import animations.WinScreenAnimation;
import board.Game;

import property_changes.HealthChangeEvent;
import property_changes.IPropertyChangeEvent;
import property_changes.IPropertyChangeListener;
import utils.GridBagLayoutUtils;

// This is the main game window
public class MasterView extends JFrame implements IPropertyChangeListener {
	
	private static final long serialVersionUID = 3L;
	
	private MasterController controller;

	
	private BoardPanel boardPanel;
	private JPanel cardPanel;
	private StatusPanel statusPanel;
	
	private Queue<Animation> animationQueue = new ArrayDeque<>();
	
	private BlackScreen blackScreen;
	
	public MasterView(MasterController masterController, Game game) {
		this.controller = masterController;
		initGUI(game);
	}
	

	private void initGUI(Game game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RoboRally Game of " + controller.playerCount + " players on " + controller.difficulty + " difficulty");
		
		setLayout(new GridBagLayout());
		
		boardPanel = new BoardPanel(game.getBoard(), this);
		cardPanel = new CardPanel(this, controller);
		statusPanel = new StatusPanel(game.getNumPlayers());
		blackScreen = new BlackScreen(this);
		
		addElements();
		pack();
		
		displayBlackScreen(controller.getCurrentPlayer()+1);
		
		setVisible(true);
		
		// maximize the window
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	
	public void displayBlackScreen(int playerTurn) {
		removeElements();
		addBlackScreen(playerTurn);
	}
	
	public void hideBlackScreen() {
		removeBlackScreen();
		addElements();
	}
	
	public void displayWinScreen(int winningPlayerNum) {
		removeElements();
		addWinScreen(winningPlayerNum);
	}

	private void addElements() {
		setLayout(new GridBagLayout());
		add(boardPanel, GridBagLayoutUtils.constraint(0, 0, 10));
		add(cardPanel, GridBagLayoutUtils.constraint(0, 1, 10));
		
		// The status panel uses a custom constraint
		GridBagConstraints spConstraint = new GridBagConstraints();
		spConstraint.gridx = 1;
		spConstraint.gridy = 0;
		spConstraint.fill = GridBagConstraints.VERTICAL;
		add(statusPanel, spConstraint);
		
		revalidate();
		repaint();
	}
	
	private void removeElements() {
		remove(boardPanel);
		remove(cardPanel);
		remove(statusPanel);
	}
	
	private void addBlackScreen(int playerTurn) {
		setLayout(new BorderLayout()); // So that the black screen can take up the whole window
		add(blackScreen, BorderLayout.CENTER);
		blackScreen.setPlayerTurnText(playerTurn);
		revalidate();
		repaint();
	}
	
	private void addWinScreen(int winningPlayerNum) {
		setLayout(new BorderLayout()); // So that the win screen can take up the whole window
		add(new WinScreen(this, winningPlayerNum), BorderLayout.CENTER);
		revalidate();
		repaint();
	}
	
	private void removeBlackScreen() {
		remove(blackScreen);
	}
	
	public void displayCardPanelView(CardPanel cp){
		displayBlackScreen(controller.getCurrentPlayer()+1);
		cardPanel = cp;
//		add(cardPanel, GridBagLayoutUtils.constraint(0, 1, 10));
//		revalidate();
//		repaint();
		
		
	}
	
	public void removeCardPanel()
	{
		remove(cardPanel);
		revalidate();
		repaint();
	}


	@Override
	public void propertyChange(IPropertyChangeEvent pce) {
		if (pce instanceof HealthChangeEvent) {
			HealthChangeEvent hce = (HealthChangeEvent) pce;
			enqueueAnimation(new HealthChangeAnimation(statusPanel, hce.getRobotNum(), hce.getHealth()));
		} else if (pce instanceof ActivationPhaseEndEvent) {
			playAllAnimations();
		} else if (pce instanceof GameWinEvent) {
			GameWinEvent gwe = (GameWinEvent) pce;
			enqueueAnimation(new WinScreenAnimation(gwe.getWinningPlayerNum(), this));
		} else {
			boardPanel.propertyChange(pce);
		}
	}
	
	public void enqueueAnimation(Animation a) {
		animationQueue.add(a);
	}
	
	/**
	 * This method dequeues an animation from animationQueue, and creates a new thread (SwingWorker) to play this animation. Once the thread
	 * is finished, this method is called again, and the process repeats until the queue is empty.
	 * 
	 * The method first initializes the animation. Then, it creates a worker thread, which uses SwingUtilities.invokeLater to tell the Event
	 * Dispatch Thread (the main thread, in which this method is called) to call establishNextFrame on the Animation. It then sleeps long
	 * enough to maintain 60 frames per second, and repeats this as many times as the animation requires, given by the getNumFrames method.
	 * Finally, it finalizes the animation, repaints the MasterView, and calls the method recursively, all in the Event Dispatch Thread.
	 * 
	 * All of this is done because recommendations state that sleeps should never be done on the Event Dispatch Thread, but also that
	 * GUI updates should always be done on this thread. Moreover, we tried making the Event Dispatch Thread sleep, and ran into
	 * rendering glitches.
	 */
	public void playAllAnimations() {
		if (animationQueue.size() != 0) {
			Animation animation = animationQueue.remove();
			animation.initializeAnimation();
			
			int frames = animation.getNumFrames();
			System.out.println("Playing animation " + animation.getClass());
			System.out.println("Running for " + frames + " frames");
			
			
			
			new SwingWorker<Void, Void>() {
				@Override
				public Void doInBackground() {
					for (int i = 0; i < frames; i++) {
						try {
							SwingUtilities.invokeLater(() -> {
								animation.establishNextFrame();
								repaint();
							});
							Thread.sleep(1000 / Animation.FRAMES_PER_SECOND);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					SwingUtilities.invokeLater(() -> {
						System.out.println("finishing thread for " + animation.getClass());
						System.out.flush();
						animation.finalizeAnimation();
						repaint();
						playAllAnimations();
					});
					return null;
				}
			}.execute();
		} else {
			System.out.println("Animations finished");
			controller.beginProgrammingPhase();
		}
	}

}
