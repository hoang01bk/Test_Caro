/**
 * 
 */
package pro_test_caro_pm_LeHuyHoang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;



/**
 * @author Admin
 *
 */
public class ReadFileTheCo {
	public String[][] matrix = new String[5][5];
	
	public  void read() throws Exception {
		BufferedReader input = null;
		BufferedWriter output = null;
		try {
			FileReader read = new FileReader("C:\\Users\\Admin\\eclipse-workspace\\pro_test_caro_pm_LeHuyHoang\\src\\pro_test_caro_pm_LeHuyHoang\\theco.txt");
			FileWriter write = new FileWriter("C:\\Users\\Admin\\eclipse-workspace\\pro_test_caro_pm_LeHuyHoang\\src\\pro_test_caro_pm_LeHuyHoang\\out.txt");
			input = new BufferedReader(read);
			output = new BufferedWriter(write);
			int i = 0;
			while((i = input.read()) != -1) {
				output.write(i);
				System.out.print((char) i);
			}
		}finally {
			if(input != null) {
				input.close();
			}
			if(output != null) {
				output.close();
			}
		}
	}
	public static void main(String[] args) throws Exception {
		ReadFileTheCo test = new ReadFileTheCo();
		test.read();
	}

}
