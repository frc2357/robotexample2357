package com.systemmeltdown.examples.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.systemmeltdown.robotlib.arduino.ArduinoUSBController;

/**
 * Example subsystem using an ArduinoUSB Example.
 * 
 * This is designed to work with the Example ArduinoUSB sketch.
 */
public class ArduinoUSBExampleSubsystem extends Subsystem {
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