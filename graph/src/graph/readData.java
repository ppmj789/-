package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class readData {
	
	public void readData(node input[]) { 
		
		 BufferedReader bReader = null;
		
		 int colNum=0;
	        
	        try {
	            
	            String s;
	            File file = new File("d.txt");
	            bReader = new BufferedReader(new FileReader(file));
	            
	            // 더이상 읽어들일게 없을 때까지 읽어들이게 합니다.
	            while((s = bReader.readLine()) != null) {
	                String[] a = s.split(",");
	                input[colNum] = new node();
	                input[colNum].restaurantName = a[0];
	                input[colNum].startHour = Float.parseFloat(a[1]);
	                input[colNum].endHour = Float.parseFloat(a[2]);
	                input[colNum].address = a[3];
	                input[colNum].latitude = Float.parseFloat(a[4]);
	                input[colNum].longitude = Float.parseFloat(a[5]);
	                
	                for(int i=0;i<7;i++) {
	                	input[colNum].monday[i] = Float.parseFloat(a[6+i]);
	                }
	                for(int i=0;i<7;i++) {
	                	input[colNum].tuesday[i] = Float.parseFloat(a[13+i]);
	                }
	                for(int i=0;i<7;i++) {
	                	input[colNum].wendseday[i] = Float.parseFloat(a[20+i]);
	                }
	                for(int i=0;i<7;i++) {
	                	input[colNum].thursday[i] = Float.parseFloat(a[27+i]);
	                }
	                for(int i=0;i<7;i++) {
	                	input[colNum].friday[i] = Float.parseFloat(a[34+i]);
	                }
	                for(int i=0;i<7;i++) {
	                	 input[colNum].saturday[i] = Float.parseFloat(a[41+i]);
	                }
	                for(int i=0;i<7;i++) {
	                	input[colNum].sunday[i] = Float.parseFloat(a[48+i]);
	                }
	                 colNum++;
	            }
	            
	        } catch(IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if(bReader != null) bReader.close();
	            } catch(IOException e) {
	                e.printStackTrace();
	            }
	        }
	        
	       // System.out.println(input[20].address);
	}

}