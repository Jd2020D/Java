import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public class SinglyLinkedList {
    public Node head;
    private int length=0;
    public SinglyLinkedList() {}
    public SinglyLinkedList(int value) {
        this.head=new Node(value);
    }
    public int getLength(){
        return this.length;
    }
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
        this.length++;
    }
    public Integer remove() {
        if(this.length==0){
            return null;
        } else {
            Node runner = head;
            while(runner.next.next != null) {
                runner = runner.next;
            }
            Integer val=runner.next.value;
            runner.next=null;
            this.length--;
            return val;
        }
    }
    public void printValues(){
        Node runner = head;
        while(runner!=null)
        {
            System.out.println(runner.value);
            runner=runner.next;
        }
    }
    public Node find(int value){
        Node runner = this.head;
        while(runner!=null)
        {
            if (runner.value == value)
                return runner;
            runner=runner.next;
        }
        return runner;
    }
    public void removeAt(int n){
        if(this.length>n){
            Node runner = this.head;
            if (n==0){
                this.head=runner.next;
                runner.next=null;  
            }
            else{
                for (int i = 0; i < n-1; i++) {
                    runner=runner.next;
                }
                Node node=runner.next;
                runner.next=runner.next.next;
                node.next=null;
            }
            this.length--;
        }
        else{
            System.out.println("index out of range");
        }

    }

        
}