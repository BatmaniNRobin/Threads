	class IntNode{
		private int data;
		private IntNode next;
		
		public IntNode(int n){
			data = n;
		}
		
		public int getData(){
			return data;
		}
		
		public IntNode getNext(){
			return next;
		}
		
		public void setNode(IntNode nn){
			next = nn;
		}
	}
