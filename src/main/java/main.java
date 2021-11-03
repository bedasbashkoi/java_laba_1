import java.util.Scanner;

/**
 * @autor Азаров Илья https://github.com/bedasbashkoi/java_laba_1.git
 */

class Container
{
    static class Node
    {
        int value;
        Node next;

        Node(int value)
        {
            this.value = value;
            next = null;
        }
    }

    Node head;

    static Container add(Container container, int value)
    {
        Node add_new_node = new Node(value);
        add_new_node.next = null;

        if(container.head == null)
        {
            container.head = add_new_node;
        }
        else
        {
            Node tail = container.head;
            while (tail.next != null)
            {
                tail = tail.next;
            }
            tail.next = add_new_node;
        }
        return container;
    }

    static Container delete_by_position(Container container,int position)
    {
        Node current_node = container.head, prev = null;
        if (position == 0 && current_node!=null)
        {
            container.head = current_node.next;
            System.out.println("element on "+ position +"  position deleted");
            return container;
        }
        else
        {
            int counter = 0;
            while (current_node!=null)
            {
                if(counter == position)
                {
                    prev.next = current_node.next;
                    System.out.println("element on "+ position +"  position deleted");
                    return container;
                }
                else
                {
                    prev = current_node;
                    current_node = current_node.next;
                    counter++;
                }
            }
        }
        System.out.println("element on "+ position +"  position not found");
        return container;
    }

    static Container delete_by_value(Container container, int value)
    {
        Node current_node = container.head;
        int counter = 0;
        int change_counter = 0;
        while(current_node!=null)
        {
            if (current_node.value == value)
            {
                container.delete_by_position(container,counter);
                counter = 0;
                change_counter++;
                current_node = container.head;
            }
            counter++;
            current_node = current_node.next;
        }
        if(change_counter == 0)
        {
            System.out.println("element with value " + value + " not found");
        }
        else
        {
            System.out.println("Deleted " + change_counter + " elements with value " + value);
        }
        return container;
    }

    static void print(Container container)
    {
        Node current_node = container.head;
        if (current_node == null)
        {
            System.out.println("Your List is empty");
        }
        else
        {
            System.out.println("Your List:");
            while(current_node != null)
            {
                System.out.println(current_node.value + "");
                current_node = current_node.next;
            }
        }
    }
}

public class main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int choice = 1;
        Container cnt = new Container();
        do{
            System.out.println("1 - add, 2 - delete by position, 3 - delete by value, 4 - print, 0 - exit");
            choice = console.nextInt();
            switch (choice)
            {
                case 1:
                {
                    System.out.println("Number of elements:");
                    int number = console.nextInt();
                    System.out.println("input elements:");
                    for (int i = 0;i<number;i++)
                    {
                        int element = console.nextInt();
                        cnt.add(cnt,element);
                    }
                    cnt.print(cnt);
                };break;
                case 2:
                {
                    System.out.println("Input position");
                    int position = console.nextInt();
                    cnt.delete_by_position(cnt,position);
                    cnt.print(cnt);
                };break;
                case 3:
                {
                    System.out.println("Input value");
                    int value = console.nextInt();
                    cnt.delete_by_value(cnt,value);
                    cnt.print(cnt);
                };break;
                case 4:
                {
                    cnt.print(cnt);
                }
            }
        }while(choice!=0);
    }
}
