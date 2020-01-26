package com.systemmeltdown.examples.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.systemmeltdown.robotlib.arduino.ArduinoUSBController;

/**
 * Example subsystem using an ArduinoUSB Example.
 * 
 * This is designed to work with the Example ArduinoUSB sketch.
 */
public class ArduinoUSBExampleSubsystem extends Subsystem {
	//private StringLogTopic errorLog = new StringLogTopic("arduino-error");

	private ArduinoUSBController m_arduinoUSB;

	public ArduinoUSBExampleSubsystem(String ttyDevice) {
		super("Arduino USB Example");
		m_arduinoUSB = new ArduinoUSBController(ttyDevice);

		m_arduinoUSB.start();
	}

	/**
	 * Get the count from the Arduino
	 * 
	 * This is an example of how a subsystem could expose sensor values
	 * from an arduino. No caching of state needed, state is already
	 * cached in the ArduinoUSBController.
	 */
	public int getCount() {
		// Check if the arduino is connected before getting values.
		if (!m_arduinoUSB.isConnected()) {
			return -1;
		}
		return m_arduinoUSB.getDeviceFieldInt("example", "count");
	}

	static final double POWER_CELL_DIAMETER_INCHES = 7;
	static final double INTAKE_WIDTH_INCHES = 18;
	static final double MAX_INTAKE_WIDTH_INCHES = INTAKE_WIDTH_INCHES + 0.125;
	static final double MIN_INTAKE_WIDTH_INCHES = INTAKE_WIDTH_INCHES - 0.125;

	public int getBeamPowerCellCount() {
		double width = getBeamBlockageDistance();

		if (width == 0) {
			return 0;
		}
		if (width > POWER_CELL_DIAMETER_INCHES) {
			return 2;
		}
		return 1;
	}

	public double getBeamBlockageDistance() {
		double leftDistanceInches = getLeftBeamDistanceInches();
		double rightDistanceInches = getRightBeamDistanceInches();

		boolean isLeftOpen = (
			leftDistanceInches > MIN_INTAKE_WIDTH_INCHES &&
			leftDistanceInches < MAX_INTAKE_WIDTH_INCHES );

		boolean isRightOpen = (
			leftDistanceInches > MIN_INTAKE_WIDTH_INCHES &&
			leftDistanceInches < MAX_INTAKE_WIDTH_INCHES );

		if (isLeftOpen && isRightOpen) {
			return 0;
		}

		return INTAKE_WIDTH_INCHES - leftDistanceInches - rightDistanceInches;
	}

	public double getLeftBeamDistanceInches() {
		return mmToInches(leftArduino.getDeviceFieldInt("laserToF", "distanceMM"));
	}

	public double getRightBeamDistanceInches() {
		return mmToInches(rightArduino.getDeviceFieldInt("laserToF", "distanceMM"));
	}

	@Override
	public void periodic() {
		// A periodic function should not be necessary in most subsystems.
		// This is only here to show how a subsystem can set device fields.
		// An appropriate place to do this is in initialization (setting up the sensors)
		// or when a subsystem changes "modes" (e.g. intake vs. shooting)
		if (m_arduinoUSB.isConnected() && getCount() % 10 == 0) {
			m_arduinoUSB.setDeviceField("example", "testValue", getCount());
		}
	}

	@Override
	protected void initDefaultCommand() {
		// Not used.
	}
}