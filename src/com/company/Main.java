package com.company;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Main {
     static Map<String, String> map = new HashMap<String, String>();
    public static void main(String[] args) throws ParseException {
        String csvFile = "src\\netflix_titles.csv";
        String line = "";

        System.out.println("Press 1 for List the first n records & filter on basis of type");
        System.out.println("Press 2 for List the first n records & filter on basis of listed_in ");
        System.out.println("Press 3 for List the first n & filter on basis of type and country");
//        System.out.println("Press 4 for List the first n type for the date Range duration which were added between Month Date, Year to Month Date, Year");

        Scanner s = new Scanner(System.in);
        int searchTerm = s.nextInt();

        switch (searchTerm) {
            case 1:
                System.out.println("Enter the value of n");
                Scanner s1 = new Scanner(System.in);
                int n = s1.nextInt();
                readRecordTVShow(n, csvFile);
                break;
            case 2:
                System.out.println("Enter the value of n");
                Scanner s2 = new Scanner(System.in);
                int n1 = s2.nextInt();
                readRecordlisted(n1, csvFile);
                break;
            case 3:
                System.out.println("Enter the value of n");
                Scanner s3 = new Scanner(System.in);
                int n2 = s3.nextInt();
                readRecordMovie(n2, csvFile);
                break;

//            case 4:
//                Date date1=null;
//                Date date2=null;
//
//                System.out.println("Enter the value of n");
//                Scanner s4 = new Scanner(System.in);
//                int n3 = s4.nextInt();
//
//
//                System.out.println("Enter the starting range of duration");
//                Scanner s5 = new Scanner(System.in);
//                SimpleDateFormat format = new SimpleDateFormat("MM/yyyy");
//                String startDate = s5.nextLine();
//                if(null != startDate && startDate.trim().length() > 0){
//                    date1 = format.parse(startDate);
//                }
//                System.out.println("Enter the ending range of duration");
//                Scanner s6 = new Scanner(System.in);
//                SimpleDateFormat format1 = new SimpleDateFormat("MM/yyyy");
//                String endDate = s6.nextLine();
//
//                if(null != endDate && endDate.trim().length() > 0){
//                    date2 = format1.parse(endDate);
//                }
//                System.out.println(date1);
//                readRecordTime(n3,csvFile, date1,date2);
//                break;
            default:{
                System.out.println("Please enter right values");
            }
        }
    }

    public static void readRecordTime(int searchTerm,String csvFile,Date date1, Date date2) {
        long start = System.currentTimeMillis();
        long en = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int i = 0;
            String line = "";
            while ((line = br.readLine()) != null && i < searchTerm) {
                String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if ((tokens[1].equals("Movie")) && (tokens[5].equals("India")) ) {
                    System.out.println(tokens[0] + " " + tokens[1] + " s" + tokens[2] + tokens[3] + tokens[4] + tokens[5] + tokens[6] + tokens[7] +
                            tokens[8] + tokens[9] + tokens[10] + tokens[11]);
                    i++;
                }

            }
            en = System.currentTimeMillis();

        } catch (IOException e) {
            e.printStackTrace();
//            long en = System.currentTimeMillis();

        }


        long totalTime = en - start;
        System.out.print("Execution time is " + totalTime + "nms");

    }


    public static void readRecordMovie(int searchTerm,String csvFile) {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Enter a value of Type: ");
        String type= sc.nextLine();

        System.out.print("Enter a value of Country: ");
        String type1= sc.nextLine();


        long start = System.currentTimeMillis();
        long en = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int i = 0;
            String line = "";
            while ((line = br.readLine()) != null && i < searchTerm) {
                String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if ((tokens[1].equals(type)) && (tokens[5].equals(type1))) {
                    System.out.println(tokens[0] + " " + tokens[1] + " s" + tokens[2] + tokens[3] + tokens[4] + tokens[5] + tokens[6] + tokens[7] +
                            tokens[8] + tokens[9] + tokens[10] + tokens[11]);
                    i++;
                }

            }
            en = System.currentTimeMillis();

        } catch (IOException e) {
            e.printStackTrace();
//            long en = System.currentTimeMillis();

        }


        long totalTime = en - start;
        System.out.print("Execution time is " + totalTime + "nms");

    }




    public static void readRecordTVShow(int searchTerm,String csvFile){
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Enter a Type: ");
        String type= sc.nextLine();              //reads string

        long start = System.currentTimeMillis();
        long en = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int i=0;
            String line = "";
            while ((line = br.readLine()) != null && i<searchTerm) {
                String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if(tokens[1].equals(type))
                {
                    System.out.println(tokens[0]+tokens[1]+tokens[2]+tokens[3]+tokens[4]+tokens[5]+tokens[6]+tokens[7]+
                            tokens[8]+tokens[9]+tokens[10]+tokens[11]);
                    i++;
                }
            }
            en = System.currentTimeMillis();

        } catch (IOException e) {
            e.printStackTrace();
        }

        long totalTime = en - start;
        System.out.print("Execution time is " + totalTime + "nms");
    }

    public static void readRecordlisted(int searchTerm,String csvFile){
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Enter a listed_in value: ");
        String type= sc.nextLine();              //reads string
        long start = System.currentTimeMillis();
long en=0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int i=0;
            String line = "";
            while ((line = br.readLine()) != null && i<searchTerm) {
                String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if(tokens[10].contains(type))
                {
                System.out.println(tokens[0]+tokens[1]+tokens[2]+tokens[3]+tokens[4]+tokens[5]+tokens[6]+tokens[7]+
                        tokens[8]+tokens[9]+tokens[10]+tokens[11]);
                i++;
            }
            }
            en = System.currentTimeMillis();

        } catch (IOException e) {
            e.printStackTrace();
        }

        long totalTime = en - start;
        System.out.print("Execution time is " + totalTime + "nms");
    }
}



