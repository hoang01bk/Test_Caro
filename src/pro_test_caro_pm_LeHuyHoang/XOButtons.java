/**
 * 
 */
package pro_test_caro_pm_LeHuyHoang;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * @author Admin
 *
 */
public class XOButtons extends JButton {
	private ImageIcon X;
	private ImageIcon O;
	public Point point;
	public static boolean isXMove = true;
	public String value = "";
	
	public XOButtons(int x, int y) {
		X = new ImageIcon(this.getClass().getResource("X.png"));
		O = new ImageIcon(this.getClass().getResource("O.png"));
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		this.point = new Point(x, y);
	}
	public void setState(Boolean isXMove) {
		if(isXMove) {
			this.setIcon(X);
			this.value = "X";
			XOButtons.isXMove = false;
		}else {
			this.setIcon(O);
			this.value = "O";
			XOButtons.isXMove = true;
		}
	}
	

}
