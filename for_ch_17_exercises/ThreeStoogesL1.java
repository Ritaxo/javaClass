package for_ch_17_exercises;// Three Stooges Application// your name// the dateimport java.awt.*;// we need this one for Componentsimport java.awt.event.*;// we need this one for ActionListenerimport javax.swing.*;// we need this one for components 					// whose class name begins with a J  /** * This is the application program for the first lab in CS 63. * Students learn how to add a JButton and its ActionListener. *  * @author Barbara Li Santi */public class ThreeStoogesL1 extends JFrame {	/**	 * displays instructions for the user	 */	private JLabel instructionsL; 		/**	 * User clicks this button to display Moe's phrase.	 */	private JButton moeB;	/**	 * User clicks this button to display Larry's phrase.	 */	private JButton larryB;	/**	 * User clicks this button to display Curly's phrase.	 */	private JButton curlyB;  												/**	 * indicates that the Stooge phrases will appear in the scroll pane 		 */	private JLabel resultsL; 							/**	 * where the Stooge phrases appear and	 * whose view is controlled by the scroll pane	 */	private JTextArea resultsTA; 											/**	 * controls view of the text area	 */	private JScrollPane resultsSP;   															/**	 * This variable holds a reference to the content pane so that 	 * getContentPane() needs to be called only once.	 */	private Container myCP; 		/**	 * This is the constructor of this application.	 */	public ThreeStoogesL1() {		super("Three Stooges");		setSize(300,330);		myCP = getContentPane();		myCP.setLayout(new FlowLayout());		myCP.setBackground(Color.CYAN);				instructionsL = new JLabel("Press a Stooge button to get a phrase");		instructionsL.setOpaque(true);		instructionsL.setBackground(Color.WHITE);		myCP.add(instructionsL);						moeB = new JButton("Moe"); 		moeB.setForeground(Color.BLUE);		moeB.addActionListener(new MoeBHandler());		myCP.add(moeB); 				larryB = new JButton("Larry"); 		larryB.setForeground(Color.RED); 		larryB.addActionListener(new LarryBHandler());		myCP.add(larryB); 				curlyB = new JButton("Curly"); 		curlyB.setForeground(Color.GREEN); 		curlyB.addActionListener(new CurlyBHandler());		myCP.add(curlyB); 				resultsL = new JLabel("         Results         "); 		resultsL.setOpaque(true);		resultsL.setBackground(Color.yellow); 		myCP.add(resultsL);				resultsTA = new JTextArea(); 		resultsTA.setBackground(Color.PINK);		resultsSP = 			new JScrollPane(resultsTA,						JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);		resultsSP.setPreferredSize(new Dimension(200,200));		myCP.add(resultsSP);  		setVisible(true);		addWindowListener(new WindowAdapter() {			public void windowClosing(WindowEvent e) {				System.exit(0);			}//windowClosing		}); //end of definition of WindowAdapter and semicolon to end the line 	}//ThreeStoogesL1 constructor		/**	 * ActionListener for Larry's JButton	 */	public class LarryBHandler implements ActionListener {		/**		 * action to be performed when Larry's button is clicked		 */		public void actionPerformed(ActionEvent e) {			resultsTA.append("Wise Guy!\n");		}// actionPerformed	}// LarryBHandler		/**	 * ActionListener for Moe's JButton	 */	public class MoeBHandler implements ActionListener {		/**		 * action to be performed when Moe's button is clicked		 */		public void actionPerformed(ActionEvent e) {			resultsTA.append("Knuckle Heads!\n");		}// actionPerformed	}// MoeBHandler		/**	 * ActionListener for Curly's JButton	 */	public class CurlyBHandler implements ActionListener {		/**		 * action to be performed when Curly's button is clicked		 */		public void actionPerformed(ActionEvent e) {			resultsTA.append("Nyuck Nyuck!\n");		}// actionPerformed	}// CurlyBHandler		/**	 * The main method is where execution begins.	 * @param args parameter is not used since we are not	 * working at the command line.	 */	public static void main (String args[]) {		ThreeStoogesL1 myAppF = new ThreeStoogesL1(); 	} //main method	}// ThreeStoogesL1 class		