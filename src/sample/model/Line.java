package sample.model;

import java.util.List;

/**
 * @author ���������
 * @version 1.0
 * @created 03-���-2014 20:56:45
 */
public class Line {

	private TrafficLight trafficLight;
	private int direction;
	private int orientation;
	public Road road;

	public Line(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param listOfLines
	 */
	public int makeConflictTrafficLigthsList(List<Line> listOfLines){
		return 0;
	}



}