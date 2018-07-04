import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Stock {
	
	void update(String s, String p) throws IOException{
		File input = new File("Stock");
		File temp = new File("temp");
		BufferedReader reader = new BufferedReader(new FileReader(input));
		BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
	    String line;
		while((line=reader.readLine())!=null){
			String[] words=line.split(" ");
	    	if(s.equals(words[0])){ 
	    		words[1] = p;
	    		FileWriter filewriter1 = new FileWriter("Update",true);
	    	    BufferedWriter buffwrite1 = new BufferedWriter(filewriter1);
	    	    buffwrite1.write(s+" "+p+"\n");
	    	    buffwrite1.close();
	    		filewriter1.close();
	    	}
		    writer.write(words[0] +" "+words[1] + System.getProperty("line.separator"));
	    }
	    reader.close();
	    writer.close();
	    input.delete();
	    temp.renameTo(input);
	}
	
	void delete(String s) throws IOException{
		File input = new File("Stock");
		File temp = new File("temp");
		BufferedReader reader = new BufferedReader(new FileReader(input));
		BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
	    String line;
		while((line=reader.readLine())!=null){
			String[] words=line.split(" ");
	    	if(s.equals(words[0])) continue;
	    	writer.write(words[0] +" "+words[1] + System.getProperty("line.separator"));
	    }
	    reader.close();
	    writer.close();
	    input.delete();
	    temp.renameTo(input);
	}
	
	void insert(String s,float p) throws IOException{
		FileWriter filewriter = new FileWriter("Stock",true);
		FileWriter filewriter1 = new FileWriter("Update",true);
	    BufferedWriter buffwrite = new BufferedWriter(filewriter);
	    BufferedWriter buffwrite1 = new BufferedWriter(filewriter1);
	    buffwrite.write(s+" "+p+"\n");
	    buffwrite1.write(s+" "+p+"\n");
	    buffwrite.close();
	    buffwrite1.close();
		filewriter1.close();
		filewriter.close();
	}
	
	void currentstatus() throws IOException{
		File input = new File("Stock");
		BufferedReader reader = new BufferedReader(new FileReader(input));
	    String line;
		while((line=reader.readLine())!=null){
		    System.out.println(line);
		}
		reader.close();
	}
	
	void showprogress(String s) throws IOException{
		File input = new File("Update");
		BufferedReader reader = new BufferedReader(new FileReader(input));
	    String line;
		while((line=reader.readLine())!=null){
			String[] words=line.split(" ");
	    	if(s.equals(words[0])){
	    		System.out.print(words[1]+"  ");
	    	}
		}
		System.out.println();
		reader.close();
	}
}
