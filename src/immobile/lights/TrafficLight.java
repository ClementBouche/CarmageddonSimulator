package immobile.lights;

import enumeration.Color;
import immobile.structures.Road;
import model.Cell;

/**
* Abstract Traffic Light class
*/
public abstract class TrafficLight {
	/**
	* Traffic Light orientation identifies the road
	*/
	protected Road road;
	/**
	* Yellow light duration
	*/
	protected Color currentColor;

	/*
	 * deprecated
	protected int timeGreen;
	protected int timeRed;
	 */

	public TrafficLight(Road road, Color currentColor) { // deprecated: , int timeGreen, int timeRed
		super();
		this.road = road;
		this.currentColor = currentColor;
		/*
		 * deprecated
		this.timeGreen = timeGreen;
		this.timeRed = timeRed;
		 */
	}

	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}
	/* 
	 * deprecated
	public void setTimeGreen(int timeGreen) {
		this.timeGreen = timeGreen;
	}
	public void setTimeRed(int timeRed) {
		this.timeRed = timeRed;
	}

	public void changeColor() {
		switch (currentColor) {
		case Green: currentColor = Color.Red;
		case Red: currentColor = Color.Green;
		}
	}
	 */
	
	
	//Getters
	
	public Color getCurrentColor() {
		return currentColor;
	}
	
	@Override
	protected TrafficLight clone() {
		return new TrafficLightCar(this.road, this.currentColor);
	}
}
