import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class ScribbleShop extends JFrame{
	public static ScribbleShop program;
	protected JMenuBar menuBar;
	protected JMenu fileMenu, aboutMenu;
	protected JMenuItem newMenuItem, closeMenuItem, closeAllMenuItem, exitMenuItem, helpMenuItem, authorMenuItem;
	protected static JDesktopPane desktop;
	static int openFrameCount = 0;
	public ScribbleShop(){
		super("ScribbleShop - Putti O. 5431270021");
		initGUI();
	}
	

	public void initGUI(){
		setupMenu();
		desktop = new JDesktopPane();
		setContentPane(desktop);
	}

	
	public static void createFrame(){
		ScribblerInternalFrame frame1 = new ScribblerInternalFrame();
		frame1.setSize(500,600);
		frame1.setVisible(true);
		desktop.add(frame1);
		try{
			frame1.setSelected(true);
		} catch (Exception e){}
		
	}
	

	public void setupMenu(){
		menuBar = new JMenuBar();
		
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		newMenuItem = new JMenuItem("New");
		fileMenu.add(newMenuItem);
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.CTRL_MASK));
		newMenuItem.addActionListener(new MenuListener());
		
		
		fileMenu.addSeparator();
		
		closeMenuItem = new JMenuItem("Close");
		closeAllMenuItem = new JMenuItem("Close All");
		fileMenu.add(closeMenuItem);
		fileMenu.add(closeAllMenuItem);
		closeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
				ActionEvent.CTRL_MASK));
		closeAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				ActionEvent.CTRL_MASK));
		closeMenuItem.addActionListener(new MenuListener());
		closeAllMenuItem.addActionListener(new MenuListener());
		
		
		fileMenu.addSeparator();
		
		exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(exitMenuItem);
		exitMenuItem.addActionListener(new MenuListener());
		
		
		aboutMenu = new JMenu("About");
		menuBar.add(aboutMenu);
		
		helpMenuItem = new JMenuItem("Help");
		authorMenuItem = new JMenuItem("Author");
		aboutMenu.add(helpMenuItem);
		aboutMenu.add(authorMenuItem);
		helpMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,0));
		helpMenuItem.addActionListener(new MenuListener());
		authorMenuItem.addActionListener(new MenuListener());
		
		
		setJMenuBar(menuBar);
	}
	

	private static void createAndShowGUI(){
		program = new ScribbleShop();
		program.setPreferredSize(new Dimension(1000,800));
		program.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		program.pack();
		// Position the program at the center of screen
		program.setLocationRelativeTo(null);
		program.setVisible(true);
	}

	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}


