package graph;

import java.util.Scanner;

public class main {
	
	public static void main (String[] args) {
		
		node[] realNode = new node[30];
		readData rD = new readData();
		rD.readData(realNode);
		
	//	System.out.println(realNode[0].monday[2]);
		
		/* array하게
		 * 0 : 10시
		 * 1 : 12시
		 * 2 : 14시
		 * 3 : 16시
		 * 4 : 18시
		 * 5 : 20시
		 * 6 : 22시
		 */
		 
		double[] weightResult = new double [30];
		double [] distanceResult = new double[30];
		double max=0;
		int maxNode=0;
		int[] openOrClose = new int [30];
		
		System.out.println("입력할 값 : 현재위도, 현재경도, 현재시간, 원하는요일");
		Scanner sc = new Scanner(System.in);
	
		double x = sc.nextDouble() ; //현재위치 x
		double y = sc.nextDouble() ;//현재위치 y
		int selectHour = sc.nextInt();
		String dayName=sc.next();
		int selectHourForArray = selectHour/2-5;
		int weightForDistance=1;
		int weightForSearch=1;
		
		
		//운영하고 있는 식당 찾기
		for (int i=0;i<30;i++) {
			//열고있는상태
			if (selectHour >=realNode[i].startHour  && selectHour <= realNode[i].endHour) {
				openOrClose[i] = 1;
			} 
			//닫고있는상태
			else  openOrClose[i] = 0;
		}
		
		// 가중치계산
		for (int i=0;i<30;i++) {
			if(openOrClose[i]==0) { //식당이 닫았을때 가중치 0
				weightResult[i] =0;
			}
			else {
			
				if(dayName.equals("monday")) {
					distance dis = new distance();
					distanceResult[i] = dis.distance(x,y,realNode[i].latitude, realNode[i].longitude );
				weightResult[i] = ( weightForDistance*distanceResult[i] )+ 
					( weightForSearch*realNode[i].monday[selectHourForArray] ); 	//가중치 계싼
				}
				if(dayName.equals("tuesday")) {
					distance dis = new distance();
					distanceResult[i] = dis.distance(x,y,realNode[i].latitude, realNode[i].longitude );
					weightResult[i] = ( weightForDistance*distanceResult[i] )+ 
							( weightForSearch*realNode[i].tuesday[selectHourForArray] ); 	//가중치 계싼
						}
				if(dayName.equals("wendseday")) {
					distance dis = new distance();
					distanceResult[i] = dis.distance(x,y,realNode[i].latitude, realNode[i].longitude );
					weightResult[i] = ( weightForDistance*distanceResult[i] )+ 
							( weightForSearch*realNode[i].wendseday[selectHourForArray] ); 	//가중치 계싼
						}
				if(dayName.equals("thursday")) {
					distance dis = new distance();
					distanceResult[i] = dis.distance(x,y,realNode[i].latitude, realNode[i].longitude );
					weightResult[i] = ( weightForDistance*distanceResult[i] )+ 
							( weightForSearch*realNode[i].thursday[selectHourForArray] ); 	//가중치 계싼
						}
				if(dayName.equals("friday")) {
					distance dis = new distance();
					distanceResult[i] = dis.distance(x,y,realNode[i].latitude, realNode[i].longitude );
					weightResult[i] = ( weightForDistance*distanceResult[i] )+ 
							( weightForSearch*realNode[i].friday[selectHourForArray] ); 	//가중치 계싼
						}
				if(dayName.equals("saturday")) {
					distance dis = new distance();
					distanceResult[i] = dis.distance(x,y,realNode[i].latitude, realNode[i].longitude );
					weightResult[i] = ( weightForDistance*distanceResult[i] )+ 
							( weightForSearch*realNode[i].saturday[selectHourForArray] ); 	//가중치 계싼
						}
				if(dayName.equals("sunday")) {
					distance dis = new distance();
					distanceResult[i] = dis.distance(x,y,realNode[i].latitude, realNode[i].longitude );
					weightResult[i] = ( weightForDistance*distanceResult[i] )+ 
							( weightForSearch*realNode[i].sunday[selectHourForArray] ); 	//가중치 계싼
						}
				
				}
		}
		
		//가중치가 가장 높은 노드 찾기
		for(int i = 0;i<30;i++) {
			if(weightResult[i]>=max) {
				max = weightResult[i];
				maxNode = i;
			}
		}

			System.out.println("가장 추천하는 식당은:"+ realNode[maxNode].restaurantName);
			
	}
	
	
}
