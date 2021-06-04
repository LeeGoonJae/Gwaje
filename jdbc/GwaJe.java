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
            
            System.out.println("\n[INFO] �� ��: " 
            + count + ", �ε���: " + index);
            System.out.println("�޴��� �Է��ϼ���.");
            System.out.println("(I)nsert, (P)revious, "
                    + "(N)ext, (C)urrent, (U)pdate, "
                    + "(D)elete, (Q)uit");
            System.out.print("�޴� �Է�: ");
            String menu = scan.next();
            menu = menu.toLowerCase();
            char m = menu.charAt(0);
            
            String text = "������ ���Դϴ�.";

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
            case '��':
                System.out.println("\n�� ���� �Է��� �����մϴ�.");
                insertData();
                System.out.println("�� ������ ���������� �ԷµǾ����ϴ�.");
                break;
            case 'p':
            case '��':
                System.out.println("\n���� �������� ����մϴ�.");
                
                if(index <= 0) {
                    System.out.println("���� �������� �������� �ʽ��ϴ�.");
                }else {
                    index--;
                    printData(index);                    
                }                
                break;
            case 'n':
            case '��':
                System.out.println("\n���� �������� ����մϴ�.");
                
                if(index >= count-1) {
                    System.out.println("���� �������� �������� �ʽ��ϴ�.");
                }else {                    
                    index++;
                    printData(index);                    
                }
                break;
            case 'c':
            case '��':
                System.out.println("\n���� �������� ����մϴ�.");
                
                if(index >= 0 && index < count) {
                    printData(index);
                } else {
                    System.out.println("���� �������� �������� �ʽ��ϴ�.");
                }
                break;
            case 'u':
            case '��':
                if(index >= 0 && index < count) {
                    System.out.println(nameList[index] + "���� ������ �����մϴ�.");
                    updateData(index);
                    System.out.println("�� ������ ���������� �����Ǿ����ϴ�.");
                }else {
                    System.out.println("������ �����Ͱ� �������� �ʽ��ϴ�.");
                }
                break;
            case 'd':
            case '��':
                if(index >= 0 && index < count) {
                    System.out.println(nameList[index] + "���� ������ �����մϴ�.");
                    deleteData(index);
                    System.out.println("�� ������ ���������� �����Ǿ����ϴ�.");
                }else {
                    System.out.println("������ �����Ͱ� �������� �ʽ��ϴ�.");
                }
                
                break;
            case 'q':
            case '��':
                System.out.println("\n���α׷��� �����մϴ�.");
                scan.close();
                System.exit(0);
                break;
            
            default:
                System.out.println("�޴��� �߸� �Է��߽��ϴ�.");
            }        
            
            
            
        }
    }
    
    
    static void insertData() {
        
        System.out.println("========�� ���� �Է�========");
        System.out.print("�̸�: ");
        String name = scan.next();
        
        System.out.print("����(M/F): ");
        String str = scan.next();
        char gender = str.charAt(0);
        
        System.out.print("�̸���: ");
        String email = scan.next();
        
        System.out.print("����⵵: ");
        int birth = scan.nextInt();
        
        System.out.println("===========================");
        
        nameList[count] = name;
        genderList[count] = gender;
        emailList[count] = email;
        birthList[count] = birth;
        
        count++;
    }
    
    static void printData(int index) {
        
        System.out.println("\n======�� ����======");
        System.out.println("�̸�: " + nameList[index]);
        System.out.println("����: " + genderList[index]);
        System.out.println("�̸���: " + emailList[index]);
        System.out.println("����⵵: " + birthList[index]);
        System.out.println("=====================");
    }
    
    static void updateData(int index) {
        
        System.out.println("\n========�� ���� ����========");
        System.out.print("�̸�(" + nameList[index] + "): ");
        nameList[index] = scan.next();
        
        System.out.print("����(" + genderList[index] + "): ");
        genderList[index] = scan.next().charAt(0);
        
        System.out.print("�̸���(" + emailList[index] + "): ");
        emailList[index] = scan.next();
        
        System.out.print("����⵵(" + birthList[index] + "): ");
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