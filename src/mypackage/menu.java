package mypackage;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class menu {
	public static void main(String[] args) throws IOException {
		System.out.println("WELCOME TO VIRTUAL KEY FOR YOUR REPOSITORIES");
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		System.out.println("Application Name:LOCKED.IN");
		System.out.println("Developer Name:HARSH GUPTA");
		System.out.println("Directory Path : D:\\Project directory ");
		final String location = "D:\\Project directory";
		do {
			System.out.println("File Menu");
			System.out.println("*********");
			System.out.println("1)List Filenames In Ascending Order");
			System.out.println("2)User Interaction Options");
			System.out.println("3)EXIT");
			System.out.println("************");
			System.out.print("ENTER YOUR COICE: ");
			try {
				choice = Integer.parseInt(scanner.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("Only number Allowed");
				continue;
		}
			System.out.println("****************");
			switch(choice) {
			case 1:
				System.out.println("File And Directory List In Ascending Order");
				System.out.println();
				try {
				File file = new File(location);
	            File filedirec [] = file.listFiles();
	            Arrays.sort(filedirec);
	            for(File e : filedirec) {
	            	if (e.isFile()) {
	            		System.out.println("File:" + e.getName());
	            		System.out.println();
	            	}
	            	else if (e.isDirectory()) {
	            		System.out.println("Directory:" + e.getName());
	            		System.out.println();
	            	}	
	            	else {
	            		System.out.println("Not Known:" + e.getName());
	            		System.out.println();
	            	}		
	            }
				}
				catch(Exception e) {
					System.err.println("Directory Path must be present to do this operation :");
					System.err.println("Directory Path : D:\\Project directory ");
				}
				break;
			case 2:
				int subchoice = 0;
				do {
				System.out.println();
				System.out.println("USER INTERCATION OPTIONS:");
				System.out.println("**************************");
				System.out.println("1)ADD FILE HERE");
				System.out.println("2)DELETE FILE HERE");
				System.out.println("3)SEARCH FILE HERE");
				System.out.println("4)MAIN MENU");
				System.out.println("****************");
				System.out.print("Enter your choice: ");

				try {
					subchoice = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("only numbers allowed");
					continue;
				}
				
				System.out.println("******************");
				System.out.println();
				
				switch(subchoice) {
				
				case 1:
					System.out.print("ADD ENTER YOUR FILE NAME HERE: ");
					String fileName = scanner.nextLine().toLowerCase();
					try {
					Path path = Paths.get("D:\\Project directory\\"+fileName+".txt");
					if(Files.exists(path)) {
						System.out.println("THIS FILE NAME ALREADY EXIST PLEASE TRY ANOTHER FILE ");
					}
					else {
						Path pathdone = Files.createFile(path);
						System.out.println("FILE IS CREATED :" + pathdone.toString());
					}
					
					}
					catch(Exception e) {
						e.printStackTrace();
						continue;
					}
					break;
					
				case 2:
					System.out.print("DELETE YOUR FILE NAME HERE : ");
					String fileName2 = scanner.nextLine();
					try {
					Path path = Paths.get("D:\\Project directory\\"+fileName2+".txt");
					if(Files.exists(path)) {
						  Files.delete(path);
						 System.out.println("DELETED SUCESSFULLY");
					}
					else {	
						System.out.println("FILE DOESN'T EXIST");	
					}
					
					}
					catch(Exception e) {
						e.printStackTrace();
						continue;
					}
					break;		
				case 3:
					boolean flag = false;
					System.out.print("SEARCH YOUR FILE NAME HERE :  ");
					String fileName3  = scanner.nextLine().toLowerCase();
					File file = new File(location);
					File filedirec[] = file.listFiles();
					for(int i=0; i<filedirec.length; i++) {
						if(filedirec[i].getName().startsWith(fileName3)) {
							System.out.println(filedirec[i].toString());
							flag = true;
						}
					}
					if(flag==false) {
						System.out.println("FILE DOESN'T EXIST");
					}	
					break;
				case 4:
					System.out.println("BACK To The Main Menu");
					break;
					
				default:
					System.out.println("Invaid Option : RETRY");	
			}
				}while(subchoice!=4);	
			case 3:
				System.out.println("THANK YOU FOR VISITING * HAVE A NICE DAY ");
				break;
			default:
				System.out.println("Invalid Option : RETRY ");	
			}	
		}while(choice!=3);
		scanner.close();
		}
		
		
		
	}

