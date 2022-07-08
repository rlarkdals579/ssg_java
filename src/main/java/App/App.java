package App;

/**
 * == 명언 SSG ==
 * 명령) 등록
 * 명언 : 현재를 사랑하라.
 * 작가 : 작자미상
 * 1번 명언이 등록되었습니다.
 * 명령) 등록
 * 명언 : 과거에 집착하지 마라.
 * 작가 : 작자미상
 * 2번 명언이 등록되었습니다.
 * 명령) 목록
 * 번호 / 작가 / 명언
 * ----------------------
 * 2 / 작자미상 / 과거에 집착하지 마라.
 * 1 / 작자미상 / 현재를 사랑하라.
 * 명령) 삭제?id=1
 * 1번 명언이 삭제되었습니다.
 * 명령) 삭제?id=1
 * 1번 명언은 존재하지 않습니다.
 * 명령) 수정?id=2
 * 2번 명언을 수정합니다.
 * 기존 명언 : 과거에 집착하지 마라.
 * 새 명언 : 미래와 과거에 집착하지 마라.
 * 2번 명언이 수정되었습니다.
 * 명령) 목록
 * 번호 / 작가 / 명언
 * ----------------------
 * 2 / 작자미상 / 미래와 과거에 집착하지 마라.
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");

        ArrayList<Saying> sayingArrayList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int id = 1;

        outer:
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            switch (cmd) {
                case "종료":
                    break outer;
                case "등록":
                    System.out.print("명언 : ");
                    String words = sc.nextLine().trim();

                    System.out.print("작가 : ");
                    String author = sc.nextLine().trim();

                    System.out.println(id + "번 명언이 등록됐습니다.");
                    Saying saying = new Saying(id, words, author);
                    sayingArrayList.add(saying);
                    break;

                case "목록":
                    System.out.println("번호 /   작가   /   명언   ");
                    System.out.println("------------------------------");
                    for(int i = sayingArrayList.size()-1; i>= 0; i--){
                        Saying saying1 = sayingArrayList.get(i);
                        System.out.printf("%d   /    %s    /   %s\n",
                                saying1.id, saying1.words, saying1.author);                    }

            }
            id++;
        }
        sc.close();
    }
}