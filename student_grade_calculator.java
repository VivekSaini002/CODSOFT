import java.util.Scanner;

public class student_grade_calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Hindi marks out of 100");
        int Hindi = sc.nextInt();
        System.out.println("Enter your English marks out of 100");
        int English = sc.nextInt();
        System.out.println("Enter your Math marks out of 100");
        int Math = sc.nextInt();
        System.out.println("Enter your Science marks out of 100");
        int Science = sc.nextInt();
        System.out.println("Enter your Computer marks out of 100");
        int Computer = sc.nextInt();

        int total_marks = (Hindi+English+Math+Science+Computer);
        System.out.println("Your total marks is : "+ total_marks);

        float average_percentage = (total_marks/500.0f)*100;
        System.out.println("Your average percentage is : "+ average_percentage);

        char Grade;
        if (average_percentage >= 90.0){
            Grade = 'A';
        } else if (average_percentage >= 80.0) {
            Grade = 'B';
        } else if (average_percentage >= 70.0) {
            Grade = 'C';
        } else if (average_percentage >= 60.0) {
            Grade = 'D';
        } else if (average_percentage >= 50.0) {
            Grade = 'E';
        }else if (average_percentage >= 40.0){
            Grade = 'P';
        }else{
            Grade = 'F';
        }
        System.out.println("Your grade is : "+ Grade);
    }
}
