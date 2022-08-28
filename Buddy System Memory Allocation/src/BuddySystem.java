import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BuddySystem {
	
	public static Scanner sc = new Scanner(System.in);
	static int internal = 0 , external_Fragmentation = 0;
	public static void main(String[] args) {
		int memory_size = 0 ,
			user_Choice = 0,
			process_Number = 0,
			counter_Check = 0;
		
		ArrayList<Process> p_List = new ArrayList<Process>(); // intialize each process to array list
		ArrayList<Integer> p_List1 = null;
		System.out.println("Enter size of the memory: (in byte)");
		memory_size = sc.nextInt();
		p_List1 = new ArrayList<Integer>(Collections.nCopies(memory_size, 0));
		while ((Math.log(memory_size)/Math.log(2))%1 != 0) { // checking if the memory size is an exponent of 2
			
			System.out.println("Please try again");
			System.out.println("Enter size of the memory: (in byte)");
			memory_size = sc.nextInt();
			p_List1 = new ArrayList<Integer>(Collections.nCopies(memory_size, 0)); // initialize array list to liken memory 
		}
		    external_Fragmentation = memory_size; 
		    
		//keep asknig the user which choice he would rather 
		while(user_Choice != 4){
			System.out.println("1.Enter process \n2.Exit process \n3.Print status \n4.Exit");
			System.out.println("Please enter your choice: ");
			user_Choice = sc.nextInt();
			switch(user_Choice) {
			//allocate memory by the buddy system
			case 1:
				 external_Fragmentation = memory_Allocate(memory_size , p_List , process_Number , p_List1);
				 System.out.println("The external Fragmentation is:  " + external_Fragmentation );
				 process_Number++;
				 break;
			//taking back memory that allocate to some prcocess	 
			case 2:
				System.out.println("Enter process number you want to realse: ");
				for (int i = 0; i < p_List.size(); i++) {
					if(p_List.get(i).remove_Or_Not == false && p_List.get(i).getEndP()!=0) {
						System.out.println("process number "+ i);
					}
				}
				int remove = sc.nextInt();
				
				for (int i = p_List.get(remove).getStartP(); i < p_List.get(remove).getEndP(); i++) {
					p_List1.set(i, 0);
				}
				
				//initialize each process internal Fragmentation to null
				p_List.get(remove).setStartP(0);
				p_List.get(remove).setEndP(0);
				external_Fragmentation += p_List.get(remove).getProcess_Size();
				System.out.println("The external Fragmentation is:  " + external_Fragmentation );
				p_List.get(remove).remove_Or_Not = true;
				p_List.get(remove).internalP = 0;
				internal-= p_List.get(remove).internalP;
				break;
			//printing present status of the memory 	
			case 3:
				//printing which process is running and the inernal fragmentation 
				for (int i = 0; i < p_List.size(); i++) {
					if(p_List.get(i).remove_Or_Not == false && p_List.get(i).getEndP()!=0) {
						System.out.println("p"+i+ " is running in block: "
					+ (p_List.get(i).getStartP()+1) + " - " + p_List.get(i).getEndP() 
					+ " with " +p_List.get(i).internalP + "k Internal Fragmentation." );
						
					}
			
				}
				counter_Check = p_List.size()-1;
				//printing if there is available memory to use
				for (int i = 0; i < p_List1.size(); i++) {
					if (counter_Check >= 0) {
					if((p_List1.get(i)!= 1) && (i%(p_List.get(counter_Check).block) == 0 )) {
					System.out.println("block " + ((i+1)) + " - " +
									(i+ p_List.get(counter_Check).block) + " is available");
					counter_Check--;
					}
					}
				}
				break;
					
				}
				
						}
					}
	
	private static int memory_Allocate(int m_s , ArrayList<Process> p_l , int p_n , ArrayList<Integer> p_l1) {
		int in_order = 0;
		int counter_Divide = 2 ;
		
		System.out.println("process number "+ p_n);
		//int process_Number = sc.nextInt();
		System.out.println("Enter process size: (in Bytes) ");
		int process_Size = sc.nextInt();
		Process new_p = new Process(p_n, process_Size , 0 , 0 ); // create new process 
		p_l.add(new_p);
		//checking what's the minimum block in the memory the user choice fit
		while(p_l.get(p_n).getProcess_Size() <= m_s/counter_Divide) {
			counter_Divide*=2;
		}
		//initialize for each process block start and ending to "jump" by blocks of exponent in 2
		int block_Start = 0;
		int block_End = m_s /(counter_Divide/2);
		p_l.get(p_n).block =  m_s /(counter_Divide/2);
		double logOf2; 
		
		//checking if there enough place in the cuurent block of memory 
		for (int i = 0; i < counter_Divide/2; i++) {
			for (int x = block_Start; x < block_Start+p_l.get(p_n).getProcess_Size() && x< m_s ; x++) {
				if(p_l1.get(x) != 1) {
					in_order++; // counting how many place left in the memory by checking if the array list empty from one's
				}
			}
			logOf2 = Math.log(block_Start)/Math.log(2)%1;
			if((in_order == p_l.get(p_n).getProcess_Size()) && ((logOf2 == 0) || (block_Start == 0 ) )) { 
				for (int j = block_Start; j < p_l.get(p_n).getProcess_Size()+block_Start ; j++) {
					p_l1.set(j, 1);
				}
				p_l.get(p_n).setStartP(block_Start);
				p_l.get(p_n).setEndP(p_l.get(p_n).getProcess_Size()+block_Start);
				external_Fragmentation -= process_Size; //update size of external fragmentation each time process gets memory
				p_l.get(p_n).internalP = m_s /(counter_Divide/2) - p_l.get(p_n).getProcess_Size() ;
				block_Start = block_End;
				block_End = block_Start + m_s /(counter_Divide/2);
				return external_Fragmentation;
				//if we been through all blocks and there isn't place then we print a message
			}else if (i == (counter_Divide/2) -1) {
				
				System.out.println("There isn't more left memory to your size... :(");
				
			}
			
			block_Start = block_End; 
			block_End = block_Start + m_s /(counter_Divide/2)  ;
			in_order = 0;
			
		}
		
			return external_Fragmentation;

	}
	
}

