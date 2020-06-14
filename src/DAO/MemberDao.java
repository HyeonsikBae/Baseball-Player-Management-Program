package DAO;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import AboutFile.*;
import DTO.*;

//DAO:Data Access Object = model = back end
public class MemberDao {
	// 데이터 담을 배열 필요
	Scanner scanner = new Scanner(System.in);

	ArrayList<Human> playerList = new ArrayList<Human>();
	//static Human players[] = new Human[0];
	AboutFile file = new AboutFile();
	
	/*
	Human human[]; < 변수 선언
	human = new Human(); < 객체 생성
	human = new Human[20]; < 변수 20개 생성
	 */
	
	public MemberDao() {
		playerList = file.fileLoad();
		/*
		Human players = new Human[8];
		players[0] = new Batter("타자",101,"주홍",25,188.0,30,20,0.33);
		players[1] = new Pitcher("투수",201,"경호",27,187.3,6,5,4.3);
		players[2] = new Pitcher("투수",202,"도흠",26,182.1,7,2,6.6);
		players[3] = new Batter("타자",102,"상우",27,179.5,25,17,0.38);
		players[4] = new Batter("타자",103,"성환",23,181.8,22,19,0.39);
		players[5] = new Pitcher("투수",203,"현식",29,177.7,10,1,9.0);
		players[6] = new Batter("타자",104,"김밥",30,182.6,40,10,0.23);
		players[7] = new Pitcher("투수",204,"돌돌",19,183.4,3,4,3.3);
		playerList.add(players[0]);
		playerList.add(players[1]);
		playerList.add(players[2]);
		playerList.add(players[3]);
		playerList.add(players[4]);
		playerList.add(players[5]);
		playerList.add(players[6]);
		playerList.add(players[7]);
		*/
	}
	
	public void swap(Human[] arr,int a, int b) {
		Human temp;
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public void swap(ArrayList<Human> list) {
		
	}
	public String hitAvgLine() {
		String str = "";
		ArrayList<Human> hitAvg = new ArrayList<Human>();
		for(int i=0;i<playerList.size();i++) {
			Human temp = playerList.get(i);
			System.out.println(temp.toString());
			if(temp instanceof Batter) {
			}
		}
		System.out.println(hitAvg.toString());
		for(int i=0;i<hitAvg.size()-1;i++) {
			for(int j=i+1;j<hitAvg.size();j++) {
				if(((Batter)hitAvg.get(i)).getHitAvg()<((Batter)hitAvg.get(j)).getHitAvg()) {
					Human temp = hitAvg.get(i);
					hitAvg.set(i,hitAvg.get(j));
					hitAvg.set(j, temp);
				}
			}
		}
		for(int i=0;i<hitAvg.size();i++) {
			str += (hitAvg.get(i).toString()+"\n");
		}
		return str;
	}
	public String defenceLine() {
		String str = "";
		ArrayList<Human> defAvg = new ArrayList<Human> ();
		for(int i=0;i<playerList.size();i++) {
			Human temp = playerList.get(i);
			if(temp instanceof Pitcher) {
				defAvg.add(temp);
			}
		}
		for(int i=0;i<defAvg.size()-1;i++) {
			for(int j=i+1;j<defAvg.size();j++) {
				if(((Pitcher)defAvg.get(i)).getDefence()>((Pitcher)defAvg.get(j)).getDefence()) {
					Human temp = defAvg.get(i);
					defAvg.set(i,defAvg.get(j));
					defAvg.set(j, temp);
				}
			}
		}
		for(int i=0;i<defAvg.size();i++) {
			str += (defAvg.get(i).toString()+"\n");
		}
		return str;
	}	
	public void insert(int type, int number, String name, int age, double height, int op1, int op2, double op3) {
		Human human = new Human();

		if(type == 1) {
			human = new Batter("타자", number, name, age, height, op1, op2, op3);
			playerList.add(human);
		}
		else {
			human = new Pitcher("투수", number, name, age, height, op1, op2, op3);
			playerList.add(human);
		}
		file.fileWrite(playerList);
	}
	public void delete(int playerNumber) {
		int deleteIndex = search(playerNumber);
		System.out.println(deleteIndex);
		System.out.println(playerList);
		playerList.remove(deleteIndex);
		file.fileWriteWithDelete(playerList);
	}
	public int select(int playerNumber) {
		int i=-1;
		int selectNum = search(playerNumber);
		if(selectNum==-1) {
			i = -1;
		}
		else {
			i = selectNum;
		}
		return i;
	}
	public Human print(int indexNumber) {
		return playerList.get(indexNumber);
	}
	
	public void update(int playerNumber) {
		int updateNum = search(playerNumber);
		if(updateNum==-1) {
			System.out.println(playerNumber + "번 선수는 없습니다.");
		}
		else {
			if(playerList.get(updateNum).getType().equals("타자")) {
				Human human = new Batter("타자", number, name, age, height, op1, op2, op3);
				playerList.add(human);
			}
			else {
				Human temp = setHuman(2);
				playerList.set(updateNum, temp);
			}
		}
	}

	public String allPrint() {
		String str = "";
		for(int i=0;i<playerList.size();i++) {
			str += (playerList.get(i).toString() + "\n");
		}
		return str;
	}
	
	public void allClear() {
		playerList.removeAll(playerList);
		file.fileWriteWithDelete(playerList);
	}
	
	public int search(int number) {
		int findNum = -1;
		for(int i=0;i<playerList.size();i++) {
			Human mem = playerList.get(i);
			if(mem.getNumber()==number) {
				findNum = i;
				break;
			}
		}
		return findNum;
	}
	
	public String searchType(int index) {
		String findType = "";
		findType = playerList.get(index).getType();
		return findType;
	}
	
	public int searchName(String name) {
		int findName = -1;
		for(int i=0;i<playerList.size();i++) {
			Human mem = playerList.get(i);
			if(mem.getName().equals(name)) {
				findName = i;
			}
		}
		return findName;
	}
	

}