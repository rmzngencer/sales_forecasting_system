public class Ft {
    LinkList head; //head of list
    LinkList tail; //tail of list

    //Constructor
    public Ft() {
        //Write your codes here
        this.head=null;
        this.tail=null;
    }

    //Check list is empty or not
    public boolean isEmpty() {
        //Write your codes here
        return head == null;
    }

    //This function first builds new patient with the given data
    //than adds it to the LinkedList
    //new nodes are added to the tail of LinkedList
    public void insert(int name) {
        //Write your codes here

        LinkList newLinkList = new LinkList(name);


        if (isEmpty()) {
            head = tail = newLinkList;
            head.previous = null;
        } else {

            tail.next = newLinkList;
            newLinkList.previous = tail;
            tail = newLinkList;
        }
        tail.next = null;
    }

    // overload this method as new nodes are added to given position (int pos)
    // fill the rest
    public void insert(int name, int pos) {
        //Write your codes here
        LinkList newList = new LinkList(name);
        newList.next = null;
        newList.previous = null;

        if (isEmpty()) {
            head = tail = newList;
            head.previous = null;
            tail.next = null;
        }else {
            if (pos == 0) {
                newList.next = head;
                head.previous = newList;
                head = newList;
            } else {
                LinkList temp;
                temp = head;
                for (int i = 1; i < pos; i++) {
                    if (temp != null) {
                        temp = temp.next;
                    }
                }
                if (temp != null) {
                    newList.next = temp.next;
                    newList.previous = temp;
                    temp.next = newList;
                    if (newList.next != null) {
                        newList.next.previous = newList;
                    }
                } else {
                    System.out.print("\nThe previous node is null.");
                }
            }
        }
    }


    public LinkList getByPosition(int pos){
        if(this.isEmpty())
            return new LinkList(0);
        LinkList current = this.head;
        int index = 0;

        while (current != null){
            if(index++ == pos)
                break;
            current = current.next;
        }

        if(current == null)
            return new LinkList(0);

        return current;
    }
}
