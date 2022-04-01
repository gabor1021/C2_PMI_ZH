import java.util.ArrayList;
import java.util.Scanner;

public class zh {
    public static void main(String[] args) {
        elso();
        masodik();
        harmadik();
    }

    public static void elso() {
        Matrix elso = new Matrix();
        elso.feltolt(); //3x3 mátrix feltöltése billentyűzetről (soronként haladva)
        System.out.println("Nem 0 értékek száma: " + elso.numberOfNonZeroValues());
        System.out.println("Azonos értékeket tartalmazó oszlopok indexe:");
        elso.indexOfColumnsWithSameValues();
    }

    public static void masodik() {
        Team elso = new Team();
        elso.newMember();
        elso.newMember();
        System.out.println(elso.getMembers());
        elso.leaveTeam();
        System.out.println(elso.getMembers());
    }

    public static void harmadik() {
        PositionChanges elso = new PositionChanges();
        elso.newMember();
        elso.newMember();
        System.out.println(elso.getMembers());
        elso.promote();
        System.out.println(elso.getMembers());
    }
}

class Matrix {
    Scanner in = new Scanner(System.in);
    private int[][] matrix = new int[3][3];

    public void feltolt() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
    }

    public int numberOfNonZeroValues() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] != 0) count++;
            }
        }
        return count;
    }

    public void indexOfColumnsWithSameValues() {
        int[][] matrix2=new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix2[j][i] = matrix[i][j];
            }
        }
        int temp;
        boolean same=true;
        String a="";
        for (int i = 0; i < 3; i++) {
            temp=matrix2[i][0];
            for (int j = 0; j < 3; j++) {
                if (matrix2[i][j]!=temp)same=false;
            }
            if (same){
                same=false;
                a=a+i+", ";
            }
        }
        System.out.println(a);
    }
}

class Team {
    Scanner in = new Scanner(System.in);
    protected ArrayList<String> name = new ArrayList<>();
    protected ArrayList<String> position = new ArrayList<>();

    public void newMember() {
        System.out.println("Új csapattag hozzáadása");
        System.out.println("Név:");
        name.add(in.nextLine());
        System.out.println("Pozíció:");
        position.add(in.nextLine());
    }

    public void leaveTeam() {
        System.out.println("Hányadik csapattagot töröljem?");
        int index = in.nextInt();
        try {
            name.remove(index - 1);
            position.remove(index - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nincs ilyen csapattag");
        }
    }

    public String getMembers() {
        String members = "";
        for (int i = 0; i < name.size(); i++) {
            members = members + name.get(i) + ", " + position.get(i) + "\n";
        }
        return members;
    }
}

class PositionChanges extends Team {
    public void promote() {
        int index;
        String pos;
        Scanner in = new Scanner(System.in);
        System.out.println("Új pozíció:");
        pos = in.nextLine();
        System.out.println("Hányadik csapattagot kell előléptetni?");
        index = in.nextInt();
        try {
            position.set(index-1, pos);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nincs ilyen csapattag");
        }
    }
}