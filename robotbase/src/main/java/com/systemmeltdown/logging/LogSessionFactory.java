package com.systemmeltdown.logging;

import java.util.HashMap;
import java.util.Map;

import com.systemmeltdown.robotlog.LogSession;
import com.systemmeltdown.robotlog.outputs.LogOutput;
import com.systemmeltdown.robotlog.outputs.PrintStreamOutput;

public class LogSessionFactory {
  public static LogSession createLogSession() {
    Map<String, LogOutput> outputs = new HashMap<String, LogOutput>();
    outputs.put("stdout", new PrintStreamOutput("stdout", System.out));

    LogSession session = new LogSession(outputs);

    session.subscribeTopic("PDP Error", "stdout");
    session.subscribeTopic("Battery Volts", "stdout");
    session.subscribeTopic("Total Amps", "stdout");
    session.subscribeTopic("PDP Temp", "stdout");

    return session;
  }
}
