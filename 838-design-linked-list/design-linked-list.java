class Node{
    int data;
    Node prev;
    Node next;
    Node(int data){
        this.data = data;
    }
}
class MyLinkedList {
    Node start; // start or head
    // start = null (no reference)
    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if(index<0){
            return -1;
        }
        Node temp = start;
        for(int i =0 ; i<index && temp!=null; i++){
            temp = temp.next;
        }
        return temp==null?-1:temp.data;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        if(start == null){
            start = node;
        }
        else{
            node.next = start;
            start.prev = node;
            start = node;
        }
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        if(start == null){
            start = node;
        }
        else{
            Node temp= start;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0){
            return ;
        }
        if(index == 0 ){
            addAtHead(val);
            return ;
        }
        Node temp = start;
        for(int i = 0 ; i<index-1 && temp!=null; i++){
            temp = temp.next;
        }
        if(temp == null){
            return ;
        }
        // end
        if(temp.next == null){
           addAtTail(val);
           return ;
        }
        Node node = new Node(val);
        node.prev = temp;
        node.next = temp.next;
        temp.next.prev = node;
        temp.next = node;

    }
    
    public void deleteAtIndex(int index) {
        if(index<0){
            return ;
        }
        if(start == null){
            return ;
        }
        if(index ==0){
            start = start.next;
            if(start == null){
                return ;
            }
            start.prev = null;
            return ;
        }
        Node temp = start;
        for(int i = 0; i<index-1 && temp!=null; i++){
            temp = temp.next;
        }
        if(temp==null || temp.next ==null){
            return ;
        }
        if(temp.next.next == null){
            temp.next = null;
            return ;
        }
        temp.next.next.prev = temp;
        temp.next = temp.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */