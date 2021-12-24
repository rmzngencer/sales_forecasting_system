public class LinkList {

        private int name;
    LinkList next;
    LinkList previous;

        //Constructor
        public LinkList(int n){
            this.name = n;
            this.next=null;
            this.previous=null;
        }

        //Getter method
        public int getName(){
            return this.name;
        }



}
