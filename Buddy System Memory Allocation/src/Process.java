		public class Process {
			private int process_Number;
			private int process_Size;
			public boolean remove_Or_Not; //which procees did we removed 
			private int startP; // start block of internal fragmentation
			private int endP;  // end block of internal fragmentation
			public int internalP; // sum of  internal fragmentation
			public int block; 
		


		public Process(int p_n , int p_s , int start , int end ) {
			setProcess_Number(p_n);
			setProcess_Size(p_s);
			this.remove_Or_Not = false;
			setStartP(start);
			setEndP(end);	
		}

		public int getProcess_Number() {
			return process_Number;
		}

		public void setProcess_Number(int process_Number) {
			this.process_Number = process_Number;
		}

		public int getProcess_Size() {
			return process_Size;
		}

		public void setProcess_Size(int process_Size) {
			this.process_Size = process_Size;
		}
		
		public int getStartP() {
			return startP;
		}

		public void setStartP(int startP) {
			this.startP = startP;
		}

		public int getEndP() {
			return endP;
		}

		public void setEndP(int endP) {
			this.endP = endP;
		}

		public boolean isRemove_Or_Not() {
			return remove_Or_Not;
		}

		public void setRemove_Or_Not(boolean remove_Or_Not) {
			this.remove_Or_Not = remove_Or_Not;
		}


		
		
		
	}
