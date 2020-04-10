/**
 * 
 */
package function;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import database.Library;
import database.Strings;

import static database.Strings.*;
import static java.util.logging.Level.*;
import static database.Log.*;

/**
 * @author Roman
 *
 */
public class Save extends Values{
		
	public static void initialize(ArrayList<Double> a1, ArrayList<Double> a2, ArrayList<Double> a3, ArrayList<String> a4, ArrayList<Double> b1, ArrayList<Double> b2, ArrayList<Double> b3, ArrayList<String> b4, int toggle) {
		// TODO Auto-generated method stub
		initializeText(a4, b4, toggle);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(getPathtooutput().concat("").concat(".txt")));
			for (int i = 0; i < a3.size(); i++) {
				bw.write(getWrite(Library.toString(a1.get(i)), Library.toString(a2.get(i)), Library.toString(a3.get(i)), a4.get(i)));
				bw.newLine();
			}
			for (int i = 0; i < b3.size(); i++) {
				bw.write(getWrite(Library.toString(b1.get(i)), Library.toString(b2.get(i)), Library.toString(b3.get(i)), b4.get(i)));
				bw.newLine();
			}
			bw.write(String.join(getEmpty(), String.format(getFormat80(), String.join(getSpace(), Strings.getTotal(), "�", "������".concat(getColon()))), String.format(getFormat10(),Library.toString(getValue()))));
			bw.newLine();
			bw.write(String.join(getEmpty(), String.format(getFormat80(),  Strings.getTimer().concat(getColon())), String.format(getFormat30(), getDate())));
			bw.close();
			Library.showMessage("���������");
		} catch (Exception ex) {
			// TODO: handle exception
			logp(INFO, getClassName(Save.class), "initialize", ex.getMessage());
		}
	}
	
	private static String getWrite(String a1, String a2, String a3, String a4) {
		String ta1 = String.join(getEmpty(), String.format(getFormat10(), Strings.getTarif().concat(getColon())), String.format(getFormat10(), a1));
		String ta2 = String.join(getEmpty(), String.format(getFormat10(), Strings.getValue().concat(getColon())), String.format(getFormat10(), a2));
		String ta3 = String.join(getEmpty(), String.format(getFormat10(), Strings.getTotal().concat(getColon())), String.format(getFormat10(), a3));
		String ta4 = String.format(getFormat80(), a4);
		return String.join(getEmpty(), ta4, ta1, ta2, ta3);
	}
	
	private static String getDate() {
		Date date = new Date();
		return date.toString();
	}
	
	private static void initializeText( ArrayList<String> a4, ArrayList<String> b4,  int toggle) {
		// TODO Auto-generated method stub
		try {
			clearArray(a4);
			clearArray(b4);
			a4.add(0, "����������");
			a4.add(1, "������ ���� ������ �������������");
			a4.add(2, "�������� ������������� ��� ���������� ������ ���������");
			a4.add(3, "�������� ���� �� ������� ������������� ��� ���������� ������ ���������");
			a4.add(4, "�������� ������� �������� ������������� ��� ���������� ������ ���������");
			a4.add(5, "��������� ������� ��� �������� ���� ��� ���������� ������ ���������");
			a4.add(6, "��������� ������� ��� ������� ���� ��� ���������� ������ ���������");
			a4.add(7, "�������������� ��� ���������� ������ ���������");
			a4.add(8, "���������");
			a4.add(9, "�������� �������������");
			a4.add(10, "�������� ������������� �� ����� �������� �������������");
			a4.add(11, "�������� ������� �������� �������������");
			a4.add(12, "��������� ������� ��� ��������� �������������");
			a4.add(13, "��������� ������� ��� �������� �������������");
			a4.add(14, "��������� � �������� ������������� ��������");
			a4.add(15, "������������ ������������� �������");
			a4.add(16, "�������-������������ ����������");
			a4.add(17, "�����");
			a4.add(18, "���");
			switch (toggle) {
			case 1:
				b4.add(0, "�������������� ������������� �����");
				break;
			case 2:
				b4.add(0, "��������������. ������� ����");
				b4.add(1, "��������������. ������ ����");
				break;
			case 3:
				b4.add(0, "��������������. ������� ����");
				b4.add(1, "��������������. ����������� ����");
				b4.add(2, "��������������. ������ ����");
				break;
			default:
				break;
			}
		} catch (Exception ex) {
			// TODO: handle exception
			logp(INFO, getClassName(Save.class), "initializeText", ex.getMessage());
		}
	}
}
