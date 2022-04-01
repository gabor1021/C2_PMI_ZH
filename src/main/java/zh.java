import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class zh {
    public static void main(String[] args) {
        //elso();
        masodik();
    }
    public static void elso(){
        Matrix elso = new Matrix();
        elso.feltolt(); //3x3 mátrix feltöltése billentyűzetről (soronként haladva)
        System.out.println("Nem 0 értékeket száma: " + elso.numberOfNonZeroValues());
        elso.indexOfColumnsWithSameValues();
    }
    public static void masodik(){
        Team elso=new Team();
        elso.newMember();
        elso.newMember();
        System.out.println(elso.getMembers());
        elso.leaveTeam();
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
        int temp;
        for (int i = 0, j = 0; i < 3; i++) {
            temp = matrix[i][j];
            while (temp == matrix[i][j] && i < 2) {
                i++;
            }
            if (i != 2) {
                j++;
                i = 0;
            } else System.out.println("Azonos értékeket tartalmazó oszlop indexe: " + j);
        }
    }
}
class Team{
    Scanner in= new Scanner(System.in);
    protected ArrayList<String> name=new ArrayList<>();
    protected ArrayList<String> position=new ArrayList<>();
    public void newMember(){
        System.out.println("Új csapattag hozzáadása");
        System.out.println("Név:");
        name.add(in.nextLine());
        System.out.println("Pozíció:");
        position.add(in.nextLine());
    }
    public void leaveTeam(){
        System.out.println("Hányadik csapattagot töröljem?");
        int index=in.nextInt();
        name.remove(index-1);
        position.remove(index-1);
    }
    public String getMembers(){
        String members="";
        for(int i=0;i< name.size();i++){
            members=members+name.get(i)+", "+position.get(i)+"\n";
        }
        return members;
    }
}
class PositionChanges extends Team{
    public void promote(){
        int index;
        String pos;
        Scanner in= new Scanner(System.in);
        System.out.println("Hányadik csapattagot kell előléptetni?");
        index=in.nextInt();
        System.out.println("Új pozíció:");
        pos=in.nextLine();
        position.set(index-1,pos);
    }
}