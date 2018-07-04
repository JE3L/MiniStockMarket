import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class customer {
	
	void createaccount(String name,float balance) throws IOException{
		FileWriter filewriter = new FileWriter("customer",true);
	    BufferedWriter buffwrite = new BufferedWriter(filewriter);
	    buffwrite.write(name+" "+balance+"\n");
	    buffwrite.close();
		filewriter.close();
	}
	
	void buy(String name,String stockname,int n) throws IOException{
		File input1 = new File("customer");
		File temp1 = new File("Stock");
		BufferedReader reader = new BufferedReader(new FileReader(input1));
		BufferedReader reader1 = new BufferedReader(new FileReader(temp1));
	    String line;
	    int flag=0;
	    float customerbalance=0,stockprize=0;
		while((line=reader.readLine())!=null){
			String[] words=line.split(" ");
	    	if(name.equals(words[0])){
	    		customerbalance = Float.parseFloat(words[1]);
	    		flag++;
	    		break;
	    	}
		}
		while((line=reader1.readLine())!=null){
			String[] words=line.split(" ");
	    	if(stockname.equals(words[0])){
	    		stockprize = Float.parseFloat(words[1]);
	    		flag++;
	    		break;
	    	}
		}
		reader.close();
		reader1.close();
		if(flag!=2) {System.out.println("The Information you have provided is wrong or does not exist please check again.");return;}
		if(n>0){
			if(stockprize*n>customerbalance){System.out.println("Unsucssesful attempt because your account have "+customerbalance+" rupee.");return;}
			addmoney(name,(-1)*stockprize*n);
			update(name,stockname,n);
		}
		else sell(name,stockname,n,customerbalance,stockprize);
	}
	
	void update(String name,String stockname,int n) throws IOException{
		File input = new File("Information");
		File temp = new File("temp2");
		BufferedReader reader = new BufferedReader(new FileReader(input));
		BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
	    String line;
	    boolean flag = false;
		while((line=reader.readLine())!=null){
			String[] words=line.split(" ");
	    	if(name.equals(words[0]) && stockname.equals(words[1])){
	    		flag = true;
	    		words[2] = Integer.toString(n+Integer.parseInt(words[2]));
	    	}
		    writer.write(words[0] +" "+words[1]+" "+words[2]+ System.getProperty("line.separator"));
	    }
	    reader.close();
	    writer.close();
	    input.delete();
	    temp.renameTo(input);
	    if(flag) return;
		FileWriter filewriter = new FileWriter("information",true);
	    BufferedWriter buffwrite = new BufferedWriter(filewriter);
	    buffwrite.write(name+" "+stockname+" "+n+"\n");
	    buffwrite.close();
		filewriter.close();
	}
	
	void sell(String name,String stockname,int n,float customerbalance,float stockprize) throws IOException{
		File input2 = new File("Information");
		File temp2 = new File("temp1");
		BufferedReader reader2 = new BufferedReader(new FileReader(input2));
		BufferedWriter writer = new BufferedWriter(new FileWriter(temp2));
	    String line1;
		while((line1=reader2.readLine())!=null){
			String[] words=line1.split(" ");
	    	if(name.equals(words[0]) && stockname.equals(words[1])){
	    		int z = Integer.parseInt(words[2]);
	    		if((-1)*n>z) System.out.println("You have "+z+" number of "+words[1]);
	    		else {
	    			words[2] = Integer.toString(z+n);
	    			addmoney(name,(-1)*stockprize*n);
	    			if(z+n==0) continue;
	    		}
	    	}
		    writer.write(words[0] +" "+words[1]+" "+words[2]+ System.getProperty("line.separator"));
	    }
	    reader2.close();
	    writer.close();
	    input2.delete();
	    temp2.renameTo(input2);
	}
	
	void addmoney(String name,float amount) throws IOException{
		File input = new File("customer");
		File temp = new File("temp");
		BufferedReader reader = new BufferedReader(new FileReader(input));
		BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
	    String line;
	    int flag=0;
	    float m=0;
		while((line=reader.readLine())!=null){
			String[] words=line.split(" ");
	    	if(name.equals(words[0])){
	    		float b = Float.parseFloat(words[1]);
	    		if(b<(-1)*amount) {m=b;flag=2;}
	    		else{
	    			m = b+amount;
		    		words[1] = Float.toString(m);
		    		line = words[0]+" "+words[1];
		    		flag=1;
	    		}
	    	}
		    writer.write(line + System.getProperty("line.separator"));
	    }
		if(flag==0) System.out.println("The name you've entered is wrong or does not exit.");
		System.out.println("Now your account have "+m+" rupee.");
	    reader.close();
	    writer.close();
	    input.delete();
	    temp.renameTo(input);
	}
	
	void myaccount(String name) throws IOException{
		File input1 = new File("customer");
		File temp1 = new File("Information");
		BufferedReader reader = new BufferedReader(new FileReader(input1));
		BufferedReader reader1 = new BufferedReader(new FileReader(temp1));
	    String line;
	    int flag=0;
	    float customerbalance=0;
		while((line=reader.readLine())!=null){
			String[] words=line.split(" ");
	    	if(name.equals(words[0])){
	    		customerbalance = Float.parseFloat(words[1]);
	    		flag++;
	    	}
		}
		System.out.println("You have "+customerbalance+" balance in your account.");
		while((line=reader1.readLine())!=null){
			String[] words=line.split(" ");
	    	if(name.equals(words[0])){
	    		System.out.println("You have "+words[2]+" of "+words[1]);
	    		flag++;
	    	}
		}
		if(flag<1) System.out.println("You don't have account or you've entered wrong name");
		reader.close();
		reader1.close();
	}
	
}
