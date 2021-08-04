/**
 * 
 */
package pro_test_caro_pm_LeHuyHoang;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Admin
 *
 */
public class GUI {
	
	public JFrame frame;
	private int row = 20;
	private int col = 20;
	public XOButtons[][] Buttons = new XOButtons[row][col];
	
	JPanel panel = new JPanel();
	
	public GUI() {
		initialize();
	}
	/**
	 * giao dien
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setSize(600,600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(row,col));
		for(int i = 0; i < Buttons.length; i++) {
			for(int j = 0; j < Buttons.length; j++ ) {
				Point point = new Point(i, j);
				Buttons[i][j] = new XOButtons(i, j);
				MouseListener moseEvent = new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						try {
							handleClick(point);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				}; 
				
				panel.add(Buttons[i][j]);
				Buttons[i][j].addMouseListener(moseEvent);
				
			}
		}
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public void handleClick(Point point) throws Exception {
		Buttons[point.x][point.y].setState(true);
		MayDanh();
	}
	
	 public void MayDanh() throws Exception {
		 BufferedReader input = null;
		 try {
			 /**
			  * tach ma tran 5*5
			  */
			 String[][] checkMatrix = new String[5][5];
			 FileReader read = new FileReader("C:\\Users\\Admin\\eclipse-workspace\\pro_test_caro_pm_LeHuyHoang\\src\\pro_test_caro_pm_LeHuyHoang\\theco.txt");
			 input = new BufferedReader(read);
			 String s = "";
			 int step = 0;
			 loop1:
			 while (true) {
				 step++;
				 for(int i = 0; i < 5; i++) {
					 s = input.readLine();
					 if(s == null) {
						 danhRandom();
						 System.out.println("thoat1");
						 break loop1;
					 }
					 for(int j = 0; j < 5; j++) {
						 checkMatrix[i][j] = Character.toString(s.charAt(j));
					 }
				 }
				 
			 System.out.println("duyet ma tran thu:"+ step);
			 boolean checked = true;
			 
			loop2:
				for(int hang = 0; hang < 16; hang++) {
					for(int cot = 0; cot < 16; cot++) {
						loop3:
							for(int i = 0; i < 5;i++) {
								for(int j = 0; j < 5; j++) {
									String checkingPoint = checkMatrix[i][j];
									String checkingPointBoard = Buttons[i+hang][j+cot].value;
									if((checkingPoint == "O" && checkingPointBoard == "O")
										|| (checkingPoint == "X" && checkingPointBoard == "X")
										|| (checkingPoint == "D" && checkingPointBoard == "")
										|| (checkingPoint == "G")) {
										//checked = true
									}else if (checkingPoint == "D" && checkingPointBoard == "") {
										Buttons[i+hang][j+cot].setState(false);
										System.out.println("may da danh" );
									}else {
										checked = false;
										System.out.println("thoat3");
										break loop3;
									}
								}
							}
						if(checked) {
							System.out.println("thoat2");
							break loop2;
						}
						
					}
				}
			 if(checked)
			 {
				 break;
			 }
			 
			 }//end while
			 }finally {
			 if(input != null) {
				 input.close();
			 }
		 }
	 }
	 public void danhRandom() {
		 System.out.println("danh random");
	 }
	

}
