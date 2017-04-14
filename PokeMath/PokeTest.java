//Sidd Rao
//4/1/16
//PokeTest.java is the first testing iteration of akhl and i's pokemath game
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException; 
public class PokeTest extends JFrame
{
	private PanelHolder pHolder;
        private CardLayout cards;
        private StartPanel sp;
        private CreationPanel cp;
        private PythagPanel pp;
        private PythagPanel1 pp1;
        private BattlePanel bp;
        private PythagPanel2 pp2;
        private PythagPanel3 pp3;
        private PythagPanel4 pp4;
        private PythagPanel5 pp5;
        private PythagPanel6 pp6;
        private PythagPanel7 pp7;
        private PythagPanel8 pp8;
        private PreTut pret;
        private TutorialPanel tp;
        private CircPanel circp;
        private AreaPanel ap;
        private RadiusPanel rp;
        private EndPanel ep;
        
	
	
	public static void main(String[] args)
	{
		PokeTest pt = new PokeTest();
	}
	public PokeTest()
	{
		super("PokeTest");
	//	setLayout(new BorderLayouyt());
		setSize( 1500, 850);		//will change later		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setLocation(0,0);
		setResizable(true);

		pHolder = new PanelHolder();
		cards = new CardLayout();
		
		
		pHolder.setLayout(cards);
		
		sp = new StartPanel();
                cp = new CreationPanel();                                                                                /// AKHIL, ADD TUTORIALPANEL INSTANCE (TP) AS A
                tp = new TutorialPanel();      
                bp = new BattlePanel();     
                pp = new PythagPanel();
                pp1 = new PythagPanel1();                           
               pp2 = new PythagPanel2();
               pp3 = new PythagPanel3();
               pp4 = new PythagPanel4();
               pp5 = new PythagPanel5();
               pp6 = new PythagPanel6();
               pp7 = new PythagPanel7();
               pp8 = new PythagPanel8();
               pret = new PreTut();
               circp = new CircPanel();
               ap = new AreaPanel();
               rp = new RadiusPanel();
               ep = new EndPanel();
		
		
		 pHolder.add(sp, "Start Panel");
                pHolder.add(pp, "PythagPanel");
                pHolder.add(pp1, "PythagPanel1");
                pHolder.add(pp2, "PythagPanel2");
                pHolder.add(pp3, "PythagPanel3");
                pHolder.add(pp4, "PythagPanel4");
                pHolder.add(pp5, "PythagPanel5");
                pHolder.add(pp6, "PythagPanel6");
                pHolder.add(pp7, "PythagPanel7");
                pHolder.add(pp8, "PythagPanel8");
                pHolder.add(cp, "Creation Panel");
                pHolder.add(pret, "PreTut");
                pHolder.add(tp, "Tutorial Panel");
                pHolder.add(bp, "Battle Panel");
                pHolder.add(circp, "Circumference Panel");
                pHolder.add(ap, "Area Panel");
                pHolder.add(rp, "Radius Panel");
                pHolder.add(ep, "End Panel");
		add(pHolder);
	

		setVisible(true);	
	}

class PanelHolder extends JPanel 
{        
	public PanelHolder()
	{
		setBackground(Color.BLUE);
	}                                //  Panel holder (Holds all the Panels,for the Card Layout)(essentially)
}    



	class StartPanel extends JPanel
	{
		
		 boolean dirPressed;                //make proper boolean variables for directions, start button, and the scores button, so it can can conduct the corresponding actions
		 boolean startPressed;
		 boolean hsPressed;
		 String tempString;
		 Image PokeMathLogo = Toolkit.getDefaultToolkit().getImage("PokeLogo.JPG");//getsImage from my computer using the get DefaultToolKit
		 Image PokeBack1 = Toolkit.getDefaultToolkit().getImage("PokeBack1.png");
				//        g.drawImage(PokeMathLogo, 60,150,800,625,this);
				
		boolean squirtleChosen;
		boolean charizardChosen;
		boolean bulbasaurChosen;
		
		JTextField enterName;
		String name;
		boolean somethingEntered;

		 public StartPanel() 
		 {
		   setLayout(null);                                //Use BorderLayout in main panel. Incorporate Card Layout for all the others
			//Card Layout made( needs more pseudocode)
			setBackground(Color.WHITE);
			Font titleFont = new Font("Serif", Font.BOLD, 20);                //Set Fonts
			 setFont(titleFont);
			BottomPanel bp = new BottomPanel();                //Instantiate the Start Panel
			bp.setBounds(0,600,1500,50);
			 add(bp);
			 
			 enterName = new JTextField("Enter Name");
			 SPTF sptf = new SPTF();
			 enterName.addActionListener(sptf);
			 enterName.setBounds(0,0,0,0);
			 add(enterName);

		  }
	 
		public void paintComponent(Graphics g) 
		{                //graphics method header
			 super.paintComponent(g);                        // draw Images first, draws background then Pokemath logo
			 g.drawImage(PokeBack1, 0,0,1500,850,this);
			g.drawImage(PokeMathLogo, 600,10,250,130,this);
			 //g.drawImage(PokeBack, 0,0,600,400,this);
			 if (startPressed) 
			 {                                //boolean for startPressed and hsPressed to trigger thecorresponding CardLayout. For testing we'll just use a String
					enterName.setBounds(650,500,200,50);
					startPressed = false;
					if(somethingEntered)
						cards.show(pHolder, "Creation Panel");
			 }
			 if (hsPressed) 
			 {
					 g.drawString("you just pressed high scores bro", 100, 100);
					 hsPressed = false;
		
			 }
	 
		}
		class SPTF implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				sp.name = e.getActionCommand();
				sp.somethingEntered = true;
				sp.repaint();
			}
		}
	}

	class BottomPanel extends JPanel
	{
		public BottomPanel()
		{
			setLayout(null);
			
			JButton start = new JButton("Start Game");
			JButtonHandlerS jbhs = new JButtonHandlerS();
			start.addActionListener(jbhs);
			start.setBounds(0,0,1500,50);
			add(start);
			
			
		}
	}
	class JButtonHandlerS implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			sp.tempString = "you just pressed start bro";
			sp.enterName.setBounds(650,500,200,50);
			sp.startPressed = true;
			sp.repaint();
		}
	}

	class JButtonHandlerH implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			sp.tempString = "you just pressed the high scores button brodie";
			sp.hsPressed = true;
			sp.repaint();
		}
	}
	
class  CreationPanel extends JPanel
{
	
		private PanelHolder1 pHolder1;
		SelectPokemonPanel spp;
	
	public CreationPanel() 
	{
		setBackground(Color.BLUE);	
		pHolder1 = new PanelHolder1();
		add(pHolder1);
	}
	
	class PanelHolder1 extends JPanel 
	{ //  Panel holder (Holds all the Panels, for the Card Layout)(essentially) boolean dirPressed; 
		//make proper boolean variables for directions, start button, and the scores button, so it can can conduct the corresponding actions 
		boolean startPressed;
		 boolean hsPressed; 
		 String tempString; 
		// Image PokeMathLogo = Toolkit.getDefaultToolkit().getImage("PokeLogo.JPG");//gets Image from my computer using the get DefaultToolKit 
	//	 Image PokeBack = Toolkit.getDefaultToolkit().getImage("PokeBack1.JPG");     // g.drawImage(PokeMathLogo, 60,150,800,625,this);
		 
	
		public PanelHolder1() 
		{
				setLayout(new BorderLayout(10, 0)); //Use BorderLayout in main panel. Incorporate Card Layout for all the others 
				//Card Layout made( needs more pseudocode)
			setBackground(Color.WHITE);
			Font titleFont = new Font("Serif", Font.BOLD, 20); //Set Fonts
			setFont(titleFont);
			LabelPanel1 lb1 = new LabelPanel1(); //Instantiate the Label Panel for the first Label
			LabelPanel2 lb2 = new LabelPanel2(); //Instantiate the Label Panel for the second Label that goes to the north
			spp = new SelectPokemonPanel();
			LeftPanel1 lp = new LeftPanel1();
			RightPanel1 rp = new RightPanel1();
			add(lb1, BorderLayout.SOUTH);
			add(lb2, BorderLayout.NORTH);
			add(spp, BorderLayout.CENTER);
			add(lp, BorderLayout.WEST);
			add(rp, BorderLayout.EAST);
		}
	
		public void paintComponent(Graphics g) 
		{ //graphics method header
			super.paintComponent(g); // draw Images first, draws background then Pokemath logo
			//g.drawImage(PokeBack, 0,0,600,400,this);
		//	g.drawImage(PokeMathLogo, 210,10,150,75,this);
			//System.out.println("Brodie this is a test");
			//g.drawImage(PokeBack, 0,0,600,400,this);
			
		}		 // mark for change
	}
	class LabelPanel1 extends JPanel 
	{ //Start Panel Header
		JLabel label1;
		public LabelPanel1() 
		{ //Start Panel Constructor
			//setLayout(new FlowLayout); //Sets the layout as gridLayout for the bottom two buttons
			
			 label1 = new JLabel("Pokemath: By Sidd Rao and Akhil Parvathaneni");    		// creates JLabel to present information. This also helps with Layout purposes when creating the center Grid Layout
			 label1.setFont(new Font("Serif", Font.PLAIN, 14));
	          add(label1);
	    }
			
	
			
	}
	class LabelPanel2 extends JPanel 
	{ //Start Panel Header
		JLabel label2;
		public LabelPanel2() 
		{ //Start Panel Constructor
			//setLayout(new FlowLayout); //Sets the layout as gridLayout for the bottom two buttons
			
			 label2 = new JLabel("SELECT YOUR POKEMON ");    		// creates JLabel to present information. This also helps with Layout purposes when creating the center Grid Layout
			 label2.setFont(new Font("Dialog", Font.PLAIN, 14));
	         add(label2);
		}
			
	
			
	}
	class SelectPokemonPanel extends JPanel 
	
	{
		
		//button = new JButton(new ImageIcon(buttonIcon));
		JTextField enterName;
		boolean somethingEntered;
		String name;
		public SelectPokemonPanel()
		{
			
			setLayout(new GridLayout(0,3));

			//enterName = new JTextField("Enter Name");
			//SPJTextFieldHandler spjtfh = new SPJTextFieldHandler();
			//enterName.addActionListener(spjtfh);
			//enterName.setBounds(0,0,0,0);
			//add(enterName);
			
			ImageIcon charizard = new ImageIcon("charizard2.JPG");	//Create charizard button, by first creating an Image Icon, and then adding it to a button	
		    JButton charButton = new JButton (charizard);
		    JButtonHandlerChar chari = new JButtonHandlerChar();
			charButton.addActionListener(chari);
			charButton.setBounds(0,0,750,850);
		    add(charButton);
		    
		    ImageIcon squirtle = new ImageIcon("squirtle.jpg");	//Create charizard button, by first creating an Image Icon, and then adding it to a button	
		    JButton squirtleButton = new JButton(squirtle);
		    JButtonHandlerSquirt squirt = new JButtonHandlerSquirt();
		    squirtleButton.addActionListener(squirt);
		    squirtleButton.setBounds(750,0,750,800);
		    add(squirtleButton);
		    
		    
		    
		    
		    
		}
	
	}
	class JButtonHandlerChar implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			sp.charizardChosen = true;
			System.out.print(sp.charizardChosen);
			
			
				cards.show(pHolder, "PythagPanel");//change in future to going to specific panel based on what button pressed 
			///CHANGE THIS TO PYTHAG PANEL ONCE AKHIL FINISHES IT
		}
	}
	class JButtonHandlerSquirt implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			sp.squirtleChosen = true;
			
			cards.show(pHolder, "Radius Panel");///CHANGE THIS TO CIRCLEPANEL ONCE FINISHED WITH IT
		}
	}
	class SPJTextFieldHandler implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			spp.name = e.getActionCommand();
			spp.somethingEntered = true;
		}
	}
	class LeftPanel1 extends JPanel
	{
		JLabel label2;
		public LeftPanel1()
		{
			label2 = new JLabel("                                                                                 ");    		// creates JLabel to present information. This also helps with Layout purposes when creating the center Grid Layout
			 label2.setFont(new Font("Dialog", Font.PLAIN, 14));
	          add(label2);
		}
		
	}
	class RightPanel1 extends JPanel
	{
		JLabel label2;
		public RightPanel1()
		{
			label2 = new JLabel("                                                                                 ");    		// creates JLabel to present information. This also helps with Layout purposes when creating the center Grid Layout
			 label2.setFont(new Font("Dialog", Font.PLAIN, 14));
	          add(label2);
		}
	}
		
}
class TutorialPanel extends JPanel implements ActionListener
	{
		JButton problemButton1, problemButton2;
		String problem1, answer1, problem2, answer2;
		JTextField answerTF1, answerTF2;
		boolean answerCorrect1, answerCorrect2;
		boolean problemClicked1, problemClicked2;
		boolean nextPan;
		JButton attackButton, attackButton2;
		boolean attacked;
		int count;
		int count1;
		Timer animationDelay;
		
		int animationCount;
		int healthRemaining;
		int totalHealth;
		
		int pokeX;//location of pokemon image
		int pokeY;
		boolean reachedOpponent;
		
		
		
		Image BattleBack = Toolkit.getDefaultToolkit().getImage("BattleBack.png");//getsImage from my computer using the get DefaultToolKit
		Image CharizardBack = Toolkit.getDefaultToolkit().getImage("CharizardBack.png");//getsImage from my computer using the get DefaultToolKit
		Image BottomPart = Toolkit.getDefaultToolkit().getImage("RightTriangleSL10P1.jpg");//getsImage from my computer using the get DefaultToolKit
		Image SquirtleBack = Toolkit.getDefaultToolkit().getImage("SquirtleBack.png");//getsImage from my computer using the get DefaultToolKit
		public TutorialPanel()
		{
			setLayout(null);//set Layout to null
			setBackground(Color.WHITE);
			Font font = new Font("Dialog", Font.BOLD, 13);
			setFont(font);
			
			
			count = 0;
			count1 = 0;
			
			problem1 = "Click this to type the answer";
			answer1 = "5";
			
			animationDelay = new Timer(10,this);
			
			pokeX = 300;
			pokeY = 100;
			reachedOpponent = false;
			
			problemButton1 = new JButton(problem1);//All the JButtons made(for Problem)
			BPButtonHandler bpbh = new BPButtonHandler();//handler
			problemButton1.addActionListener(bpbh);//listener
			problemButton1.setBounds(800,715,200,100);
			add(problemButton1);
			
//			problemButton2 = new JButton(problem2);//All the JButtons made(for Problem)
//			problemButton2.addActionListener(bpbh);//listener
//			problemButton2.setBounds(750,425,750,200);
//			add(problemButton2);
			
			answerTF1 = new JTextField("");//All the JTextFields for problem answers
			BPTextFieldHandler bptfh = new BPTextFieldHandler();
			answerTF1.addActionListener(bptfh);
			answerTF1.setBounds(0,0,0,0);
			add(answerTF1);
			

			
			attackButton = new JButton("Attack!");
			attackButton.addActionListener(bpbh);//listener
			attackButton.setBounds(0,0,0,0);
			add(attackButton);
			

			
			
		}
		public void actionPerformed(ActionEvent e)
		{
			if(attacked)
			{
				
				if(pokeX > 1125)
				{
					reachedOpponent = true;
					count1++;
				}
				if(!reachedOpponent)
				{
					pokeX+=10;
					pokeY-=2;
					animationCount++;
				}
				else if(pokeX > 300)
				{
					pokeX-=10;
					pokeY+=2;
					
				}
				if(count1>0 && pokeX == 300)
				{
					nextPan = true;
					repaint();
				}
					//////////////////
			}
			
			repaint();
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);//draw the pokemons + health and attacks
			
			g.drawImage(BattleBack, 0,0,1500,425,this);
			g.drawImage(BottomPart, 0,375,1500,425,this);
			
			g.drawImage(CharizardBack,pokeX,pokeY,300,300,this);
			
			
			
			
			if(problemClicked1)
			{
				problemButton1.setBounds(0,0,0,0);
				answerTF1.setBounds(800,715,200,100);
				problemClicked1 = false;
			}
//			else if(problemClicked2)
//			{
//				problemButton2.setBounds(0,0,0,0);
//				answerTF2.setBounds(750,425,750,200);
//				problemClicked2 = false;
//			}
			if(answerCorrect1)
			{
				answerTF1.setBounds(0,0,0,0);
				attackButton.setBounds(800,715,200,100);
				answerCorrect1 = false;
			}
//			else if(answerCorrect2)
//			{
//				answerTF2.setBounds(0,0,0,0);
//				attackButton2.setBounds(750,425,750,200);
//				answerCorrect2 = false;
//			}
			else if(count !=0)
			{
				g.setColor(Color.RED);
				g.drawString("Try again, do 3 squared plus 4 squared. Get that answer, then square root it. Easy!", 900, 710);
			}
			if(attacked)
			{
			//	g.drawString("PEW PEW PEW!",100,500);
				attackButton.setBounds(0,0,0,0);
			//	attackButton2.setBounds(0,0,0,0);
			}
			if(nextPan)
			{
				cards.show(pHolder,  "Battle Panel");
			}
			
			animationDelay.start();
		}
	
	class BPButtonHandler implements ActionListener 	
	{
		public void actionPerformed(ActionEvent e)
		{
			Object source = e.getSource();
			if(source == problemButton1)
			{
				problemClicked1 = true;
				repaint();
			}
			else if(source == attackButton)
			{
				attacked = true;
				repaint();
			}
			
		}
	}
	class BPTextFieldHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object source = e.getSource();
			String answer = e.getActionCommand();
			if(source == answerTF1)
			{
				if(answer.equalsIgnoreCase(answer1))
				{
					answerCorrect1 = true;
					count = 0;
					repaint();
				}
				else if(!answer.equalsIgnoreCase(answer1))
				{
					count++;
				}
			}
		}
	}
	}
	class PythagPanel extends JPanel//panel displaying how to solve triangle sides using pythag thrm
	{
		boolean correct;
		 Image RightTriangle1 = Toolkit.getDefaultToolkit().getImage("RightTriangleSL1P1.jpg");//getsImage from my computer using the get DefaultToolKit
		 Image RightSquareTriangle1 = Toolkit.getDefaultToolkit().getImage("RightTriangleSL1P2.jpg");
		 Image RightSquareTriangle2 = Toolkit.getDefaultToolkit().getImage("RightTriangleSL1P3.jpg");
		int count;
		 Font font2;
		  Font NormFont;
		  Font BigFont;
		  JTextArea questionOne;
		public PythagPanel()
		{
			 setLayout(null);//setLayout(null);//setLayout to null layout
			 
			setBackground(Color.WHITE);//JButtons asking to click to show 
			 //add these JButtons w specific size and location 							//setBackground color
			   JTextField textField = new JTextField("", 5);
                    TextFieldHandler tfHandler = new TextFieldHandler();
                    textField.addActionListener(tfHandler);
                    textField.setBounds(1200, 700, 40, 20);
                    add(textField);
//                    questionOne = new JTextArea("What is the measure of angle <ABC? (Answer to move on) Hint: Measure of a right angle!", 2, 10);
//                    JScrollPane scrollPane = new JScrollPane(questionOne);
//                    setPreferredSize(new Dimension(450, 110));
                  
                    System.out.println("Hi");
                    //add(scrollPane);
			
		}
		public void paintComponent(Graphics g)
        {
            setBackground(Color.WHITE);
			super.paintComponent(g);
                  
                  
                    if(correct)
                    	cards.show(pHolder, "PythagPanel1"); 
                    else if(!correct && count != 0)
                    	g.drawString("Read it again!", 1200, 680);
                 
                    g.drawImage(RightTriangle1, 10,190, 800,580,this);		//Right triangle with labels is drawn
					g.drawImage(RightSquareTriangle1, 200,0,1000,200,this);	// picture of the Header for the Slide is drawn
					g.drawImage(RightSquareTriangle2, 600,200,600,400,this);//Picture of the information about the right triangles is drawn
					g.drawLine(40, 50, 60, 70);
					g.drawLine(40, 80, 60, 70);
					g.drawLine(40, 110, 60, 70);
					g.drawLine(40, 140, 60, 70);
					g.drawString("What is the measure of angle <ACB? (Answer to move on) Hint: Measure of a right angle!", 950, 650);
				
                }
         
    
            class TextFieldHandler implements ActionListener
            {
                public void actionPerformed(ActionEvent tf)
                {
                    String text = tf.getActionCommand();
                    pp.count++;
                    correct = false;
                    
                   if(text.equals("90"))
                        correct = true;
                 
                    repaint();
                }
            }
		}
	class PythagPanel1 extends JPanel
	{
		boolean clicked;
	
		 Image RightSquareTriangleSL2P3 = Toolkit.getDefaultToolkit().getImage("RightTriangleSL2P1.jpg"); 
		public PythagPanel1()
		{
			setLayout(null);//setLayout(null);//setLayout to null layout
			 
					setBackground(Color.WHITE);//JButtons asking to click to show 
					//add these JButtons w specific size and location 							//setBackground color
					JButton nextButton = new JButton("Next Panel");	///
                    JButtonHandlerS bhHandler = new JButtonHandlerS();
                    nextButton.addActionListener(bhHandler);
                    nextButton.setBounds(750, 700, 100, 50);
                    add(nextButton);
		}
	
		public void paintComponent(Graphics g)
        {
            setBackground(Color.WHITE);
			super.paintComponent(g);
			g.drawImage(RightSquareTriangleSL2P3, 0, 0, 1500, 850, this);
	
			if(clicked)
				cards.show(pHolder, "PythagPanel2");
		
			
			
        }
        class JButtonHandlerS implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				
				clicked = true;
				pp1.repaint();
			}
		}
	}
	class PythagPanel2 extends JPanel
	{
			boolean clicked;
		
		 Image RightSquareTriangleSL3P1 = Toolkit.getDefaultToolkit().getImage("RightTriangleSL3P1.jpg"); 
		public PythagPanel2()
		{
			setLayout(null);//setLayout(null);//setLayout to null layout
			 
					setBackground(Color.WHITE);//JButtons asking to click to show 
					//add these JButtons w specific size and location 							//setBackground color
					JButton nextButton = new JButton("Next");	///
	               JButtonHandlerS bhHandler = new JButtonHandlerS();
	               nextButton.addActionListener(bhHandler);
	               nextButton.setBounds(700, 500, 100, 50);
	               add(nextButton);
		}
	
		public void paintComponent(Graphics g)
	   {
	       setBackground(Color.WHITE);
			super.paintComponent(g);
			g.drawImage(RightSquareTriangleSL3P1, 0, 0, 1500, 850, this);
	
			if(clicked)
					cards.show(pHolder, "PythagPanel3");
		
			
			
	   }
	   class JButtonHandlerS implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				
				clicked = true;
				repaint();
			}
		}
	}
	class PythagPanel3 extends JPanel
	{
			boolean right1;
			boolean right2;
			boolean right3;
			int count1;
			int count2;
			int count3;
			int cCount;
		
		 Image RightSquareTriangleSL4P1 = Toolkit.getDefaultToolkit().getImage("RightTriangleSL4P1.JPG"); 
		public PythagPanel3()
		{
			setLayout(null);//setLayout(null);//setLayout to null layout
			
			count1 = 0;
			count2 = 0;
			count3 = 0;
			cCount = 0;
			 JTextField textField1 = new JTextField("", 5);
             TextFieldHandler1 tfHandler1 = new TextFieldHandler1();
             textField1.addActionListener(tfHandler1);
             textField1.setBounds(1040, 290, 40, 20);
             add(textField1);
             
             JTextField textField2 = new JTextField("", 5);
             TextFieldHandler2 tfHandler2 = new TextFieldHandler2();
             textField2.addActionListener(tfHandler2);
             textField2.setBounds(1040, 350, 40, 20);
             add(textField2);
             
             JTextField textField3 = new JTextField("", 5);
             TextFieldHandler3 tfHandler3 = new TextFieldHandler3();
             textField3.addActionListener(tfHandler3);
             textField3.setBounds(1040, 410, 40, 20);
             add(textField3);
					
					
		}
	
		public void paintComponent(Graphics g)
	   {
	       setBackground(Color.WHITE);
			super.paintComponent(g);
			g.drawImage(RightSquareTriangleSL4P1, 0, 0, 1500, 850, this);
			g.setColor(Color
					.WHITE);
			if(right1 && count1!=0)
			{
				g.drawString("Correct", 1080, 290);
			//	cCount++;
			}
			else if(!right1 && count1 > 0)
			
				g.drawString("Try again!(hint: Square the length! (the length times the length))", 1080, 290);
			if(right2 && count2!=0)
			{
				g.drawString("Correct", 1080, 350);
			//	cCount++;
			}
			else if(!right2 && count2 > 0)
				g.drawString("Try again!(hint: Square the length! (the length times the length))", 1080, 350);
			if(right3)
			{
				g.drawString("Correct", 1080, 410);	
				
			}
			else if(!right3 && count3 > 0)
				g.drawString("Try again!(hint: Square the length! (the length times the length))", 1080, 410);
			if(cCount > 3)
				cards.show(pHolder, "PythagPanel4");
			
			
			
			
	   }
	   class TextFieldHandler1 implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String text = e.getActionCommand();
                count1++;
                right1 = false;
                
               if(text.equals("9"))
               {
                    right1 = true;
                    cCount++;
               }
             
                repaint();
				
			}
		}
	   class TextFieldHandler2 implements ActionListener
	   {
		   public void actionPerformed(ActionEvent e)
		   {
			   String text = e.getActionCommand();
               count2++;
               right2 = false;
               
              if(text.equals("16"))
              {
                   right2 = true;
                   cCount++;
              }
            
			   repaint();
		   }
	   }
	   class TextFieldHandler3 implements ActionListener
	   {
		   public void actionPerformed(ActionEvent e)
		   {
			   String text = e.getActionCommand();
               count3++;
               right3 = false;
               
              if(text.equals("25"))
              {
                   right3 = true;
                   cCount++;
              }
			   
			   repaint();
		   }
	   }
	}
	class PythagPanel4 extends JPanel
	{
		boolean clicked;
		 Image RightSquareTriangleSL5P1 = Toolkit.getDefaultToolkit().getImage("RightTriangleSL5P1.jpg");
		public PythagPanel4()
		{
			JButton nextButton = new JButton("Next");	///
            JButtonHandlerS bhHandler = new JButtonHandlerS();
            nextButton.addActionListener(bhHandler);
            nextButton.setBounds(700, 500, 100, 50);
            add(nextButton);
		}
		public void paintComponent(Graphics g)
		{
			g.drawImage(RightSquareTriangleSL5P1, 0, 0, 1500, 850, this);
			if(clicked)
			{
				cards.show(pHolder, "PythagPanel5");
			}
		}
		 class JButtonHandlerS implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
					
					clicked = true;
					repaint();
				}
			}
	}
	class PythagPanel5 extends JPanel
	{
			boolean clicked;
		
		 Image RightSquareTriangleSL6P1 = Toolkit.getDefaultToolkit().getImage("RightTriangleSL6P1.jpg"); 
		public PythagPanel5()
		{
			setLayout(null);//setLayout(null);//setLayout to null layout
			 
					setBackground(Color.WHITE);//JButtons asking to click to show 
					//add these JButtons w specific size and location 							//setBackground color
					JButton nextButton = new JButton("Next");	///
	               JButtonHandlerS bhHandler = new JButtonHandlerS();
	               nextButton.addActionListener(bhHandler);
	               nextButton.setBounds(700, 750, 100, 50);
	               add(nextButton);
		}
	
		public void paintComponent(Graphics g)
	   {
	       setBackground(Color.WHITE);
			super.paintComponent(g);
			g.drawImage(RightSquareTriangleSL6P1, 0, 0, 1500, 850, this);
			if(clicked)
			{
				cards.show(pHolder, "PythagPanel6");
			}
	   }
		 class JButtonHandlerS implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
					
					clicked = true;
					repaint();
				}
			}
	  
	}
	class PythagPanel6 extends JPanel
	{
			boolean clicked;
		
		 Image RightSquareTriangleSL7P1 = Toolkit.getDefaultToolkit().getImage("RightTriangleSL7P1.jpg"); 
		public PythagPanel6()
		{
			setLayout(null);//setLayout(null);//setLayout to null layout
			 
					setBackground(Color.WHITE);//JButtons asking to click to show 
					//add these JButtons w specific size and location 							//setBackground color
					JButton nextButton = new JButton("Next");	///
	               JButtonHandlerS bhHandler = new JButtonHandlerS();
	               nextButton.addActionListener(bhHandler);
	               nextButton.setBounds(700, 750, 100, 50);
	               add(nextButton);
		}
	
		public void paintComponent(Graphics g)
	   {
	       setBackground(Color.WHITE);
			super.paintComponent(g);
			g.drawImage(RightSquareTriangleSL7P1, 0, 0, 1500, 850, this);
			if(clicked)
			{
				cards.show(pHolder, "PythagPanel7");
			}
	   }
		 class JButtonHandlerS implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
					
					clicked = true;
					repaint();
				}
			}
	  
	}
	class PythagPanel7 extends JPanel
	{
		boolean clicked;
	
	 Image RightSquareTriangleSL8P1 = Toolkit.getDefaultToolkit().getImage("RightTriangleSL8P1.jpg"); 
	public PythagPanel7()
	{
		setLayout(null);//setLayout(null);//setLayout to null layout
		 
				setBackground(Color.WHITE);//JButtons asking to click to show 
				//add these JButtons w specific size and location 							//setBackground color
				JButton nextButton = new JButton("Next");	///
               JButtonHandlerS bhHandler = new JButtonHandlerS();
               nextButton.addActionListener(bhHandler);
               nextButton.setBounds(700, 750, 100, 50);
               add(nextButton);
	}

	public void paintComponent(Graphics g)
   {
       setBackground(Color.WHITE);
		super.paintComponent(g);
		g.drawImage(RightSquareTriangleSL8P1, 0, 0, 1500, 850, this);
		if(clicked)
		{
			cards.show(pHolder, "PythagPanel8");
		}
   }
	 class JButtonHandlerS implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				
				clicked = true;
				repaint();
			}
		}
  
	}
	class PythagPanel8 extends JPanel ////////////////////
	{
		boolean clicked;
	
	 Image RightSquareTriangleSL9P1 = Toolkit.getDefaultToolkit().getImage("RightTriangleSL9P1.jpg"); 
	public PythagPanel8()
	{
		setLayout(null);//setLayout(null);//setLayout to null layout
		 
				setBackground(Color.WHITE);//JButtons asking to click to show 
				//add these JButtons w specific size and location 							//setBackground color
				JButton nextButton = new JButton("Next");	///
               JButtonHandlerS bhHandler = new JButtonHandlerS();
               nextButton.addActionListener(bhHandler);
               nextButton.setBounds(700, 750, 100, 50);
               add(nextButton);
	}

	public void paintComponent(Graphics g)
   {
       setBackground(Color.WHITE);
		super.paintComponent(g);
		g.drawImage(RightSquareTriangleSL9P1, 0, 0, 1500, 850, this);
		if(clicked)
		{
			cards.show(pHolder, "PreTut");
		}
   }
	 class JButtonHandlerS implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				
				clicked = true;
				repaint();
			}
		}
  
	}
	class PreTut extends JPanel
	{
		boolean clicked;
		
		Image BattleBack = Toolkit.getDefaultToolkit().getImage("BattleBack.png"); 
		Image BottomPart = Toolkit.getDefaultToolkit().getImage("PreTutSL1.jpg"); 
		Image CharizardBack = Toolkit.getDefaultToolkit().getImage("CharizardBack.png");
		public PreTut()
		{
			setLayout(null);//setLayout(null);//setLayout to null layout
			
			setBackground(Color.WHITE);//JButtons asking to click to show 
			//add these JButtons w specific size and location 							//setBackground color
			JButton nextButton = new JButton("Click to go to the Tutorial!");	///
			JButtonHandlerS bhHandler = new JButtonHandlerS();
			nextButton.addActionListener(bhHandler);
			nextButton.setBounds(800, 550, 500, 100);
			add(nextButton);
		}
		
		public void paintComponent(Graphics g)
		{
			setBackground(Color.WHITE);
			super.paintComponent(g);
			g.drawImage(BattleBack, 0, 0, 1500, 425, this);
			g.drawImage(BottomPart, 0, 400, 1500, 425, this);
			g.drawImage(CharizardBack,100,130,300,300,this);
			if(clicked)
			{
				cards.show(pHolder, "Tutorial Panel");
			}
		}
		class JButtonHandlerS implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				
				clicked = true;
				repaint();
			}
		}
		
	}
	class BattlePanel extends JPanel implements ActionListener
	{
		JButton problemButton1, problemButton2;			//JButtons 
		String problem1, answer1, answer2, problem2;		//booleans to see what is correct and what is incorrect
		double answer3;
		JTextField answerTF1, answerTF2;
		boolean answerCorrect1, answerCorrect2;
		boolean answerWrong1;
		boolean problemClicked1, problemClicked2;
		boolean nextPan;
		JButton attackButton, attackButton2;
		boolean attacked;
		int count;
		int count1;
		String p1;
		String p2;
		String p3;
		double b4answer;
		double answer;
		int check;
		Timer animationDelay;
		
		int animationCount;
		int healthRemaining;
		int totalHealth;
		
		int pokeX;//location of pokemon image
		int pokeY;
		boolean reachedOpponent;
		
		int oppX;
		int oppY;
		boolean oppAttacked;
		boolean reachedUser;
		
		boolean userDied;
		boolean opponentDied;
		
		Player opponent, user;
		
		JButton nextBattle;
		boolean nextBattleClicked;
		
		int r1,r2,r3;
		
		int battlesFought;
		double b4answer1;
		
		
		Image Pikachu = Toolkit.getDefaultToolkit().getImage("Pikachu.png");//getsImage from my computer using the get DefaultToolKit
		
		Image BattleBack = Toolkit.getDefaultToolkit().getImage("BattleBack.png");//getsImage from my computer using the get DefaultToolKit
		Image CharizardBack = Toolkit.getDefaultToolkit().getImage("CharizardBack.png");//getsImage from my computer using the get DefaultToolKit
		Image BottomPart = Toolkit.getDefaultToolkit().getImage("RightTriangleSL11P1.jpg");//getsImage from my computer using the get DefaultToolKit
		Image SquirtleBack = Toolkit.getDefaultToolkit().getImage("SquirtleBack.png");//getsImage from my computer using the get DefaultToolKit
		
			Image BottomPartSquirt = Toolkit.getDefaultToolkit().getImage("BottomPartSquirt.png");//getsImage from my computer using the get DefaultToolKit
		public BattlePanel()
		{
			
			setLayout(null);//set Layout to null
			setBackground(Color.WHITE);
			
			answer1 = "";
			user = new Player(sp.name,100);
			opponent = new Player("Akhil",100);
			
			count = 0;
			count1 = 0;
			
			problem1 = "Click this to type the answer";
			
			battlesFought = 1;
			//sp.charizardChosen = true;
			///Answer portion, randomizes, and creates answer
			System.out.print(sp.charizardChosen);

				///////
				
			
			
			animationDelay = new Timer(10,this);
			
			pokeX = 300;
			pokeY = 100;
			reachedOpponent = false;
			
			oppX = 1125;
			oppY = 50;
			reachedUser = false;
			
			problemButton1 = new JButton(problem1);//All the JButtons made(for Problem)
			BPButtonHandler bpbh = new BPButtonHandler();//handler
			problemButton1.addActionListener(bpbh);//listener
			problemButton1.setBounds(800,715,200,100);
			add(problemButton1);
			
//			problemButton2 = new JButton(problem2);//All the JButtons made(for Problem)
//			problemButton2.addActionListener(bpbh);//listener
//			problemButton2.setBounds(750,425,750,200);
//			add(problemButton2);
			
			answerTF1 = new JTextField("");//All the JTextFields for problem answers
			BPTextFieldHandler bptfh = new BPTextFieldHandler();
			answerTF1.addActionListener(bptfh);
			answerTF1.setBounds(0,0,0,0);
			add(answerTF1);
			

			
			attackButton = new JButton("Attack!");
			attackButton.addActionListener(bpbh);//listener
			attackButton.setBounds(0,0,0,0);
			add(attackButton);
			
			nextBattle = new JButton("Next Battle");
			nextBattle.addActionListener(bpbh);
			nextBattle.setBounds(0,0,0,0);
			add(nextBattle);
			

			
			
		}
		public void actionPerformed(ActionEvent e)
		{
			if(attacked)
			{
				
				if(pokeX > 1125)
				{
					reachedOpponent = true;
				}
				if(!reachedOpponent)
				{
					pokeX+=10;
					pokeY-=2;
					animationCount++;
				}
				else if(pokeX > 300)
				{
					pokeX-=10;
					pokeY+=2;
				}
				else if(pokeX == 300)
				{
					attacked = false;
					reachedOpponent = false;
				}
			}
			else if(oppAttacked)
			{
				if(oppX < 300)
				{
					
					reachedUser = true; //condition to check if the opponent reached the user ( so it can go back)
				}
				if(!reachedUser)
				{
					oppX-=10;
					oppY+=2;
				}
				else if(oppX < 1125)
				{
					oppX+=10;
					oppY-=2;
				}
				else if(oppX == 1125)
				{
					oppAttacked = false;
					reachedUser = false;
					answerWrong1 = false;
					//answerWrong2 = false;
				}
			}
			
			repaint();
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);//draw the pokemons + health and attacks
			//System.out.print(sp.charizardChosen);
			g.drawImage(BattleBack, 0,0,1500,425,this);
			if(sp.charizardChosen)
			{
				g.drawImage(BottomPart, 0,375,1500,425,this);
			}
			
			if(sp.charizardChosen)
			{
				g.drawImage(CharizardBack,pokeX,pokeY,300,300,this);
			}
			else
			{
				g.drawImage(SquirtleBack,pokeX,pokeY,300,300,this);
				g.drawImage(BottomPartSquirt, 0,375,750,425,this);
			}
			
			
			
			if(sp.charizardChosen && count == 0)
			{
				r1 = (int) (Math.random()*10)+1;		/// starts of with number between one and 10, to show there are levels to the game
				r2 = (int) (Math.random()*10)+1;		///Next one will do random numebrs between 10 and 15, and then to 15 and 20
			
			
			
				p1 = Integer.toString(r1);
				p2 = Integer.toString(r2);
				answer = (r1 * r1) + (r2 * r2);
				answer = (double) Math.sqrt((answer));
			
				System.out.println(answer);
				System.out.println(r1);
				System.out.println(r1);
			
				b4answer = (double)Math.round(answer * 10d) / 10d;
				System.out.println(b4answer);
				answer1 = Double.toString(b4answer);
					//Makes double in case of decimals, will figure out how to round
				if(answer1.indexOf(".0")>0)
				{
					check = answer1.indexOf(".");
					answer1 = answer1.substring(0, check);
				
				}
				count++;
			}
			else if(sp.squirtleChosen && count == 0)	
				{
					r3 = (int) (Math.random()*10+1);		///Next one will do random numebrs between 10 and 15, and then to 15 and 20
				
				
				
					p3 = Integer.toString(r3);
					answer3 = r3 * r3 * Math.PI;
					//answer4 = 2 * Math.PI * r3;
					System.out.println(answer);
					System.out.println(answer3);
					System.out.println(r3);
				
					b4answer1 = (double)Math.round(answer3 * 10d) / 10d;
					System.out.println(b4answer1);
					answer1 = Double.toString(b4answer1);		//Makes double in case of decimals, will figure out how to round
					count++;
				}
			
			g.setColor(Color.RED);
			g.drawString(user.playerHealth + "/100",750,350);														//health stuff
			g.fillRect(750,375,user.playerHealth*2,10);
			g.drawString(opponent.playerHealth + "/100",750,75);
			g.fillRect(750,100,opponent.playerHealth*2,10);
			
			g.drawImage(Pikachu,oppX,oppY,150,150,this);//enemy image
			
			Font font = new Font("Dialog", Font.BOLD, 40);
			setFont(font);
			
			
			
			Font font1 = new Font("Dialog", Font.BOLD, 13);
			setFont(font1);
			if(sp.charizardChosen)
			{
				g.drawString("Round to the nearest tenth if neccessary", 800, 400);
				g.drawString(" " + p1 + "", 350, 510);
				g.drawString(p2 + " ", 305, 540);
			}
			else
			{
				g.drawString("Round to the nearest tenth if neccessary", 800, 400);
				g.drawString(" " + r3 + "", 294, 450);
				//g.drawString(p2 + " ", 305, 540);
			}
			
			
			if(problemClicked1)
			{
				problemButton1.setBounds(0,0,0,0);
				answerTF1.setBounds(800,715,200,100);
				problemClicked1 = false;
			}
//			else if(problemClicked2)
//			{
//				problemButton2.setBounds(0,0,0,0);
//				answerTF2.setBounds(750,425,750,200);
//				problemClicked2 = false;
//			}
			if(answerCorrect1)
			{
				answerTF1.setBounds(0,0,0,0);
				attackButton.setBounds(800,715,200,100);
				
				opponent.playerHealth -= user.attack;
				if(sp.charizardChosen)
				{
					int r1 = (int) (Math.random()*10)+1;		/// starts of with number between one and 10, to show there are levels to the game
					int r2 = (int) (Math.random()*10)+1;		///Next one will do random numebrs between 10 and 15, and then to 15 and 20
					
					
					
					p1 = Integer.toString(r1);
					p2 = Integer.toString(r2);
					answer = (r1 * r1) + (r2 * r2);
					answer = (double) Math.sqrt((answer));
					
					System.out.println(answer);
					System.out.println(r1);
					System.out.println(r1);
					
					b4answer = (double)Math.round(answer * 10d) / 10d;
					System.out.println(b4answer);
					answer1 = Double.toString(b4answer);		//Makes double in case of decimals, will figure out how to round
					if(answer1.indexOf(".0")>0)
					{
						check = answer1.indexOf(".");
						answer1 = answer1.substring(0, check);
						
					}
				}
				else
				{
					r3 = (int) (Math.random()*10+1);		///Next one will do random numebrs between 10 and 15, and then to 15 and 20
				
				
				
					p3 = Integer.toString(r3);
					answer3 = r3 * r3 * Math.PI;
					//answer4 = 2 * Math.PI * r3;
					System.out.println(answer);
					System.out.println(answer3);
					System.out.println(r3);
				
					b4answer1 = (double)Math.round(answer3 * 10d) / 10d;
					System.out.println(b4answer1);
					answer1 = Double.toString(b4answer1);		//Makes double in case of decimals, will figure out how to round
					count++;
				}	
				answerCorrect1 = false;
			}
//			
			
			if(attacked)
			{
			//	g.drawString("PEW PEW PEW!",100,500);
				attackButton.setBounds(0,0,0,0);
				problemButton1.setBounds(800,715,200,100);
			//	attackButton2.setBounds(0,0,0,0);
			}
			if(answerWrong1)
			{
				oppAttacked = true;
				user.playerHealth -=opponent.attack;
				answerWrong1 = false;
			}
			
			
			if(user.playerHealth == 0 || user.playerHealth < 0)
			{
				userDied = true;
			}
			else if(opponent.playerHealth == 0 || opponent.playerHealth < 0)
			{
				opponentDied = true;
			}
			
			if(userDied) /// come back to this SIDD
			{
				attackButton.setBounds(0,0,0,0);
				problemButton1.setBounds(0,0,0,0);
				answerTF1.setBounds(0,0,0,0);
				ep.printScore();
				cards.show(pHolder, "End Panel");
				userDied = false;
			}
			else if(opponentDied)
			{
				attackButton.setBounds(0,0,0,0);
				problemButton1.setBounds(0,0,0,0);
				answerTF1.setBounds(0,0,0,0);
				
				nextBattle.setBounds(800,715,200,100);
				opponentDied = false;
				
				battlesFought++;
			}
			
			
			if(nextBattleClicked)
			{
				user.playerHealth = user.totalHealth;
				
				opponent.totalHealth += 50;
				opponent.playerHealth = opponent.totalHealth;
				opponent.attack +=20;
			}
			//if(nextPan)
			//{
				//cards.show(pHolder,  "Battle Panel");
		//	}
			
			animationDelay.start();
		}
	
	class BPButtonHandler implements ActionListener //handles buttons in battle panel	
	{
		public void actionPerformed(ActionEvent e)
		{
			Object source = e.getSource();
			if(source == problemButton1)
			{
				problemClicked1 = true;
				repaint();
			}
			else if(source == attackButton)
			{
				attacked = true;
				repaint();
			}
			else if(source == nextBattle)
			{
				nextBattleClicked = true;
				repaint();
			}
			
		}
	}
	class BPTextFieldHandler implements ActionListener//handles text fields for battle panel
	{
		public void actionPerformed(ActionEvent e)
		{
			Object source = e.getSource();
			String answer = e.getActionCommand();
			if(source == answerTF1)
			{
				if(answer.equalsIgnoreCase(answer1))
				{
					answerCorrect1 = true;
					answerWrong1 = false;
					count =0;
					repaint();
				}
				else if(!answer.equalsIgnoreCase(answer1))
				{
					answerWrong1 = true;
					answerCorrect1 = false;
					count++;
					repaint();
				}
			}
		}
	}
	}
	
		
	class RadiusPanel extends JPanel
	{
		Image CircImage = Toolkit.getDefaultToolkit().getImage("RadiusImage.png");//getsImage from my computer using the get DefaultToolKit
		JButton cNext;
		JLabel jl;
		JRadioButton p1, p2, p3, p4;
		ButtonGroup group1;
		boolean correct;
		boolean strange;
		int count;
		public RadiusPanel()
		{
			setBackground(Color.WHITE);
			
			setLayout(new FlowLayout(FlowLayout.CENTER,1000,50));
			
			jl = new JLabel("Which is the formula for the diameter?");    		// creates JLabel to present information. This also helps with Layout purposes when creating the center Grid Layout
			 jl.setFont(new Font("Dialog", Font.PLAIN, 14));
	          add(jl);
			 
			 p1 = new JRadioButton("2 * pi * r, r being the radius");
			 p2 = new JRadioButton("2* pi * r, r being one radian");
			 p3 = new JRadioButton("pi * r^2, r being the Reimann Sum");
			 p4 = new JRadioButton("2r, r being the radius");
			 
			// ActionHandler ah = new ActionHandler();
				RadioHandler rh = new RadioHandler();
				
				p1.addActionListener(rh);
				p2.addActionListener(rh);
				p3.addActionListener(rh);
				p4.addActionListener(rh);
				
				group1 = new ButtonGroup();
				group1.add(p1);
				group1.add(p2);
				group1.add(p3);
				group1.add(p4);
				
				this.add(p1);
				this.add(p2);
				this.add(p3);
				this.add(p4);
				
			
			// group1.setBounds(40, 50, 90, 40);
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(CircImage, 40,50,600,400,this);
			g.setColor(Color.RED);
			if(correct)
			{
				cards.show(pHolder, "Area Panel");
			}
			else if(strange)
			{
				g.setColor(Color.RED);
				g.drawString("Are you really sure?", 600, 600);
				strange = false;
			}
			else if(!correct && count >0)
			{
				g.drawString("Read again!", 600, 600);	
			}
				
		}	
		class RadioHandler implements ActionListener
		{
			public void actionPerformed (ActionEvent e)
			{
				String command1 = e.getActionCommand();
				count++;
					if(command1.equalsIgnoreCase("2r, r being the radius"))
					{
	                	correct = true;
	                	repaint();
					}
					else if(command1.equalsIgnoreCase("pi * r^2, r being the Reimann Sum"))
					{
						strange = true;
					}
	                else
	                	correct = false;
						repaint();
	                }     
			
	        }
	}
	
	class AreaPanel extends JPanel
	{
		Image AreaImage = Toolkit.getDefaultToolkit().getImage("AreaImage.png");//getsImage from my computer using the get DefaultToolKit
		JButton cNext;
		JLabel jl;
		JRadioButton p1, p2, p3, p4;
		ButtonGroup group1;
		boolean correct;
		boolean strange;
		int count;
		public AreaPanel()
		{
			setBackground(Color.WHITE);
			
			setLayout(new FlowLayout(FlowLayout.CENTER,1000,50));
			
			jl = new JLabel("Which is the formula for the area of a circle?");    		// creates JLabel to present information. This also helps with Layout purposes when creating the center Grid Layout
			 jl.setFont(new Font("Dialog", Font.PLAIN, 14));
	          add(jl);
			 
			 p1 = new JRadioButton("2 * pi * r, r being the radius");
			 p2 = new JRadioButton("2* pi * r, r being one radian");
			 p3 = new JRadioButton("pi * r^2, r being the radius");
			 p4 = new JRadioButton("2r, r being the radius");
			 
			// ActionHandler ah = new ActionHandler();
				RadioHandler rh = new RadioHandler();
				
				p1.addActionListener(rh);
				p2.addActionListener(rh);
				p3.addActionListener(rh);
				p4.addActionListener(rh);
				
				group1 = new ButtonGroup();
				group1.add(p1);
				group1.add(p2);
				group1.add(p3);
				group1.add(p4);
				
				this.add(p1);
				this.add(p2);
				this.add(p3);
				this.add(p4);
				
			
			// group1.setBounds(40, 50, 90, 40);
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(AreaImage, 40,50,400,400,this);
			g.setColor(Color.RED);
			if(correct)
			{
				cards.show(pHolder, "Circumference Panel");
			}
			else if(strange)
			{
				g.setColor(Color.RED);
				g.drawString("Are you really sure?", 600, 600);
				strange = false;
			}
			else if(!correct && count >0)
			{
				g.drawString("Read again!", 600, 600);	
			}
				
		}	
		class RadioHandler implements ActionListener
		{
			public void actionPerformed (ActionEvent e)
			{
				String command1 = e.getActionCommand();
				count++;
					if(command1.equalsIgnoreCase("pi * r^2, r being the radius"))
					{
	                	correct = true;
	                	repaint();
					}
					
	                else
	                	correct = false;
						repaint();
	                }     
			
	        }
	}
	class CircPanel extends JPanel
	{
		Image RadiusImage = Toolkit.getDefaultToolkit().getImage("CircImage.png");
		JButton rNext;
		boolean clicked;
		public CircPanel()
		{
			setBackground(Color.WHITE);
			setLayout(null);
			
			
			rNext = new JButton("Next");
			CircButtonHandler cbh = new CircButtonHandler();
			rNext.addActionListener(cbh);
			rNext.setBounds(1300, 380, 200, 140);
			add(rNext);
			
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(RadiusImage, 600,300,500,500,this);
			Font titleFont = new Font("Serif", Font.BOLD, 20);                //Set Fonts
			 setFont(titleFont);
			 g.setColor(Color.RED);
			g.drawString("Here's a little break from the quizzes, but remember this information!", 80, 60);
			if(clicked)
			{
				cards.show(pHolder, "Battle Panel"); //Look into this tho 
			}
		}	
	
	
		class CircButtonHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				clicked = true;
			}
		}
	}
	
	class EndPanel extends JPanel
	{
		JButton tryAgain;
		boolean tryAgainClicked;
		public EndPanel()
		{
			setBackground(Color.WHITE);
			setLayout(null);
			Font font = new Font("Dialog", Font.BOLD, 36);
			setFont(font);
			
			tryAgain = new JButton("Try again!");
			EPButtonHandler epbh = new EPButtonHandler();
			tryAgain.addActionListener(epbh);
			tryAgain.setBounds(500,900,600,200);
			add(tryAgain);
		}
		public void printScore()
		{
			 
    	try
    	{
    		String data = bp.user.playerName + "-" + bp.battlesFought + " battle(s)";
    		
    		File file =new File("HighScores.txt");

    		
    		FileWriter fileWriter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
    	        bufferWriter.write(data);
    	        bufferWriter.close();
	        
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawString("Oops, you LOST!", 400,100);
			g.drawString("You fought " + bp.battlesFought + " battle(s)!",400,300);
			
			if(tryAgainClicked)
			{
				cards.show(pHolder, "Start Panel");
			}
			
		}
		class EPButtonHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				tryAgainClicked = true;
			}
		}
	}
	
	

}
