public class Dt {
    LinkList head; //head of list
    LinkList tail; //tail of list

    //Constructor
    public Dt() {
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

    //This method finds how many patients are exist in LinkedList
    public int size() {
        //Write your codes here
        int count = 0;
        if (isEmpty()){
            return count;
        }else{
            count++;
            LinkList temp = head;
            while (temp.next != null) {
                temp = temp.next;
                count++;
            }
        }
        return count;
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
