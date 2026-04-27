import java.util.ArrayList;

class HashTableTask8 {
    static class HashTable {
        ArrayList<Integer>[] table;
        int size;

        HashTable(int size) {
            this.size = size;
            table = new ArrayList[size];
            for (int i = 0; i < size; i++) {
                table[i] = new ArrayList<Integer>();
            }
        }

        int hash(int key) {
            return key % size;
        }

        void add(int key) {
            int index = hash(key);
            table[index].add(key);
        }

        void printTable() {
            for (int i = 0; i < size; i++) {
                System.out.print(i + ": ");
                for (int j = 0; j < table[i].size(); j++) {
                    System.out.print(table[i].get(j) + " ");
                }
                System.out.println();
            }
        }

        int sum() {
            int sum = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < table[i].size(); j++) {
                    sum += table[i].get(j);
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable(5);

        ht.add(10);
        ht.add(15);
        ht.add(7);
        ht.add(22);
        ht.add(3);

        System.out.println("Hash table:");
        ht.printTable();

        System.out.println("Sum of elements: " + ht.sum());
    }
}