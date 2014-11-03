package sample.model;

/**
 * @author ���������
 * @version 1.0
 * @created 03-���-2014 20:56:30
 */
public class FourRoadCrossing implements Crossing {

	private Road northRoad;
	private Road southRoad;
	private Road westRoad;
	private Road eastRoad;
	private Crossing northCrossing;
	private Crossing southCrossing;
	private Crossing westCrossing;
	private Crossing eastCrossing;

	public FourRoadCrossing(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param line
	 */
	public void addLine(Line line){

	}
}//end FourRoadCrossing