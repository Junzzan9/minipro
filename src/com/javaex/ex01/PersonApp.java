package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PersonApp {
	public static void main(String[] args) throws IOException {
		
		InputStream in = new FileInputStream("./PhoneDB.txt");
		InputStreamReader ir = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(ir);
		List<Person> pList = new ArrayList<Person>();
		Scanner sc = new Scanner(System.in);
		
		String line="";
		
		while(true) {
			line=br.readLine();
			if(line==null) {
				break;
			}
			
			String[] pInfo=line.split(",");
			Person p=new Person(pInfo[0],pInfo[1], pInfo[2]);
			pList.add(p);
		}
		
		System.out.println("*************************************");
		System.out.println("*        전화번호 관리 프로그램           *");
		System.out.println("*************************************");
		System.out.println("");
		while(true) {
			System.out.println("1.리스트\t2.등록\t3.삭제\t4.검색\t5.종료");
			System.out.println("-------------------------------------");
			System.out.print(">메뉴번호: ");
			int n=sc.nextInt();
			if(n==1) {
				System.out.println("<1.리스트>");
				for(int i=0;i<pList.size();i++) {
					System.out.println(i+1+".\t"+pList.get(i).getName()+"\t"+pList.get(i).getHp()+"\t"+pList.get(i).getCom());
				}
			}
			else if(n==2) {
				System.out.println("<2.등록>");
				System.out.print(">이름: ");
				String name=sc.next();
				System.out.println("");
				System.out.print(">휴대전화: ");
				String hp=sc.next();
				System.out.println("");
				System.out.print(">회사전화: ");
				String com=sc.next();
				System.out.println("");
				Person p=new Person(name,hp,com);
				pList.add(p);
				System.out.println("[등록되었습니다.]");
				
			}
			else if(n==3) {
				System.out.println("<3.삭제>");
				System.out.print(">번호: ");
				int rNum=sc.nextInt();
				System.out.println("");
				pList.remove(rNum-1);
				System.out.println("[삭제되었습니다.]");
			}
			else if(n==4) {
				System.out.println("<4.검색>");
				System.out.print(">이름: ");
				String srch=sc.next();
				System.out.println("");
				for(int i=0;i<pList.size();i++) {
					if(pList.get(i).getName().contains(srch)) {
						System.out.println(i+1+".\t"+pList.get(i).getName()+"\t"+pList.get(i).getHp()+"\t"+pList.get(i).getCom());
					}
				}
			}
			else if(n==5) {
				System.out.println("*************************************");
				System.out.println("*               감사합니다             *");
				System.out.println("*************************************");
				break;
			}
			else {
				System.out.println("[다시 입력해주세요.]");
			}
		}
		sc.close();
		Writer fw = new FileWriter("./PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		String str = "";
		for (int i = 0; i < pList.size(); i++) {
			str = pList.get(i).save();
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		br.close();
		bw.close();
		
	}
}
