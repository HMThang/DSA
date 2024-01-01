package Lab2;

public class TowersofHanoi {
   public static void moveDisk(int disk, char source, char dest, char spare) {
        if (disk == 0) {
            System.out.println("Move disk " + disk + " from rod " + source + " to rod " + dest);
        } else {
            moveTower(disk - 1, source, spare, dest); // Bước 1
            System.out.println("Move disk " + disk + " from rod " + source + " to rod " + dest); // Bước 2
            moveTower(disk - 1, spare, dest, source); // Bước 3
        }
    }

    public static void moveTower(int disk, char source, char dest, char spare) {
        moveDisk(disk, source, dest, spare);
    }
}
