import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Quadrangle {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            System.out.println("жопа");
            FileReader fileReader = new FileReader("new2.txt"); //
            Scanner sc = new Scanner(fileReader);

            while (sc.hasNextLine()) {
                arrayList.add(sc.nextInt());
            }
            sc.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Polygon polygon = new Polygon();
        polygon.addPoint(arrayList.get(0), arrayList.get(1));
        polygon.addPoint(arrayList.get(2), arrayList.get(3));
        polygon.addPoint(arrayList.get(4), arrayList.get(5));
        polygon.addPoint(arrayList.get(6), arrayList.get(7));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите координату x:");
        int x = Integer.parseInt(reader.readLine());
        System.out.println("Введите координату y:");
        int y = Integer.parseInt(reader.readLine());
        reader.close();

        if ((x == arrayList.get(0) & y == arrayList.get(1)) |
                (x == arrayList.get(2) & y == arrayList.get(3)) |
                (x == arrayList.get(4) & y == arrayList.get(5)) |
                (x == arrayList.get(6) & y == arrayList.get(7))) {
            System.out.println("точка - вершина четырехугольника");
        } else if ((x * (arrayList.get(3) - arrayList.get(1)) - y * (arrayList.get(2) - arrayList.get(0)) == arrayList.get(0) * arrayList.get(3) - arrayList.get(2) * arrayList.get(1)) |
                (x * (arrayList.get(5) - arrayList.get(3)) - y * (arrayList.get(4) - arrayList.get(2)) == arrayList.get(2) * arrayList.get(5) - arrayList.get(4) * arrayList.get(3)) |
                (x * (arrayList.get(7) - arrayList.get(5)) - y * (arrayList.get(6) - arrayList.get(4)) == arrayList.get(4) * arrayList.get(7) - arrayList.get(6) * arrayList.get(5)) |
                (x * (arrayList.get(1) - arrayList.get(7)) - y * (arrayList.get(0) - arrayList.get(6)) == arrayList.get(6) * arrayList.get(1) - arrayList.get(0) * arrayList.get(7))
        ) {
            System.out.println("точка лежит на сторонах четырехугольника");
        } else if (polygon.contains(x, y)) {
            System.out.println("точка внутри четырехугольника");
        } else System.out.println("точка снаружи четырехугольника");
    }
}
