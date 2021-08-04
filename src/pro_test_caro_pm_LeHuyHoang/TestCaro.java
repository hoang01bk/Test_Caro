/**
 * 
 */
package pro_test_caro_pm_LeHuyHoang;

import java.awt.EventQueue;


/**
 * @author Admin
 *
 */
public class TestCaro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
