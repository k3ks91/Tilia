package parametri;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import skripta.GlavnaSkripta;

public class Test1 {
	static String kateriTest="Test1";
	//GlavnaSkripta SkriptaC = new GlavnaSkripta(); 
	
	//Parametri za Vnos
	//Koliko otrok in izobrazba
	static int Predsolski=1;
	static int Osnovnosolski=0; 
	static int Srednjesolski=0;
	static int Studentnje=0;
	
	//Form 2 lots of Stuff* TODO
	static String Paket = "A"; // A B C D V V+ (S> za sred in stu), Trenutno nastavi za vse..., vec otrok zna probleme delat TODO

@Test	
public static void test() throws ClientProtocolException, InterruptedException, IOException {
	// TODO Auto-generated method stub
		GlavnaSkripta.Test(Predsolski, Osnovnosolski, Srednjesolski, Studentnje, Paket);
	}
}
