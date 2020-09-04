package chap04.section1.paragraph2.practise;

//Practise2
public class Gstack<E> {
    private int max;
    private int ptr;
    private E[] stk;

    public Gstack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = (E[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public E push(E x) throws OverflowIntStackException {
        if (ptr >= max) {
            throw new OverflowIntStackException();
        }
        return stk[ptr++] = x;
    }

    public E pop() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[--ptr];
    }

    public E peek() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[ptr - 1];
    }

    public void dump() {
        if (ptr <= 0) {
            System.out.println("스택이 비어 있습니다.");
        } else {
            for (int i = 0; i < ptr; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Gstack<String> strStack = new Gstack<>(10);
        Gstack<Integer> intStack = new Gstack<>(10);

        strStack.push("a");
        strStack.push("b");
        strStack.push("c");
        strStack.push("d");
        strStack.dump();

        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        intStack.dump();
    }
}

class EmptyIntStackException extends RuntimeException {
    public EmptyIntStackException() {
    }
}

class OverflowIntStackException extends RuntimeException {
    public OverflowIntStackException() {
    }
}
