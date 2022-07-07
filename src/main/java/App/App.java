package App;

import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);
        int id = 1;

        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            switch (cmd) {
                case "종료":
                    break outer;
                case "등록":
                    System.out.print("명언 : ");
                    String words = sc.nextLine().trim();
                    System.out.print("작가 : ");
                    String author = sc.nextLine().trim();
                    System.out.println(id + "번 명언이 등록되었습니다.");

                    Saying saying = new Saying(id, words, author);
//                    System.out.println(saying);

                case "목록":
                    System.out.println("번호 / 작가 / 명언");

            }
            id++;
        }
        sc.close();
    }
}