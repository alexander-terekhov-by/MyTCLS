package sample.model;

/**
 * @author ���������
 * @version 1.0
 * @created 03-���-2014 20:56:27
 */
public class ThreeRoadCrossing implements Crossing {

	private Road northRoad;
	private Road westRoad;
	private Road eastRoad;
	private Crossing northCrossing;
	private Crossing westCrossing;
	private Crossing eastCrossing;

	public ThreeRoadCrossing(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param line
	 */
	public void addLine(Line line){

	}
}//end ThreeRoadCrossing