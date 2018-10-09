package graph;

public class distance {

	public static float distance(double x, double y, double nodeX, double nodeY) {
		
		double earthRadius = 637100; //meters
		double dLat = Math.toRadians(nodeX - x);
		double dLng = Math.toRadians(nodeY - y);
		double a = Math.sin(dLat/2)* Math.sin(dLat)/2 +
		Math.cos(Math.toRadians(x))* Math.cos(Math.toRadians(y)) * Math.sin(dLng/2) * Math.sin(dLng/2);
		
		 double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		 float dist = (float) (earthRadius * c);

		    return dist;
		
		
	}
}
