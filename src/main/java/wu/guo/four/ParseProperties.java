package wu.guo.four;

/**
 * ��װ��ȡproperties�ļ�
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ParseProperties {
	
	private Properties pro = new Properties();
	String value = null;
	
	public ParseProperties(String propertiespath) {
		this.loadProperties(propertiespath);
	}
	
	
	/**
	 * ����properties�ļ�
	 * @param propertiespat
	 */
	private void loadProperties(String propertiespat) {
		try {
			InputStream in = new FileInputStream(propertiespat);
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			pro.load(br);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * ����keyname��ֵ
	 * @param keyname
	 * @return
	 */
	public String getValue(String keyname){
		value = pro.getProperty(keyname).trim();
		try {
			value = new String(value.getBytes("utf-8"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	public static void main(String[] args) {
		ParseProperties a = new ParseProperties(System.getProperty("user.dir") + "/tool/test.properties");
		System.out.println(System.getProperty("user.dir"));		
		System.out.println(a.getValue("url"));
	}
	

}
