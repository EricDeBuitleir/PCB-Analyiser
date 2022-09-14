package sample;

import java.io.Serializable;

public class myLinkedList<F> implements Serializable {

    public myLinkedListNode<F> head = null;

    public void addElement(F e) {
        myLinkedListNode<F> fn = new myLinkedListNode<>();
        fn.setContents(e);
        fn.next = head;
        head = fn;
    }

    public void delete(int index) {
        myLinkedListNode<F> temp = head;
        if (index == 0)
        {
            head = head.next;

        }

        while(index < 0 && temp != null){
            temp  = temp.next;

        }
        if (temp != null && temp.next != null){
            temp.next = temp.next.next;
        }
    }

    public F get(int index){
        // if you want to invert the list | index=size()-index-1; ?????
        myLinkedListNode<F> temp = head;
        for (int i = 0 ; i<index && temp!=null ; i++)
            temp = temp.next;

        return temp!=null ? temp.getContents() : null;
    }

    public int size(){
        int size = 1;
        myLinkedListNode<F> temp = head;
        if(temp == null){
            return 0;
        }
        while(temp.next != null){
            temp = temp.next;
            size++;
        }
        return size;
    }
    public void resetAll(){

        head = null;
    }


//    public void Search (searchCentre){
//        myLinkedListNode<F> temp = head;
//        if()
//    }




   public class myLinkedListNode<F> {
        public myLinkedListNode<F> next = null;
        public F contents;

        public F getContents() {
            return contents;
        }
        public void setContents(F c) {
            contents = c;
        }
    }
}
