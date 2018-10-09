package graph;

import java.util.Scanner;

public class main {
	
	public static void main (String[] args) {
		
		node[] realNode = new node[30];
		readData rD = new readData();
		rD.readData(realNode);
		
	//	System.out.println(realNode[0].monday[2]);
		
		/* array�ϰ�
		 * 0 : 10��
		 * 1 : 12��
		 * 2 : 14��
		 * 3 : 16��
		 * 4 : 18��
		 * 5 : 20��
		 * 6 : 22��
		 */
		 
		double[] weightResult = new double [30];
		double [] distanceResult = new double[30];
		double max=0;
		int maxNode=0;
		int[] openOrClose = new int [30];
		
		System.out.println("�Է��� �� : ��������, ����浵, ����ð�, ���ϴ¿���");
		Scanner sc = new Scanner(System.in);
	
		double x = sc.nextDouble() ; //������ġ x
		double y = sc.nextDouble() ;//������ġ y
		int selectHour = sc.nextInt();
		String dayName=sc.next();
		int selectHourForArray = selectHour/2-5;
		int weightForDistance=1;
		int weightForSearch=1;
		
		
		//��ϰ� �ִ� �Ĵ� ã��
		for (int i=0;i<30;i++) {
			//�����ִ»���
			if (selectHour >=realNode[i].startHour  && selectHour <= realNode[i].endHour) {
				openOrClose[i] = 1;
			} 
			//�ݰ��ִ»���
			else  openOrClose[i] = 0;
		}
		
		// ����ġ���
		for (int i=0;i<30;i++) {
			if(openOrClose[i]==0) { //�Ĵ��� �ݾ����� ����ġ 0
				weightResult[i] =0;
			}
			else {
			
				if(dayName.equals("monday")) {
					distance dis = new distance();
					distanceResult[i] = dis.distance(x,y,realNode[i].latitude, realNode[i].longitude );
				weightResult[i] = ( weightForDistance*distanceResult[i] )+ 
					( weightForSearch*realNode[i].monday[selectHourForArray] ); 	//����ġ ���
				}
				if(dayName.equals("tuesday")) {
					distance dis = new distance();
					distanceResult[i] = dis.distance(x,y,realNode[i].latitude, realNode[i].longitude );
					weightResult[i] = ( weightForDistance*distanceResult[i] )+ 
							( weightForSearch*realNode[i].tuesday[selectHourForArray] ); 	//����ġ ���
						}
				if(dayName.equals("wendseday")) {
					distance dis = new distance();
					distanceResult[i] = dis.distance(x,y,realNode[i].latitude, realNode[i].longitude );
					weightResult[i] = ( weightForDistance*distanceResult[i] )+ 
							( weightForSearch*realNode[i].wendseday[selectHourForArray] ); 	//����ġ ���
						}
				if(dayName.equals("thursday")) {
					distance dis = new distance();
					distanceResult[i] = dis.distance(x,y,realNode[i].latitude, realNode[i].longitude );
					weightResult[i] = ( weightForDistance*distanceResult[i] )+ 
							( weightForSearch*realNode[i].thursday[selectHourForArray] ); 	//����ġ ���
						}
				if(dayName.equals("friday")) {
					distance dis = new distance();
					distanceResult[i] = dis.distance(x,y,realNode[i].latitude, realNode[i].longitude );
					weightResult[i] = ( weightForDistance*distanceResult[i] )+ 
							( weightForSearch*realNode[i].friday[selectHourForArray] ); 	//����ġ ���
						}
				if(dayName.equals("saturday")) {
					distance dis = new distance();
					distanceResult[i] = dis.distance(x,y,realNode[i].latitude, realNode[i].longitude );
					weightResult[i] = ( weightForDistance*distanceResult[i] )+ 
							( weightForSearch*realNode[i].saturday[selectHourForArray] ); 	//����ġ ���
						}
				if(dayName.equals("sunday")) {
					distance dis = new distance();
					distanceResult[i] = dis.distance(x,y,realNode[i].latitude, realNode[i].longitude );
					weightResult[i] = ( weightForDistance*distanceResult[i] )+ 
							( weightForSearch*realNode[i].sunday[selectHourForArray] ); 	//����ġ ���
						}
				
				}
		}
		
		//����ġ�� ���� ���� ��� ã��
		for(int i = 0;i<30;i++) {
			if(weightResult[i]>=max) {
				max = weightResult[i];
				maxNode = i;
			}
		}

			System.out.println("���� ��õ�ϴ� �Ĵ���:"+ realNode[maxNode].restaurantName);
			
	}
	
	
}
