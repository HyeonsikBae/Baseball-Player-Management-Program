package AboutFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import DTO.*;

public class AboutFile {
	private File file;
	private static String team;
	
	public AboutFile() {
		
	}
	
	public void createFile(String team){
		try {
		
		this.team = team;
		this.file = new File("c:\\temp\\"+this.team+".txt");
		this.file.createNewFile();
		System.out.println("파일 생성 완료");
		}catch(IOException e) {
			e.getStackTrace();
		}
	}

	public ArrayList<Human> fileLoad() {
		ArrayList<Human> playerList = new ArrayList<Human>();
		System.out.println(this.team);
		file = new File("c:\\temp\\"+this.team+".txt");
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			int count = 0;		
			String temp="";
			while((temp=br.readLine())!=null) {
				count++;
			}
			
			br.close();
			br = new BufferedReader(new FileReader(file));
			
			String strRead[] = new String[count];
			int i=0;
			while((temp=br.readLine())!=null) {
				strRead[i] = temp;
				i++;
			}
			
			Human[] player = new Human[count];
			
			for(int j=0;j<count;j++) {
				String data[]  = strRead[j].split("-");
				if(data[0].equals("타자")) {
					player[j] = new Pitcher(data[0],
											Integer.parseInt(data[1]),
											data[2],
											Integer.parseInt(data[3]),
											Double.parseDouble(data[4]),
											Integer.parseInt(data[5]),
											Integer.parseInt(data[6]),
											Double.parseDouble(data[7])
											);
				}		
				else {
					player[j] = new Pitcher(data[0],
											Integer.parseInt(data[1]),
											data[2],
											Integer.parseInt(data[3]),
											Double.parseDouble(data[4]),
											Integer.parseInt(data[5]),
											Integer.parseInt(data[6]),
											Double.parseDouble(data[7])
											);
				}
				playerList.add(player[j]);
			}
			br.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		return playerList;
	}
	
	public void fileWrite(ArrayList<Human> playerList) {
		try {
			Human datas[] = new Human[playerList.size()];	
			for(int i=0;i<playerList.size();i++) {
				Human temp = playerList.get(i);
				datas[i] = temp;
				System.out.println(datas[i]);
			}
			
			
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			
			for(int i=0;i<playerList.size();i++) {
				pw.println(datas[i]);
			}
			System.out.println("저장 성공");
			pw.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void fileWriteWithDelete(ArrayList<Human> playerList) {
		try {
			System.out.println(file);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			if(file.exists()) {
				for(int i=0;i<playerList.size();i++) {
					Human mem = playerList.get(i);
					pw.println(mem);
				}
			}
			System.out.println("저장 성공");
			pw.close();
		}catch(Exception e) {
			System.out.println("저장 실패");
		}
	}
	
}
