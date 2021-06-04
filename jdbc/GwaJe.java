package jdbc;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
 
public class GwaJe {
    
    static final int MAX = 100;
  
    static String[] nameList = new String[MAX];
    static char[] genderList = new char[MAX];
    static String[] emailList = new String[MAX];
    static int[] birthList = new int[MAX];
    
    static int count = 0;
     
    static int index = -1;
    
    static Scanner scan = new Scanner(System.in);
 
    public static void main(String[] args) {        
        
    	
    	
        while(true) {
            
            System.out.println("\n[INFO] 고객 수: " 
            + count + ", 인덱스: " + index);
            System.out.println("메뉴를 입력하세요.");
            System.out.println("(I)nsert, (P)revious, "
                    + "(N)ext, (C)urrent, (U)pdate, "
                    + "(D)elete, (Q)uit");
            System.out.print("메뉴 입력: ");
            String menu = scan.next();
            menu = menu.toLowerCase();
            char m = menu.charAt(0);
            
            String text = "저장할 값입니다.";

            String fileNm = "F:\\Java\\GwaJe\\Note.txt";

            try{


            File file = new File(fileNm);

            FileWriter fileWrite = new FileWriter(file, true);

            fileWrite.write(text);

            fileWrite.flush(); 

            fileWrite.close();


            } catch (Exception e){

            e.printStackTrace();
            }
            
            switch(m) {
            
            case 'i':
            case 'ㅑ':
                System.out.println("\n고객 정보 입력을 시작합니다.");
                insertData();
                System.out.println("고객 정보가 정상적으로 입력되었습니다.");
                break;
            case 'p':
            case 'ㅔ':
                System.out.println("\n이전 고객정보를 출력합니다.");
                
                if(index <= 0) {
                    System.out.println("이전 고객정보가 존재하지 않습니다.");
                }else {
                    index--;
                    printData(index);                    
                }                
                break;
            case 'n':
            case 'ㅜ':
                System.out.println("\n다음 고객정보를 출력합니다.");
                
                if(index >= count-1) {
                    System.out.println("다음 고객정보가 존재하지 않습니다.");
                }else {                    
                    index++;
                    printData(index);                    
                }
                break;
            case 'c':
            case 'ㅊ':
                System.out.println("\n현재 고객정보를 출력합니다.");
                
                if(index >= 0 && index < count) {
                    printData(index);
                } else {
                    System.out.println("현재 고객정보가 존재하지 않습니다.");
                }
                break;
            case 'u':
            case 'ㅕ':
                if(index >= 0 && index < count) {
                    System.out.println(nameList[index] + "님의 정보를 수정합니다.");
                    updateData(index);
                    System.out.println("고객 정보가 정상적으로 수정되었습니다.");
                }else {
                    System.out.println("수정할 데이터가 존재하지 않습니다.");
                }
                break;
            case 'd':
            case 'ㅇ':
                if(index >= 0 && index < count) {
                    System.out.println(nameList[index] + "님의 정보를 삭제합니다.");
                    deleteData(index);
                    System.out.println("고객 정보가 정상적으로 삭제되었습니다.");
                }else {
                    System.out.println("삭제할 데이터가 존재하지 않습니다.");
                }
                
                break;
            case 'q':
            case 'ㅂ':
                System.out.println("\n프로그램을 종료합니다.");
                scan.close();
                System.exit(0);
                break;
            
            default:
                System.out.println("메뉴를 잘못 입력했습니다.");
            }        
            
            
            
        }
    }
    
    
    static void insertData() {
        
        System.out.println("========고객 정보 입력========");
        System.out.print("이름: ");
        String name = scan.next();
        
        System.out.print("성별(M/F): ");
        String str = scan.next();
        char gender = str.charAt(0);
        
        System.out.print("이메일: ");
        String email = scan.next();
        
        System.out.print("출생년도: ");
        int birth = scan.nextInt();
        
        System.out.println("===========================");
        
        nameList[count] = name;
        genderList[count] = gender;
        emailList[count] = email;
        birthList[count] = birth;
        
        count++;
    }
    
    static void printData(int index) {
        
        System.out.println("\n======고객 정보======");
        System.out.println("이름: " + nameList[index]);
        System.out.println("성별: " + genderList[index]);
        System.out.println("이메일: " + emailList[index]);
        System.out.println("출생년도: " + birthList[index]);
        System.out.println("=====================");
    }
    
    static void updateData(int index) {
        
        System.out.println("\n========고객 정보 수정========");
        System.out.print("이름(" + nameList[index] + "): ");
        nameList[index] = scan.next();
        
        System.out.print("성별(" + genderList[index] + "): ");
        genderList[index] = scan.next().charAt(0);
        
        System.out.print("이메일(" + emailList[index] + "): ");
        emailList[index] = scan.next();
        
        System.out.print("출생년도(" + birthList[index] + "): ");
        birthList[index] = scan.nextInt();
    }
    
    static void deleteData(int index) {
        
        for(int i=index; i<count-1; i++) {
            nameList[i] = nameList[i+1];
            genderList[i] = genderList[i+1];
            emailList[i] = emailList[i+1];
            birthList[i] = birthList[i+1];
        }
        count--;
    }
 
}