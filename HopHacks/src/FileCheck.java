import java.io.File;
import java.util.Map;

//import com.google.appengine.repackaged.org.json.JSONArray; 

import javax.swing.JFileChooser;

import com.echonest.api.v4.EchoNestAPI;
import com.echonest.api.v4.EchoNestException;
import com.echonest.api.v4.Song;

public class FileCheck {
	
	private String fileType(String path){
	    JFileChooser chooser = new JFileChooser();
	    File file = new File(path);
	    String fileTypeName ="";
	    
	    try{
	    	fileTypeName = file.toURI().toURL().openConnection().getContentType();
	    }catch(Exception e){}
	    
	    return fileTypeName;
	  }
	
	private String fileSize(String path){
		File file = new File(path);
		String value = file.length()+ " "+ "(Bytes)";
		return value;
	}
	
	private String md5(String path){
		DB x = new DB();
		String md5hash = "";
		try{
			md5hash = x.getMD5Checksum(path);
		}catch(Exception e){}
		
		return md5hash;
	}
	
	private boolean maliciousFile(String path){
		return new DB().isFileMalicious(path);
	}
	
	// num =0 means file analysis; num = 1 means song; num = 2 means do both
	public static String[] rawAnalysis(String path, int num) {	
		FileCheck x = new FileCheck();
		
		int dataLength = 0;
		if(num==0)
			dataLength=5;
		else if(num==1)
			dataLength=3;
		else
			dataLength=8;
		
		String data[] = new String[dataLength];
		if(num==0){
			data[0] = path;
			data[1] = x.fileType(path);
			data[2] = x.fileSize(path);
			data[3] = x.md5(path);
			if(x.maliciousFile(path)){
				data[4] = "We Have Deemed that this File is Malicious\nPlease Do Not Use";
			}else{
				data[4] = "According To Our Analysis Of millions of Malicious Software\nWe believe that the following file is safe";
			}
		}
		//GFQ8MTPXM4MYHFMTU
		else if(num==1){
			
		}
		else{
			data[0] = path;
			data[1] = x.fileType(path);
			data[2] = x.fileSize(path);
			data[3] = x.md5(path);
			if(x.maliciousFile(path)){
				data[4] = "We Have Deemed that this File is Malicious\nPlease Do Not Use";
			}else{
				data[4] = "According To Our Analysis Of millions of Malicious Software\nWe believe that the following file is safe";
			}

		}
		
		return data;
	}
}
