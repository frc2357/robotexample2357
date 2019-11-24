package com.systemmeltdown.examples.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.systemmeltdown.robotlib.sensors.DigitalInputLimitSwitch;

public class LimitSwitchExampleSubsystem extends Subsystem {
	private DigitalInputLimitSwitch m_limitSwitch;
	private boolean m_lastValue;

	public LimitSwitchExampleSubsystem(int gpioPin, boolean inverted) {
		super("Limit Switch Example");
		var digitalInput = new DigitalInput(gpioPin);
		m_limitSwitch = new DigitalInputLimitSwitch(digitalInput, inverted);
		m_lastValue = false;
	}

	@Override
	public void periodic() {
		super.periodic();

		var value = m_limitSwitch.isAtLimit();
		if (m_lastValue != value) {
			System.out.println("Limit Switch is now " + value);
			m_lastValue = value;
		}
	}

	@Override
	protected void initDefaultCommand() {
	}
}