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

    // This functions delete a node in the LinkedList by a given "data"
    // parameter name changed as key in order to prevent confusion
    public LinkList deleteByName(int name) {

        if (!isEmpty()) {
            LinkList del;
            del = head;

            if (del.getName()==(name)) {
                head = head.next;
            } else if (del.next != null) {
                while (del.getName()!=(name)) {
                    del = del.next;
                    if (del == null)
                        break;
                }
            }


            if (del != null) {
                if (del.next != null) {
                    del.next.previous = del.previous;
                }

                if (del.previous != null) {
                    del.previous.next = del.next;
                }

                return del;
            }
        }
        return null;
    }



    // This functions delete a node in the LinkedList by a given position
    public LinkList deleteByPosition(int pos) {
        //Write your codes here
        LinkList del;
        del = head;
        if (pos == 0) {
            head = head.next;
        } else {

            for (int i = 0; i < pos; i++) {
                if (del != null) {
                    del = del.next;
                }
            }

            if (del.next != null) {
                del.next.previous = del.previous;
            }

            if (del.previous != null) {
                del.previous.next = del.next;
            }
        }
        return del;
    }

    //This function get the node in the given index
    //*********************DO NOTHING*********************
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

    // This function prints  the LinkenList
    //*********************DO NOTHING*********************
    public void print() {

        if(this.isEmpty())
            return;
        LinkList patient = this.head;  // make a copy of head
        int index = 1;

        // never operate on "head", otherwise you will lost the linkedlist
        //unless you want to change "head"
        while (patient != null) {
            System.out.println(index++ + ". " + patient.getName());

            patient = patient.next;  // iterate to next node
        }

    }

}
