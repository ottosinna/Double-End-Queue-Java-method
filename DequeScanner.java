import java.util.Scanner;
public class DequeScanner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        print("Choose Queue Aray Size: ");
        int size = sc.nextInt();
        Deque deque = new Deque(size);
        print("Queue size: " + deque.size());

        while(true){
            print("Menu Options:");
            print("0. Exit");
            print("1. Insert Front");
            print("2. Insert Back");
            print("3. Remove Front");
            print("4. Remove Back");
            print("5. Get Front");
            print("6. Get Back");
            print("7. Peek  nth");
            print("8. Check if Empty");
            print("9. Check if Full");
            print("10. Clear Deque");
            print("11. Rotate Deque");

            int choice = sc.nextInt();

            switch(choice){
                case 0:
                    print("Exiting...");
                    sc.close();
                    return;
                case 1:
                    print("Enter value to insert at front: ");
                    int frontVal = sc.nextInt();
                    deque.insertFront(frontVal);
                    print("Inserted " + frontVal + " at front.");
                    break;
                case 2:
                    print("Enter value to insert at back: ");
                    int backVal = sc.nextInt();
                    deque.insertBack(backVal);
                    print("Inserted " + backVal + " at back.");
                    break;
                case 3:
                    int removedFront = deque.removeFront();
                    print("Removed " + removedFront + " from front.");
                    break;
                case 4:
                    int removedBack = deque.removeBack();
                    print("Removed " + removedBack + " from back.");
                    break;
                case 5:
                    int frontItem = deque.getFront();
                    print("Front item: " + frontItem);
                    break;
                case 6:
                    int backItem = deque.getRear();
                    print("Back item: " + backItem);
                    break;  
                case 7:
                    print("Enter index to peek: ");
                    int index = sc.nextInt();
                    int peekedItem = deque.peekNth(index);
                    print("Item at index " + index + ": " + peekedItem);
                    break;
                case 8:
                    print("Is Deque Empty? " + deque.isEmpty());
                    break;
                case 9:
                    print("Is Deque Full? " + deque.isFull());
                    break;
                case 10:
                    deque.clear();
                    print("Deque cleared.");
                    break;
                case 11:
                    print("Enter number of rotations (positive for right, negative for left): ");
                        int rotations = sc.nextInt();
                        deque.rotate(rotations);
                        print("Deque rotated by " + rotations + " positions.");
                        break;
                default:
                    print("Invalid choice. Please try again.");
            }
        }
    }
    static void print(String s){
        System.out.println(s);
    }
}